package com.hand.opportunityprod.controller;

import com.hand.frame.model.ResultDTO;
import com.hand.frame.model.ServiceData;
import com.hand.frame.util.DateFormatUtil;
import com.hand.frame.util.PageQuery;
import com.hand.opportunityprod.access.vo.OpportunityProductVO;
import com.hand.opportunityprod.service.OpportunityProductService;
import com.hand.opportunityteam.access.vo.OpportunityTeamVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@Api("商机产品相关api")
public class OpportunityProductController {
    //@Value(value = "${lang.language}")
    //private String langId;

    @Autowired
    OpportunityProductService opportunityProductService;

    @ApiOperation(value="新建商机产品")
    @PostMapping("/add-opportunity-product")
    public ResultDTO addOpportunityProd(@RequestBody OpportunityProductVO opportunityProductVO){
        return opportunityProductService.addOpportunityProd(opportunityProductVO);
    }

    @ApiOperation(value="查询商机产品")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
            @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int"),
            @ApiImplicitParam(paramType="query", name="optyCode", value="商机编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="code", value="商机产品编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="amount", value="预计销售额度", dataType="String"),
            @ApiImplicitParam(paramType="query", name="expectSignTime", value="预计签单时间", dataType="String"),
            @ApiImplicitParam(paramType="query", name="productCategory", value="产品类别", dataType="String"),
            @ApiImplicitParam(paramType="query", name="primaryFlag", value="是否主要", dataType="Double"),
            @ApiImplicitParam(paramType="query", name="createdName", value="创建人", dataType="String"),
            @ApiImplicitParam(paramType="query", name="created", value="创建日期", dataType="String"),
            @ApiImplicitParam(paramType="query", name="updatedName", value="更新人", dataType="String"),
            @ApiImplicitParam(paramType="query", name="updated", value="更新时间", dataType="String"),
    })
    @GetMapping("/get-opportunity-product-info")
    public ServiceData getOppProdInfo(int currentPage, int pageSize,
                                  @RequestParam(value = "code",required = false) String code, @RequestParam(value = "expectSignTime",required = false) Date expectSignTime,
                                  @RequestParam(value = "amount",required = false) Double amount, @RequestParam(value = "productCategory",required = false) String productCategory,
                                  @RequestParam(value = "primaryFlag",required = false) String primaryFlag, @RequestParam(value = "created",required = false) String created,
                                  @RequestParam(value = "createdName",required = false) String createdName, @RequestParam(value = "updated",required = false) String updated,
                                  @RequestParam(value = "updatedName",required = false) String updatedName, @RequestParam(value = "optyCode",required = false) String optyCode,
                                      @RequestParam(value = "langId",required = false)String langId){
        OpportunityProductVO opportunityProductVO = new OpportunityProductVO();
        opportunityProductVO.setCode(code);
        opportunityProductVO.setOptyCode(optyCode);
        opportunityProductVO.setAmount(amount);
        opportunityProductVO.setExpectSignTime(expectSignTime);
        opportunityProductVO.setProductCategory(productCategory);
        opportunityProductVO.setPrimaryFlag(primaryFlag);
        opportunityProductVO.setLangId(langId);
        opportunityProductVO.setCreatedName(createdName);
        opportunityProductVO.setUpdatedName(updatedName);
        opportunityProductVO.setCreated(DateFormatUtil.strToDate(created));
        opportunityProductVO.setUpdated(DateFormatUtil.strToDate(updated));
        PageQuery<OpportunityProductVO> pageQuery = new PageQuery<OpportunityProductVO>(opportunityProductVO, currentPage, pageSize);
        return  ServiceData.success(opportunityProductService.getOpportunityProd(pageQuery), pageQuery.getMapOfPageQuery());
    }

    @ApiOperation(value="修改商机产品")
    @PutMapping("/modify-opportunity-product")
    public ResultDTO modifyOpportunityProd(@RequestBody OpportunityProductVO opportunityProductVO){
        return opportunityProductService.modifyOpportunityProd(opportunityProductVO);
    }

    @ApiOperation(value="删除商机产品")
    @DeleteMapping("/delete-opportunity-product")
    public ResultDTO deleteOpportunityProd(@RequestBody OpportunityProductVO opportunityProductVO){
        return opportunityProductService.deleteOpportunityProd(opportunityProductVO);
    }
}
