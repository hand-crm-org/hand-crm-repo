package com.hand.opportunityteam.access.dao;

import com.hand.frame.util.PageQuery;
import com.hand.opportunityteam.access.vo.OpportunityTeamVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunityTeamDao {
    /**
     * 插入商机团队信息
     * @UpdateBy LIUDH
     * @param opportunityTeamVO
     * @return
     */
    int insertOpportunityTeam(OpportunityTeamVO opportunityTeamVO);

    /**
     * 查询商机团队信息
     * @UpdateBy LIUDH
     * @param pageQuery
     * @return
     */
    List<OpportunityTeamVO> queryOpportunityTeam(PageQuery<OpportunityTeamVO> pageQuery);

    /**
     * 商机团队记录计数
     * @UpdateBy LIUDH
     * @param pageQuery
     * @return
     */
    int queryOpportunityTeamCount(PageQuery<OpportunityTeamVO> pageQuery);
    /**
     * 修改商机团队信息
     * @UpdateBy LIUDH
     * @param opportunityTeamVO
     * @Return int
     */
    int updateOpportunityTeam(OpportunityTeamVO opportunityTeamVO);

    /**
     * 删除商机团队信息
     * UpdateBy LIUDH
     * @param opportunityTeamVO
     * @return int
     */
    int deleteOpportunityTeam(OpportunityTeamVO opportunityTeamVO);
}
