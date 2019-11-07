package com.hand.opportunityweekly.controller;

import com.hand.frame.model.ResultDTO;
import com.hand.frame.model.ServiceData;
import com.hand.frame.util.DateFormatUtil;
import com.hand.frame.util.PageQuery;
import com.hand.opportunityactivity.access.vo.OpportunityActivityVO;
import com.hand.opportunityactivity.service.OpportunityActivityServcie;
import com.hand.opportunityweekly.access.vo.OpportunityWeeklyVO;
import com.hand.opportunityweekly.service.OpportunityWeeklyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("商机周报相关api")
public class OpportunityWeeklyController {
    //@Value(value = "${lang.language}")
    //private String langId;

    @Autowired
    OpportunityWeeklyService opportunityWeeklyService;

    @ApiOperation(value="新建商机周报")
    @PostMapping("/add-opportunity-weekly")
    public ResultDTO addOpportunityWeekly(@RequestBody OpportunityWeeklyVO opportunityWeeklyVO){
        return opportunityWeeklyService.addOpportunityWeekly(opportunityWeeklyVO);
    }

    @ApiOperation(value="查询商机周报")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
            @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int"),
            @ApiImplicitParam(paramType="query", name="optyCode", value="商机编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="code", value="商机周报编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="name", value="周报序列", dataType="String"),
            @ApiImplicitParam(paramType="query", name="weeklySummary", value="进展计划", dataType="String"),
            @ApiImplicitParam(paramType="query", name="weeklyRisk", value="问题风险", dataType="String"),
            @ApiImplicitParam(paramType="query", name="weeklyPushStatus", value="推进状态", dataType="Double"),
            @ApiImplicitParam(paramType="query", name="createdName", value="创建人", dataType="String"),
            @ApiImplicitParam(paramType="query", name="created", value="创建日期", dataType="String"),
            @ApiImplicitParam(paramType="query", name="updatedName", value="更新人", dataType="String"),
            @ApiImplicitParam(paramType="query", name="updated", value="更新时间", dataType="String"),
            @ApiImplicitParam(paramType="query", name="actived", value="生效时间", dataType="String"),
            @ApiImplicitParam(paramType="query", name="status", value="周报状态", dataType="String"),
    })
    @GetMapping("/get-opportunity-weekly-info")
    public ServiceData getOppWeeklyInfo(int currentPage, int pageSize,
                                        @RequestParam(value = "code",required = false) String code, @RequestParam(value = "name",required = false) String name,
                                        @RequestParam(value = "weeklySummary",required = false) String weeklySummary, @RequestParam(value = "status",required = false) String status,
                                        @RequestParam(value = "weeklyRisk",required = false) String weeklyRisk, @RequestParam(value = "weeklyPushStatus",required = false) String weeklyPushStatus,
                                        @RequestParam(value = "actived",required = false) String actived, @RequestParam(value = "created",required = false) String created,
                                        @RequestParam(value = "createdName",required = false) String createdName, @RequestParam(value = "updated",required = false) String updated,
                                        @RequestParam(value = "updatedName",required = false) String updatedName, @RequestParam(value = "optyCode",required = false) String optyCode,
                                        @RequestParam(value = "langId",required = false)String langId){
        OpportunityWeeklyVO opportunityWeeklyVO = new OpportunityWeeklyVO();
        opportunityWeeklyVO.setCode(code);
        opportunityWeeklyVO.setOptyCode(optyCode);
        opportunityWeeklyVO.setName(name);
        opportunityWeeklyVO.setWeeklySummary(weeklySummary);
        opportunityWeeklyVO.setStatus(status);
        opportunityWeeklyVO.setWeeklyPushStatus(weeklyPushStatus);
        opportunityWeeklyVO.setWeeklyRisk(weeklyRisk);
        opportunityWeeklyVO.setLangId(langId);
        opportunityWeeklyVO.setCreatedName(createdName);
        opportunityWeeklyVO.setUpdatedName(updatedName);
        opportunityWeeklyVO.setActived(DateFormatUtil.strToDate(actived));
        opportunityWeeklyVO.setCreated(DateFormatUtil.strToDate(created));
        opportunityWeeklyVO.setUpdated(DateFormatUtil.strToDate(updated));
        PageQuery<OpportunityWeeklyVO> pageQuery = new PageQuery<OpportunityWeeklyVO>(opportunityWeeklyVO, currentPage, pageSize);
        return  ServiceData.success(opportunityWeeklyService.getOpportunityWeekly(pageQuery), pageQuery.getMapOfPageQuery());
    }

    @ApiOperation(value="修改商机周报")
    @PutMapping("/modify-opportunity-weekly")
    public ResultDTO modifyOpportunityWeekly(@RequestBody OpportunityWeeklyVO opportunityWeeklyVO){
        return opportunityWeeklyService.modifyOpportunityWeekly(opportunityWeeklyVO);
    }

    @ApiOperation(value="删除商机周报")
    @DeleteMapping("/delete-opportunity-weekly")
    public ResultDTO deleteOpportunityWeekly(@RequestBody OpportunityWeeklyVO opportunityWeeklyVO){
        return opportunityWeeklyService.deleteOpportunityWeekly(opportunityWeeklyVO);
    }
}
