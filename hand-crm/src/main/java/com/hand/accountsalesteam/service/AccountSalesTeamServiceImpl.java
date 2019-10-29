package com.hand.accountsalesteam.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.hand.accountsalesteam.access.dao.AccountSalesTeamDao;
import com.hand.accountsalesteam.access.vo.AccountSalesTeamVO;
import com.hand.frame.model.ResultDTO;
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
    public ResultDTO addAccountSalesTeam(AccountSalesTeamVO accountSalesTeamVO) {
        if (!StringUtil.isEmpty(accountSalesTeamVO.getUpdatedBy())&&
            !StringUtil.isEmpty(accountSalesTeamVO.getAccntCode())&&!StringUtil.isEmpty(accountSalesTeamVO.getPriFlg())&&
            !StringUtil.isEmpty(accountSalesTeamVO.getEmpCode())){
            String code = StringUtil.getCode();
            accountSalesTeamVO.setCode(code);
            int count = accountSalesTeamDao.insertAccountSalesTeam(accountSalesTeamVO);
            if (count>0){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code", code);
                return ResultDTO.success(jsonObject);
            }
            return ResultDTO.error("新建销售团队失败");
        }
        return ResultDTO.error("缺失参数");
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
    public ResultDTO modifyAccountSalesTeam(AccountSalesTeamVO accountSalesTeamVO) {
        if (!StringUtil.isEmpty(accountSalesTeamVO.getCode())&&
            !StringUtil.isEmpty(accountSalesTeamVO.getUpdatedBy())){
            int count = accountSalesTeamDao.updateAccountSalesTeam(accountSalesTeamVO);
            if (count > 0) {
                return ResultDTO.success();
            }
            return ResultDTO.error("修改销售团队失败");
        }
        return ResultDTO.error("缺失参数");
    }

    @Override
    public ResultDTO removeAccountSalesTeam(String code) {
        if (!StringUtil.isEmpty(code)) {
            int count = accountSalesTeamDao.deleteAccountSalesTeam(code);
            if (count > 0) {
                return ResultDTO.success();
            }
            return ResultDTO.error("删除销售团队失败");
        }
        return ResultDTO.error("缺失参数");
    }
}
