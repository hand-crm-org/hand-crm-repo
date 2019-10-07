package com.hand.employee.service;

import java.util.List;

import com.hand.employee.access.dao.EmployeeDao;
import com.hand.employee.access.vo.EmployeeVO;
import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nan.yao@hand-china.com 2019/9/30 16:38
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    @Override
    public String addEmployee(EmployeeVO employeeVO) {
        if (!StringUtil.isEmpty(employeeVO.getLogin())&&!StringUtil.isEmpty(employeeVO.getPassword())&&
            !StringUtil.isEmpty(employeeVO.getName())&&!StringUtil.isEmpty(employeeVO.getPriPostnCode())){
            String code = StringUtil.getCode();
            employeeVO.setCode(code);
            int count = employeeDao.insertEmployee(employeeVO);
            if (count>0){
                return code;
            }
        }
        else{
            throw new RuntimeException("miss params");
        }
        return null;
    }

    @Override
    public List<EmployeeVO> getEmployee(PageQuery<EmployeeVO> pageQuery) {
        int count = employeeDao.countEmployee(pageQuery);
        pageQuery.setCount(count);
        if (count>0){
            return employeeDao.queryEmployee(pageQuery);
        }
        return null;
    }

    @Override
    public boolean modifyEmployee(EmployeeVO employeeVO) {
        if (!StringUtil.isEmpty(employeeVO.getCode())&&!StringUtil.isEmpty(employeeVO.getUpdatedBy())){
            int count = employeeDao.updateEmployee(employeeVO);
            return count>0;
        }
        else {
            throw new RuntimeException("miss param!");
        }
    }

    @Override
    public boolean deleteEmployee(String empCode) {
        if (!StringUtil.isEmpty(empCode)){
            int count = employeeDao.deleteEmployee(empCode);
            return count>0;
        }
        else {
            throw new RuntimeException("miss param!");
        }
    }
}
