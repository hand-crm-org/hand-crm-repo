package com.hand.contact.access.dao;

import com.hand.contact.access.vo.ContactVO;
import com.hand.frame.util.PageQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactDao {
    /**
     * 根据code精确查询或者其他字段模糊查询
     * @UpdateBy yne
     * @param pageQuery
     * @Return List<contactVO>
     */
    List<ContactVO> queryContactList(PageQuery<ContactVO> pageQuery);

    /**
     * 根据查询条件对联系人计数
     * @UpdateBy yne
     * @param pageQuery
     * @Return int
     */
    int queryContactCount(PageQuery<ContactVO> pageQuery);
    /**
     * 新建联系人信息
     * @UpdateBy yne
     * @param contactVO
     * @Return int
     */
    int insertContact(ContactVO contactVO);

    /**
     * 修改联系人信息
     * @UpdateBy yne
     * @param contactVO
     * @Return int
     */
    int updateContact(ContactVO contactVO);
}
