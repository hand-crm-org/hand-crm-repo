package com.hand.accountsalesteam.access.dao;

import java.util.List;

import com.hand.accountsalesteam.access.vo.AccountSalesTeamVO;
import com.hand.frame.util.PageQuery;
import org.springframework.stereotype.Repository;

/**
 * @author nan.yao@hand-china.com 2019/8/28 17:29
 */

@Repository
public interface AccountSalesTeamDao {
    /**
     * 新建客户销售团队信息
     * @param accountSalesTeamVO
     * @return
     */
    int insertAccountSalesTeam(AccountSalesTeamVO accountSalesTeamVO);

    /**
     * 查询客户销售团队列表
     * @param pageQuery
     * @return
     */
    List<AccountSalesTeamVO> queryAccountSalesTeamList(PageQuery<AccountSalesTeamVO> pageQuery);

    /**
     * 对所有客户销售团队计数
     * @param pageQuery
     * @return
     */
    int queryAccountSalesTeamCount(PageQuery<AccountSalesTeamVO> pageQuery);

    /**
     * 修改客户销售团队信息
     * @param accountSalesTeamVO
     * @return
     */
    int updateAccountSalesTeam(AccountSalesTeamVO accountSalesTeamVO);

    /**
     * 删除客户销售团队
     * @param code
     * @return
     */
    int deleteAccountSalesTeam(String code);
}
