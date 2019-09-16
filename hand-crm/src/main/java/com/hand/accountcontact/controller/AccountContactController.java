package com.hand.accountcontact.controller;

import com.hand.accountcontact.access.vo.AccountContactVO;
import com.hand.accountcontact.service.AccountContactService;
import com.hand.frame.model.ResultDTO;
import com.hand.frame.model.ServiceData;
import com.hand.frame.util.PageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("客户-联系人相关api")
public class AccountContactController {
    @Autowired
    AccountContactService accountContactService;

    @ApiOperation("查询客户联系人列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
            @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int"),
            @ApiImplicitParam(paramType = "query",name = "code",value = "客户-联系人编码",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "accntCode",value = "客户编码",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "ctctCode",value = "联系人编码",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "status",value = "状态",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "desc",value = "描述",dataType = "String"),
    })
    @GetMapping("/getAccountContactList")
    public ServiceData getAccountContactList(int currentPage, int pageSize, String code, String accntCode,
                                        String ctctCode, String status, String desc){
        AccountContactVO accountContactVO = new AccountContactVO();
        accountContactVO.setCode(code);
        accountContactVO.setAccntCode(accntCode);
        accountContactVO.setCtctCode(ctctCode);
        accountContactVO.setStatus(status);
        accountContactVO.setDesc(desc);
        PageQuery<AccountContactVO> pageQuery = new PageQuery<AccountContactVO>(accountContactVO,currentPage,pageSize);
        return ServiceData.success(accountContactService.getAccountContactList(pageQuery), pageQuery.getMapOfPageQuery());
    }
    @ApiOperation(value="客户-联系人信息新建")
    @PostMapping("/addAccountContact")
    public ResultDTO addAccountContact(@RequestBody AccountContactVO accountContactVO){
        if (accountContactService.addAccountContact(accountContactVO)){
            return ResultDTO.success();
        }
        return ResultDTO.error("客户-联系人信息新建失败");
    }
    @ApiOperation(value="客户-联系人信息更新")
    @PutMapping("/modifyAccountContact")
    public ResultDTO modifyAccountContact(@RequestBody AccountContactVO accountContactVO){
        if (accountContactService.modifyAccountContact(accountContactVO)){
            return ResultDTO.success();
        }
        return ResultDTO.error("客户-联系人信息更新失败");
    }
}
