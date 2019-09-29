package com.hand.contact.service;

import com.hand.contact.access.vo.ContactVO;
import com.hand.frame.util.PageQuery;

import java.util.List;

public interface ContactService {
    /**
     * 根据code精确查询或者其他字段模糊查询
     * @UpdateBy yne
     * @param pageQuery
     * @Return List<contactVO>
     */
    List<ContactVO> getContactList(PageQuery<ContactVO> pageQuery);
    /**
     * 新建联系人信息
     * @UpdateBy yne
     * @param contactVO
     * @Return boolean
     */
    String addContact(ContactVO contactVO);

    /**
     * 修改联系人信息
     * @UpdateBy yne
     * @param contactVO
     * @Return boolean
     */
    boolean modifyContact(ContactVO contactVO);
}
