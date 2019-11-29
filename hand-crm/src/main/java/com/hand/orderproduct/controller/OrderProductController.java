package com.hand.orderproduct.controller;

import com.hand.frame.model.ResultDTO;
import com.hand.frame.model.ServiceData;
import com.hand.frame.util.DateFormatUtil;
import com.hand.frame.util.PageQuery;
import com.hand.orderproduct.access.vo.OrderProductVO;
import com.hand.orderproduct.service.OrderProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("订单产品相关api")
public class OrderProductController {
    @Value(value = "${lang.language}")
    private String langId;

    @Autowired
    private OrderProductService orderProductService;

    @ApiOperation(value="新建订单产品")
    @PostMapping("/add-order-product")
    public ResultDTO addOrderProd(@RequestBody OrderProductVO orderProductVO){
        return orderProductService.addOrderProd(orderProductVO);
    }

    @ApiOperation(value="查询订单产品")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
            @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int"),
            @ApiImplicitParam(paramType="query", name="orderCode", value="订单头编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="code", value="订单产品编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="productNum", value="产品编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="productCtlg", value="产品大类", dataType="String"),
            @ApiImplicitParam(paramType="query", name="productCtgy", value="产品小类", dataType="String"),
            @ApiImplicitParam(paramType="query", name="productUnit", value="产品单位", dataType="Double"),
            @ApiImplicitParam(paramType="query", name="productQuantity", value="产品数量", dataType="String"),
            @ApiImplicitParam(paramType="query", name="createdName", value="创建人", dataType="String"),
            @ApiImplicitParam(paramType="query", name="created", value="创建日期", dataType="String"),
            @ApiImplicitParam(paramType="query", name="updated", value="更新时间", dataType="String"),
            @ApiImplicitParam(paramType="query", name="productPrice", value="产品单价", dataType="String"),
            @ApiImplicitParam(paramType="query", name="description", value="备注", dataType="String"),
    })
    @GetMapping("/get-order-product-info")
    public ServiceData getOppActiveInfo(int currentPage, int pageSize,
                                        @RequestParam(value = "code",required = false) String code, @RequestParam(value = "productNum",required = false) String productNum,
                                        @RequestParam(value = "productCtlg",required = false) String productCtlg, @RequestParam(value = "productCtgy",required = false) String productCtgy,
                                        @RequestParam(value = "productUnit",required = false) String productUnit, @RequestParam(value = "productQuantity",required = false) String productQuantity,
                                        @RequestParam(value = "createdName",required = false) String createdName, @RequestParam(value = "created",required = false) String created,
                                        @RequestParam(value = "productPrice",required = false) String productPrice, @RequestParam(value = "updated",required = false) String updated,
                                        @RequestParam(value = "description",required = false) String description){
        OrderProductVO orderProductVO = new OrderProductVO();
        orderProductVO.setCode(code);
        orderProductVO.setProductNum(productNum);
        orderProductVO.setProductCtlg(productCtlg);
        orderProductVO.setProductCtgy(productCtgy);
        orderProductVO.setProductUnit(productUnit);
        orderProductVO.setProductQuantity(productQuantity);
        orderProductVO.setProductPrice(productPrice);
        orderProductVO.setLangId(langId);
        orderProductVO.setCreatedName(createdName);
        orderProductVO.setDescription(description);
        orderProductVO.setCreated(DateFormatUtil.strToDate(created));
        orderProductVO.setUpdated(DateFormatUtil.strToDate(updated));
        PageQuery<OrderProductVO> pageQuery = new PageQuery<OrderProductVO>(orderProductVO, currentPage, pageSize);
        return  ServiceData.success(orderProductService.getOrderProd(pageQuery), pageQuery.getMapOfPageQuery());
    }

    @ApiOperation(value="修改订单产品")
    @PutMapping("/modify-order-product")
    public ResultDTO modifyOrderProd(@RequestBody OrderProductVO orderProductVO){
        return orderProductService.modifyOrderProd(orderProductVO);
    }

    @ApiOperation(value="删除订单产品")
    @DeleteMapping("/delete-order-product")
    public ResultDTO deleteOrderProd(@RequestBody OrderProductVO orderProductVO){
        return orderProductService.removeOrderProd(orderProductVO);
    }
}
