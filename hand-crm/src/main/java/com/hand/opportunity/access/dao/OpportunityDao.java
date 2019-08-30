package com.hand.opportunity.access.dao;

import com.hand.account.access.vo.AccountVO;
import com.hand.frame.util.PageQuery;
import com.hand.opportunity.access.vo.OpportunityVO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OpportunityDao {
    /**
     * 新建商机
     * @UpdateBy lln
     * @param opportunityVO
     * @Return int
     */
    int insertOpportunity(OpportunityVO opportunityVO);
    /**
     * 根据条件查询商机
     * @UpdateBy lln
     * @param pageQuery
     * @Return List<OpportunityVO>
     */
    List<OpportunityVO> queryOpportunity(PageQuery<OpportunityVO> pageQuery);
    /**
     * 根据条件查询商机得到的数量
     * @UpdateBy lln
     * @param pageQuery
     * @Return List<OpportunityVO>
     */
    int queryOpportunityCount(PageQuery<OpportunityVO> pageQuery);
    /**
     * 修改商机信息
     * @UpdateBy lln
     * @param opportunityVO
     * @Return int
     */
    int updateOpportunity(OpportunityVO opportunityVO);
}
