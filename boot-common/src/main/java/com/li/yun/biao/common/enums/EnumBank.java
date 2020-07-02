package com.li.yun.biao.common.enums;

import com.li.yun.biao.common.utils.StringUtil;

import java.util.Arrays;
import java.util.Objects;

public enum EnumBank {
    ICBC(1, "102", "中国工商银行"),
    ABC(2, "103", "中国农业银行"),
    BOC(3, "104", "中国银行"),
    CCB(4, "105", "中国建设银行"),
    NDB(5, "201", "国家开发银行"),
    CIAEB(6, "202", "中国进出口银行"),
    CADB(7, "203", "中国农业发展银行"),
    COMM(8, "301", "交通银行"),
    CPSB(9, "403", "中国邮政储蓄银行"),
    CITIC(10, "302", "中信银行"),
    CEB(11, "303", "中国光大银行"),
    HUA_XIA(12, "304", "华夏银行"),
    CMBC(13, "305", "中国民生银行"),
    GDB(14, "306", "广东发展银行"),
    PBO(15, "001", "中国人民银行"),
    CMB(16, "308", "招商银行"),
    SHPDB(18, "310", "上海浦东发展银行"),
    CCBC(19, "313", "城市商业银行"),
    RCB(20, "314", "农村商业银行"),
    HFC(21, "315", "恒丰银行"),
    RCPB(22, "317", "农村合作银行"),
    BHB(23, "318", "渤海银行"),
    HSB(24, "319", "徽商银行"),
    UCCP(25, "401", "城市信用社"),
    RCA(26, "402", "农村信用联社"),
    HKSHHSBC(27, "501", "香港上海汇丰银行"),
    BOEA(28, "502", "东亚银行"),
    NYCB(29, "503", "南洋商业银行"),
    HSBC(30, "504", "恒生银行"),
    HKRB(32, "989", "(香港地区)银行"),
    BOF(33, "506", "集友银行"),
    DBSBHK(34, "509", "星展银行（香港）"),
    WHB(34, "510", "永亨银行"),
    CBCHINA(36, "531", "花旗银行（中国）"),
    BOAMERICA(37, "532", "美国银行"),
    JPMCB(38, "533", "美国摩根大通银行"),
    JMTJCB(39, "561", "日本三菱东京日联银行"),
    JJBOC(40, "562", "日本日联银行"),
    SBOMJ(41, "563", "日本三井住友银行"),
    MZHCB(42, "564", "日本瑞穗实业银行"),
    YMGCBOJ(43, "565", "日本山口银行"),
    FEISK(44, "591", "韩国外换银行"),
    SKNKB(45, "595", "韩国新韩银行"),
    WRIB(46, "593", "韩国友利银行"),
    IBOK(47, "594", "韩国产业银行"),
    SKSAMEB(48, "596", "韩国中小企业银行"),
    BBSBS(49, "623", "新加坡星展银行"),
    RZO(50, "641", "奥地利中央合作银行"),
    UBOB(51, "651", "比利时联合银行"),
    BOHL(52, "661", "荷兰银行"),
    CBOH(53, "662", "荷兰商业银行"),
    SCBCHINA(54, "671", "渣打银行（中国）"),
    FTANCEXYB(55, "691", "法国兴业银行"),
    BOPF(56, "691", "法国巴黎银行"),
    OBOF(57, "693", "法国东方汇理银行"),
    DBAS(58, "711", "德国德累斯登银行"),
    BSB(59, "712", "德意志银行"),
    GERMANCB(60, "713", "德国商业银行"),
    WGERMANYB(61, "714", "德国西德银行"),
    BOBG(62, "715", "德国巴伐利亚州银行"),
    CSB(63, "715", "瑞士信贷银行"),
    BMO(64, "752", "加拿大蒙特利尔银行"),
    BGOAANZ(65, "", "澳大利亚和新西兰银行集团"),
    DFTB(66, "", "德富泰银行"),
    XMIB(67, "781", "厦门国际银行"),
    BOPFCHINA(68, "", "法国巴黎银行（中国）"),
    PAB(69, "307", "平安银行"),
    QDIB(70, "786", "青岛国际银行"),
    FBHB(71, "787", "富邦华一银行"),
    BODL(72, "311", "大连银行"),
    BOSH(73, "325", "上海银行"),
    BOZS(74, "787", "浙商银行"),
    BONB(75, "313", "宁波银行"),
    BOHZ(76, "313", "杭州银行"),
    BOJS(77, "313", "江苏银行"),
    BOLZ(78, "313", "兰州银行"),
    BONC(79, "313", "南昌银行"),
    BONJ(80, "313", "南京银行"),
    BOQL(81, "326", "齐鲁银行"),
    BOQS(82, "327", "齐商银行"),
    BOTJ(83, "328", "天津银行"),
    BOWZ(84, "329", "温州银行"),
    BOXA(85, "330", "西安银行"),
    BOXM(86, "331", "厦门银行"),
    BOYZ(87, "332", "鄞州银行"),
    BOTZ(88, "335", "台州银行"),
    BOGZ(89, "336", "广州银行"),
    BOLS(90, "342", "临商银行"),
    BOJX(91, "345", "嘉兴银行"),
    BOJH(92, "346", "金华银行"),
    BOQD(93, "348", "青岛银行"),
    BONY(94, "349", "南阳银行"),
    BOCD(95, "642", "成都银行"),
    BOSZFZ(96, "807", "深圳发展银行"),
    BOXY(97, "309", "兴业银行"),
    BOBJ(98, "313", "北京银行"),
    BOGZNCSY(99, "505", "广州农村商业银行"),
    BOCX(100, "507", "创兴银行"),
    BOMHK(101, "508", "大众银行（香港）"),
    CBOSH(102, "511", "上海商业银行"),
    WLB(103, "512", "永隆银行"),
    BNBCHINA(104, "513", "大新银行（中国）"),
    CITICBICHINA(105, "514", "中信银行国际（中国）"),
    CBOSC(106, "521", "华南商业银行"),
    CBOCH(107, "522", "彰化商业银行"),
    TWCB(109, "524", "合作金库商业银行"),
    CUB(110, "523", "国泰世华商业银行"),
    FCB(111, "525", "第一商业银行"),
    TIB(112, "526", "台湾土地银行"),
    MICB(113, "527", "兆丰国际商业银行"),
    BOTW(114, "528", "台湾银行"),
    BOYS(115, "529", "玉山银行（中国）"),
    STBJ(116, "566", "日本三井住友信托银行"),
    BOYKHL(117, "567", "日本横滨银行"),
    HBCHINA(118, "597", "韩亚银行（中国）"),
    NBCHINA(119, "598", "国民银行（中国）"),
    TWSAMSEB(120, "600", "台湾中小企业银行"),
    MMB(121, "611", "马来西亚马来亚银行"),
    CBOCHINA(122, "616", "首都银行（中国）"),
    OCBOCHINA(123, "621", "华侨银行（中国）"),
    DBOCHINA(124, "622", "大华银行（中国）"),
    PBOCHINA(125, "631", "盘谷银行（中国）"),
    TKTB(126, "633", "泰国开泰银行"),
    BARCLAYSBANK(127, "673", "英国巴克莱银行"),
    CBOS(128, "681", "瑞典商业银行"),
    SEBAB(129, "682", "瑞典北欧斯安银行"),
    BOSWEDEN(130, "683", "瑞典银行"),
    FFTB(131, "695", "法国外贸银行"),
    DBG(132, "716", "德国北德意志州银行"),
    SGBSK(133, "717", "中德住房储蓄银行"),
    UNIC(134, "731", "意大利裕信银行"),
    INTESASANPAOLO(135, "732", "意大利联合圣保罗银行"),
    BOSOCHINA(136, "741", "瑞士银行（中国）"),
    FBOC(137, "751", "加拿大丰业银行"),
    BOAANZ(138, "761", "澳大利亚和新西兰银行"),
    WPBOA(139, "762", "澳大利亚西太平洋银行"),
    RFTB(140, "767", "俄罗斯外贸银行"),
    MSIBOCHINA(141, "771", "摩根士丹利国际银行（中国）"),
    HBOCHINA(142, "775", "华美银行（中国）"),
    HCB(143, "776", "荷兰合作银行"),
    BOPFOCHINA(145, "782", "法国巴黎银行（中国）"),
    CHINESEMERCANTILEBANK(146, "785", "华商银行"),
    CQTGB(147, "321", "重庆三峡银行"),
    SRCB(148, "322", "上海农商银行"),
    VILLAGEBANK(149, "320", "村镇银行"),
    BOCOHK(151, "505", "中国银行（香港）"),
    FORTIS(152, "652", "比利时富通银行"),
    RBOSL(153, "672", "英国苏格兰皇家银行"),
    MRBANK(154, "969", "(澳门地区)银行"),
    BOCQ(155, "313", "重庆银行"),
    BOGZ1(156, "313", "赣州银行"),
    BOJJ(157, "313", "九江银行"),
    BOLY(158, "313", "洛阳银行"),
    BOHB(159, "313", "湖北银行"),
    BOHK(160, "313", "汉口银行"),
    BOSZ(161, "313", "苏州银行"),
    BOGS(162, "313", "甘肃银行"),
    BOGZ2(163, "313", "贵州银行"),
    BOZZ(164, "313", "郑州银行"),
    BOCA(165, "313", "长安银行"),
    BOKF(166, "313", "开封银行"),
    BOCS(167, "313", "长沙银行"),
    BOHB1(168, "313", "河北银行"),
    BOTS(169, "313", "唐山银行"),
    BOJS1(170, "313", "晋商银行"),
    BOJL(171, "313", "吉林银行"),
    BOHEB(172, "313", "哈尔滨银行"),
    BOLJ(173, "313", "龙江银行"),
    BONX(174, "313", "宁夏银行"),
    BOZJK(175, "313", "张家口银行"),
    BOJX1(176, "313", "江西银行"),
    BOGY(177, "313", "贵阳银行"),
    BOQH(178, "313", "青海银行"),
    BONMG(179, "313", "内蒙古银行"),
    BODW(180, "313", "东莞银行"),
    BOZY(181, "313", "中原银行");
    public final Integer id;
    public final String code;
    public final String bankName;

