package com.hand.accountrating.access.dao;

import com.hand.accountrating.access.vo.AccountRatingVO;
import com.hand.contact.access.vo.ContactVO;
import com.hand.frame.util.PageQuery;

import java.util.List;

public interface AccountRatingDao {

    /**
     * 查询客户评级列表
     * @param pageQuery
     * @return
     */
    List<ContactVO> queryAccountRatingList(PageQuery<AccountRatingVO> pageQuery);

    /**
     * 计数该客户联系人下的评级记录
     * @param pageQuery
     * @return
     */
    int queryAccountRatingCount(PageQuery<AccountRatingVO> pageQuery);

    /**
     * 新建客户评级记录
     * @param accountRatingVO
     * @return
     */
    int insertAccountRating(AccountRatingVO accountRatingVO);
}
