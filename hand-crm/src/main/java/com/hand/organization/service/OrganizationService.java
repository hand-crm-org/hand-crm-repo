package com.hand.organization.service;

import com.hand.frame.util.PageQuery;
import com.hand.organization.access.vo.OrganizationVO;

import java.util.List;

public interface OrganizationService {
    /**
     * 根据查询条件查询组织
     * @UpdateBy yne
     * @param pageQuery
     * @Return List<OrganizationVO>
     */
    List<OrganizationVO> getOrgList(PageQuery<OrganizationVO> pageQuery);
    /**
     * 新建组织
     * @UpdateBy yne
     * @param organizationVO
     * @Return boolean
     */
    boolean addOrg(OrganizationVO organizationVO);
    /**
     * 修改组织信息
     * @UpdateBy yne
     * @param organizationVO
     * @Return boolean
     */
    boolean modifyOrg(OrganizationVO organizationVO);
    /**
     * 删除组织
     * @UpdateBy yne
     * @param code
     * @Return boolean
     */
    boolean removeOrg(String code);
}
