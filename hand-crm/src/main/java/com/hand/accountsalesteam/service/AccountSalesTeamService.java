package com.hand.accountsalesteam.service;

import java.util.List;

import com.hand.accountsalesteam.access.vo.AccountSalesTeamVO;
import com.hand.frame.model.ResultDTO;
import com.hand.frame.util.PageQuery;

/**
 * @author nan.yao@hand-china.com 2019/8/28 17:24
 */
public interface AccountSalesTeamService {
    /**
     * 新建客户销售团队信息
     * @param accountSalesTeamVO
     * @return
     */
    ResultDTO addAccountSalesTeam(AccountSalesTeamVO accountSalesTeamVO);

    /**
     * 查询客户销售团队列表
     * @param pageQuery
     * @return
     */
    List<AccountSalesTeamVO> getAccountSalesTeamList(PageQuery<AccountSalesTeamVO> pageQuery);

    /**
     * 修改客户销售团队信息
     * @param accountSalesTeamVO
     * @return
     */
    ResultDTO modifyAccountSalesTeam(AccountSalesTeamVO accountSalesTeamVO);

    /**
     * 删除销售团队信息
     * @param code
     * @return
     */
    ResultDTO removeAccountSalesTeam(String code);
}
