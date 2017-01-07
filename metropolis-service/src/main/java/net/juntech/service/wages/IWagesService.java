package net.juntech.service.wages;

import java.util.List;
import java.util.Map;

public interface IWagesService {
	public List<Map<String, Object>> selectWagesAll();
	
	
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
	
	/**
	 * 查询党支部缴费详细
	 * <ul>
	 * <li>ZX 2016年12月28日 新建</li>
	 * </ul>
	 * 
	 * @return
	 */
	public Map<String,Object> selectPartyBranchDetail(String year, String partyBranchCode);
	
	
	/**
	 * 查询党支部缴费概要
	 * <ul>
	 * <li>ZX 2016年12月28日 新建</li>
	 * </ul>
	 * 
	 * @return
	 */
	public Map<String,Object> selectPartyBranchGeneral(String year, String companyCode);
	
	/**
	 * 搜索该用户所属的党支部信息
	 * @param psnCode
	 * @return
	 */
	public Map<String, Object> selectStaffPartyBranch(String psnCode);
}
