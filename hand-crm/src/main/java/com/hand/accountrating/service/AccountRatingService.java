package com.hand.accountrating.service;

import com.hand.accountrating.access.vo.AccountRatingVO;
import com.hand.contact.access.vo.ContactVO;
import com.hand.frame.util.PageQuery;

import java.util.List;

public interface AccountRatingService {
    /**
     * 查询客户评级列表
     * @param pageQuery
     * @return
     */
    List<ContactVO> getAccountRatingList(PageQuery<AccountRatingVO> pageQuery);

    /**
     * 新建客户评级信息
     * @param accountRatingVO
     * @return
     */
    String addAccountRating(AccountRatingVO accountRatingVO);

    /**
     * 修改客户评级信息
     * @param accountRatingVO
     * @return
     */
    boolean modifyAccountRating(AccountRatingVO accountRatingVO);
}
