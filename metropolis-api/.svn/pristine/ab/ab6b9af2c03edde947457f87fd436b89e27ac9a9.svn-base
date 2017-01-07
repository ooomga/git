package net.juntech.controller.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.juntech.constant.ProjectName;
import net.juntech.controller.base.BaseController;
import net.juntech.service.user.IAddressService;
import net.juntech.util.RedisUtil;
import net.juntech.util.zk.ClientProUtil;

/**
 * <ul>
 * <li>xhl 2017年1月2日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Controller
@RequestMapping(value = "mobile/address")
public class AddressController extends BaseController {

	// 地址列表
	@RequestMapping(value = "listAddress")
	public void listAddress(String json) throws IOException {
		Map<String, Object> params = verify(json, true);
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> user = RedisUtil.getMap(params.get("uuid"));
		params.put("userId", user.get("id"));
		IAddressService addressService = ClientProUtil.createInterface(IAddressService.class, ProjectName.METROPOLIS_USER);
		List<Map<String, Object>> list = addressService.selectAddressListAll(params);
		for (Map<String, Object> map : list) {
			map.remove("seq");
		}
		result.put("data", list);
		result.put(MSG, "获取成功");
		writeApiJson(new TreeMap<>(result), false);
	}

	// 地址保存
	@RequestMapping(value = "saveAddress")
	public void saveAddress(String json) throws IOException {
		Map<String, Object> params = verify(json, true);
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> user = RedisUtil.getMap(params.get("uuid"));
		params.put("userId", user.get("id"));
		IAddressService addressService = ClientProUtil.createInterface(IAddressService.class, ProjectName.METROPOLIS_USER);
		int row = addressService.insertAddress(params);
		if (row != 0) {
			result.put(MSG, "保存成功");
		}
		writeApiJson(new TreeMap<>(result), false);
	}

	// 地址删除
	@RequestMapping(value = "delAddress")
	public void delAddress(String json) throws IOException {
		Map<String, Object> params = verify(json, true);
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> user = RedisUtil.getMap(params.get("uuid"));
		params.put("userId", user.get("id"));
		IAddressService addressService = ClientProUtil.createInterface(IAddressService.class, ProjectName.METROPOLIS_USER);
		int row = addressService.deleteAddress(params);
		if (row != 0) {
			result.put(MSG, "删除成功");
		}
		writeApiJson(new TreeMap<>(result), false);
	}

}
