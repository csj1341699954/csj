/** 
 * <pre>项目名称:shop-admin 
 * 文件名称:ServerResponse.java 
 * 包名:com.fh.shop.admin.server 
 * 创建日期:2018年10月18日下午7:04:39 
 * Copyright (c) 2018, chang15479612@163.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.api.common;

import java.io.Serializable;

/** 
 * <pre>项目名称：shop-admin    
 * 类名称：ServerResponse    
 * 类描述：    
 * 创建人：常帅杰 chang15479612@163.com    
 * 创建时间：2018年10月18日 下午7:04:39    
 * 修改人：常帅杰 chang15479612@163.com     
 * 修改时间：2018年10月18日 下午7:04:39    
 * 修改备注：       
 * @version </pre>    
 */
public class ServerResponse implements Serializable{

	private static final long serialVersionUID = -201055230507300060L;

	private   Integer  code;
	
	private   String   msg;
	
    private   Object  data;

    public  ServerResponse(){
    	
    }
    
    private   ServerResponse(Integer  code,String   msg,Object  data){
    	this.code=code;
    	this.msg=msg;
    	this.data=data;
    }
    
    public static  ServerResponse error(Integer code ,String msg){
    	
    	return  new ServerResponse(code, msg, null);
    }
    
    public static  ServerResponse error(SystemEnum systemEnum){
    	
    	return  new ServerResponse(systemEnum.getCode(), systemEnum.getMsg(), null);
    }
    
    public  static  ServerResponse success(Object data){
    	
    	return new ServerResponse(200, "ok", data);
    }
    
    
    public  static  ServerResponse success(){
    	
    	return new ServerResponse(200, "ok", null);
    }
    
    
	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public Object getData() {
		return data;
	}
    
    
}
