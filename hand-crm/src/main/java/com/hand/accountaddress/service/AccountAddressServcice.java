package com.hand.accountaddress.service;

import com.hand.accountaddress.access.vo.AccountAddressVO;
import com.hand.address.access.vo.AddressVO;
import com.hand.frame.model.ResultDTO;
import com.hand.frame.util.PageQuery;

import java.util.List;

public interface AccountAddressServcice {
    /**
     * 新建客户-地址
     * @UpdateBy lln
     * @param accountAddressVO
     * @Return int
     */
    ResultDTO addAccountAddr(AccountAddressVO accountAddressVO);


    /**
     * 根据条件查询客户-地址
     * @UpdateBy lln
     * @param pageQuery
     * @Return List<AccountAddressVO>
     */
    List<AddressVO> getAccountAddr(PageQuery<AddressVO> pageQuery);


    /**
     * 修改客户-地址
     * @UpdateBy lln
     * @param accountAddressVO
     * @Return int
     */
    ResultDTO modifyAccountAddr(AccountAddressVO accountAddressVO);
}
