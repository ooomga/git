package net.juntech.service.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.juntech.constant.PageConstant;

/**
 * 基础业务
 * <ul>
 * <li>xhl 2016年5月16日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 * 
 * @param <T>
 *
 */
public class BaseService {

	private static Log log = LogFactory.getLog(BaseService.class);

	protected Integer totalRecords; // 总条数
	protected Integer pageIndex; // 当前页数
	protected Integer pageSize; // 每页显示数
	private Integer totalPage; // 总页数
	protected List<Map<String, Object>> list; // 查询数据
	protected boolean isPage = false; // 是否需要分页

	/**
	 * 初始化分页参数
	 * <ul>
	 * <li>xhl 2016年5月16日 新建</li>
	 * </ul>
	 * 
	 * @param param
	 */
	public void init(Map<String, Object> param) {
		/* 重置 */
		isPage = false;

		Pattern pattern = Pattern.compile("[0-9]*");
		if (!param.containsKey("pageSize") || !param.containsKey("pageIndex")) {
			return;
		}

		isPage = true;
		if (param.containsKey("pageIndex")) {
			Object value = param.get("pageIndex");

			if (pattern.matcher(value.toString()).matches()) {
				this.pageIndex = Integer.parseInt(value.toString());
			} else {
				throw new IllegalArgumentException("分页参数错误");
			}
		} else {
			this.pageIndex = 1;
		}

		if (param.containsKey("pageSize")) {
			Object value = param.get("pageSize");
			if (pattern.matcher(value.toString()).matches()) {
				this.pageSize = Integer.parseInt(value.toString());
			} else {
				throw new IllegalArgumentException("分页参数错误");
			}
		} else {
			this.pageSize = 10;
		}

	}

	/**
	 * 计算总页数
	 * <ul>
	 * <li>xhl 2016年5月16日 新建</li>
	 * </ul>
	 * 
	 * @return
	 */
	private Integer totlePage() {
		if (null == pageSize) {
			throw new NullPointerException("分页条件错误");
		}
		totalPage = (totalRecords + this.pageSize - 1) / this.pageSize;
		return totalPage;
	}

	/**
	 * 返回分页信息包含数据
	 * <ul>
	 * <li>xhl 2016年5月16日 新建</li>
	 * </ul>
	 * 
	 * @param <T>
	 * 
	 * @param t
	 * @return
	 */
	protected Map<String, Object> result() {
		Map<String, Object> map = new HashMap<>();
		if (isPage) {
			map.put("pageIndex", this.pageIndex);
			map.put("pageSize", this.pageSize);
			map.put("totalRecords", this.totalRecords);
			map.put("totalPage", totlePage());
			if (log.isDebugEnabled()) {
				log.debug("分页信息:==>" + map);
			}
		}
		if (null == this.list) {
			this.list = new ArrayList<>();
		}
		map.put("list", this.list);
		return map;
	}
	
	/**
	 * sql组装
	 * <ul>
	 * <li>xhl 2016年12月28日 新建</li>
	 * </ul>
	 * 
	 * @param sql
	 *            需要组装分页或者排序的sql
	 * @param param
	 *            参数（包含分页或者排序）[pageIndex：当前页数(1)、pageSize：每页显示数(20)、orderBy：排序包含正序反序(name asc)]
	 * @return 组装后的sql
	 */
	protected StringBuffer sqlBuild(StringBuffer sql, Map<String, Object> param) {
		if (param.containsKey(PageConstant.ORDER_BY)) {
			String orderBy = param.get(PageConstant.ORDER_BY).toString();
			sql.append(" ORDER BY ").append(orderBy);
		}

		if (isPage) {
			sql.append(" LIMIT ").append((pageIndex - 1) * pageSize).append(", ").append(pageSize);
		}
		return sql;
	}

}
