package com.hand.organization.controller;

import com.hand.frame.model.ServiceData;
import com.hand.frame.util.PageQuery;
import com.hand.organization.access.vo.OrganizationVO;
import com.hand.organization.service.OrganizationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("组织相关api")
public class OrganizationController {
    @Autowired
    OrganizationService organizationService;

    @ApiOperation(value="组织列表查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
            @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int")
    })
    //@GetMapping("/getOrgList")
    @PostMapping("/getOrgList")
    public ServiceData getOrgList(@RequestBody(required = false) OrganizationVO OrganizationVO, int currentPage, int pageSize){
        PageQuery<OrganizationVO> pageQuery = new PageQuery<OrganizationVO>(OrganizationVO, currentPage, pageSize);
        return  ServiceData.success(organizationService.getOrgList(pageQuery), pageQuery.getMapOfPageQuery());
    }
    @ApiOperation(value="组织信息新建")
    @PostMapping("/addOrg")
    public String addOrg(@RequestBody OrganizationVO organizationVO){
        if (organizationService.addOrg(organizationVO)){
            return "success";
        }
        return "failed";
    }
    @ApiOperation(value="组织信息删除")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="code", value="组织code", dataType="String"),
    })
    @DeleteMapping("/removeOrg")
    public String removeOrg(String code){
        if (organizationService.removeOrg(code)){
            return "success";
        }
        return "failed";
    }
    @ApiOperation(value="组织信息更新")
    @PutMapping("/modifyOrg")
    public String modifyOrg(@RequestBody OrganizationVO organizationVO){
        if (organizationService.modifyOrg(organizationVO)){
            return "success";
        }
        return "failed";
    }
}
