package com.hand.opportunityteam.service;

import com.hand.frame.model.ResultDTO;
import com.hand.frame.util.PageQuery;
import com.hand.opportunityteam.access.vo.OpportunityTeamVO;

import java.util.List;

public interface OpportunityTeamService {
    /**
     * 新建商机
     * @UpdateBy LIUDH
     * @param opportunityTeamVO
     * @Return int
     */
    ResultDTO addOpportunityTeam(OpportunityTeamVO opportunityTeamVO);


    /**
     * 根据条件查询商机
     * @UpdateBy LIUDH
     * @param pageQuery
     * @Return List<OpportunityTeamVO>
     */
    List<OpportunityTeamVO> getOpportunityTeam(PageQuery<OpportunityTeamVO> pageQuery);


    /**
     * 修改商机
     * @UpdateBy LIUDH
     * @param opportunityTeamVO
     * @Return int
     */
    ResultDTO modifyOpportunityTeam(OpportunityTeamVO opportunityTeamVO);

    /**
     * 删除商机团队信息
     * UpdateBy LIUDH
     * @param opportunityTeamVO
     * @return int
     */
    ResultDTO deleteOpportunityTeam(OpportunityTeamVO opportunityTeamVO);
}
