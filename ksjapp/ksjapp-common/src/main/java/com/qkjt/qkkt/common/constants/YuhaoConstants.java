package com.qkjt.qkkt.common.constants;

/**
 *
 * @author yuhao
 * @date 2014年12月26日 下午2:32:17
 */
public class YuhaoConstants {

	// APP类型
	public static final int IOS = 1;
	public static final int ANDROID = 2;
	public static final int WP = 3;

	// 客户端
	//一体机
	public static final int MFP = 1;
	//用户
	public static final int USER = 2;
	//医师
	public static final int DOCTOR = 3;
	
	//送药
	public static final int SY = 4;
	//接口送药
	public static final int SY_INF = 1;
	
	//接口送药内容
    public static final int MORE_SYCONTENT = 0;
    //接口下发URL
    public static final int MORE_BOTTOM = 1;
	
	//接口送药内容
	public static final int INF_SYCONTENT = 0;
	//接口下发URL
	public static final int INF_BOTTOM = 1;
	
	//YN
	public static final int Y=1;
	public static final int N=0;
	
	//客户端
    public static final String APP_IOS="ios";
    public static final String APP_ANDDROID="android";
	
	//删除标记
    public static final int DEL_Y=0;
    public static final int DEL_N=1;
	
	public static final String INVALID_MARK="99";
	
	//短信状态
	public static final int SMS_Success=1;//短信发送成功
	public static final int SMS_Faild=2;//短信发送失败
	public static final int SMS_Err=3;//短信发送程序错误
	
	//短信平台
    public static final int SMS_MD=1;//漫道
    public static final int SMS_JTD=2;//聚通达
    public static final int SMS_TXCT=3;//天下畅通
    //APP图片扩展名
    public static final String APP_IMG=".png";
    
    //运动频次
    public static final String Sport_Frequency="次/周";
    //运动分钟
    public static final String Sport_Minute="分钟/次";
}
