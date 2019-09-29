package com.hand.account.service;

import com.hand.account.access.vo.AccountVO;
import com.hand.address.access.vo.AddressVO;
import com.hand.frame.util.PageQuery;

import java.util.List;

public interface AccountService {
    /**
     * 新建客户
     * @UpdateBy lln
     * @param accountVO
     * @Return int
     */
    String addAccount(AccountVO accountVO);


    /**
     * 根据条件查询客户
     * @UpdateBy lln
     * @param pageQuery
     * @Return List<PositionVO>
     */
    List<AccountVO> getAccount(PageQuery<AccountVO> pageQuery);


    /**
     * 修改客户
     * @UpdateBy lln
     * @param accountVO
     * @Return int
     */
    boolean modifyAccount(AccountVO accountVO);
}
