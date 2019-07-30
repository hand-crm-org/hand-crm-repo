package com.hand.organization.service;

import com.hand.organization.access.dao.OrganizationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService{
    @Autowired
    OrganizationDao organizationDao;
}
