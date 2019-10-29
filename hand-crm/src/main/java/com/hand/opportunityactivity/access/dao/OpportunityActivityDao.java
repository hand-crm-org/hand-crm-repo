package com.hand.opportunityactivity.access.dao;

import com.hand.frame.util.PageQuery;
import com.hand.opportunityactivity.access.vo.OpportunityActivityVO;

import java.util.List;

public interface OpportunityActivityDao {
    /**
     * 插入商机活动信息
     * @UpdateBy LIUDH
     * @param opportunityActivityVO
     * @return
     */
    int insertOpportunityActive(OpportunityActivityVO opportunityActivityVO);

    /**
     * 查询商机活动信息
     * @UpdateBy LIUDH
     * @param pageQuery
     * @return
     */
    List<OpportunityActivityVO> queryOpportunityActive(PageQuery<OpportunityActivityVO> pageQuery);

    /**
     * 商机活动记录计数
     * @UpdateBy LIUDH
     * @param pageQuery
     * @return
     */
    int queryOpportunityActiveCount(PageQuery<OpportunityActivityVO> pageQuery);
    /**
     * 修改商机活动信息
     * @UpdateBy LIUDH
     * @param opportunityActivityVO
     * @Return int
     */
    int updateOpportunityActive(OpportunityActivityVO opportunityActivityVO);

    /**
     * 删除商机活动信息
     * @UpdateBy LIUDH
     * @param opportunityActivityVO
     * @return
     */
    int deleteOpportunityActive(OpportunityActivityVO opportunityActivityVO);
}
