package com.hnkj.hm.dao;

import java.util.List;

import com.hnkj.hm.vo.EmployeeVO;

/**
 * <p>

 */
public interface IEmployeeDAO {

	/**
	 * ����Ա����Ϣ
	 * 
	 * @param employeeVo
	 * @return
	 */
	public boolean insertEmployee(EmployeeVO employeeVo);

	/**
	 * �޸�Ա����Ϣ
	 * 
	 * @param employeeVo
	 * @return
	 */
	public boolean modifyEmployee(EmployeeVO employeeVo);

	/**
	 * ����Ա��IDɾ����Ϣ
	 * 
	 * @param empid
	 * @return
	 */
	public boolean removeEmployee(String empid);

	/**
	 * ����Ա��ID��ѯ��Ϣ
	 * 
	 * @param Id
	 * @return
	 */
	public List<EmployeeVO> findEmployeeById(String Id);

	/**
	 * ��ѯ���е�Ա����Ϣ
	 * 
	 * @return
	 */
	public List<EmployeeVO> findAllEmployee();

}
