package com.hand.organization.access.dao;

import com.hand.frame.util.PageQuery;
import com.hand.listofvalue.access.vo.ListOfValueVO;
import com.hand.organization.access.vo.OrganizationVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationDao {
    /**
     * 根据查询条件查询组织
     * @UpdateBy yne
     * @param pageQuery
     * @Return List<OrganizationVO>
     */
    List<OrganizationVO> queryOrgList(PageQuery<OrganizationVO> pageQuery);

    /**
     * 根据查询条件对组织计数
     * @UpdateBy yne
     * @param pageQuery
     * @Return int
     */
    int queryOrgCount(PageQuery<OrganizationVO> pageQuery);
    /**
     * 新建组织
     * @UpdateBy yne
     * @param organizationVO
     * @Return int
     */
    int insertOrg(OrganizationVO organizationVO);

    /**
     * 修改组织信息
     * @UpdateBy yne
     * @param organizationVO
     * @Return int
     */
    int updateOrg(OrganizationVO organizationVO);

    /**
     * 删除组织
     * @UpdateBy yne
     * @param code
     * @Return int
     */
    int deleteOrgByCode(String code);
}
