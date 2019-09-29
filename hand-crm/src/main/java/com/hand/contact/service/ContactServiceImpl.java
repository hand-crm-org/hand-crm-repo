package com.hand.contact.service;

import com.hand.contact.access.dao.ContactDao;
import com.hand.contact.access.vo.ContactVO;
import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    ContactDao contactDao;
    @Override
    public List<ContactVO> getContactList(PageQuery<ContactVO> pageQuery) {
        int count = contactDao.queryContactCount(pageQuery);
        pageQuery.setCount(count);
        if (count>0){
            return contactDao.queryContactList(pageQuery);
        }
        return null;
    }

    @Override
    public String addContact(ContactVO contactVO) {
        if (!StringUtil.isEmpty(contactVO.getUpdatedBy())&&
            !StringUtil.isEmpty(contactVO.getName())){
            String code = StringUtil.getCode();
            contactVO.setCode(code);
            int count = contactDao.insertContact(contactVO);
            if (count>0){
                return code;
            }
            return null;
        }
        else {
            throw new RuntimeException("miss param!");
        }
    }

    @Override
    public boolean modifyContact(ContactVO contactVO) {
        if (!StringUtil.isEmpty(contactVO.getCode())&&!StringUtil.isEmpty(contactVO.getUpdatedBy())){
            int count = contactDao.updateContact(contactVO);
            return count>0;
        }
        else{
            throw new RuntimeException("miss param!");
        }
    }
}
