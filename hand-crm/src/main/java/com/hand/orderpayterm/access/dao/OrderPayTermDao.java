package com.hand.orderpayterm.access.dao;

import com.hand.frame.util.PageQuery;
import com.hand.orderpayterm.access.vo.OrderPayTermVO;

import java.util.List;

public interface OrderPayTermDao {
    /**
     * 插入订单付款条件信息
     * @UpdateBy LIUDH
     * @param orderPayTermVO
     * @return
     */
    int insertPayTerm(OrderPayTermVO orderPayTermVO);

    /**
     * 查询订单付款条件信息
     * @UpdateBy LIUDH
     * @param pageQuery
     * @return
     */
    List<OrderPayTermVO> queryPayTermList(PageQuery<OrderPayTermVO> pageQuery);

    /**
     * 计数订单付款条件信息
     * @UpdateBy LIUDH
     * @param pageQuery
     * @return
     */
    int queryPayTermCount(PageQuery<OrderPayTermVO> pageQuery);

    /**
     * 修改订单付款条件
     * @UpdateBy LIUDH
     * @param orderPayTermVO
     * @Return int
     */
    int updatePayTerm(OrderPayTermVO orderPayTermVO);
    /**
     * 删除订单付款条件
     * @UpdateBy LIUDH
     * @param code
     * @Return int
     */
    int deletePayTerm(String code);
}
