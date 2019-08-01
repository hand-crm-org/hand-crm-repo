package com.hand.organization.service;

import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import com.hand.organization.access.dao.OrganizationDao;
import com.hand.organization.access.vo.OrganizationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService{
    @Autowired
    OrganizationDao organizationDao;

    @Override
    public List<OrganizationVO> getOrgList(PageQuery<OrganizationVO> pageQuery) {
        int count = organizationDao.queryOrgCount(pageQuery);
        pageQuery.setCount(count);
        if(count > 0) {
            return organizationDao.queryOrgList(pageQuery);
        }
        return null;
    }

    @Override
    public boolean addOrg(OrganizationVO organizationVO) {
        if (!StringUtil.isEmpty(organizationVO.getCode())&&!StringUtil.isEmpty(organizationVO.getUpdatedBy())){
            int count = organizationDao.insertOrg(organizationVO);
            if (count>0){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean modifyOrg(OrganizationVO organizationVO) {
        if (!StringUtil.isEmpty(organizationVO.getCode())&&!StringUtil.isEmpty(organizationVO.getUpdatedBy())){
            int count = organizationDao.updateOrg(organizationVO);
            if (count>0){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeOrg(String code) {
        if(!StringUtil.isEmpty(code)){
            int count = organizationDao.deleteOrgByCode(code);
            if (count>0){
                return true;
            }
        }
        return false;
    }
}
