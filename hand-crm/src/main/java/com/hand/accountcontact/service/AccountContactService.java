package com.hand.accountcontact.service;

import com.hand.accountcontact.access.vo.AccountContactVO;
import com.hand.contact.access.vo.ContactVO;
import com.hand.frame.util.PageQuery;

import java.util.List;

public interface AccountContactService {
    /**
     * 获取客户联系人列表
     * @param pageQuery
     * @return
     */
    List<ContactVO> getAccountContactList(PageQuery<ContactVO> pageQuery);

    /**
     * 增加客户联系人
     * @param accountContactVO
     * @return
     */
    String addAccountContact(AccountContactVO accountContactVO);

    /**
     * 更新客户联系人
     * @param accountContactVO
     * @return
     */
    boolean modifyAccountContact(AccountContactVO accountContactVO);
}
