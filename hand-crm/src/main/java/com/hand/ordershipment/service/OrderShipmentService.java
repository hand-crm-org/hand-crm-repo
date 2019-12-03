package com.hand.ordershipment.service;

import com.hand.frame.model.ResultDTO;
import com.hand.frame.util.PageQuery;
import com.hand.ordershipment.access.vo.OrderShipmentVO;

import java.util.List;

public interface OrderShipmentService {
    /**
     * 新建订单发到货
     * @UpdateBy liudh
     * @param orderShipmentVO
     * @Return int
     */
    ResultDTO addOrderShipment(OrderShipmentVO orderShipmentVO);


    /**
     * 根据条件查询订单发到货
     * @UpdateBy liudh
     * @param pageQuery
     * @Return List<OrderProductVO>
     */
    List<OrderShipmentVO> getOrderShipment(PageQuery<OrderShipmentVO> pageQuery);


    /**
     * 更新订单发到货
     * @UpdateBy liudh
     * @param orderShipmentVO
     * @Return int
     */
    ResultDTO modifyOrderShipment(OrderShipmentVO orderShipmentVO);


    /**
     * 删除订单发到货
     * @UpdateBy liudh
     * @param orderShipmentVO
     * @Return int
     */
    ResultDTO removeOrderShipment(OrderShipmentVO orderShipmentVO);
}
