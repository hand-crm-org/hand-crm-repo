package com.hand.opportunityprod.service;

import com.hand.frame.model.ResultDTO;
import com.hand.frame.util.PageQuery;
import com.hand.opportunityprod.access.vo.OpportunityProductVO;

import java.util.List;

public interface OpportunityProductService {
    /**
     * 新建商机产品
     * @UpdateBy LIUDH
     * @param opportunityProductVO
     * @Return int
     */
    ResultDTO addOpportunityProd(OpportunityProductVO opportunityProductVO);


    /**
     * 根据条件查询商机产品
     * @UpdateBy LIUDH
     * @param pageQuery
     * @Return List<OpportunityTeamVO>
     */
    List<OpportunityProductVO> getOpportunityProd(PageQuery<OpportunityProductVO> pageQuery);


    /**
     * 修改商机产品
     * @UpdateBy LIUDH
     * @param opportunityProductVO
     * @Return int
     */
    ResultDTO modifyOpportunityProd(OpportunityProductVO opportunityProductVO);

    /**
     * 删除商机产品信息
     * @UpdateBy LIUDH
     * @param opportunityProductVO
     * @return
     */
    ResultDTO deleteOpportunityProd(OpportunityProductVO opportunityProductVO);
}
