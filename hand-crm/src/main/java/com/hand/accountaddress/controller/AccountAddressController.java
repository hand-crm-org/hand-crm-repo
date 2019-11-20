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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("客户-地址相关api")
public class AccountAddressController {
    @Value(value = "${lang.language}")
    private String langId;

    @Autowired
    AccountAddressServcice accountAddressServcice;

    @ApiOperation(value="新建客户-地址")
    @PostMapping("/add-account-address")
    public ResultDTO addAccount(@RequestBody AccountAddressVO accountAddressVO){
        return accountAddressServcice.addAccountAddr(accountAddressVO);
    }

    @ApiOperation(value="查询客户-地址")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
            @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int"),
            @ApiImplicitParam(paramType="query", name="accntCode", value="客户编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="country", value="国家", dataType="String"),
            @ApiImplicitParam(paramType="query", name="state", value="省份", dataType="String"),
            @ApiImplicitParam(paramType="query", name="city", value="城市", dataType="String"),
            @ApiImplicitParam(paramType="query", name="county", value="区县", dataType="String"),
            @ApiImplicitParam(paramType="query", name="street", value="镇", dataType="String"),
            @ApiImplicitParam(paramType="query", name="addr1", value="详细地址", dataType="String"),
            @ApiImplicitParam(paramType="query", name="desc", value="备注", dataType="String"),
            @ApiImplicitParam(paramType="query", name="type", value="地址类型", dataType="String"),
            @ApiImplicitParam(paramType="query", name="status", value="状态", dataType="String")
    })
    @GetMapping("/get-account-address-info")
    public ServiceData getAccInfo(int currentPage, int pageSize,
                                  String accntCode,String country,String state,String city,String county,
                                  String street,String addr1,String desc,String type,String status){
        AccountAddressVO addressVO = new AccountAddressVO();
        addressVO.setAccntCode(accntCode);
        addressVO.setCountry(country);
        addressVO.setState(state);
        addressVO.setCity(city);
        addressVO.setCounty(county);
        addressVO.setStreet(street);
        addressVO.setAddr1(addr1);
        addressVO.setDesc(desc);
        addressVO.setType(type);
        addressVO.setStatus(status);
        addressVO.setLangId(langId);
        PageQuery<AccountAddressVO> pageQuery = new PageQuery<AccountAddressVO>(addressVO, currentPage, pageSize);
        return  ServiceData.success(accountAddressServcice.getAccountAddr(pageQuery), pageQuery.getMapOfPageQuery());
    }

    @ApiOperation(value="修改客户-地址")
    @PutMapping("/modify-account-address")
    public ResultDTO modifyAccount(@RequestBody AccountAddressVO accountAddressVO){
        return accountAddressServcice.modifyAccountAddr(accountAddressVO);
    }
}
