package net.juntech.service.test;

import java.util.Date;
import java.util.List;
import java.util.Map;

import net.juntech.entity.UserEntity;

/**
 * <ul>
 * <li>xhl 2016年10月21日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public interface IUserService {

	/**
	 * 保存用户信息
	 * <ul>
	 * <li>xhl 2016年10月21日 新建</li>
	 * </ul>
	 * 
	 * @param userEntity
	 * 
	 * @return
	 */
	int saveUser(UserEntity userEntity);

	/**
	 * 查询用户列表
	 * <ul>
	 * <li>xhl 2016年10月21日 新建</li>
	 * </ul>
	 * 
	 * @return
	 *
	 */
	Map<String, Object> selectUserList(Map<String, Object> param);

	/**
	 * 查询所有用户
	 * <ul>
	 * <li>xhl 2016年10月21日 新建</li>
	 * </ul>
	 * 
	 * @param param
	 * @return
	 */
	List<UserEntity> selectUserAllList(Map<String, Object> param);

	/**
	 * 查询用户详情
	 * <ul>
	 * <li>xhl 2016年10月21日 新建</li>
	 * </ul>
	 * 
	 * @return
	 *
	 */
	UserEntity selectUser(Map<String, Object> param);

	/**
	 * 删除用户
	 * <ul>
	 * <li>xhl 2016年10月21日 新建</li>
	 * </ul>
	 * 
	 * @param ids
	 * @return
	 */
	int deleteUser(String ids);

	/**
	 * 查询数据库时间
	 * <ul>
	 * <li>xhl 2016年11月7日 新建</li>
	 * </ul>
	 * 
	 * @return
	 */
	Date selectDBDate();

}
