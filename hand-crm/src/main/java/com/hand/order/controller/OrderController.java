package com.hand.order.controller;

import com.hand.frame.model.ResultDTO;
import com.hand.frame.model.ServiceData;
import com.hand.frame.util.PageQuery;
import com.hand.order.access.vo.OrderVO;
import com.hand.order.service.OrderService;
import com.hand.orderpayment.access.vo.OrderPaymentVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@Api("销售订单相关api")
public class OrderController {

    @Value(value = "${lang.language}")
    private String langId;

    @Autowired
    OrderService orderService;

    @ApiOperation(value="新建销售订单")
    @PostMapping("/add-order-info")
    public ResultDTO addOrder(@RequestBody OrderVO orderVO){
        return orderService.addOrder(orderVO);
    }

    @ApiOperation(value="查询销售订单")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
            @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int"),
            @ApiImplicitParam(paramType="query", name="code", value="订单头编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="createdName", value="创建人", dataType="String"),
            @ApiImplicitParam(paramType="query", name="orderNumber", value="订单编号", dataType="String"),
            @ApiImplicitParam(paramType="query", name="accountCode", value="客户编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="accountName", value="客户", dataType="String"),
            @ApiImplicitParam(paramType="query", name="accountAddrCode", value="客户地址编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="refOptyCode", value="商机编码", dataType="Double"),
            @ApiImplicitParam(paramType="query", name="ownerDeptCode", value="业绩归属部门编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="orderType", value="合同类型", dataType="String"),
            @ApiImplicitParam(paramType="query", name="orderEntity", value="经营单位（签约主体", dataType="String"),
            @ApiImplicitParam(paramType="query", name="orderProperty", value="合同属性", dataType="String"),
            @ApiImplicitParam(paramType="query", name="country", value="国家", dataType="String"),
            @ApiImplicitParam(paramType="query", name="rate", value="税率", dataType="Double"),
            @ApiImplicitParam(paramType="query", name="amountRatedFlag", value="合同金额是否含税", dataType="String"),
            @ApiImplicitParam(paramType="query", name="totalAmount", value="签单金额", dataType="Double"),
            @ApiImplicitParam(paramType="query", name="ratedAmount", value="含税金额", dataType="Double"),
            @ApiImplicitParam(paramType="query", name="unratedAmount", value="不含税金额", dataType="Double"),
            @ApiImplicitParam(paramType="query", name="currency", value="币种", dataType="String"),
            @ApiImplicitParam(paramType="query", name="industy", value="行业", dataType="String"),
            @ApiImplicitParam(paramType="query", name="subIndusty", value="子行业", dataType="String"),
            @ApiImplicitParam(paramType="query", name="salesMethod", value="销售模式", dataType="String"),
            @ApiImplicitParam(paramType="query", name="orderCondition", value="合同生效条件", dataType="String"),
            @ApiImplicitParam(paramType="query", name="shipCondition", value="发货条件", dataType="String"),
            @ApiImplicitParam(paramType="query", name="orderSignTime", value="合同签订时间", dataType="String"),
            @ApiImplicitParam(paramType="query", name="orderEffectTime", value="合同生效时间", dataType="String"),
            @ApiImplicitParam(paramType="query", name="orderApproveTime", value="审批通过时间", dataType="String"),
            @ApiImplicitParam(paramType="query", name="orderStatus", value="订单状态", dataType="String"),
    })
    @GetMapping("/get-order-info")
    public ServiceData getOrderInfo(int currentPage, int pageSize,
                                        @RequestParam(value = "createdName",required = false) String createdName, @RequestParam(value = "orderNumber",required = false) String orderNumber,
                                        @RequestParam(value = "accountCode",required = false) String accountCode, @RequestParam(value = "accountName",required = false) String accountName,
                                        @RequestParam(value = "accountAddrCode",required = false) String accountAddrCode, @RequestParam(value = "refOptyCode",required = false) String refOptyCode,
                                        @RequestParam(value = "orderType",required = false) String orderType, @RequestParam(value = "ownerDeptCode",required = false) String ownerDeptCode,
                                        @RequestParam(value = "orderEntity",required = false) String orderEntity, @RequestParam(value = "orderProperty",required = false) String orderProperty,
                                        @RequestParam(value = "country",required = false) String country, @RequestParam(value = "rate",required = false) Double rate,
                                        @RequestParam(value = "amountRatedFlag",required = false) String amountRatedFlag, @RequestParam(value = "totalAmount",required = false) Double totalAmount,
                                        @RequestParam(value = "ratedAmount",required = false) Double ratedAmount, @RequestParam(value = "unratedAmount",required = false) Double unratedAmount,
                                        @RequestParam(value = "currency",required = false) String currency, @RequestParam(value = "industy",required = false) String industy,
                                        @RequestParam(value = "subIndusty",required = false) String subIndusty, @RequestParam(value = "salesMethod",required = false) String salesMethod,
                                        @RequestParam(value = "orderCondition",required = false) String orderCondition, @RequestParam(value = "shipCondition",required = false) String shipCondition,
                                        @RequestParam(value = "orderEffectTime",required = false) Date orderEffectTime, @RequestParam(value = "orderApproveTime",required = false) Date orderApproveTime,
                                        @RequestParam(value = "orderStatus",required = false) String orderStatus,@RequestParam(value = "code",required = false) String code){
        OrderVO orderVO = new OrderVO();
        orderVO.setCode(code);
        orderVO.setOrderNumber(orderNumber);
        orderVO.setAccountCode(accountCode);
        orderVO.setAccountName(accountName);
        orderVO.setAccountAddrCode(accountAddrCode);
        orderVO.setRefOptyCode(refOptyCode);
        orderVO.setOrderType(orderType);
        orderVO.setOwnerDeptCode(ownerDeptCode);
        orderVO.setCreatedName(createdName);
        orderVO.setOrderEntity(orderEntity);
        orderVO.setOrderProperty(orderProperty);
        orderVO.setCountry(country);
        orderVO.setRate(rate);
        orderVO.setAmountRatedFlag(amountRatedFlag);
        orderVO.setTotalAmount(totalAmount);
        orderVO.setRatedAmount(ratedAmount);
        orderVO.setUnratedAmount(unratedAmount);
        orderVO.setCurrency(currency);
        orderVO.setIndusty(industy);
        orderVO.setSubIndusty(subIndusty);
        orderVO.setSalesMethod(salesMethod);
        orderVO.setOrderCondition(orderCondition);
        orderVO.setShipCondition(shipCondition);
        orderVO.setOrderEffectTime(orderEffectTime);
        orderVO.setOrderApproveTime(orderApproveTime);
        orderVO.setOrderStatus(orderStatus);
        orderVO.setLangId(langId);
        PageQuery<OrderVO> pageQuery = new PageQuery<OrderVO>(orderVO, currentPage, pageSize);
        return  ServiceData.success(orderService.getOderList(pageQuery), pageQuery.getMapOfPageQuery());
    }

    @ApiOperation(value="修改销售订单")
    @PutMapping("/modify-order")
    public ResultDTO modifyOrder(@RequestBody OrderVO orderVO){
        return orderService.modifyOrder(orderVO);
    }
}
