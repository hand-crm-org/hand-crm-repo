package com.hand.orderproduct.service;

import com.hand.frame.model.ResultDTO;
import com.hand.frame.util.PageQuery;
import com.hand.orderproduct.access.vo.OrderProductVO;

import java.util.List;

public interface OrderProductService {
    /**
     * 新建订单产品
     * @UpdateBy liudh
     * @param orderProductVO
     * @Return int
     */
    ResultDTO addOrderProd(OrderProductVO orderProductVO);


    /**
     * 根据条件查询订单产品
     * @UpdateBy liudh
     * @param pageQuery
     * @Return List<OrderProductVO>
     */
    List<OrderProductVO> getOrderProd(PageQuery<OrderProductVO> pageQuery);

    /**
     * 更新订单产品
     * @UpdateBy liudh
     * @param orderProductVO
     * @Return int
     */
    ResultDTO modifyOrderProd(OrderProductVO orderProductVO);


    /**
     * 删除订单产品
     * @UpdateBy liudh
     * @param orderProd
     * @Return int
     */
    ResultDTO removeOrderProd(OrderProductVO orderProd);
}
