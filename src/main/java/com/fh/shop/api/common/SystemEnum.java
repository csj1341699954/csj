/** 
 * <pre>项目名称:shop-admin 
 * 文件名称:SystemEnum.java 
 * 包名:com.fh.shop.admin.common 
 * 创建日期:2018年10月19日下午2:01:06 
 * Copyright (c) 2018, chang15479612@163.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.api.common;

/** 
 * <pre>项目名称：shop-admin    
 * 类名称：SystemEnum    
 * 类描述：    
 * 创建人：常帅杰 chang15479612@163.com    
 * 创建时间：2018年10月19日 下午2:01:06    
 * 修改人：常帅杰 chang15479612@163.com     
 * 修改时间：2018年10月19日 下午2:01:06    
 * 修改备注：       
 * @version </pre>    
 */
public enum SystemEnum {
	
	SUCCESS(200,"ok"),
	ERROR(-1,"error"),

	SMS_MOBILE_NOT(2000,"手机号不能为空"),

	SMS_MOBILE_INCORRECT(2001,"手机号格式不正确"),

	SMS_CODE_TIMEOUT(2002,"验证码超时"),

	SMS_CODE_ERROE(2003,"验证码错误"),

	USER_NOT(2004,"用户不能为空"),

	USER_NOT_EXIST(2005,"可以创建该用户"),

	HEADR_NOT_MISS(3000,"头信息不完整"),
	TIME_NOT_OVERDUE(3005,"请求超时"),

	APPKEY_NOT_MISS(3006,"Appkey不存在"),

	SIGN_NOT_MISS(3006,"签名不对"),

	ATTACKED(3007,"被攻击了"),

	THE_NUMBER_OF_CAPS(3007,"次数上限");



	private   int  code;
	
	private   String  msg;
	
	private   SystemEnum(int code ,String  msg){
	    this.code=code;
	    this.msg=msg;
	}
	
	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
