package com.qkjt.qkkt.common.constants;




public class AnalyseConstants {
    

  
    
    
    
	 //目标体重范围上限公式系数
	 public static final Float BMI_WT  = 23.9f;
	 //目标体重范围下限公式系数
	 public static final Float BMI_WF  = 18.5f;
	 
	 //体脂：男性需要增加或减少的体重公式系数
	 public static final Float TZ_WM  = 19.99f;
	 //体脂：女性需要增加或减少的体重公式系数
	 public static final Float TZ_WF  = 27.99f;
	 //血脂：低密度脂蛋白异常临界点
	 public static final Float XUEZHI_LDLC_LJ1  = 3.37f;
	 public static final Float XUEZHI_LDLC_LJ2  = 3.64f;
	 public static final Float XUEZHI_LDLC_LJ3  = 4.14f;
	 
	//测量单项类型(1身高体重，2腰围，3体脂，4血压，5血氧，6血糖，7血脂，8尿酸，9运动，10睡眠,11体温)
	 public static final String TYPE_BMI  = "1";
	 public static final String TYPE_YAOWEI  = "2";
	 public static final String TYPE_TIZHI  = "3";
	 public static final String TYPE_XUEYA  = "4";
	 public static final String TYPE_XUEYANG = "5";
	 public static final String TYPE_XUETANG  = "6";
	 public static final String TYPE_XUEZHI  = "7";
	 public static final String TYPE_NIAOSUAN  = "8";
	 public static final String TYPE_SPORT  = "9";
	 public static final String TYPE_SLEEP  = "10";
	 public static final String TYPE_TEMP  = "11";
	// public static final String TYPE_MAIBO  = "9";
	 //指标标识:TC总胆固醇,TG总甘油三酯,HDL-C高密度脂蛋白
	 public static final String XUEZHI_TYPE_TC  = "TC";
	 public static final String XUEZHI_TYPE_TG  = "TG";
	 public static final String XUEZHI_TYPE_LDLC  = "LDLC";
	 public static final String XUEZHI_TYPE_HDLC  = "HDLC";
	 //测量结果标识：1正常2临界3需治疗4严重
	 public static final String XUEZHI_ZC  = "1";
	 public static final String XUEZHI_LJ  = "2";
	 public static final String XUEZHI_ZL  = "3";
	 public static final String XUEZHI_YZ  = "4";
	 //代谢综合征包含的编码
	 public static final String MS_ALL_CODE = "OB02,OB03,OB04,OB05,OB06,DM02,DM03,HP01,HP02,HP03,HP04,DL01,DL02,DL03,DL04";
	 //指标有命中三个就是代谢综合征
	 public static final Integer MS_CODE_NUM = 3;
     //综合征编码
	 public static final String MS_CODE = "MS01";
	 //数据来源
	 public static final String DATA_SOURCE_MFP="MFP";
	 public static final String DATA_SOURCE_APP="APP";
	 public static final String DATA_SOURCE_GSM="GSM";
	   //数据来源
     public static final Integer SOURCE_MFP=1;
     public static final Integer SOURCE_APP=2;
     public static final Integer SOURCE_GSM=3;

	   //在此定义常量类
     //BMI
     public static final String BMI_H  = "身高";
     public static final String BMI_W  = "体重";
     public static final String BMI_BMI  = "BMI";
     //腰围
     public static final String YAOWEI_YW  = "腰围";
     //尿酸
     public static final String NIAOSUAN_NS  = "尿酸";
     public static final String NIAOSUAN_NSXT  = "尿酸血糖";
     public static final String NIAOSUAN_NSZDGC  = "尿酸总胆固醇";
     //血氧
     public static final String XUEYANG_XYZ  = "血氧";
     public static final String XUEYANG_MB  = "脉率";
     //血压
     public static final String XUEYA_SSY  = "收缩压";
     public static final String XUEYA_SZY  = "舒张压";
     public static final String XUEYA_XL  = "心率";
     
     //体脂
     public static final String TIZHI_ZFL  = "脂肪率";
     public static final String TIZHI_JCDX  = "基础代谢";
     public static final String TIZHI_TZW  = "体脂体重";
     public static final String TIZHI_SFL  = "水分率";
     public static final String TIZHI_ZK  = "阻抗";
     public static final String TIZHI_JRHL  = "肌肉含量";
     public static final String TIZHI_KLL  = "卡路里";
     public static final String TIZHI_GL  = "骨量";
     public static final String TIZHI_NZZF  = "内脏脂肪";
     //血糖
     public static final String XUETANG_XTZ  = "血糖";
     public static final String XUETANG_ISKF  = "是否空腹";
     //血脂
     public static final String XUEZHI_TC  = "总胆固醇";
     public static final String XUEZHI_TG  = "甘油三酯";
     public static final String XUEZHI_LDLC  = "低密度脂蛋白胆固醇";
     public static final String XUEZHI_HDLC  = "高密度脂蛋白胆固醇";
     //客户端类型
     public static final String CLIENT_MFP  = "MFP";
     public static final String CLIENT_APP  = "APP";
     public static final String CLIENT_PC  = "PC";
     //数据内容条目（1评估，2建议，3风险，4报告，5饮食，6运动，7营养，8保健，9模板，10睡眠）
     public static final String CONTENT_PG  = "1";
     public static final String CONTENT_JY  = "2";
     public static final String CONTENT_FX  = "3";
     public static final String CONTENT_BG  = "4";
     public static final String CONTENT_YS  = "5";
     public static final String CONTENT_YD  = "6";
     public static final String CONTENT_YY  = "7";
     public static final String CONTENT_BJ  = "8";
     public static final String CONTENT_MB  = "9";
     public static final String CONTENT_SM  = "10";
     //血糖测量是否空腹
     public static final String XUETANG_ISKF_Y  = "y";
     public static final String XUETANG_ISKF_N  = "n";
     public static final String XUETANG_ISKF_A  = "a";
     public static final String XUETANG_ISKF_Y_KF  = "空腹";
     public static final String XUETANG_ISKF_N_FKF  = "餐后两小时";
     public static final String XUETANG_ISKF_A_RY  = "任意时间";
     
