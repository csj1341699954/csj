/** 
 * <pre>项目名称:shop-admin2 
 * 文件名称:AreaService.java 
 * 包名:com.fh.shop.admin.biz.area 
 * 创建日期:2018年10月9日下午12:08:09 
 * Copyright (c) 2018, chang15479612@163.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.api.area.biz;

import com.fh.shop.api.area.mapper.IAreaMapper;
import com.fh.shop.api.area.po.Area;
import com.fh.shop.api.common.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * <pre>项目名称：shop-admin2    
 * 类名称：AreaService    
 * 类描述：    
 * 创建人：常帅杰 chang15479612@163.com    
 * 创建时间：2018年10月9日 下午12:08:09    
 * 修改人：常帅杰 chang15479612@163.com     
 * 修改时间：2018年10月9日 下午12:08:09    
 * 修改备注：       
 * @version </pre>    
 */
@Service("aeraService")
public class AreaServiceImpl  implements IAreaService{

	@Resource
	private IAreaMapper aeraMapper;
	
	/* (non-Javadoc)    
	 * @see com.fh.shop.admin.biz.area.IAreaService#delArea(java.util.List)    
	 */
	
	public void delArea(List<Integer> ids) {
		aeraMapper.delArea(ids);
	}

	/* (non-Javadoc)    
	 * @see com.fh.shop.admin.biz.area.IAreaService#addArea(com.fh.shop.admin.po.aera.Area)    
	 */
	public void addArea(Area area) {
		aeraMapper.addArea(area);	
		
	}

	/* (non-Javadoc)    
	 * @see com.fh.shop.admin.biz.area.IAreaService#updateArea(com.fh.shop.admin.po.aera.Area)    
	 */
	public void updateArea(Area area) {
		aeraMapper.updateArea(area);
	}

	/* (non-Javadoc)    
	 * @see com.fh.shop.admin.biz.area.IAreaService#findAreaList()    
	 */
	public List<Area> findAreaList() {
		return aeraMapper.findAreaList();
	}

	@Override
	public ServerResponse findById(Integer id) {
	    List<Area> alist=aeraMapper.findById(id);

		return ServerResponse.success(alist);
	}

}
