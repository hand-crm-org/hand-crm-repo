package com.hand.orderpayment.controller;

import com.hand.frame.model.ResultDTO;
import com.hand.frame.model.ServiceData;
import com.hand.frame.util.DateFormatUtil;
import com.hand.frame.util.PageQuery;
import com.hand.orderpayment.access.vo.OrderPaymentVO;
import com.hand.orderpayment.service.OrderPaymentService;
import com.hand.orderpayterm.access.vo.OrderPayTermVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("订单回款api")
public class OrderPaymentController {
    @Value(value = "${lang.language}")
    private String langId;

    @Autowired
    private OrderPaymentService orderPaymentService;

    @ApiOperation(value="新建订单回款")
    @PostMapping("/add-order-payment")
    public ResultDTO addOrderPayment(@RequestBody OrderPaymentVO orderPaymentVO){
        return orderPaymentService.addOrderPayment(orderPaymentVO);
    }

    @ApiOperation(value="查询订单付款条件")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
            @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int"),
            @ApiImplicitParam(paramType="query", name="orderCode", value="订单编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="code", value="订单回款编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="paymentName", value="收款名称", dataType="String"),
            @ApiImplicitParam(paramType="query", name="planPaymentAmount", value="计划收款金额", dataType="Double"),
            @ApiImplicitParam(paramType="query", name="planPaymentTime", value="计划收款时间", dataType="String"),
            @ApiImplicitParam(paramType="query", name="billAmount", value="开票金额", dataType="Double"),
            @ApiImplicitParam(paramType="query", name="receivedAmount", value="收款金额", dataType="Double"),
            @ApiImplicitParam(paramType="query", name="createdName", value="创建人", dataType="String"),
            @ApiImplicitParam(paramType="query", name="created", value="创建日期", dataType="String"),
            @ApiImplicitParam(paramType="query", name="updated", value="更新时间", dataType="String"),
            @ApiImplicitParam(paramType="query", name="description", value="备注", dataType="String"),
    })
    @GetMapping("/get-order-payment-info")
    public ServiceData getPaymentInfo(int currentPage, int pageSize,
                                        @RequestParam(value = "code",required = false) String code, @RequestParam(value = "paymentName",required = false) String paymentName,
                                        @RequestParam(value = "planPaymentAmount",required = false) Double planPaymentAmount, @RequestParam(value = "planPaymentTime",required = false) String planPaymentTime,
                                        @RequestParam(value = "createdName",required = false) String createdName, @RequestParam(value = "created",required = false) String created,
                                        @RequestParam(value = "billAmount",required = false) Double billAmount, @RequestParam(value = "updated",required = false) String updated,
                                        @RequestParam(value = "description",required = false) String description, @RequestParam(value = "receivedAmount",required = false) Double receivedAmount){
        OrderPaymentVO orderPaymentVO = new OrderPaymentVO();
        orderPaymentVO.setCode(code);
        orderPaymentVO.setPaymentName(paymentName);
        orderPaymentVO.setPlanPaymentAmount(planPaymentAmount);
        orderPaymentVO.setPlanPaymentTime(DateFormatUtil.strToDate(planPaymentTime));
        orderPaymentVO.setBillAmount(billAmount);
        orderPaymentVO.setReceivedAmount(receivedAmount);
        orderPaymentVO.setLangId(langId);
        orderPaymentVO.setCreatedName(createdName);
        orderPaymentVO.setDescription(description);
        orderPaymentVO.setCreated(DateFormatUtil.strToDate(created));
        orderPaymentVO.setUpdated(DateFormatUtil.strToDate(updated));
        PageQuery<OrderPaymentVO> pageQuery = new PageQuery<OrderPaymentVO>(orderPaymentVO, currentPage, pageSize);
        return  ServiceData.success(orderPaymentService.getOrderPayment(pageQuery), pageQuery.getMapOfPageQuery());
    }

    @ApiOperation(value="修改订单付款条件")
    @PutMapping("/modify-order-payment")
    public ResultDTO modifyOrderPayment(@RequestBody OrderPaymentVO orderPaymentVO){
        return orderPaymentService.modifyOrderPayment(orderPaymentVO);
    }

    @ApiOperation(value="删除订单付款条件")
    @DeleteMapping("/delete-order-payment")
    public ResultDTO deleteOrderPayment(@RequestBody OrderPaymentVO orderPaymentVO){
        return orderPaymentService.removeOrderPayment(orderPaymentVO);
    }
}
