/** 
 * <pre>项目名称:shop-admin2 
 * 文件名称:AreaController.java 
 * 包名:com.fh.shop.admin.controller.area 
 * 创建日期:2018年10月9日下午12:00:37 
 * Copyright (c) 2018, chang15479612@163.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.api.area.controller;

import com.fh.shop.api.area.biz.IAreaService;
import com.fh.shop.api.area.po.Area;
import com.fh.shop.api.common.ServerResponse;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * <pre>项目名称：shop-admin2    
 * 类名称：AreaController    
 * 类描述：    
 * 创建人：常帅杰 chang15479612@163.com    
 * 创建时间：2018年10月9日 下午12:00:37    
 * 修改人：常帅杰 chang15479612@163.com     
 * 修改时间：2018年10月9日 下午12:00:37    
 * 修改备注：       
 * @version </pre>    
 */
@RestController
public class AreaController {
	
	@Resource(name="aeraService")
	private IAreaService areaService;

	@GetMapping("/area/list")
	public Object  findById(Integer id,String callback){
		System.out.println(id+"00000000000000000000");
		ServerResponse alist=areaService.findById(id);
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(alist);
		mappingJacksonValue.setJsonpFunction(callback);
		return  mappingJacksonValue;
	}

}
