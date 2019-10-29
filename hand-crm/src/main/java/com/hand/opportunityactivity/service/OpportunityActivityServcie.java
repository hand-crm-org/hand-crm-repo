package com.hand.opportunityactivity.service;

import com.hand.frame.model.ResultDTO;
import com.hand.frame.util.PageQuery;
import com.hand.opportunityactivity.access.vo.OpportunityActivityVO;

import java.util.List;

public interface OpportunityActivityServcie {
    /**
     * 新建商机活动
     * @UpdateBy LIUDH
     * @param opportunityActivityVO
     * @Return int
     */
    ResultDTO addOpportunityActivity(OpportunityActivityVO opportunityActivityVO);


    /**
     * 根据条件查询商机活动
     * @UpdateBy LIUDH
     * @param pageQuery
     * @Return List<OpportunityActivityVO>
     */
    List<OpportunityActivityVO> getOpportunityActivity(PageQuery<OpportunityActivityVO> pageQuery);


    /**
     * 修改商机活动
     * @UpdateBy LIUDH
     * @param opportunityActivityVO
     * @Return int
     */
    ResultDTO modifyOpportunityActivity(OpportunityActivityVO opportunityActivityVO);

    /**
     * 删除商机商机活动
     * @UpdateBy LIUDH
     * @param opportunityActivityVO
     * @return
     */
    ResultDTO deleteOpportunityActivity(OpportunityActivityVO opportunityActivityVO);
}
