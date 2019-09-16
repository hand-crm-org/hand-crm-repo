package com.hand.organization.controller;

import com.hand.frame.model.ResultDTO;
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
            @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int"),
            @ApiImplicitParam(paramType="query", name="code", value="组织编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="name", value="名称", dataType="String"),
            @ApiImplicitParam(paramType="query", name="level", value="层级", dataType="String"),
            @ApiImplicitParam(paramType="query", name="type", value="类型", dataType="String"),
            @ApiImplicitParam(paramType="query", name="parOrgCode", value="父组织编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="extFlg", value="内外部组织标识", dataType="String"),
            @ApiImplicitParam(paramType="query", name="desc", value="描述", dataType="String")
    })
    @GetMapping("/getOrgList")
    public ServiceData getOrgList(int currentPage, int pageSize,String code,
                                  String name, String level,String type,
                                  String parOrgCode,String extFlg,
                                  String desc){
        OrganizationVO organizationVO = new OrganizationVO();
        organizationVO.setCode(code);
        organizationVO.setName(name);
        organizationVO.setLevel(level);
        organizationVO.setType(type);
        organizationVO.setParOrgCode(parOrgCode);
        organizationVO.setExtFlg(extFlg);
        organizationVO.setDesc(desc);
        PageQuery<OrganizationVO> pageQuery = new PageQuery<OrganizationVO>(organizationVO, currentPage, pageSize);
        return  ServiceData.success(organizationService.getOrgList(pageQuery), pageQuery.getMapOfPageQuery());
    }
    @ApiOperation(value="组织信息新建")
    @PostMapping("/addOrg")
    public ResultDTO addOrg(@RequestBody OrganizationVO organizationVO){
        if (organizationService.addOrg(organizationVO)){
            return ResultDTO.success();
        }
        return ResultDTO.error("组织信息新建失败");
    }
    @ApiOperation(value="组织信息删除")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="code", value="组织code", dataType="String"),
    })
    @DeleteMapping("/removeOrg")
    public ResultDTO removeOrg(String code){
        if (organizationService.removeOrg(code)){
            return ResultDTO.success();
        }
        return ResultDTO.error("组织信息删除失败");
    }
    @ApiOperation(value="组织信息更新")
    @PutMapping("/modifyOrg")
    public ResultDTO modifyOrg(@RequestBody OrganizationVO organizationVO){
        if (organizationService.modifyOrg(organizationVO)){
            return ResultDTO.success();
        }
        return ResultDTO.error("组织信息更新失败");
    }
}
