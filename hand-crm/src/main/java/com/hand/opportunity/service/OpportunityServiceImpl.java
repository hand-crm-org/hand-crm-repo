package com.hand.opportunity.service;

import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import com.hand.opportunity.access.dao.OpportunityDao;
import com.hand.opportunity.access.vo.OpportunityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpportunityServiceImpl implements OpportunityService{
    @Autowired
    OpportunityDao opportunityDao;

    /**
     * 新建商机
     * @UpdateBy lln
     * @param opportunityVO
     * @Return int
     */
    @Override
    public String addOpportunity(OpportunityVO opportunityVO) {
        if (!StringUtil.isEmpty(opportunityVO.getCode()) && !StringUtil.isEmpty(opportunityVO.getName())
                && !StringUtil.isEmpty(opportunityVO.getAccntCode()) && !StringUtil.isEmpty(opportunityVO.getOptySource())
                && !StringUtil.isEmpty(opportunityVO.getExpectSignTime().toString()) && !StringUtil.isEmpty(opportunityVO.getUpdatedBy())
                && !StringUtil.isEmpty(opportunityVO.getStatus()) && !StringUtil.isEmpty(opportunityVO.getOptyFsctAmount().toString())
                && !StringUtil.isEmpty(opportunityVO.getOwnOrgCode()))
        {
            int count = opportunityDao.insertOpportunity(opportunityVO);
            if (count > 0) {
                return "success";
            }
            return "failed";
        }
        return "miss param";
    }

    /**
     * 根据条件查询商机
     * @UpdateBy lln
     * @param pageQuery
     * @Return List<OpportunityVO>
     */
    @Override
    public List<OpportunityVO> getOpportunity(PageQuery<OpportunityVO> pageQuery) {
        int count = opportunityDao.queryOpportunityCount(pageQuery);
        pageQuery.setCount(count);
        if(count > 0) {
            return opportunityDao.queryOpportunity(pageQuery);
        }
        return null;
    }

    /**
     * 修改商机
     * @UpdateBy lln
     * @param opportunityVO
     * @Return int
     */
    @Override
    public String modifyOpportunity(OpportunityVO opportunityVO) {
        if(!StringUtil.isEmpty(opportunityVO.getCode())&&!StringUtil.isEmpty(opportunityVO.getUpdatedBy())) {
            int count = opportunityDao.updateOpportunity(opportunityVO);
            if (count > 0) {
                return "success";
            }
            return "failed";
        }
        return "miss param";
    }
}
