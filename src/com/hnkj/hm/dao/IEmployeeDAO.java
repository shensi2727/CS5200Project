package com.hnkj.hm.dao;

import java.util.List;

import com.hnkj.hm.vo.EmployeeVO;

/**
 * <p>

 */
public interface IEmployeeDAO {

	/**
	 * 增加员工信息
	 * 
	 * @param employeeVo
	 * @return
	 */
	public boolean insertEmployee(EmployeeVO employeeVo);

	/**
	 * 修改员工信息
	 * 
	 * @param employeeVo
	 * @return
	 */
	public boolean modifyEmployee(EmployeeVO employeeVo);

	/**
	 * 根据员工ID删除信息
	 * 
	 * @param empid
	 * @return
	 */
	public boolean removeEmployee(String empid);

	/**
	 * 根据员工ID查询信息
	 * 
	 * @param Id
	 * @return
	 */
	public List<EmployeeVO> findEmployeeById(String Id);

	/**
	 * 查询所有的员工信息
	 * 
	 * @return
	 */
	public List<EmployeeVO> findAllEmployee();

}
