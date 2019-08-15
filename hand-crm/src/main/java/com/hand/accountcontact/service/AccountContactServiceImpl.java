package com.hand.accountcontact.service;

import com.hand.accountcontact.access.dao.AccountContactDao;
import com.hand.accountcontact.access.vo.AccountContactVO;
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
    public List<AccountContactVO> getAccountContactList(PageQuery<AccountContactVO> pageQuery) {
        int count = accountContactDao.queryAccountContactCount(pageQuery);
        if (count>0){
            pageQuery.setCount(count);
            return accountContactDao.queryAccountContactList(pageQuery);
        }
        return null;
    }

    @Override
    public boolean addAccountContact(AccountContactVO accountContactVO) {
        if (!StringUtil.isEmpty(accountContactVO.getCode())&&!StringUtil.isEmpty(accountContactVO.getUpdatedBy())&&
            !StringUtil.isEmpty(accountContactVO.getAccntCode())&&!StringUtil.isEmpty(accountContactVO.getCtctCode())){
            int count = accountContactDao.insertAccountContact(accountContactVO);
            return count>0;
        }
        else{
            throw new RuntimeException("miss param");
        }
    }

    @Override
    public boolean modifyAccountContact(AccountContactVO accountContactVO) {
        if (!StringUtil.isEmpty(accountContactVO.getCode())&&!StringUtil.isEmpty(accountContactVO.getCtctCode())&&
            !StringUtil.isEmpty(accountContactVO.getUpdatedBy())){
            int count = accountContactDao.updateAccountContact(accountContactVO);
            return count>0;
        }else {
            throw new RuntimeException("miss param");
        }
    }
}
