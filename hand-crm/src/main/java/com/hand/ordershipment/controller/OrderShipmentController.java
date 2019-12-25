package com.hand.ordershipment.controller;

import com.hand.frame.model.ResultDTO;
import com.hand.frame.model.ServiceData;
import com.hand.frame.util.DateFormatUtil;
import com.hand.frame.util.PageQuery;
import com.hand.ordershipment.access.vo.OrderShipmentVO;
import com.hand.ordershipment.service.OrderShipmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("订单发到货相关api")
public class OrderShipmentController {

    @Value(value = "${lang.language}")
    private String langId;

    @Autowired
    private OrderShipmentService orderShipmentService;

    @ApiOperation(value="新建订单发到货")
    @PostMapping("/add-order-shipment")
    public ResultDTO addOrderShipment(@RequestBody OrderShipmentVO orderShipmentVO){
        return orderShipmentService.addOrderShipment(orderShipmentVO);
    }

    @ApiOperation(value="查询订单发到货")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
            @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int"),
            @ApiImplicitParam(paramType="query", name="orderCode", value="订单头编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="code", value="订单发到货编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="shipNumber", value="发货序号", dataType="String"),
            @ApiImplicitParam(paramType="query", name="shipCondition", value="发货条件", dataType="String"),
            @ApiImplicitParam(paramType="query", name="shipDate", value="发货日期", dataType="String"),
            @ApiImplicitParam(paramType="query", name="receiveCondition", value="到货条件", dataType="String"),
            @ApiImplicitParam(paramType="query", name="receiveDate", value="到货日期", dataType="String"),
            @ApiImplicitParam(paramType="query", name="createdName", value="创建人", dataType="String"),
            @ApiImplicitParam(paramType="query", name="created", value="创建日期", dataType="String"),
            @ApiImplicitParam(paramType="query", name="updated", value="更新时间", dataType="String"),
            @ApiImplicitParam(paramType="query", name="limitedDays", value="期限天数", dataType="Integer"),
            @ApiImplicitParam(paramType="query", name="description", value="备注", dataType="String"),
    })
    @GetMapping("/get-order-shipment-info")
    public ServiceData getOrderShipmentInfo(int currentPage, int pageSize,
                                        @RequestParam(value = "code",required = false) String code, @RequestParam(value = "shipNumber",required = false) String shipNumber,
                                        @RequestParam(value = "shipCondition",required = false) String shipCondition, @RequestParam(value = "shipDate",required = false) String shipDate,
                                        @RequestParam(value = "receiveCondition",required = false) String receiveCondition, @RequestParam(value = "receiveDate",required = false) String receiveDate,
                                        @RequestParam(value = "createdName",required = false) String createdName, @RequestParam(value = "created",required = false) String created,
                                        @RequestParam(value = "limitedDays",required = false) Integer limitedDays, @RequestParam(value = "updated",required = false) String updated,
                                        @RequestParam(value = "description",required = false) String description,@RequestParam(value = "orderCode",required = false) String orderCode){
        OrderShipmentVO orderShipmentVO = new OrderShipmentVO();
        orderShipmentVO.setCode(code);
        orderShipmentVO.setOrderCode(orderCode);
        orderShipmentVO.setShipDate(DateFormatUtil.strToDate(shipDate));
        orderShipmentVO.setReceiveDate(DateFormatUtil.strToDate(receiveDate));
        orderShipmentVO.setShipCondition(shipCondition);
        orderShipmentVO.setReceiveCondition(receiveCondition);
        orderShipmentVO.setLimitedDays(limitedDays);
        orderShipmentVO.setShipNumber(shipNumber);
        orderShipmentVO.setLangId(langId);
        orderShipmentVO.setCreatedName(createdName);
        orderShipmentVO.setDescription(description);
        orderShipmentVO.setCreated(DateFormatUtil.strToDate(created));
        orderShipmentVO.setUpdated(DateFormatUtil.strToDate(updated));
        PageQuery<OrderShipmentVO> pageQuery = new PageQuery<OrderShipmentVO>(orderShipmentVO, currentPage, pageSize);
        return  ServiceData.success(orderShipmentService.getOrderShipment(pageQuery), pageQuery.getMapOfPageQuery());
    }

    @ApiOperation(value="修改订单发到货")
    @PutMapping("/modify-order-shipment")
    public ResultDTO modifyOrderShipment(@RequestBody OrderShipmentVO orderShipmentVO){
        return orderShipmentService.modifyOrderShipment(orderShipmentVO);
    }

    @ApiOperation(value="删除订单发到货")
    @DeleteMapping("/delete-order-shipment")
    public ResultDTO deleteOrderShipment(OrderShipmentVO orderShipmentVO){
        return orderShipmentService.removeOrderShipment(orderShipmentVO);
    }
}
