package com.li.yun.biao.job.executor.jobhandler;

import com.li.yun.biao.job.core.biz.model.ReturnT;
import com.li.yun.biao.job.core.handler.IJobHandler;
import com.li.yun.biao.job.core.handler.annotation.Job;
import com.li.yun.biao.job.core.log.JobLogger;
import com.li.yun.biao.job.core.util.ShardingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;


/**
 * @author: liyunbiao
 * @date: 2020/5/28 1:54 下午
 * @description Job开发示例（Bean模式）
 * <p>
 * 开发步骤：
 * 1、在Spring Bean实例中，开发Job方法，方式格式要求为 "public ReturnT<String> execute(String param)"
 * 2、为Job方法添加注解 "@Job(value="自定义jobhandler名称", init = "JobHandler初始化方法", destroy = "JobHandler销毁方法")"，注解value值对应的是调度中心新建任务的JobHandler属性的值。
 * 3、执行日志：需要通过 "JobLogger.log" 打印执行日志；
 */
@Component
public class SampleJob {
    private static Logger logger = LoggerFactory.getLogger(SampleJob.class);


    /**
     * 1、简单任务示例（Bean模式）
     */
    @Job("demoJobHandler")
    public ReturnT<String> demoJobHandler(String param) throws Exception {
        JobLogger.log("JOB, Hello World.");
        logger.info("********************demoJobHandler");
        return ReturnT.SUCCESS;
    }


    /**
     * 2、分片广播任务
     */
    @Job("shardingJobHandler")
    public ReturnT<String> shardingJobHandler(String param) throws Exception {

        // 分片参数
        ShardingUtil.ShardingVO shardingVO = ShardingUtil.getShardingVo();
        JobLogger.log("分片参数：当前分片序号 = {}, 总分片数 = {}", shardingVO.getIndex(), shardingVO.getTotal());

        // 业务逻辑
        for (int i = 0; i < shardingVO.getTotal(); i++) {
            if (i == shardingVO.getIndex()) {
                JobLogger.log("第 {} 片, 命中分片开始处理", i);
            } else {
                JobLogger.log("第 {} 片, 忽略", i);
            }
        }

        logger.info("********************shardingJobHandler");
        return ReturnT.SUCCESS;
    }


    /**
     * 3、命令行任务
     */
    @Job("commandJobHandler")
    public ReturnT<String> commandJobHandler(String param) throws Exception {
        String command = param;
        int exitValue = -1;

        BufferedReader bufferedReader = null;
        try {
            // command process
            Process process = Runtime.getRuntime().exec(command);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(process.getInputStream());
            bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream));

            // command log
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                JobLogger.log(line);
            }

            // command exit
            process.waitFor();
            exitValue = process.exitValue();
        } catch (Exception e) {
            JobLogger.log(e);
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }

        if (exitValue == 0) {
            return IJobHandler.SUCCESS;
        } else {
            return new ReturnT<String>(IJobHandler.FAIL.getCode(), "command exit value(" + exitValue + ") is failed");
        }
    }


    /**
     * 4、跨平台Http任务
     * 参数示例：
     * "url: http://www.baidu.com\n" +
     * "method: get\n" +
     * "data: content\n";
     */
    @Job("httpJobHandler")
    public ReturnT<String> httpJobHandler(String param) throws Exception {

        // param parse
        if (param == null || param.trim().length() == 0) {
            JobLogger.log("param[" + param + "] invalid.");
            return ReturnT.FAIL;
        }
        String[] httpParams = param.split("\n");
        String url = null;
        String method = null;
        String data = null;
        for (String httpParam : httpParams) {
            if (httpParam.startsWith("url:")) {
                url = httpParam.substring(httpParam.indexOf("url:") + 4).trim();
            }
            if (httpParam.startsWith("method:")) {
                method = httpParam.substring(httpParam.indexOf("method:") + 7).trim().toUpperCase();
            }
            if (httpParam.startsWith("data:")) {
                data = httpParam.substring(httpParam.indexOf("data:") + 5).trim();
            }
        }

        // param valid
        if (url == null || url.trim().length() == 0) {
            JobLogger.log("url[" + url + "] invalid.");
            return ReturnT.FAIL;
        }
        if (method == null || !Arrays.asList("GET", "POST").contains(method)) {
            JobLogger.log("method[" + method + "] invalid.");
            return ReturnT.FAIL;
        }

        // request
        HttpURLConnection connection = null;
        BufferedReader bufferedReader = null;
        try {
            // connection
            URL realUrl = new URL(url);
            connection = (HttpURLConnection) realUrl.openConnection();

            // connection setting
            connection.setRequestMethod(method);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setReadTimeout(5 * 1000);
            connection.setConnectTimeout(3 * 1000);
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            connection.setRequestProperty("Accept-Charset", "application/json;charset=UTF-8");

            // do connection
            connection.connect();

            // data
            if (data != null && data.trim().length() > 0) {
                DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
                dataOutputStream.write(data.getBytes("UTF-8"));
                dataOutputStream.flush();
                dataOutputStream.close();
            }

            // valid StatusCode
            int statusCode = connection.getResponseCode();
            if (statusCode != 200) {
                throw new RuntimeException("Http Request StatusCode(" + statusCode + ") Invalid.");
            }

            // result
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
            String responseMsg = result.toString();

            JobLogger.log(responseMsg);
            return ReturnT.SUCCESS;
        } catch (Exception e) {
            JobLogger.log(e);
            return ReturnT.FAIL;
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (connection != null) {
                    connection.disconnect();
                }
            } catch (Exception e2) {
                JobLogger.log(e2);
            }
        }

    }

    /**
     * 5、生命周期任务示例：任务初始化与销毁时，支持自定义相关逻辑；
     */
    @Job(value = "demoJobHandler2", init = "init", destroy = "destroy")
    public ReturnT<String> demoJobHandler2(String param) throws Exception {
        JobLogger.log("JOB, Hello World.");
        return ReturnT.SUCCESS;
    }

    public void init() {
        logger.info("init");
    }

    public void destroy() {
        logger.info("destory");
    }


}
