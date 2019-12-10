package com.hand.ordershipment.access.dao;

import com.hand.frame.util.PageQuery;
import com.hand.ordershipment.access.vo.OrderShipmentVO;

import java.util.List;

public interface OrderShipmentDao {

    /**
     * 插入订单发到货信息
     * @UpdateBy LIUDH
     * @param orderShipmentVO
     * @return
     */
    int insertOrderShipment(OrderShipmentVO orderShipmentVO);

    /**
     * 查询订单发到货信息
     * @UpdateBy LIUDH
     * @param pageQuery
     * @return
     */
    List<OrderShipmentVO> queryOrderShipmentList(PageQuery<OrderShipmentVO> pageQuery);

    /**
     * 计数订单发到货信息
     * @UpdateBy LIUDH
     * @param pageQuery
     * @return
     */
    int queryOrderShipmentCount(PageQuery<OrderShipmentVO> pageQuery);

    /**
     * 修改订单发到货
     * @UpdateBy LIUDH
     * @param orderShipmentVO
     * @Return int
     */
    int updateOrderShipment(OrderShipmentVO orderShipmentVO);
    /**
     * 删除订单发到货
     * @UpdateBy LIUDH
     * @param code
     * @Return int
     */
    int deleteOrderShipment(String code);
}
