package com.hand.opportunityweekly.service;

import com.hand.frame.model.ResultDTO;
import com.hand.frame.util.PageQuery;
import com.hand.opportunityweekly.access.vo.OpportunityWeeklyVO;

import java.util.List;

public interface OpportunityWeeklyService {
    /**
     * 新建商机周报
     * @UpdateBy LIUDH
     * @param opportunityWeeklyVO
     * @Return int
     */
    ResultDTO addOpportunityWeekly(OpportunityWeeklyVO opportunityWeeklyVO);


    /**
     * 根据条件查询商机周报
     * @UpdateBy LIUDH
     * @param pageQuery
     * @Return List<OpportunityWeeklyVO>
     */
    List<OpportunityWeeklyVO> getOpportunityWeekly(PageQuery<OpportunityWeeklyVO> pageQuery);


    /**
     * 修改商机周报
     * @UpdateBy LIUDH
     * @param opportunityWeeklyVO
     * @Return int
     */
    ResultDTO modifyOpportunityWeekly(OpportunityWeeklyVO opportunityWeeklyVO);

    /**
     * 删除商机商机周报
     * @UpdateBy LIUDH
     * @param opportunityWeeklyVO
     * @return
     */
    ResultDTO deleteOpportunityWeekly(OpportunityWeeklyVO opportunityWeeklyVO);
}
