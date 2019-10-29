package com.hand.accountrating.controller;

import com.alibaba.fastjson.JSONObject;
import com.hand.accountrating.access.vo.AccountRatingVO;
import com.hand.accountrating.service.AccountRatingService;
import com.hand.frame.model.ResultDTO;
import com.hand.frame.model.ServiceData;
import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@Api("客户-客户评级api")
public class AccountRationController {
    @Value(value = "${lang.language}")
    private String langId;

    @Autowired
    AccountRatingService accountRatingService;

    @ApiOperation("查询客户评级列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
            @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int"),
            @ApiImplicitParam(paramType = "query",name = "accountCode",value = "客户编码",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "status",value = "状态",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "ratingLevel",value = "评级等级",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "qixinLevel",value = "启信宝资信等级",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "startDate",value = "生效时间",dataType = "Date"),
            @ApiImplicitParam(paramType = "query",name = "endDate",value = "失效时间",dataType = "Date"),
            @ApiImplicitParam(paramType = "query",name = "version",value = "版本",dataType = "int"),
            @ApiImplicitParam(paramType = "query",name = "creditAll",value = "可用信用额度",dataType = "double"),
            @ApiImplicitParam(paramType = "query",name = "creditUsed",value = "已用信用额度",dataType = "double"),
            @ApiImplicitParam(paramType = "query",name = "currency",value = "币种",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "comment",value = "备注",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "attachmentCode",value = "评级附件",dataType = "String")
    })
    @GetMapping("/get-accountRating-list")
    public ServiceData getAccountRatingList(int currentPage, int pageSize,
                                            @RequestParam(value = "accountCode",required = false)String accountCode, @RequestParam(value = "status",required = false)String status,
                                            @RequestParam(value = "ratingLevel",required = false)String ratingLevel, @RequestParam(value = "qixinLevel",required = false)String qixinLevel,
                                            @RequestParam(value = "startDate",required = false)Date startDate, @RequestParam(value = "endDate",required = false)Date endDate,
                                            @RequestParam(value = "version",required = false)Integer version, @RequestParam(value = "creditAll",required = false)Double creditAll,
                                            @RequestParam(value = "creditUsed",required = false)Double creditUsed, @RequestParam(value = "currency",required = false)String currency,
                                            @RequestParam(value = "comment",required = false)String comment, @RequestParam(value = "attachmentCode",required = false)String attachmentCode){
        AccountRatingVO accountRatingVO = new AccountRatingVO();
        accountRatingVO.setAccountCode(accountCode);
        accountRatingVO.setStatus(status);
        accountRatingVO.setLangId(langId);
        accountRatingVO.setRatingLevel(ratingLevel);
        accountRatingVO.setQixinLevel(qixinLevel);
        accountRatingVO.setStartDate(startDate);
        accountRatingVO.setEndDate(endDate);
        accountRatingVO.setVersion(version);
        accountRatingVO.setCreditAll(creditAll);
        accountRatingVO.setCreditUsed(creditUsed);
        accountRatingVO.setCurrency(currency);
        accountRatingVO.setComment(comment);
        accountRatingVO.setAttachmentCode(attachmentCode);
        PageQuery<AccountRatingVO> pageQuery = new PageQuery<AccountRatingVO>(accountRatingVO,currentPage,pageSize);
        return ServiceData.success(accountRatingService.getAccountRatingList(pageQuery), pageQuery.getMapOfPageQuery());
    }
    @ApiOperation("新建客户评级")
    @PostMapping("add-accountRating")
    public ResultDTO addAccountRating(@RequestBody AccountRatingVO accountRatingVO){
        accountRatingVO.setVersion(accountRatingService.queryAccountRatingVersion(accountRatingVO).getVersion());
        return accountRatingService.addAccountRating(accountRatingVO);
    }
    @ApiOperation("更新客户评级")
    @PutMapping("modify-accountRating")
    public ResultDTO modifyAccountRating(@RequestBody AccountRatingVO accountRatingVO) {
        return accountRatingService.modifyAccountRating(accountRatingVO);
    }
}
