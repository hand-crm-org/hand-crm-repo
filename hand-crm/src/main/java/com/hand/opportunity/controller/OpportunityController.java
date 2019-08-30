package com.hand.opportunity.controller;

import com.hand.frame.model.ServiceData;
import com.hand.frame.util.DateFormatUtil;
import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import com.hand.opportunity.access.vo.OpportunityVO;
import com.hand.opportunity.service.OpportunityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("商机相关api")
public class OpportunityController {
    @Autowired
    OpportunityService opportunityService;

    @ApiOperation(value="新建商机")
    @PostMapping("/addOpportunity")
    public String addOpportunity(@RequestBody OpportunityVO opportunityVO){
        return opportunityService.addOpportunity(opportunityVO);
    }

    @ApiOperation(value="查询商机")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
            @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int"),
            @ApiImplicitParam(paramType="query", name="code", value="商机编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="name", value="商机名称", dataType="String"),
            @ApiImplicitParam(paramType="query", name="type", value="商机类型", dataType="String"),
            @ApiImplicitParam(paramType="query", name="status", value="商机状态", dataType="String"),
            @ApiImplicitParam(paramType="query", name="accntCode", value="客户编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="optySource", value="商机来源", dataType="String"),
            @ApiImplicitParam(paramType="query", name="optyFsctAmount", value="预计销售额度（万）", dataType="String"),
            @ApiImplicitParam(paramType="query", name="expectSignTime", value="预计签单时间", dataType="String"),
            @ApiImplicitParam(paramType="query", name="desc", value="备注", dataType="String"),
            @ApiImplicitParam(paramType="query", name="ownOrgCode", value="归属部门", dataType="String"),
            @ApiImplicitParam(paramType="query", name="lostReason", value="失单原因", dataType="String"),
            @ApiImplicitParam(paramType="query", name="finalUse", value="最终用途", dataType="String"),
            @ApiImplicitParam(paramType="query", name="createdBy", value="创建人", dataType="String"),
            @ApiImplicitParam(paramType="query", name="created", value="创建日期", dataType="String"),
            @ApiImplicitParam(paramType="query", name="updatedBy", value="更新人", dataType="String"),
            @ApiImplicitParam(paramType="query", name="updated", value="更新时间", dataType="String"),

    })
    @GetMapping("/getOppInfo")
    public ServiceData getOppInfo(int currentPage, int pageSize,
                                  @RequestParam(value = "code",required = false) String code, @RequestParam(value = "name",required = false) String name,
                                  @RequestParam(value = "type",required = false) String type, @RequestParam(value = "status",required = false) String status,
                                  @RequestParam(value = "accntCode",required = false) String accntCode, @RequestParam(value = "optySource",required = false) String optySource,
                                  @RequestParam(value = "optyFsctAmount",required = false) String optyFsctAmount, @RequestParam(value = "expectSignTime",required = false) String expectSignTime,
                                  @RequestParam(value = "desc",required = false) String desc, @RequestParam(value = "ownOrgCode",required = false) String ownOrgCode,
                                  @RequestParam(value = "lostReason",required = false) String lostReason, @RequestParam(value = "finalUse",required = false) String finalUse,
                                  @RequestParam(value = "createdBy",required = false) String createdBy, @RequestParam(value = "created",required = false) String created,
                                  @RequestParam(value = "updatedBy",required = false) String updatedBy, @RequestParam(value = "updated",required = false) String updated){
        OpportunityVO opportunityVO = new OpportunityVO();
        opportunityVO.setCode(code);
        opportunityVO.setName(name);
        opportunityVO.setType(type);
        opportunityVO.setStatus(status);
        opportunityVO.setAccntCode(accntCode);
        opportunityVO.setOptySource(optySource);
        if(StringUtil.isEmpty(optyFsctAmount)){
            opportunityVO.setOptyFsctAmount(0);
        }
        else{
            opportunityVO.setOptyFsctAmount(Integer.parseInt(optyFsctAmount));
        }
        opportunityVO.setExpectSignTime(DateFormatUtil.strToDate(expectSignTime));
        opportunityVO.setDesc(desc);
        opportunityVO.setOwnOrgCode(ownOrgCode);
        opportunityVO.setLostReason(lostReason);
        opportunityVO.setFinalUse(finalUse);
        opportunityVO.setCreatedBy(createdBy);
        opportunityVO.setCreated(DateFormatUtil.strToDate(created));
        opportunityVO.setUpdatedBy(updatedBy);
        opportunityVO.setUpdated(DateFormatUtil.strToDate(updated));
        PageQuery<OpportunityVO> pageQuery = new PageQuery<OpportunityVO>(opportunityVO, currentPage, pageSize);
        return  ServiceData.success(opportunityService.getOpportunity(pageQuery), pageQuery.getMapOfPageQuery());
    }

    @ApiOperation(value="修改商机")
    @PutMapping("/modifyOpportunity")
    public String modifyOpportunity(@RequestBody OpportunityVO opportunityVO){
        return opportunityService.modifyOpportunity(opportunityVO);
    }
}
