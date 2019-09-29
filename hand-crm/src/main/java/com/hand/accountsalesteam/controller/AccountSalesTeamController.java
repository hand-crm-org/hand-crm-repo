package com.hand.accountsalesteam.controller;

import com.alibaba.fastjson.JSONObject;
import com.hand.accountsalesteam.access.vo.AccountSalesTeamVO;
import com.hand.accountsalesteam.service.AccountSalesTeamService;
import com.hand.frame.model.ResultDTO;
import com.hand.frame.model.ServiceData;
import com.hand.frame.util.PageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author nan.yao@hand-china.com 2019/8/28 17:26
 */
@RestController
@Api("客户-销售团队相关api")
public class AccountSalesTeamController {
    @Autowired
    AccountSalesTeamService accountSalesTeamService;

    @ApiOperation("查询客户销售团队列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
            @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int"),
            @ApiImplicitParam(paramType = "query",name = "code",value = "客户-销售团队编码",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "accntCode",value = "客户编码",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "empCode",value = "员工编码",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "priFlg",value = "主要标识",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "status",value = "状态",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "desc",value = "描述",dataType = "String"),
    })
    @GetMapping("/getAccountSalesTeamList")
    public ServiceData getAccountSalesTeamList(int currentPage, int pageSize, String code, String accntCode,
                                             String empCode, String priFlg, String status, String desc){
        AccountSalesTeamVO accountSalesTeamVO = new AccountSalesTeamVO();
        accountSalesTeamVO.setCode(code);
        accountSalesTeamVO.setAccntCode(accntCode);
        accountSalesTeamVO.setEmpCode(empCode);
        accountSalesTeamVO.setPriFlg(priFlg);
        accountSalesTeamVO.setStatus(status);
        accountSalesTeamVO.setDesc(desc);
        PageQuery<AccountSalesTeamVO> pageQuery = new PageQuery<AccountSalesTeamVO>(accountSalesTeamVO,currentPage,pageSize);
        return ServiceData.success(accountSalesTeamService.getAccountSalesTeamList(pageQuery), pageQuery.getMapOfPageQuery());
    }
    @ApiOperation(value="客户-销售团队信息新建")
    @PostMapping("/addAccountSalesTeam")
    public ResultDTO addAccountSalesTeam(@RequestBody AccountSalesTeamVO accountSalesTeamVO){
        String code = accountSalesTeamService.addAccountSalesTeam(accountSalesTeamVO);
        if (code!=null){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code",code);
            return ResultDTO.success(jsonObject.toJSONString());
        }
        return ResultDTO.error("客户-销售团队信息新建失败");
    }
    @ApiOperation(value="客户-销售团队信息更新")
    @PutMapping("/modifyAccountSalesTeam")
    public ResultDTO modifyAccountSalesTeam(@RequestBody AccountSalesTeamVO accountSalesTeamVO){
        if (accountSalesTeamService.modifyAccountSalesTeam(accountSalesTeamVO)){
            return ResultDTO.success();
        }
        return ResultDTO.error("客户-销售团队信息更新失败");
    }
}
