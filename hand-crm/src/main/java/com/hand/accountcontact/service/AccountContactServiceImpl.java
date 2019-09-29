package com.hand.accountcontact.service;

import com.hand.accountcontact.access.dao.AccountContactDao;
import com.hand.accountcontact.access.vo.AccountContactVO;
import com.hand.contact.access.vo.ContactVO;
import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountContactServiceImpl implements AccountContactService {
    @Autowired
    AccountContactDao accountContactDao;
    @Override
    public List<ContactVO> getAccountContactList(PageQuery<ContactVO> pageQuery) {
        int count = accountContactDao.queryAccountContactCount(pageQuery);
        if (count>0){
            pageQuery.setCount(count);
            return accountContactDao.queryAccountContactList(pageQuery);
        }
        return null;
    }

    @Override
    public String addAccountContact(AccountContactVO accountContactVO) {
        if (!StringUtil.isEmpty(accountContactVO.getUpdatedBy())&&
            !StringUtil.isEmpty(accountContactVO.getAccntCode())&&!StringUtil.isEmpty(accountContactVO.getCtctCode())){
            String code = StringUtil.getCode();
            accountContactVO.setCode(code);
            int count = accountContactDao.insertAccountContact(accountContactVO);
            if (count>0){
                return code;
            }
            return null;
        }
        else{
            throw new RuntimeException("miss params");
        }
    }

    @Override
    public boolean modifyAccountContact(AccountContactVO accountContactVO) {
        if (!StringUtil.isEmpty(accountContactVO.getCode())&&
            !StringUtil.isEmpty(accountContactVO.getUpdatedBy())){
            int count = accountContactDao.updateAccountContact(accountContactVO);
            return count>0;
        }else {
            throw new RuntimeException("miss params");
        }
    }
}