    EnumBank(Integer id, String code, String bankName) {
        this.id = id;
        this.code = code;
        this.bankName = bankName;
    }

    public static Integer getIdByCode(String code) {
        if (StringUtil.isBlank(code)) return null;
        return Arrays.stream(values()).anyMatch(item -> Objects.equals(code, item.code)) ? Arrays.stream(values()).filter(item -> Objects.equals(code, item.code)).findFirst().get().id : null;
    }

    public static String getBankNameByCode(String code) {
        if (StringUtil.isBlank(code)) return "";
        return Arrays.stream(values()).anyMatch(item -> Objects.equals(code, item.code)) ? Arrays.stream(values()).filter(item -> Objects.equals(code, item.code)).findFirst().get().bankName : "";
    }

    public static String getBankNameById(Integer id) {
        if (Objects.isNull(id)) return "";
        return Arrays.stream(values()).anyMatch(item -> Objects.equals(id, item.id)) ? Arrays.stream(values()).filter(item -> Objects.equals(id, item.id)).findFirst().get().bankName : "";
    }

    public static String getCodeById(Integer id) {
        if (Objects.isNull(id)) return "";
        return Arrays.stream(values()).anyMatch(item -> Objects.equals(id, item.id)) ? Arrays.stream(values()).filter(item -> Objects.equals(id, item.id)).findFirst().get().code : "";
    }

}