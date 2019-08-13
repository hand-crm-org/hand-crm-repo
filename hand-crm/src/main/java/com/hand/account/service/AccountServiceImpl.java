package com.hand.account.service;

import com.hand.account.access.dao.AccountDao;
import com.hand.account.access.vo.AccountVO;
import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    AccountDao accountDao;

    /**
     * 新建客户
     * @UpdateBy lln
     * @param accountVO
     * @Return int
     */
    @Override
    public String addAccount(AccountVO accountVO) {
        if (!StringUtil.isEmpty(accountVO.getPriEmpCode()) && !StringUtil.isEmpty(accountVO.getType())
                && !StringUtil.isEmpty(accountVO.getPeriodCode()) && !StringUtil.isEmpty(accountVO.getName())
                && !StringUtil.isEmpty(accountVO.getOrgCode()) && !StringUtil.isEmpty(accountVO.getUpdatedBy())
                && !StringUtil.isEmpty(accountVO.getStatus()) && !StringUtil.isEmpty(accountVO.getPeriodCode())
                && !StringUtil.isEmpty(accountVO.getPriCtctCode()) && !StringUtil.isEmpty(accountVO.getPhNum()))
        {
            if ("潜在客户".equals(accountVO.getPeriodCode()))
            {
                int count = accountDao.insertAccount(accountVO);
                if (count > 0) {
                    return "success";
                }
                return "failed";
            }
            else
            {
                if (!StringUtil.isEmpty(accountVO.getCode())&& !StringUtil.isEmpty(accountVO.getTaxCode())
                        && !StringUtil.isEmpty(accountVO.getAddrCode()))
                {
                    int count = accountDao.insertAccount(accountVO);
                    if (count > 0) {
                        return "success";
                    }
                    return "failed";
                }
                return "miss param";
            }
        }
        return "miss param";
    }

    /**
     * 根据条件查询客户
     * @UpdateBy lln
     * @param pageQuery
     * @Return List<AccountVO>
     */
    @Override
    public List<AccountVO> getAccount(PageQuery<AccountVO> pageQuery) {
        int count = accountDao.queryAccountCount(pageQuery);
        pageQuery.setCount(count);
        if(count > 0) {
            return accountDao.queryAccount(pageQuery);
        }
        return null;
    }

    /**
     * 修改客户
     * @UpdateBy lln
     * @param accountVO
     * @Return int
     */
    @Override
    public String modifyAccount(AccountVO accountVO) {
        if(!StringUtil.isEmpty(accountVO.getCode())&&!StringUtil.isEmpty(accountVO.getUpdatedBy())) {
            int count = accountDao.updateAccount(accountVO);
            if (count > 0) {
                return "success";
            }
            return "failed";
        }
        return "miss param";
    }
}