package com.hand.address.service;

import com.hand.address.access.vo.AddressVO;
import com.hand.frame.util.PageQuery;

import java.util.List;

public interface AddressService {
    /**
     * 根据code精确查询或者其他字段模糊查询
     * @UpdateBy yne
     * @param pageQuery
     * @Return List<AddressVO>
     */
    List<AddressVO> getAddrList(PageQuery<AddressVO> pageQuery);
    /**
     * 新建地址信息
     * @UpdateBy yne
     * @param addressVO
     * @Return boolean
     */
    boolean addAddr(AddressVO addressVO);

    /**
     * 修改地址信息
     * @UpdateBy yne
     * @param addressVO
     * @Return boolean
     */
    boolean modifyAddr(AddressVO addressVO);

}
