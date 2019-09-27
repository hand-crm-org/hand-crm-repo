package com.hand.accountsalesteam.service;

import java.util.List;

import com.hand.accountsalesteam.access.dao.AccountSalesTeamDao;
import com.hand.accountsalesteam.access.vo.AccountSalesTeamVO;
import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nan.yao@hand-china.com 2019/8/28 17:25
 */
@Service
public class AccountSalesTeamServiceImpl implements AccountSalesTeamService {
    @Autowired
    AccountSalesTeamDao accountSalesTeamDao;
    @Override
    public boolean addAccountSalesTeam(AccountSalesTeamVO accountSalesTeamVO) {
        if (!StringUtil.isEmpty(accountSalesTeamVO.getUpdatedBy())&&
            !StringUtil.isEmpty(accountSalesTeamVO.getAccntCode())&&!StringUtil.isEmpty(accountSalesTeamVO.getPriFlg())&&
            !StringUtil.isEmpty(accountSalesTeamVO.getEmpCode())){
            accountSalesTeamVO.setCode(StringUtil.getCode());
            int count = accountSalesTeamDao.insertAccountSalesTeam(accountSalesTeamVO);
            return count>0;
        }
        else{
            throw new RuntimeException("miss params");
        }
    }

    @Override
    public List<AccountSalesTeamVO> getAccountSalesTeamList(PageQuery<AccountSalesTeamVO> pageQuery) {
        int count = accountSalesTeamDao.queryAccountSalesTeamCount(pageQuery);
        if (count>0){
            pageQuery.setCount(count);
            return accountSalesTeamDao.queryAccountSalesTeamList(pageQuery);
        }
        return null;
    }

    @Override
    public boolean modifyAccountSalesTeam(AccountSalesTeamVO accountSalesTeamVO) {
        if (!StringUtil.isEmpty(accountSalesTeamVO.getCode())&&
            !StringUtil.isEmpty(accountSalesTeamVO.getUpdatedBy())){
            int count = accountSalesTeamDao.updateAccountSalesTeam(accountSalesTeamVO);
            return count>0;
        }else {
            throw new RuntimeException("miss params");
        }
    }
}
