package com.hand.accountaddress.controller;

import com.hand.account.access.vo.AccountVO;
import com.hand.account.service.AccountService;
import com.hand.accountaddress.access.vo.AccountAddressVO;
import com.hand.accountaddress.service.AccountAddressServcice;
import com.hand.frame.model.ResultDTO;
import com.hand.frame.model.ServiceData;
import com.hand.frame.util.DateFormatUtil;
import com.hand.frame.util.PageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("客户-地址相关api")
public class AccountAddressController {
    @Autowired
    AccountAddressServcice accountAddressServcice;

    @ApiOperation(value="新建客户-地址")
    @PostMapping("/addAccountAddr")
    public ResultDTO addAccount(@RequestBody AccountAddressVO accountAddressVO){
        return accountAddressServcice.addAccountAddr(accountAddressVO);
    }

    @ApiOperation(value="查询客户-地址")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
            @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int"),
            @ApiImplicitParam(paramType="query", name="code", value="客户-地址编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="addrCode", value="地址code", dataType="String"),
            @ApiImplicitParam(paramType="query", name="priFlg", value="是否主要", dataType="String"),
            @ApiImplicitParam(paramType="query", name="status", value="状态", dataType="String")
    })
    @GetMapping("/getAcntAddrInfo")
    public ServiceData getAccInfo(int currentPage, int pageSize,
                                  @RequestParam(value = "code",required = false) String code,@RequestParam(value = "addrCode",required = false) String addrCode,
                                  @RequestParam(value = "priFlg",required = false) String priFlg,@RequestParam(value = "status",required = false) String status){
        AccountAddressVO accountAddressVO = new AccountAddressVO();
        accountAddressVO.setCode(code);
        accountAddressVO.setAddrCode(addrCode);
        accountAddressVO.setPriFlg(priFlg);
        accountAddressVO.setStatus(status);

        PageQuery<AccountAddressVO> pageQuery = new PageQuery<AccountAddressVO>(accountAddressVO, currentPage, pageSize);
        return  ServiceData.success(accountAddressServcice.getAccountAddr(pageQuery), pageQuery.getMapOfPageQuery());
    }

    @ApiOperation(value="修改客户-地址")
    @PutMapping("/modifyAcntAddr")
    public ResultDTO modifyAccount(@RequestBody AccountAddressVO accountAddressVO){
        return accountAddressServcice.modifyAccountAddr(accountAddressVO);
    }
}
