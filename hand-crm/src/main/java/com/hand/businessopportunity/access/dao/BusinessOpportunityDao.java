package com.hand.businessopportunity.access.dao;

import com.hand.businessopportunity.access.vo.BusinessOpportunityVO;
import com.hand.frame.util.PageQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessOpportunityDao {
    /**
     * 新建商机竞品
     * @UpdateBy fuzw
     * @param BusinessOptyVO
     * @Return int
     */
    int insertBusinessOpty(BusinessOpportunityVO BusinessOptyVO);

    /**
     * 根据条件查询商机竞品
     * @UpdateBy fuzw
     * @param pageQuery
     * @Return List<BusinessOpportunityVO>
     */
    List<BusinessOpportunityVO> queryBusinessOpty(PageQuery<BusinessOpportunityVO> pageQuery);
    /**
     *根据条件查询商机竞品的数据了
     * @UpdateBy  fuzw
     * @param pageQuery
     * @Return List<BusinessOpportunityVO>
     */
    int queryBusinessOptyCount(PageQuery<BusinessOpportunityVO> pageQuery);
    /**
     * 更新商机竞品
     * @UpdateBy fuzw
     * @param businessOptyVO
     * @Return int
     */
    int updateBusinessOpty(BusinessOpportunityVO businessOptyVO);
    /**
     * 删除商机竞品
     * @UpdateBy fuzw
     * @param code
     * @Return int
     */
    int deleteBusinessOpty(String code);
}
