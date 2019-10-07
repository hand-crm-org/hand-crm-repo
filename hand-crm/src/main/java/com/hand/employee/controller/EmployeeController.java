package com.hand.employee.controller;

import com.alibaba.fastjson.JSONObject;
import com.hand.employee.access.vo.EmployeeVO;
import com.hand.employee.service.EmployeeService;
import com.hand.frame.model.ResultDTO;
import com.hand.frame.model.ServiceData;
import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author nan.yao@hand-china.com 2019/9/30 16:37
 */
@RestController
@Api("员工相关api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @ApiOperation("查询员工")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
            @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int"),
            @ApiImplicitParam(paramType="query", name="created", value="创建时间", dataType="int"),
            @ApiImplicitParam(paramType="query", name="createdBy", value="创建人Id", dataType="int"),
            @ApiImplicitParam(paramType="query", name="updated", value="更新时间", dataType="int"),
            @ApiImplicitParam(paramType="query", name="updatedBy", value="更新人Id", dataType="int"),
            @ApiImplicitParam(paramType="query", name="code", value="员工编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="userFlag", value="用户标识", dataType="String"),
            @ApiImplicitParam(paramType="query", name="login", value="账号", dataType="String"),
            @ApiImplicitParam(paramType="query", name="password", value="密码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="name", value="名字", dataType="String"),
            @ApiImplicitParam(paramType="query", name="nameForeign", value="外文名字", dataType="String"),
            @ApiImplicitParam(paramType="query", name="nameShort", value="名字简称", dataType="String"),
            @ApiImplicitParam(paramType="query", name="workNum", value="工作电话", dataType="String"),
            @ApiImplicitParam(paramType="query", name="personalNum", value="个人电话", dataType="String"),
            @ApiImplicitParam(paramType="query", name="weChatNum", value="微信号", dataType="String"),
            @ApiImplicitParam(paramType="query", name="qqNum", value="QQ号", dataType="String"),
            @ApiImplicitParam(paramType="query", name="openId", value="微信openId", dataType="String"),
            @ApiImplicitParam(paramType="query", name="email", value="邮箱", dataType="String"),
            @ApiImplicitParam(paramType="query", name="jobLevel", value="职级", dataType="String"),
            @ApiImplicitParam(paramType="query", name="status", value="状态", dataType="String")

    })
    @GetMapping("/getEmployee")
    public ServiceData getEmployee(int currentPage, int pageSize, String created, String createdBy,
                                   String updated, String updatedBy, String code, String userFlag,
                                   String login, String password, String name, String nameForeign,
                                   String nameShort, String workNum, String personalNum, String weChatNum,
                                   String qqNum, String openId, String email, String jobLevel, String status){
        EmployeeVO employeeVO = new EmployeeVO();
        employeeVO.setCode(code);
        employeeVO.setCreated(created);
        employeeVO.setCreatedBy(createdBy);
        employeeVO.setUpdated(updated);
        employeeVO.setUpdatedBy(updatedBy);
        employeeVO.setUserFlg(userFlag);
        employeeVO.setLogin(login);
        employeeVO.setPassword(password);
        employeeVO.setName(name);
        employeeVO.setNameForeign(nameForeign);
        employeeVO.setNameShort(nameShort);
        employeeVO.setWorkNum(workNum);
        employeeVO.setPersonalNum(personalNum);
        employeeVO.setWechatNum(weChatNum);
        employeeVO.setQqNum(qqNum);
        employeeVO.setOpenId(openId);
        employeeVO.setEmail(email);
        employeeVO.setJobLevel(jobLevel);
        employeeVO.setStatus(status);

        PageQuery<EmployeeVO> pageQuery = new PageQuery<>(employeeVO,currentPage,pageSize);
        return ServiceData.success(employeeService.getEmployee(pageQuery), pageQuery.getMapOfPageQuery());
    }

    @ApiOperation("新建员工")
    @PostMapping("add-employee")
    public ResultDTO addEmployee(@RequestBody EmployeeVO employeeVO){
        String code = employeeService.addEmployee(employeeVO);
        if (!StringUtil.isEmpty(code)){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code",code);
            return ResultDTO.success(jsonObject);
        }
        return ResultDTO.error("新建员工失败");
    }

    @ApiOperation("更新员工")
    @PutMapping("modify-employee")
    public ResultDTO modifyEmployee(@RequestBody EmployeeVO employeeVO){
        if (employeeService.modifyEmployee(employeeVO)){
            return ResultDTO.success();
        }
        return ResultDTO.error("更新员工失败");
    }

    @ApiOperation("删除员工")
    @DeleteMapping("delete-employee")
    public ResultDTO deleteEmployee(String empCode){
        if (employeeService.deleteEmployee(empCode)){
            return ResultDTO.success();
        }
        return ResultDTO.error("删除员工失败");
    }
}
