package com.hand.accountaddress.service;

import com.hand.accountaddress.access.dao.AccountAddressDao;
import com.hand.accountaddress.access.vo.AccountAddressVO;
import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountAddressServiceImpl implements AccountAddressServcice{
    @Autowired
    AccountAddressDao accountAddressDao;

    /**
     * 新建客户-地址
     * @UpdateBy lln
     * @param accountAddressVO
     * @Return String
     */
    @Override
    public String addAccountAddr(AccountAddressVO accountAddressVO) {
        if (!StringUtil.isEmpty(accountAddressVO.getCode()) && !StringUtil.isEmpty(accountAddressVO.getAddrCode())
                && !StringUtil.isEmpty(accountAddressVO.getPriFlg()) && !StringUtil.isEmpty(accountAddressVO.getStatus()))
        {
                int count = accountAddressDao.insertAccountAddr(accountAddressVO);
                if (count > 0) {
                    return "success";
                }
                return "failed";
        }
        return "miss param";
    }

    /**
     * 根据条件查询客户-地址
     * @UpdateBy lln
     * @param pageQuery
     * @Return List<AccountAddressVO>
     */
    @Override
    public List<AccountAddressVO> getAccountAddr(PageQuery<AccountAddressVO> pageQuery) {
        int count = accountAddressDao.queryAccountAddrCount(pageQuery);
        pageQuery.setCount(count);
        if(count > 0) {
            return accountAddressDao.queryAccountAddr(pageQuery);
        }
        return null;
    }

    /**
     * 修改客户-地址
     * @UpdateBy lln
     * @param accountAddressVO
     * @Return String
     */
    @Override
    public String modifyAccountAddr(AccountAddressVO accountAddressVO) {
        if(!StringUtil.isEmpty(accountAddressVO.getCode())&&!StringUtil.isEmpty(accountAddressVO.getUpdatedBy())) {
            int count = accountAddressDao.updateAccountAddr(accountAddressVO);
            if (count > 0) {
                return "success";
            }
            return "failed";
        }
        return "miss param";
    }
}
