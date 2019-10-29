package com.hand.opportunityactivity.controller;

import com.hand.frame.model.ResultDTO;
import com.hand.frame.model.ServiceData;
import com.hand.frame.util.DateFormatUtil;
import com.hand.frame.util.PageQuery;
import com.hand.opportunityactivity.access.vo.OpportunityActivityVO;
import com.hand.opportunityactivity.service.OpportunityActivityServcie;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
@Api("商机活动相关api")
public class OpportunityActivityController {
    @Value(value = "${lang.language}")
    private String langId;

    @Autowired
    OpportunityActivityServcie opportunityActivityServcie;

    @ApiOperation(value="新建商机活动")
    @PostMapping("/addOpportunityActive")
    public ResultDTO addOpportunityActive(@RequestBody OpportunityActivityVO opportunityActivityVO){
        return opportunityActivityServcie.addOpportunityActivity(opportunityActivityVO);
    }

    @ApiOperation(value="查询商机活动")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
            @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int"),
            @ApiImplicitParam(paramType="query", name="optyCode", value="商机编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="code", value="商机活动编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="name", value="活动名称", dataType="String"),
            @ApiImplicitParam(paramType="query", name="type", value="活动类型", dataType="String"),
            @ApiImplicitParam(paramType="query", name="status", value="活动状态", dataType="String"),
            @ApiImplicitParam(paramType="query", name="priority", value="活动优先级", dataType="Double"),
            @ApiImplicitParam(paramType="query", name="createdName", value="创建人", dataType="String"),
            @ApiImplicitParam(paramType="query", name="created", value="创建日期", dataType="String"),
            @ApiImplicitParam(paramType="query", name="updatedName", value="更新人", dataType="String"),
            @ApiImplicitParam(paramType="query", name="updated", value="更新时间", dataType="String"),
            @ApiImplicitParam(paramType="query", name="startTime", value="开始时间", dataType="String"),
            @ApiImplicitParam(paramType="query", name="endTime", value="结束时间", dataType="String"),
            @ApiImplicitParam(paramType="query", name="respName", value="责任人姓名", dataType="String"),
    })
    @GetMapping("/getOppActiveInfo")
    public ServiceData getOppActiveInfo(int currentPage, int pageSize,
                                  @RequestParam(value = "code",required = false) String code, @RequestParam(value = "name",required = false) String name,
                                  @RequestParam(value = "type",required = false) String type, @RequestParam(value = "status",required = false) String status,
                                  @RequestParam(value = "priority",required = false) String priority, @RequestParam(value = "respName",required = false) String respName,
                                  @RequestParam(value = "startTime",required = false) String startTime, @RequestParam(value = "created",required = false) String created,
                                  @RequestParam(value = "createdName",required = false) String createdName, @RequestParam(value = "updated",required = false) String updated,
                                  @RequestParam(value = "updatedName",required = false) String updatedName, @RequestParam(value = "optyCode",required = false) String optyCode,
                                  @RequestParam(value = "endTime",required = false) String endTime){
        OpportunityActivityVO opportunityActivityVO = new OpportunityActivityVO();
        opportunityActivityVO.setCode(code);
        opportunityActivityVO.setOptyCode(optyCode);
        opportunityActivityVO.setName(name);
        opportunityActivityVO.setType(type);
        opportunityActivityVO.setStatus(status);
        opportunityActivityVO.setPriority(priority);
        opportunityActivityVO.setRespName(respName);
        opportunityActivityVO.setLangId(langId);
        opportunityActivityVO.setCreatedName(createdName);
        opportunityActivityVO.setUpdatedName(updatedName);
        opportunityActivityVO.setStartTime(DateFormatUtil.strToDate(startTime));
        opportunityActivityVO.setEndTime(DateFormatUtil.strToDate(endTime));
        opportunityActivityVO.setCreated(DateFormatUtil.strToDate(created));
        opportunityActivityVO.setUpdated(DateFormatUtil.strToDate(updated));
        PageQuery<OpportunityActivityVO> pageQuery = new PageQuery<OpportunityActivityVO>(opportunityActivityVO, currentPage, pageSize);
        return  ServiceData.success(opportunityActivityServcie.getOpportunityActivity(pageQuery), pageQuery.getMapOfPageQuery());
    }

    @ApiOperation(value="修改商机活动")
    @PutMapping("/modifyOpportunityActive")
    public ResultDTO modifyOpportunityActive(@RequestBody OpportunityActivityVO opportunityActivityVO){
        return opportunityActivityServcie.modifyOpportunityActivity(opportunityActivityVO);
    }

    @ApiOperation(value="删除商机活动")
    @DeleteMapping("/deleteOpportunityActive")
    public ResultDTO deleteOpportunityActive(@RequestBody OpportunityActivityVO opportunityActivityVO){
        return opportunityActivityServcie.deleteOpportunityActivity(opportunityActivityVO);
    }
}
