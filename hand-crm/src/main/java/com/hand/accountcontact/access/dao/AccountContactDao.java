package com.hand.accountcontact.access.dao;

import com.hand.accountcontact.access.vo.AccountContactVO;
import com.hand.frame.util.PageQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountContactDao {
    /**
     * 查询客户联系人列表
     * @param pageQuery
     * @return
     */
    List<AccountContactVO> queryAccountContactList(PageQuery<AccountContactVO> pageQuery);

    /**
     * 对所有客户联系人计数
     * @param pageQuery
     * @return
     */
    int queryAccountContactCount(PageQuery<AccountContactVO> pageQuery);

    /**
     * 新建客户联系人信息
     * @param accountContactVO
     * @return
     */
    int insertAccountContact(AccountContactVO accountContactVO);

    /**
     * 修改客户联系人信息
     * @param accountContactVO
     * @return
     */
    int updateAccountContact(AccountContactVO accountContactVO);
}
