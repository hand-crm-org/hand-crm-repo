package com.hand.accountrating.controller;

import com.alibaba.fastjson.JSONObject;
import com.hand.accountrating.access.vo.AccountRatingVO;
import com.hand.accountrating.service.AccountRatingService;
import com.hand.employee.access.vo.EmployeeVO;
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

@RestController
@Api("客户-客户评级api")
public class AccountRationController {
    @Autowired
    AccountRatingService accountRatingService;
    @ApiOperation("查询客户评级列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
            @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int"),
            @ApiImplicitParam(paramType = "query",name = "accountCode",value = "客户编码",dataType = "String")
    })
    @GetMapping("/get-accountRating-list")
    public ServiceData getAccountRatingList(int currentPage, int pageSize, String accountCode){
        AccountRatingVO accountRatingVO = new AccountRatingVO();
        accountRatingVO.setAccountCode(accountCode);
        PageQuery<AccountRatingVO> pageQuery = new PageQuery<AccountRatingVO>(accountRatingVO,currentPage,pageSize);
        return ServiceData.success(accountRatingService.getAccountRatingList(pageQuery), pageQuery.getMapOfPageQuery());
    }
    @ApiOperation("新建客户评级")
    @PostMapping("add-accountRating")
    public ResultDTO addAccountRating(@RequestBody AccountRatingVO accountRatingVO){
        String code = accountRatingService.addAccountRating(accountRatingVO);
        if (!StringUtil.isEmpty(code)){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code",code);
            return ResultDTO.success(jsonObject);
        }
        return ResultDTO.error("新建员工失败");
    }
    @ApiOperation("更新客户评级")
    @PutMapping("modify-accountRating")
    public ResultDTO modifyAccountRating(@RequestBody AccountRatingVO accountRatingVO){
        if (accountRatingService.modifyAccountRating(accountRatingVO)){
            return ResultDTO.success();
        }
        return ResultDTO.error("更新员工失败");
    }
}
