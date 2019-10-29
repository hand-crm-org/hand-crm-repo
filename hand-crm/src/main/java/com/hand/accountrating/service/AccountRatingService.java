package com.hand.accountrating.service;

import com.hand.accountrating.access.vo.AccountRatingVO;
import com.hand.contact.access.vo.ContactVO;
import com.hand.frame.model.ResultDTO;
import com.hand.frame.util.PageQuery;

import java.util.List;

public interface AccountRatingService {

    /**
     * 查询客户评级列表
     * @param pageQuery
     * @return
     */
    List<AccountRatingVO> getAccountRatingList(PageQuery<AccountRatingVO> pageQuery);

    /**
     * 新建客户评级信息
     * @param accountRatingVO
     * @return
     */
    ResultDTO addAccountRating(AccountRatingVO accountRatingVO);

    /**
     * 修改客户评级信息
     * @param accountRatingVO
     * @return
     */
    ResultDTO modifyAccountRating(AccountRatingVO accountRatingVO);

    /**
     * 查询客户评级版本信息
     * @param accountRatingVO
     * @return
     */
    AccountRatingVO queryAccountRatingVersion(AccountRatingVO accountRatingVO);
}
