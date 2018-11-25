/** 
 * <pre>项目名称:shop-admin 
 * 文件名称:Page.java 
 * 包名:com.fh.shop.admin.util 
 * 创建日期:2018年10月14日下午8:57:13 
 * Copyright (c) 2018, chang15479612@163.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.api.util;

import java.io.Serializable;

/** 
 * <pre>项目名称：shop-admin    
 * 类名称：Page    
 * 类描述：    
 * 创建人：常帅杰 chang15479612@163.com    
 * 创建时间：2018年10月14日 下午8:57:13    
 * 修改人：常帅杰 chang15479612@163.com     
 * 修改时间：2018年10月14日 下午8:57:13    
 * 修改备注：       
 * @version </pre>    
 */
public class Page implements Serializable{

	private static final long serialVersionUID = -4159975899175446505L;

	
	private  Integer  start;
	
	
	private  Integer  length;


	public Integer getStart() {
		return start;
	}


	public void setStart(Integer start) {
		this.start = start;
	}


	public Integer getLength() {
		return length;
	}


	public void setLength(Integer length) {
		this.length = length;
	}
	
	
}
