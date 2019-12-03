package com.hand.orderpayment.access.dao;

import com.hand.frame.util.PageQuery;
import com.hand.orderpayment.access.vo.OrderPaymentVO;

import java.util.List;

public interface OrderPaymentDao {
    /**
     * 插入订单回款信息
     * @UpdateBy LIUDH
     * @param orderPaymentVO
     * @return
     */
    int insertPayment(OrderPaymentVO orderPaymentVO);

    /**
     * 查询订单回款信息
     * @UpdateBy LIUDH
     * @param pageQuery
     * @return
     */
    List<OrderPaymentVO> queryPaymentList(PageQuery<OrderPaymentVO> pageQuery);

    /**
     * 计数订单回款信息
     * @UpdateBy LIUDH
     * @param pageQuery
     * @return
     */
    int queryPaymentCount(PageQuery<OrderPaymentVO> pageQuery);

    /**
     * 修改订单付款条件
     * @UpdateBy LIUDH
     * @param orderPaymentVO
     * @Return int
     */
    int updatePayment(OrderPaymentVO orderPaymentVO);
    /**
     * 删除订单回款
     * @UpdateBy LIUDH
     * @param code
     * @Return int
     */
    int deletePayment(String code);
}
