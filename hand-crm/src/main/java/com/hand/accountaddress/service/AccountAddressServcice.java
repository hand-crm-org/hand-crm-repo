package com.hand.accountaddress.service;

import com.hand.accountaddress.access.vo.AccountAddressVO;
import com.hand.frame.util.PageQuery;

import java.util.List;

public interface AccountAddressServcice {
    /**
     * 新建客户-地址
     * @UpdateBy lln
     * @param accountAddressVO
     * @Return int
     */
    String addAccountAddr(AccountAddressVO accountAddressVO);


    /**
     * 根据条件查询客户-地址
     * @UpdateBy lln
     * @param pageQuery
     * @Return List<AccountAddressVO>
     */
    List<AccountAddressVO> getAccountAddr(PageQuery<AccountAddressVO> pageQuery);


    /**
     * 修改客户-地址
     * @UpdateBy lln
     * @param accountAddressVO
     * @Return int
     */
    String modifyAccountAddr(AccountAddressVO accountAddressVO);
}
