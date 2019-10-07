package com.hand.employee.access.dao;

import java.util.List;

import com.hand.employee.access.vo.EmployeeVO;
import com.hand.frame.util.PageQuery;

/**
 * @author nan.yao@hand-china.com 2019/9/30 16:37
 */
public interface EmployeeDao {

    /**
     * 新增员工
     * @param employeeVO
     * @return
     */
    int insertEmployee(EmployeeVO employeeVO);

    /**
     * 更新员工
     * @param employeeVO
     * @return
     */
    int updateEmployee(EmployeeVO employeeVO);

    /**
     * 删除员工
     * @param empCode
     * @return
     */
    int deleteEmployee(String empCode);

    /**
     * 查询员工
     * @param pageQuery
     * @return
     */
    List<EmployeeVO> queryEmployee(PageQuery<EmployeeVO> pageQuery);

    /**
     * 查询员工计数
     * @param pageQuery
     * @return
     */
    int countEmployee(PageQuery<EmployeeVO> pageQuery);
}
