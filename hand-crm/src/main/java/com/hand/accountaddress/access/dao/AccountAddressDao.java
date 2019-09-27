package com.hand.accountaddress.access.dao;

import com.hand.accountaddress.access.vo.AccountAddressVO;
import com.hand.address.access.vo.AddressVO;
import com.hand.frame.util.PageQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountAddressDao {
    /**
     * 新建客户-地址
     * @UpdateBy lln
     * @param accountAddressVO
     * @Return int
     */
    int insertAccountAddr(AccountAddressVO accountAddressVO);
    /**
     * 根据条件查询客户-地址
     * @UpdateBy lln
     * @param pageQuery
     * @Return List<AccountAddressVO>
     */
    List<AddressVO> queryAccountAddr(PageQuery<AddressVO> pageQuery);
    /**
     * 根据条件查询客户-地址得到的数量
     * @UpdateBy lln
     * @param pageQuery
     * @Return List<AccountAddressVO>
     */
    int queryAccountAddrCount(PageQuery<AddressVO> pageQuery);
    /**
     * 修改客户-地址信息
     * @UpdateBy lln
     * @param accountAddressVO
     * @Return int
     */
    int updateAccountAddr(AccountAddressVO accountAddressVO);
}
