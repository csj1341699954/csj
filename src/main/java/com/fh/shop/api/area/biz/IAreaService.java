/** 
 * <pre>项目名称:shop-admin2 
 * 文件名称:IAreaService.java 
 * 包名:com.fh.shop.admin.biz.area 
 * 创建日期:2018年10月9日下午12:05:53 
 * Copyright (c) 2018, chang15479612@163.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.api.area.biz;

import com.fh.shop.api.area.po.Area;
import com.fh.shop.api.common.ServerResponse;

import java.util.List;

/** 
 * <pre>项目名称：shop-admin2    
 * 类名称：IAreaService    
 * 类描述：    
 * 创建人：常帅杰 chang15479612@163.com    
 * 创建时间：2018年10月9日 下午12:05:53    
 * 修改人：常帅杰 chang15479612@163.com     
 * 修改时间：2018年10月9日 下午12:05:53    
 * 修改备注：       
 * @version </pre>    
 */
public interface IAreaService {

	/** <pre>delArea()   
	 * 创建人：常帅杰 chang15479612@163.com    
	 * 创建时间：2018年10月19日 下午3:10:23    
	 * 修改人：常帅杰 chang15479612@163.com     
	 * 修改时间：2018年10月19日 下午3:10:23    
	 * 修改备注： 
	 * @param ids</pre>    
	 */
	void delArea(List<Integer> ids);

	/** <pre>addArea()   
	 * 创建人：常帅杰 chang15479612@163.com    
	 * 创建时间：2018年10月19日 下午3:10:27    
	 * 修改人：常帅杰 chang15479612@163.com     
	 * 修改时间：2018年10月19日 下午3:10:27    
	 * 修改备注： 
	 * @param area</pre>    
	 */
	void addArea(Area area);

	/** <pre>updateArea()   
	 * 创建人：常帅杰 chang15479612@163.com    
	 * 创建时间：2018年10月19日 下午3:10:33    
	 * 修改人：常帅杰 chang15479612@163.com     
	 * 修改时间：2018年10月19日 下午3:10:33    
	 * 修改备注： 
	 * @param area</pre>    
	 */
	void updateArea(Area area);

	/** <pre>findAreaList()   
	 * 创建人：常帅杰 chang15479612@163.com    
	 * 创建时间：2018年10月19日 下午3:10:36    
	 * 修改人：常帅杰 chang15479612@163.com     
	 * 修改时间：2018年10月19日 下午3:10:36    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Area> findAreaList();


	ServerResponse findById(Integer id);
}
