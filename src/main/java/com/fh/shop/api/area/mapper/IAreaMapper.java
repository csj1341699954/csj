/** 
 * <pre>项目名称:shop-admin2 
 * 文件名称:AreaMapper.java 
 * 包名:com.fh.shop.admin.mapper.area 
 * 创建日期:2018年10月9日下午12:00:52 
 * Copyright (c) 2018, chang15479612@163.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.api.area.mapper;

import com.fh.shop.api.area.po.Area;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/** 
 * <pre>项目名称：shop-admin2    
 * 类名称：AreaMapper    
 * 类描述：    
 * 创建人：常帅杰 chang15479612@163.com    
 * 创建时间：2018年10月9日 下午12:00:52    
 * 修改人：常帅杰 chang15479612@163.com     
 * 修改时间：2018年10月9日 下午12:00:52    
 * 修改备注：       
 * @version </pre>    
 */
public interface IAreaMapper {

	/** <pre>addArea()   
	 * 创建人：常帅杰 chang15479612@163.com    
	 * 创建时间：2018年10月9日 下午12:13:04    
	 * 修改人：常帅杰 chang15479612@163.com     
	 * 修改时间：2018年10月9日 下午12:13:04    
	 * 修改备注： 
	 * @param area</pre>    
	 */
	void addArea(Area area);

	/** <pre>delArea()   
	 * 创建人：常帅杰 chang15479612@163.com    
	 * 创建时间：2018年10月9日 下午12:13:07    
	 * 修改人：常帅杰 chang15479612@163.com     
	 * 修改时间：2018年10月9日 下午12:13:07    
	 * 修改备注： 
	 * @param ids</pre>    
	 */
	void delArea(@Param("ids") List<Integer> ids);

	/** <pre>updateArea()   
	 * 创建人：常帅杰 chang15479612@163.com    
	 * 创建时间：2018年10月9日 下午12:13:10    
	 * 修改人：常帅杰 chang15479612@163.com     
	 * 修改时间：2018年10月9日 下午12:13:10    
	 * 修改备注： 
	 * @param area</pre>    
	 */
	void updateArea(Area area);

	/** <pre>findAreaList()   
	 * 创建人：常帅杰 chang15479612@163.com    
	 * 创建时间：2018年10月9日 下午12:13:12    
	 * 修改人：常帅杰 chang15479612@163.com     
	 * 修改时间：2018年10月9日 下午12:13:12    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Area> findAreaList();

	List<Area> findById(Integer id);
}