package com.hand.orderpayterm.controller;

import com.hand.frame.model.ResultDTO;
import com.hand.frame.model.ServiceData;
import com.hand.frame.util.DateFormatUtil;
import com.hand.frame.util.PageQuery;
import com.hand.orderpayterm.access.vo.OrderPayTermVO;
import com.hand.orderpayterm.service.OrderPayTermService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("订单付款条件api")
public class OrderPayTermController {
    @Value(value = "${lang.language}")
    private String langId;

    @Autowired
    private OrderPayTermService orderPayTermService;

    @ApiOperation(value="新建订单付款条件")
    @PostMapping("/add-order-payterm")
    public ResultDTO addOrderPayterm(@RequestBody OrderPayTermVO orderPayTermVO){
        return orderPayTermService.addOrderPayTerm(orderPayTermVO);
    }

    @ApiOperation(value="查询订单付款条件")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
            @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int"),
            @ApiImplicitParam(paramType="query", name="orderCode", value="订单编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="code", value="订单付款条件编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="payCondition", value="付款条件", dataType="String"),
            @ApiImplicitParam(paramType="query", name="payMethod", value="付款方式", dataType="String"),
            @ApiImplicitParam(paramType="query", name="payAmount", value="付款额度", dataType="Double"),
            @ApiImplicitParam(paramType="query", name="payTime", value="预计付款时间", dataType="String"),
            @ApiImplicitParam(paramType="query", name="createdName", value="创建人", dataType="String"),
            @ApiImplicitParam(paramType="query", name="created", value="创建日期", dataType="String"),
            @ApiImplicitParam(paramType="query", name="updated", value="更新时间", dataType="String"),
            @ApiImplicitParam(paramType="query", name="description", value="备注", dataType="String"),
    })
    @GetMapping("/get-order-payterm-info")
    public ServiceData getPatTermInfo(int currentPage, int pageSize,
                                        @RequestParam(value = "code",required = false) String code, @RequestParam(value = "payCondition",required = false) String payCondition,
                                        @RequestParam(value = "payAmount",required = false) Double payAmount, @RequestParam(value = "payTime",required = false) String payTime,
                                        @RequestParam(value = "createdName",required = false) String createdName, @RequestParam(value = "created",required = false) String created,
                                        @RequestParam(value = "payMethod",required = false) String payMethod, @RequestParam(value = "updated",required = false) String updated,
                                        @RequestParam(value = "description",required = false) String description){
        OrderPayTermVO orderPayTermVO = new OrderPayTermVO();
        orderPayTermVO.setCode(code);
        orderPayTermVO.setPayCondition(payCondition);
        orderPayTermVO.setPayAmount(payAmount);
        orderPayTermVO.setPayTime(DateFormatUtil.strToDate(payTime));
        orderPayTermVO.setPayMethod(payMethod);
        orderPayTermVO.setLangId(langId);
        orderPayTermVO.setCreatedName(createdName);
        orderPayTermVO.setDescription(description);
        orderPayTermVO.setCreated(DateFormatUtil.strToDate(created));
        orderPayTermVO.setUpdated(DateFormatUtil.strToDate(updated));
        PageQuery<OrderPayTermVO> pageQuery = new PageQuery<OrderPayTermVO>(orderPayTermVO, currentPage, pageSize);
        return  ServiceData.success(orderPayTermService.getOrderPayTerm(pageQuery), pageQuery.getMapOfPageQuery());
    }

    @ApiOperation(value="修改订单付款条件")
    @PutMapping("/modify-order-payterm")
    public ResultDTO modifyOrderPayterm(@RequestBody OrderPayTermVO orderPayTermVO){
        return orderPayTermService.modifyOrderPayTerm(orderPayTermVO);
    }

    @ApiOperation(value="删除订单付款条件")
    @DeleteMapping("/delete-order-payterm")
    public ResultDTO deleteOrderPayterm(@RequestBody OrderPayTermVO orderPayTermVO){
        return orderPayTermService.removeOrderPayTerm(orderPayTermVO);
    }
}
