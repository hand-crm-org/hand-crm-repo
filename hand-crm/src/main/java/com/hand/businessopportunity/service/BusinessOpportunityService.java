package com.hand.businessopportunity.service;

import com.hand.businessopportunity.access.vo.BusinessOpportunityVO;
import com.hand.frame.model.ResultDTO;
import com.hand.frame.util.PageQuery;

import java.util.List;

public interface BusinessOpportunityService {
    /**
     * 新建商机竞品
     * @UpdateBy fuzw
     * @param BusinessOptyVO
     * @Return int
     */
    ResultDTO addBusinessOpty(BusinessOpportunityVO BusinessOptyVO);
    /**
     * 根据条件查询商机竞品
     * @UpdateBy fuzw
     * @param pageQuery
     * @Return List<BusinessOpportunityVO>
     */
    List<BusinessOpportunityVO> getBusinessOpty(PageQuery<BusinessOpportunityVO> pageQuery);
  /**
     * 更新商机竞品
     * @UpdateBy fuzw
     * @param businessOptyVO
     * @Return int
     */
    ResultDTO modifyBusinessOpty(BusinessOpportunityVO businessOptyVO);
    /**
     * 删除商机竞品
     * @UpdateBy fuzw
     * @param code
     * @Return int
     */
    ResultDTO removeBusinessOpty(String code);

}
