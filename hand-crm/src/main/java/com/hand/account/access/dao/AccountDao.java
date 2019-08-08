package com.hand.account.access.dao;

import com.hand.account.access.vo.AccountVO;
import com.hand.frame.util.PageQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao {
    /**
     * 新建客户
     * @UpdateBy lln
     * @param accountVO
     * @Return int
     */
    int insertAccount(AccountVO accountVO);
    /**
     * 根据条件查询客户
     * @UpdateBy lln
     * @param pageQuery
     * @Return List<AccountVO>
     */
    List<AccountVO> queryAccount(PageQuery<AccountVO> pageQuery);
    /**
     * 根据条件查询客户得到的数量
     * @UpdateBy lln
     * @param pageQuery
     * @Return List<AccountVO>
     */
    int queryAccountCount(PageQuery<AccountVO> pageQuery);
    /**
     * 修改客户信息
     * @UpdateBy lln
     * @param accountVO
     * @Return int
     */
    int updateAccount(AccountVO accountVO);
}
