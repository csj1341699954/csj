/** 
 * <pre>项目名称:shop-admin2 
 * 文件名称:Area.java 
 * 包名:com.fh.shop.admin.po.aera 
 * 创建日期:2018年10月9日下午12:01:01 
 * Copyright (c) 2018, chang15479612@163.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.api.area.po;

import java.io.Serializable;

/** 
 * <pre>项目名称：shop-admin2    
 * 类名称：Area    
 * 类描述：    
 * 创建人：常帅杰 chang15479612@163.com    
 * 创建时间：2018年10月9日 下午12:01:01    
 * 修改人：常帅杰 chang15479612@163.com     
 * 修改时间：2018年10月9日 下午12:01:01    
 * 修改备注：       
 * @version </pre>    
 */
public class Area implements Serializable{

	private static final long serialVersionUID = 2976942577569666830L;

	
	private  Integer  aid;
	
	private  String  areaName;
	
	private  Integer afatherId;

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Integer getAfatherId() {
		return afatherId;
	}

	public void setAfatherId(Integer afatherId) {
		this.afatherId = afatherId;
	}
	
	
}
