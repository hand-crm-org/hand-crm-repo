package com.hand.address.access.dao;

import com.hand.address.access.vo.AddressVO;
import com.hand.frame.util.PageQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressDao {
    /**
     * 根据code精确查询或者其他字段模糊查询
     * @UpdateBy yne
     * @param pageQuery
     * @Return List<AddressVO>
     */
    List<AddressVO> queryAddrList(PageQuery<AddressVO> pageQuery);

    /**
     * 根据查询条件对地址计数
     * @UpdateBy yne
     * @param pageQuery
     * @Return int
     */
    int queryAddrCount(PageQuery<AddressVO> pageQuery);
    /**
     * 新建地址信息
     * @UpdateBy yne
     * @param addressVO
     * @Return int
     */
    int insertAddr(AddressVO addressVO);

    /**
     * 修改地址信息
     * @UpdateBy yne
     * @param addressVO
     * @Return int
     */
    int updateAddr(AddressVO addressVO);
}
