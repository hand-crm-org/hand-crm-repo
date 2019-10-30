package com.hand.opportunityweekly.access.dao;

import com.hand.frame.util.PageQuery;
import com.hand.opportunityweekly.access.vo.OpportunityWeeklyVO;

import java.util.List;

public interface OpportunityWeeklyDao {
    /**
     * 插入商机周报信息
     * @UpdateBy LIUDH
     * @param opportunityWeeklyVO
     * @return
     */
    int insertOpportunityWeekly(OpportunityWeeklyVO opportunityWeeklyVO);

    /**
     * 查询商机周报信息
     * @UpdateBy LIUDH
     * @param pageQuery
     * @return
     */
    List<OpportunityWeeklyVO> queryOpportunityWeekly(PageQuery<OpportunityWeeklyVO> pageQuery);

    /**
     * 商机周报记录计数
     * @UpdateBy LIUDH
     * @param pageQuery
     * @return
     */
    int queryOpportunityWeeklyCount(PageQuery<OpportunityWeeklyVO> pageQuery);
    /**
     * 修改商机周报信息
     * @UpdateBy LIUDH
     * @param opportunityWeeklyVO
     * @Return int
     */
    int updateOpportunityWeekly(OpportunityWeeklyVO opportunityWeeklyVO);

    /**
     * 删除商机周报信息
     * @UpdateBy LIUDH
     * @param opportunityWeeklyVO
     * @return
     */
    int deleteOpportunityWeekly(OpportunityWeeklyVO opportunityWeeklyVO);
}
