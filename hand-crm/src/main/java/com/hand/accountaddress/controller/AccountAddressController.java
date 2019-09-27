package com.hand.accountaddress.controller;

import com.hand.account.access.vo.AccountVO;
import com.hand.account.service.AccountService;
import com.hand.accountaddress.access.vo.AccountAddressVO;
import com.hand.accountaddress.service.AccountAddressServcice;
import com.hand.address.access.vo.AddressVO;
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
            @ApiImplicitParam(paramType="query", name="accntCode", value="客户编码", dataType="String")
    })
    @GetMapping("/getAcntAddrInfo")
    public ServiceData getAccInfo(int currentPage, int pageSize,
                                  String accntCode){
        AddressVO addressVO = new AddressVO();
        addressVO.setAccntCode(accntCode);
        PageQuery<AddressVO> pageQuery = new PageQuery<AddressVO>(addressVO, currentPage, pageSize);
        return  ServiceData.success(accountAddressServcice.getAccountAddr(pageQuery), pageQuery.getMapOfPageQuery());
    }

    @ApiOperation(value="修改客户-地址")
    @PutMapping("/modifyAcntAddr")
    public ResultDTO modifyAccount(@RequestBody AccountAddressVO accountAddressVO){
        return accountAddressServcice.modifyAccountAddr(accountAddressVO);
    }
}
