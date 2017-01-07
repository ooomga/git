/**
 * 
 */
package net.juntech.service.test.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.juntech.dao.common.ICommonDao;
import net.juntech.service.test.ITestService;
import net.juntech.util.UuidUtil;

/**
 * <ul>
 * <li>Dave 2016年12月22日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
/**
 * @author Dave
 *
 */
@Service
public class TestServiceImpl implements ITestService {

	@Autowired
	private ICommonDao commonDao;

	@Override
	public void delTestSerivce(String id) {
		System.out.println("receive client del user rquest userid " + id + "............................");
		Map<String, Object> param = new HashMap<>();
		String uuid = UuidUtil.generateUuid();
		param.put("id", uuid);
		commonDao.insert(param, "t_user");
		param.put("name", "zzzzz");
		param.put("pk", "id");
		commonDao.update(param, "t_user");
		commonDao.delete(param, "t_user");
		System.err.println(param.get("id"));
	}

}
