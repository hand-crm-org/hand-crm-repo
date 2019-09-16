package com.hand.address.controller;

import com.hand.address.access.vo.AddressVO;
import com.hand.address.service.AddressService;
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
@Api("地址相关api")
public class AddressController {
    @Autowired
    AddressService addressService;

    @ApiOperation(value="地址列表查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
            @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int"),
            @ApiImplicitParam(paramType="query", name="code", value="地址编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="objCode", value="对象编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="serviceCode", value="服务编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="country", value="国家", dataType="String"),
            @ApiImplicitParam(paramType="query", name="state", value="省", dataType="String"),
            @ApiImplicitParam(paramType="query", name="city", value="市", dataType="String"),
            @ApiImplicitParam(paramType="query", name="county", value="县", dataType="String"),
            @ApiImplicitParam(paramType="query", name="addr1", value="地址1", dataType="String"),
            @ApiImplicitParam(paramType="query", name="addr2", value="地址2", dataType="String")
    })
    @GetMapping("/getAddrList")
    public ServiceData getAddrList(int currentPage,int pageSize,String code,String objCode,String serviceCode,
                                   String country,String state,String city,String county,String addr1,String addr2){
        AddressVO addressVO = new AddressVO();
        addressVO.setCode(code);
        addressVO.setObjCode(objCode);
        addressVO.setServiceCode(serviceCode);
        addressVO.setCountry(country);
        addressVO.setState(state);
        addressVO.setCity(city);
        addressVO.setCounty(county);
        addressVO.setAddr1(addr1);
        addressVO.setAddr2(addr2);
        PageQuery<AddressVO> pageQuery = new PageQuery<AddressVO>(addressVO, currentPage, pageSize);
        return  ServiceData.success(addressService.getAddrList(pageQuery), pageQuery.getMapOfPageQuery());
    }
    @ApiOperation(value="地址信息新建")
    @PostMapping("/addAddr")
    public ResultDTO addAddr(@RequestBody AddressVO addressVO){
        if (addressService.addAddr(addressVO)){
            return ResultDTO.success();
        }
        return ResultDTO.error("地址信息新建失败");
    }
    @ApiOperation(value="地址信息更新")
    @PutMapping("/modifyAddr")
    public ResultDTO modifyAddr(@RequestBody AddressVO addressVO){
        if (addressService.modifyAddr(addressVO)){
            return ResultDTO.success();
        }
        return ResultDTO.error("地址信息更新失败");
    }

}
