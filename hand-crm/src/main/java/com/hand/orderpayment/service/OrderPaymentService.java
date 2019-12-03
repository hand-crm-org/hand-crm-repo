package com.hand.orderpayment.service;

import com.hand.frame.model.ResultDTO;
import com.hand.frame.util.PageQuery;
import com.hand.orderpayment.access.vo.OrderPaymentVO;

import java.util.List;

public interface OrderPaymentService {
    /**
     * 新建订单回款
     * @UpdateBy liudh
     * @param orderPaymentVO
     * @Return int
     */
    ResultDTO addOrderPayment(OrderPaymentVO orderPaymentVO);


    /**
     * 根据条件查询订单回款
     * @UpdateBy liudh
     * @param pageQuery
     * @Return List<OrderPayTermVO>
     */
    List<OrderPaymentVO> getOrderPayment(PageQuery<OrderPaymentVO> pageQuery);


    /**
     * 更新订单回款
     * @UpdateBy liudh
     * @param orderPaymentVO
     * @Return int
     */
    ResultDTO modifyOrderPayment(OrderPaymentVO orderPaymentVO);


    /**
     * 删除订单回款
     * @UpdateBy liudh
     * @param orderPaymentVO
     * @Return int
     */
    ResultDTO removeOrderPayment(OrderPaymentVO orderPaymentVO);
}
