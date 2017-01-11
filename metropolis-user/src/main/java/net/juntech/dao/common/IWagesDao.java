package net.juntech.dao.common;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * <ul>
 * <li>ZX 2016年12月27日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Repository
public interface IWagesDao {
	
	/**
	 * 查询所有工资数据
	 * <ul>
	 * <li>ZX 2016年12月28日 新建</li>
	 * </ul>
	 * 
	 * @return
	 */
	public List<Map<String, Object>> selectWagesAll();
	
	/**
	 * 查询工资项目表内的字段是否存在工资数据表
	 * <ul>
	 * <li>ZX 2016年12月28日 新建</li>
	 * </ul>
	 * 
	 * @return
	 */
	public List<Map<String, Object>> checkWagesItems();
	
	/**
	 * 查询个人工资详情
	 * <ul>
	 * <li>ZX 2016年12月28日 新建</li>
	 * </ul>
	 * 
	 * @return
	 */
	public Map<String,Object> selectWagesDetail(String date, String staffCode);
	
	/**
	 * 查询个人工资概括
	 * <ul>
	 * <li>ZX 2016年12月28日 新建</li>
	 * </ul>
	 * 
	 * @return
	 */
	public Map<String,Object> selectWagesGeneral(String date, String staffCode);
}
