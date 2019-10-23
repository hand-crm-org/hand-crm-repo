package com.hand.opportunityprod.access.dao;

import com.hand.frame.util.PageQuery;
import com.hand.opportunityprod.access.vo.OpportunityProductVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunityProductDao {
    /**
     * 插入商机产品信息
     * @UpdateBy LIUDH
     * @param opportunityProductVO
     * @return
     */
    int insertOpportunityProd(OpportunityProductVO opportunityProductVO);

    /**
     * 查询商机产品信息
     * @UpdateBy LIUDH
     * @param pageQuery
     * @return
     */
    List<OpportunityProductVO> queryOpportunityProd(PageQuery<OpportunityProductVO> pageQuery);

    /**
     * 商机产品记录计数
     * @UpdateBy LIUDH
     * @param pageQuery
     * @return
     */
    int queryOpportunityProdCount(PageQuery<OpportunityProductVO> pageQuery);
    /**
     * 修改商机产品信息
     * @UpdateBy LIUDH
     * @param opportunityProductVO
     * @Return int
     */
    int updateOpportunityProd(OpportunityProductVO opportunityProductVO);

    /**
     * 删除商机产品信息
     * @UpdateBy LIUDH
     * @param opportunityProductVO
     * @return
     */
    int deleteOpportunityProd(OpportunityProductVO opportunityProductVO);
}
