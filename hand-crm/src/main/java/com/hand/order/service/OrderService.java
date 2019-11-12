package com.hand.order.service;

import com.hand.frame.model.ResultDTO;
import com.hand.frame.util.PageQuery;
import com.hand.order.access.vo.OrderVO;

import java.util.List;

public interface OrderService {
    /**
     * 新建销售订单
     * @UpdateBy LIUDH
     * @param orderVO
     * @Return int
     */
    ResultDTO addOrder(OrderVO orderVO);


    /**
     * 根据条件查询销售订单
     * @UpdateBy LIUDH
     * @param pageQuery
     * @Return List<OrderVO>
     */
    List<OrderVO> getOderList(PageQuery<OrderVO> pageQuery);
}
