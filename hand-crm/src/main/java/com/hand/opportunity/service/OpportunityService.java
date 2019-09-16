package com.hand.opportunity.service;

import com.hand.frame.model.ResultDTO;
import com.hand.frame.util.PageQuery;
import com.hand.opportunity.access.vo.OpportunityVO;

import java.util.List;

public interface OpportunityService {
    /**
     * 新建商机
     * @UpdateBy lln
     * @param opportunityVO
     * @Return int
     */
    ResultDTO addOpportunity(OpportunityVO opportunityVO);


    /**
     * 根据条件查询商机
     * @UpdateBy lln
     * @param pageQuery
     * @Return List<OpportunityVO>
     */
    List<OpportunityVO> getOpportunity(PageQuery<OpportunityVO> pageQuery);


    /**
     * 修改商机
     * @UpdateBy lln
     * @param opportunityVO
     * @Return int
     */
    ResultDTO modifyOpportunity(OpportunityVO opportunityVO);
}
