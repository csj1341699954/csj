/** 
 * <pre>项目名称:shop-admin 
 * 文件名称:System.java 
 * 包名:com.fh.shop.admin.util 
 * 创建日期:2018年10月18日下午2:14:10 
 * Copyright (c) 2018, chang15479612@163.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.api.util;

/** 
 * <pre>项目名称：shop-admin    
 * 类名称：System    
 * 类描述：    
 * 创建人：常帅杰 chang15479612@163.com    
 * 创建时间：2018年10月18日 下午2:14:10    
 * 修改人：常帅杰 chang15479612@163.com     
 * 修改时间：2018年10月18日 下午2:14:10    
 * 修改备注：       
 * @version </pre>    
 */
public interface SystemContext {
   
	int  LOG_SUCCESS=1;
	
	int  LOG_FAILURE=0;

	int  LOG_LOCK=1;

	int  LOG_ERROR_PASS=3;

	 String COOKIE="fhid";

	 String  IPLNUIX="192.168.1.12";


	//腾讯云的cos
	//secretId
	String  SECRETID="AKIDWt1va2YFzUlogImogIky1pPlskNnQ0nK";
	String  SECRETKEY ="UnqfEXdT5TfcPzPdbJl12oKdmjeLm47z";
	String  HTTP="ap-beijing";
	String  BUCKET="wan-gu-1257664014";
	String  COS_URL="https://wan-gu-1257664014.cos.ap-beijing.myqcloud.com/";

}
