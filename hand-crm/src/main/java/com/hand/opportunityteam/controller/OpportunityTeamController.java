package com.hand.opportunityteam.controller;

import com.hand.frame.model.ResultDTO;
import com.hand.frame.model.ServiceData;
import com.hand.frame.util.DateFormatUtil;
import com.hand.frame.util.PageQuery;
import com.hand.opportunityteam.access.vo.OpportunityTeamVO;
import com.hand.opportunityteam.service.OpportunityTeamService;
import com.hand.opportunityweekly.access.vo.OpportunityWeeklyVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("商机团队组建相关api")
public class OpportunityTeamController {
    @Value(value = "${lang.language}")
    private String langId;

    @Autowired
    OpportunityTeamService opportunityTeamService;

    @ApiOperation(value="新建商机团队")
    @PostMapping("/add-opportunity-team")
    public ResultDTO addOpportunityTeam(@RequestBody OpportunityTeamVO opportunityTeamVO){
        return opportunityTeamService.addOpportunityTeam(opportunityTeamVO);
    }

    @ApiOperation(value="查询商机团队")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
            @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int"),
            @ApiImplicitParam(paramType="query", name="code", value="商机团队编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="optyName", value="商机名称", dataType="String"),
            @ApiImplicitParam(paramType="query", name="optyCode", value="商机编吗", dataType="String"),
            @ApiImplicitParam(paramType="query", name="type", value="商机团队类型", dataType="String"),
            @ApiImplicitParam(paramType="query", name="empName", value="成员姓名", dataType="String"),
            @ApiImplicitParam(paramType="query", name="empWorkPhone", value="成员工作电话", dataType="String"),
            @ApiImplicitParam(paramType="query", name="empPersonalPhone", value="成员个人电话", dataType="String"),
            @ApiImplicitParam(paramType="query", name="primaryFlag", value="是否主要", dataType="Double"),
            @ApiImplicitParam(paramType="query", name="createdName", value="创建人", dataType="String"),
            @ApiImplicitParam(paramType="query", name="created", value="创建日期", dataType="String"),
            @ApiImplicitParam(paramType="query", name="updatedName", value="更新人", dataType="String"),
            @ApiImplicitParam(paramType="query", name="updated", value="更新时间", dataType="String"),
    })
    @GetMapping("/get-opportunity-team-info")
    public ServiceData getOppTeamInfo(int currentPage, int pageSize,
                                  @RequestParam(value = "code",required = false) String code, @RequestParam(value = "optyName",required = false) String optyName,
                                  @RequestParam(value = "type",required = false) String type, @RequestParam(value = "empName",required = false) String empName,
                                  @RequestParam(value = "empWorkPhone",required = false) String empWorkPhone, @RequestParam(value = "empPersonalPhone",required = false) String empPersonalPhone,
                                  @RequestParam(value = "primaryFlag",required = false) String primaryFlag,@RequestParam(value = "created",required = false) String created,
                                  @RequestParam(value = "createdName",required = false) String createdName,@RequestParam(value = "updated",required = false) String updated,
                                  @RequestParam(value = "updatedName",required = false) String updatedName,@RequestParam(value = "optyCode",required = false) String optyCode){
        OpportunityTeamVO opportunityTeamVO = new OpportunityTeamVO();
        opportunityTeamVO.setCode(code);
        opportunityTeamVO.setOptyCode(optyCode);
        opportunityTeamVO.setOptyName(optyName);
        opportunityTeamVO.setType(type);
        opportunityTeamVO.setEmpName(empName);
        opportunityTeamVO.setEmpWorkPhone(empWorkPhone);
        opportunityTeamVO.setEmpPersonalPhone(empPersonalPhone);
        opportunityTeamVO.setPrimaryFlag(primaryFlag);
        opportunityTeamVO.setLangId(langId);
        opportunityTeamVO.setCreatedName(createdName);
        opportunityTeamVO.setUpdatedName(updatedName);
        opportunityTeamVO.setCreated(DateFormatUtil.strToDate(created));
        opportunityTeamVO.setUpdated(DateFormatUtil.strToDate(updated));
        PageQuery<OpportunityTeamVO> pageQuery = new PageQuery<OpportunityTeamVO>(opportunityTeamVO, currentPage, pageSize);
        return  ServiceData.success(opportunityTeamService.getOpportunityTeam(pageQuery), pageQuery.getMapOfPageQuery());
    }

    @ApiOperation(value="修改商机团队")
    @PutMapping("/modify-opportunity-team")
    public ResultDTO modifyOpportunityTeam(@RequestBody OpportunityTeamVO opportunityTeamVO){
        return opportunityTeamService.modifyOpportunityTeam(opportunityTeamVO);
    }

    @ApiOperation(value="删除商机团队")
    @ApiImplicitParam(paramType="query", name="code", value="商机团队code", dataType="String")
    @DeleteMapping("/delete-opportunity-team")
    public ResultDTO deleteOpportunityTeam(@RequestParam(value = "code",required = false)String code){
        return opportunityTeamService.deleteOpportunityTeam(code);
    }
}
