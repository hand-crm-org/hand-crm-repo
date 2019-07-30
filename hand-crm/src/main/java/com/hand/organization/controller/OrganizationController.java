package com.hand.organization.controller;

import com.hand.organization.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrganizationController {
    @Autowired
    OrganizationService organizationService;
}
