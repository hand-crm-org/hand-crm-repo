package com.hand.businessopportunity.controller;

import com.hand.businessopportunity.access.vo.BusinessOpportunityVO;
import com.hand.businessopportunity.service.BusinessOpportunityService;
import com.hand.frame.model.ResultDTO;
import com.hand.frame.model.ServiceData;
import com.hand.frame.util.PageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("商机竞品相关api")
public class BusinessOpportunityController {
    @Autowired
    BusinessOpportunityService businessOptyService;

    @ApiOperation(value = "新建商机竞品")
    @PostMapping("/addBusinessOpty")
    public ResultDTO addBusinessOpty(@RequestBody BusinessOpportunityVO businessOptyVO){
        return businessOptyService.addBusinessOpty(businessOptyVO);

    }
    @ApiOperation(value = "查询商机竞品")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
        @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int"),
        @ApiImplicitParam(paramType="query", name="code", value="商机竞品编码", dataType="String"),
        @ApiImplicitParam(paramType="query", name="optycode", value="商机编码", dataType="String"),
        @ApiImplicitParam(paramType="query", name="brand", value="竞品品牌", dataType="String"),
        @ApiImplicitParam(paramType="query", name="quotation", value="竞品报价", dataType="Float"),
        @ApiImplicitParam(paramType="query", name="goodness", value="竞品优势", dataType="String"),
        @ApiImplicitParam(paramType="query", name="badness", value="竞品劣势", dataType="String"),
        @ApiImplicitParam(paramType="query", name="comments", value="备注", dataType="String")
    })
    @GetMapping("/getBusinessOptyInfo")
    public ServiceData getBusinessOptyInfo(int currentPage, int pageSize,
            @RequestParam(value = "code",required = false) String code,@RequestParam(value = "optycode",required = false) String optycode,
            @RequestParam(value = "brand",required = false) String brand,@RequestParam(value = "quotation",required = false) Float quotation,
            @RequestParam(value = "goodness",required = false) String goodness,@RequestParam(value = "badness",required = false) String badness,
            @RequestParam(value = "comments",required = false) String comments){
            BusinessOpportunityVO businessOptyVO = new BusinessOpportunityVO();
            businessOptyVO.setCode(code);
            businessOptyVO.setOptycode(optycode);
            businessOptyVO.setBrand(brand);
            businessOptyVO.setQuotation(quotation);
            businessOptyVO.setGoodness(goodness);
            businessOptyVO.setBadness(badness);
            businessOptyVO.setComments(comments);
            PageQuery<BusinessOpportunityVO> pageQuery = new PageQuery<BusinessOpportunityVO>(businessOptyVO,currentPage,pageSize);
            return ServiceData.success(businessOptyService.getBusinessOpty(pageQuery),pageQuery.getMapOfPageQuery());
    }
    @ApiOperation(value = "更新商机竞品")
    @PutMapping("/modifyBusinessOpty")
    public ResultDTO modifyBusinessOpty(@RequestBody BusinessOpportunityVO businessOptyVO){
        return businessOptyService.modifyBusinessOpty(businessOptyVO);
    }
    @ApiOperation(value = "删除商机竞品")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query",name = "code",value = "商机竞品code",dataType = "String")})
    @DeleteMapping("/removeBusinessOpty")
    public ResultDTO removeBusinessOpty(@RequestParam("code") String code){
        return businessOptyService.removeBusinessOpty(code);
    }
}