     public static final String XUETANG_ISKF_1  = "1";//早餐前
     public static final String XUETANG_ISKF_2  = "2";//早餐后
     public static final String XUETANG_ISKF_3  = "3";//午餐前
     public static final String XUETANG_ISKF_4  = "4";//午餐后
     public static final String XUETANG_ISKF_5  = "5";//晚餐前
     public static final String XUETANG_ISKF_6  = "6";//晚餐后
     
     //慢病编码父节点
     public static final String SICK_PARENT_CODE  = "0";
     //自增ID模块类型
     public static final Integer MODUL_DIC  = 3;
     //报告类型：1指标报告2问卷报告3通用干预方案模板
     public static final Integer REPORT_TYEP_ITEM  = 1;
     public static final Integer REPORT_TYEP_SURVEY  = 2;
     public static final Integer REPORT_TYEP_SCHEME  = 3;
     //慢病编码  (OB:肥胖，HP:高血压，糖尿病：DM，血脂异常：DL,代谢综合征：MS，痛风症：GA）
     public static final String SICK_OB  = "OB";
     public static final String SICK_HP  = "HP";
     public static final String SICK_DM  = "DM";
     public static final String SICK_DL  = "DL";
     public static final String SICK_MS  = "MS";
     public static final String SICK_GA  = "GA";
     public static final String SICK_ZC  = "ZC";
     //餐饮特殊替换符
     public static final String DIET_SPLIT = "（四）";
     
     //模板编码
     //运动干预模板编码
     public static final String TEMP_SPORT  = "j04";
     //饮食模板编码，正常情况
     public static final String TEMP_DIET_NORMAL  = "j05";
     //饮食模板编码，尿酸异常
     public static final String TEMP_DIET_NS  = "j06";
     
     //总结模板，有病内容
     public static final String TEMP_REPORT_Y  = "j07";
     //总结模板，无内容
     public static final String TEMP_REPORT_W  = "j08";
     //总结模板，无病内容
     public static final String TEMP_REPORT_WB  = "j09";
     
     
     
     //通用干预方案编码
     public static final String COMMON_SCHEME  = "k100";
     //代谢综合征，优先干预血压，方案编码
     public static final String SCHEME_XY  = "CODE3";
     //代谢综合征，其次干预血糖，方案编码
     public static final String SCHEME_XT  = "CODE2";
     //代谢综合征，最后干预血脂，方案编码
     public static final String SCHEME_XZ  = "CODE5";
     
     //运动年龄界限
     public static final int SPORT_AGE_50 = 50;
     public static final int SPORT_AGE_60 = 60;
     //性别
     public static final String SEX_MALE  = "M";
     public static final String SEX_FEMALE  = "F";
     
     //运动强度 1，2，3，4 四个等级
     public static final int SPORT_LEVEL_1 = 1;
     public static final int SPORT_LEVEL_2 = 2;
     public static final int SPORT_LEVEL_3 = 3;
     public static final int SPORT_LEVEL_4 = 4;
     
     //干预方案类型 1 一体机  2手机
     public static final int SCHEME_TYPE_MFP = 1;
     public static final int SCHEME_TYPE_APP = 2;
     
     //减重每天消耗的热量((2/30)*7700/2)
     public static final int DAY_KCAL = 256;
     
    //每个月运动消耗能量
     public static final int MON_KCAL = 7700;
     //数据输入类型1：GSM手动，2：GSM自动，3：蓝牙手动，4：蓝牙自动
     public static final int INPUT_GSM_MANUAL = 1;
     public static final int INPUT_GSM_AUTO = 2;
     public static final int INPUT_BT_MANUAL = 3;
     public static final int INPUT_BT_AUTO = 4;
     //体脂设备类型1 一体机 2 手机体重秤
     public static final int TIZHI_EQ_MFP = 1;
     public static final int TIZHI_EQ_APP = 2;
     
     //正常需要区间编码，不推消息
     public static final String XUEYA_ZC  = "d04";
	 
	 
}
