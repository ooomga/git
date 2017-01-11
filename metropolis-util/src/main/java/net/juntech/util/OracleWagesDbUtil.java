package net.juntech.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OracleWagesDbUtil {
	private static Connection conn = null;
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@//10.1.44.117:1521/orcl9547";
	private static String user = "hr_payroll";// 用户名
	private static String password = "pke9hI6mrc9EXCmj60Nx1D40";// 密码
	
	private static PreparedStatement sta = null;
	private static ResultSet rs = null;

	/**
	 * 加载驱动程序
	 */
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return 连接对象
	 */
	public static Connection getConn() {
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return conn;
	}

	
	/**
	 * @param sql
	 *            sql语句 增加，删除，修改
	 * @param obj
	 *            参数
	 * @return
	 */
	public static int update(String sql, Object... obj) {
		int count = 0;
		conn = getConn();
		try {
			sta = conn.prepareStatement(sql);
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					sta.setObject(i + 1, obj[i]);
				}
			}
			count = sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return count;
	}

	/**
	 * @param sql
	 *            sql语句
	 * @param obj
	 *            参数
	 * @return 数据集合
	 */
	public static ResultSet Query(String sql, Object... obj) {
		conn = getConn();
		try {
			sta = conn.prepareStatement(sql);
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					sta.setObject(i + 1, obj[i]);
				}
			}
			rs = sta.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 根据sql语句封装MAP的list。
	 * <ul>
	 * <li>ZX 2016年12月27日 新建</li>
	 * </ul>
	 * 
	 * @return
	 */
	public static List<Map<String, Object>> getWagesList(String sql) {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		ResultSet res = null;		
		try {
			res = Query(sql);
			ResultSetMetaData md = res.getMetaData(); //获得结果集结构信息,元数据
			int columnCount = md.getColumnCount();   //获得列数 
			while (res.next()) {
				Map<String,Object> rowData = new HashMap<String,Object>();
				for (int i = 1; i <= columnCount; i++) {
					rowData.put(md.getColumnName(i), res.getObject(i));
					list.add(rowData);
				}
//				rowData.put("usrLogin",res.getString("USR_LOGIN"));
//				rowData.put("usrEmpNo",res.getString("USR_EMP_NO"));
//				rowData.put("usrLastName",res.getString("USR_LAST_NAME"));
//				rowData.put("usrEmpType",res.getString("USR_EMP_TYPE"));
//				rowData.put("usrUdfCompanyId",res.getString("USR_UDF_COMPANY_ID"));
//				rowData.put("usrUdfCompanyName",res.getString("USR_UDF_COMPANY_NAME"));
//				rowData.put("usrUdfDeptId",res.getString("USR_UDF_DEPT_ID"));
//				rowData.put("usrUdfDeptName",res.getString("USR_UDF_DEPT_NAME"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	/**
	 * 关闭资源
	 */
	public static void close() {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (sta != null) {
					sta.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
