package net.juntech.dao.common;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * 数据持久操作实现
 * 
 * @author xhl
 *
 */
@Repository
public interface ICommonDao {

	/**
	 * 数据库时间
	 * 
	 * @return Date 返回一个Date类型的日期(yyyy-MM-dd hh:MM:ss:sss);
	 * 
	 */
	Date selectDBTime();

	/**
	 * 添加数据（单条）
	 * <ul>
	 * <li>xhl 2016年12月26日 新建</li>
	 * </ul>
	 * 
	 * @param param
	 *            数据
	 * @param tableName
	 *            表名
	 * @return 影响行数
	 */
	int insert(Map<String, Object> param, String tableName);

	/**
	 * 添加数据（批量）
	 * <ul>
	 * <li>xhl 2016年12月26日 新建</li>
	 * </ul>
	 * 
	 * @param params
	 *            数据[如果需要添加的数据表不一致，需要设置参数tableName为null，在params中的Map在添加 key:table,value:表名]
	 * @param tableName
	 *            表名[支持null]
	 * @return 影响行数
	 */
	int insertBatch(List<Map<String, Object>> params, String tableName);

	/**
	 * 修改数据（单条）
	 * <ul>
	 * <li>xhl 2016年12月26日 新建</li>
	 * </ul>
	 * 
	 * @param param
	 *            数据
	 * @param tableName
	 *            表名
	 * @return 影响行数
	 */
	int update(Map<String, Object> param, String tableName);

	/**
	 * 修改数据（批量）
	 * <ul>
	 * <li>xhl 2016年12月26日 新建</li>
	 * </ul>
	 * 
	 * @param params
	 *            数据[如果需要修改的数据表不一致，需要设置参数tableName为null，在params中的Map在添加 key:table,value:表名]
	 * @param tableName
	 *            表名
	 * @return 影响行数
	 */
	int updateBatch(List<Map<String, Object>> params, String tableName);

	/**
	 * 删除数据（单条）
	 * <ul>
	 * <li>xhl 2016年12月26日 新建</li>
	 * </ul>
	 * 
	 * @param param
	 *            数据
	 * @param tableName
	 *            表名
	 * @return 影响行数
	 */
	int delete(Map<String, Object> param, String tableName);

	/**
	 * 删除数据（批量）
	 * 
	 * <ul>
	 * <li>xhl 2016年12月26日 新建</li>
	 * </ul>
	 * 
	 * @param params
	 *            数据[如果需要删除的数据表不一致，需要设置参数tableName为null，在params中的Map在添加 key:table,value:表名]
	 * @param tableName
	 *            表名
	 * @return 影响行数
	 */
	int deleteBatch(List<Map<String, Object>> params, String tableName);

}
