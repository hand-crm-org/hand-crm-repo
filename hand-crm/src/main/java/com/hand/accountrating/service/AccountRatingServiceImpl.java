package com.hand.accountrating.service;

import com.hand.accountrating.access.dao.AccountRatingDao;
import com.hand.accountrating.access.vo.AccountRatingVO;
import com.hand.contact.access.vo.ContactVO;
import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountRatingServiceImpl implements AccountRatingService {
    @Autowired
    AccountRatingDao accountRatingDao;

    @Override
    public List<ContactVO> getAccountRatingList(PageQuery<AccountRatingVO> pageQuery) {
        int count = accountRatingDao.queryAccountRatingCount(pageQuery);
        if (count>0){
            pageQuery.setCount(count);
            return accountRatingDao.queryAccountRatingList(pageQuery);
        }
        return null;
    }

    @Override
    public String addAccountRating(AccountRatingVO accountRatingVO) {
        if (!StringUtil.isEmpty(accountRatingVO.getAccountCode()) && !StringUtil.isEmpty(accountRatingVO.getRatingLevel())
                && (accountRatingVO.getStartDate()!=null) && (accountRatingVO.getEndDate()!=null)
                && !StringUtil.isEmpty(accountRatingVO.getStatus()) && (accountRatingVO.getCreditAll()!=0)
                && (accountRatingVO.getCreditUsed()!=0))
        {
            String code = StringUtil.getCode();

                accountRatingVO.setCode(code);
                int count = accountRatingDao.insertAccountRating(accountRatingVO);
                if (count > 0) {
                    return code;
                }
                return null;
        }
        throw new RuntimeException("miss params");
    }

    @Override
    public boolean modifyAccountRating(AccountRatingVO accountRatingVO) {
        if (!StringUtil.isEmpty(accountRatingVO.getCode())&&!StringUtil.isEmpty(accountRatingVO.getUpdatedBy())){
            int count = accountRatingDao.updateAccountRating(accountRatingVO);
            return count>0;
        }
        else {
            throw new RuntimeException("miss param!");
        }
    }
}
