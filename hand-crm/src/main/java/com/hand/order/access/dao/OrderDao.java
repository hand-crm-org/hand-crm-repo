package com.hand.order.access.dao;

import com.hand.frame.util.PageQuery;
import com.hand.order.access.vo.OrderVO;

import java.util.List;

public interface OrderDao {

    /**
     * 插入销售订单信息
     * @UpdateBy LIUDH
     * @param orderVO
     * @return
     */
    int insertOrder(OrderVO orderVO);

    /**
     * 查询销售订单信息
     * @UpdateBy LIUDH
     * @param pageQuery
     * @return
     */
    List<OrderVO> queryOrderList(PageQuery<OrderVO> pageQuery);

    /**
     * 计数销售订单信息
     * @UpdateBy LIUDH
     * @param pageQuery
     * @return
     */
    int queryOrderCount(PageQuery<OrderVO> pageQuery);
}
