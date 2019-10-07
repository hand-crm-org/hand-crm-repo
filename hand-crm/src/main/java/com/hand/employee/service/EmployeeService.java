package com.hand.employee.service;

import java.util.List;

import com.hand.employee.access.vo.EmployeeVO;
import com.hand.frame.util.PageQuery;

/**
 * @author nan.yao@hand-china.com 2019/9/30 16:37
 */
public interface EmployeeService {

    /**
     * 新建员工
     * @param employeeVO
     * @return
     */
    String addEmployee(EmployeeVO employeeVO);

    /**
     * 按条件查询员工
     * @param pageQuery
     * @return
     */
    List<EmployeeVO> getEmployee(PageQuery<EmployeeVO> pageQuery);

    /**
     * 更新员工信息
     * @param employeeVO
     * @return
     */
    boolean modifyEmployee(EmployeeVO employeeVO);

    /**
     * 删除员工
     * @param empCode
     * @return
     */
    boolean deleteEmployee(String empCode);
}
