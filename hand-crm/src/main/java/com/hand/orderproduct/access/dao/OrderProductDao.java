package com.hand.orderproduct.access.dao;

import com.hand.frame.util.PageQuery;
import com.hand.orderproduct.access.vo.OrderProductVO;

import java.util.List;

public interface OrderProductDao {

    /**
     * 插入订单产品信息
     * @UpdateBy LIUDH
     * @param orderProductVO
     * @return
     */
    int insertOrderProd(OrderProductVO orderProductVO);

    /**
     * 查询订单产品信息
     * @UpdateBy LIUDH
     * @param pageQuery
     * @return
     */
    List<OrderProductVO> queryOrderProdList(PageQuery<OrderProductVO> pageQuery);

    /**
     * 计数订单产品信息
     * @UpdateBy LIUDH
     * @param pageQuery
     * @return
     */
    int queryOrderProdCount(PageQuery<OrderProductVO> pageQuery);

    /**
     * 修改订单产品
     * @UpdateBy LIUDH
     * @param orderProductVO
     * @Return int
     */
    int updateOrderProd(OrderProductVO orderProductVO);
    /**
     * 删除订单产品
     * @UpdateBy LIUDH
     * @param code
     * @Return int
     */
    int deleteOrderProd(String code);
}
