package com.hand.orderpayterm.service;

import com.hand.frame.model.ResultDTO;
import com.hand.frame.util.PageQuery;
import com.hand.orderpayterm.access.vo.OrderPayTermVO;

import java.util.List;

public interface OrderPayTermService {
    /**
     * 新建付款条件
     * @UpdateBy liudh
     * @param orderPayTermVO
     * @Return int
     */
    ResultDTO addOrderPayTerm(OrderPayTermVO orderPayTermVO);


    /**
     * 根据条件查询付款条件
     * @UpdateBy liudh
     * @param pageQuery
     * @Return List<OrderPayTermVO>
     */
    List<OrderPayTermVO> getOrderPayTerm(PageQuery<OrderPayTermVO> pageQuery);


    /**
     * 更新付款条件
     * @UpdateBy liudh
     * @param orderPayTermVO
     * @Return int
     */
    ResultDTO modifyOrderPayTerm(OrderPayTermVO orderPayTermVO);


    /**
     * 删除付款条件
     * @UpdateBy liudh
     * @param orderPayTermVO
     * @Return int
     */
    ResultDTO removeOrderPayTerm(OrderPayTermVO orderPayTermVO);
}
