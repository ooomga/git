package net.juntech.service.wages.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.juntech.dao.common.ICommonDao;
import net.juntech.service.wages.IWagesService;
import net.juntech.util.MapUtil;
import net.juntech.util.OracleWagesDbUtil;

/**
 * <ul>
 * <li>ZX 2016年12月28日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Service
public class WagesServiceImpl implements IWagesService {

	@Autowired
	private ICommonDao commonDao;

	@Override
	public List<Map<String, Object>> selectWagesAll() {
		// TODO Auto-generated method stub
		
		
//		int result = 0;
//		String wagesDataSql = "select * from nchr.v_wadata_app sc ";
		String wagesItemSql = "select * from nchr.v_waitem_app t where t.unitcode = '00' and t.cyear = '2017' and t.cperiod = '01' ";
//		List<Map<String, Object>> wagesData= OracleWagesDbUtil.getWagesList(wagesDataSql);
		List<Map<String, Object>> wagesItem= OracleWagesDbUtil.getWagesList(wagesItemSql);
		
//		List<Map<String, Object>> list = commonDao.select(selectSql, null);
//		if (list.size() > 0) {
//			for (int i = 0; i < list.size(); i++) {
//				Map<String, Object> map = new HashMap<>();
//				map.put("account", list.get(i).get("usrLogin"));
//				map.put("id", UuidUtil.generateUuid());
//				map.put("password", "111111");
//				map.put("status", "2");
//				map.put("type", "2");
//				map.put("registTime", new Date());
//				map.put("display", "0");
//				map.put("verifyTime", new Date());
//				map.put("modifyTime", new Date());
//				map.put("validTime", new Date());
//				
//				result = commonDao.insert(map, "t_user_basis");
//			}
//		}
		
		return wagesItem;
	}

	@Override
	public Map<String, Object> selectWagesDetail(String date, String psnCode) {
		
		Map<String, Object> param1 = new HashMap<String, Object>();
		param1.put("psnCode", psnCode);
		param1.put("date", date);
		
		String orderBy = "";
		// 收入字段
		Map<String, Object> param2 = new HashMap<String, Object>();
		param2.put("fieldStat", "0");
		param2.put("companyCode", "00");
		List<Map<String, Object>> incomeParamList = commonDao.select(param2, "t_wages_explain", null, orderBy);
		List<String> incomeParams = MapUtil.mapToList(incomeParamList, "fieldName", "fieldExplain");
		// 查询收入
		List<Map<String, Object>> incomeList = commonDao.select(param1, "t_wages", incomeParams, orderBy);
		
		// 支出字段
		Map<String, Object> param3 = new HashMap<String, Object>();
		param3.put("fieldStat", "1");
		param3.put("companyCode", "00");
		List<Map<String, Object>> costParamList = commonDao.select(param3, "t_wages_explain", null, orderBy);
		List<String> costParams = MapUtil.mapToList(costParamList, "fieldName", "fieldExplain");
		// 查询支出
		List<Map<String, Object>> costList = commonDao.select(param1, "t_wages", costParams, orderBy);
		
		// 党费搜索条件
		Map<String, Object> param4 = new HashMap<String, Object>();
		param4.put("psnCode", psnCode);
		param4.put("year", date.substring(0, 4));
		
		// 党费搜索结果字段
		String notPaySql = "SELECT FORMAT(IFNULL(SUM(pc.partyDues),0),2) AS notPay FROM t_party_check pc WHERE pc.`year` = '2016' AND pc.usrLogin = :psnCode AND pc.userCheck = '0'";
		// 党费
		List<Map<String, Object>> partyDuesNotPay = commonDao.select(notPaySql, param4);
		String notPay = "";
		if (partyDuesNotPay.size() > 0) {
			notPay = partyDuesNotPay.get(0).get("notPay").toString();
		}
				
		String partyDuesListSql = "SELECT CONCAT(pc.`month`,'月') AS month ,pc.partyDues,pc.userCheck FROM t_party_check pc WHERE pc.usrLogin=:psnCode AND pc.`year` =:year ORDER BY month ASC ";
		// 党费
		List<Map<String, Object>> partyDuesList = commonDao.select(partyDuesListSql, param4);
		
		Map<String, Object> wagesDetail = new HashMap<String, Object>();
		wagesDetail.put("income", incomeList.get(0));
		wagesDetail.put("cost", costList.get(0));
		wagesDetail.put("partyDues", partyDuesList);
		wagesDetail.put("partyDuesNotPay", notPay);
		return wagesDetail;
	}

	@Override
	public Map<String, Object> selectWagesGeneral(String date, String psnCode) {
		
		Map<String, Object> wagesGeneral = new HashMap<String, Object>();
		// 获取工资概要信息
		String wagesSql = " SELECT w.f_1 AS 'totalPay',w.f_2 AS 'totalDeduction',w.f_3 AS 'totalNetIncome' FROM t_wages w WHERE w.date=:date AND w.psnCode=:psnCode ";
		Map<String, Object> param1 = new HashMap<String, Object>();
		param1.put("psnCode", psnCode);
		param1.put("date", date);
		List<Map<String, Object>> wagesList = commonDao.select(wagesSql, param1);
		// 判断是否有未缴党费
		String partyDuesSql = " SELECT pc.partyDues FROM t_party_check pc WHERE pc.`year`=:year AND pc.usrLogin=:psnCode ";
		Map<String, Object> param2 = new HashMap<String, Object>();
		param2.put("psnCode", psnCode);
		param2.put("year", date.substring(0, 4));
		List<Map<String, Object>> partyDuesList = commonDao.select(partyDuesSql, param2);
		String partyDues = "1";
		if (partyDuesList.size() > 0) {
			partyDues = "0";
		}
		wagesGeneral.put("wages", wagesList.get(0));
		wagesGeneral.put("partyDues", partyDues);
		return wagesGeneral;
	}
	
	@Override
	public Map<String, Object> selectPartyBranchDetail(String year, String partyBranchCode) {
		Map<String, Object> partyBranchDetail = new HashMap<String, Object>();
		String sql = " SELECT pb.partyBranchName, sc.usrUdfDeptName, sc.usrLastName, sc.usrLogin, pc.`month`, pc.partyDues,pc.userCheck, pc.partyCheck "
				+ " FROM t_party_branch pb LEFT JOIN t_staff_company sc ON sc.usrUdfDeptId = pb.deptCode LEFT JOIN t_party_check pc ON pc.usrLogin = sc.usrLogin "
				+ " WHERE pb.partyBranchCode =:partyBranchCode AND pc.`year` =:year AND sc.partyFlag = '1' ORDER BY convert(sc.usrLastName using gbk) ASC , pc.`month` ASC";
		Map<String, Object> param1 = new HashMap<String, Object>();
		param1.put("partyBranchCode", partyBranchCode);
		param1.put("year", year);
		List<Map<String, Object>> partyDuesList = commonDao.select(sql, param1);

		Map<String, Object> dataItem; // 数据库中查询到的每条记录
		Map<String, List<Map>> resultMap = new HashMap<String, List<Map>>(); // 最终要的结果
		int totalNotPay = 0;
		for (int i = 0; i < partyDuesList.size(); i++) {
			dataItem = partyDuesList.get(i);
			if ("0".equals(partyDuesList.get(i).get("partyCheck"))) {
				totalNotPay = totalNotPay + Integer.valueOf(partyDuesList.get(i).get("partyDues").toString());
			}
			if (resultMap.containsKey(dataItem.get("usrLastName"))) {
				resultMap.get(dataItem.get("usrLastName")).add(dataItem);
			} else {
				List<Map> list = new ArrayList<Map>();
				list.add(dataItem);
				resultMap.put(dataItem.get("usrLastName").toString(), list);
			}
		}

		partyBranchDetail.put("resultMap", resultMap);
		partyBranchDetail.put("totalNotPay", totalNotPay);
		return partyBranchDetail;
	}

	@Override
	public Map<String, Object> selectPartyBranchGeneral(String year, String companyCode) {
		
		Map<String, Object> partyBranchGeneral = new HashMap<String, Object>();
		// 搜索制定公司有未完成党费缴纳的党支部
		String sql = "SELECT pb.partyBranchCode,pb.partyBranchName,FORMAT(IFNULL(SUM(pc.partyDues),0),2) AS notpay "
				+ " FROM (SELECT * FROM t_party_branch GROUP BY partyBranchCode) AS pb LEFT JOIN t_party_check pc ON pb.partyBranchCode=pc.partyBranchCode AND pc.partyCheck = 0 AND pc.`year`=:year AND pb.companyCode=:companyCode "
				+ " GROUP BY pb.partyBranchCode "
				+ " ORDER BY  notpay ASC,pb.partyBranchCode ASC ";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("companyCode", companyCode);
		param.put("year", year);
		List<Map<String, Object>> partyDuesList = commonDao.select(sql, param);
		// 搜索已完成党费缴纳的党支部
		List<Map> finishList = new ArrayList<Map>();
		List<Map> unfinishList = new ArrayList<Map>();
		if (partyDuesList.size() > 0) {
			int size = partyDuesList.size();
			for (int i = 0; i < size; i++) {
				if (partyDuesList.get(i).get("notpay").equals("0.00")) {
					finishList.add(partyDuesList.get(i));
				} else {
					unfinishList.add(partyDuesList.get(i));
				}
			}
		}
		
		partyBranchGeneral.put("finishList", finishList);
		partyBranchGeneral.put("unfinishList", unfinishList);
		return partyBranchGeneral;
	}
	
	public Map<String, Object> selectStaffPartyBranch(String psnCode){
		String sql = "SELECT pb.partyBranchCode,pb.partyBranchName "
				+ "FROM t_staff_company sc LEFT JOIN t_party_branch pb ON sc.usrUdfCompanyId = pb.companyCode AND sc.usrUdfDeptId = pb.deptCode "
				+ "WHERE sc.usrLogin = :psnCode GROUP BY pb.partyBranchCode";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("psnCode", psnCode);
		List<Map<String, Object>> taffPartyBranchList = commonDao.select(sql, param);
		if (taffPartyBranchList.size() > 0) {
			return taffPartyBranchList.get(0);
		}else {
			return null;
		}
	}

}
