/** 
 * <pre>项目名称:shop-admin 
 * 文件名称:WebContext.java 
 * 包名:com.fh.shop.admin.util 
 * 创建日期:2018年10月17日下午2:03:22 
 * Copyright (c) 2018, chang15479612@163.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.api.util;

import javax.servlet.http.HttpServletRequest;

/** 
 * <pre>项目名称：shop-admin    
 * 类名称：WebContext    
 * 类描述：    
 * 创建人：常帅杰 chang15479612@163.com    
 * 创建时间：2018年10月17日 下午2:03:22    
 * 修改人：常帅杰 chang15479612@163.com     
 * 修改时间：2018年10月17日 下午2:03:22    
 * 修改备注：       
 * @version </pre>    
 */
public class WebContext {
	  private  static    ThreadLocal<HttpServletRequest> requestLocal=new ThreadLocal<>();
    

	  public static  void setRequest(HttpServletRequest request){
		  requestLocal.set(request);
	  }
	  
	  public static  HttpServletRequest getReuqest(){
		  return requestLocal.get();
	  }

	  public static  void  remove(){
		  requestLocal.remove();
	  }

}

