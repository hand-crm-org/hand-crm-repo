package com.hand.account.controller;

import com.alibaba.fastjson.JSONObject;
import com.hand.account.access.vo.AccountVO;
import com.hand.account.service.AccountService;
import com.hand.frame.model.ResultDTO;
import com.hand.frame.model.ServiceData;
import com.hand.frame.util.DateFormatUtil;
import com.hand.frame.util.PageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("客户头相关api")
public class AccountController {
    @Value(value = "${lang.language}")
    private String langId;

    @Autowired
    AccountService accountService;

    @ApiOperation(value="新建客户头")
    @PostMapping("/addAccount")
    public ResultDTO addAccount(@RequestBody AccountVO accountVO){
        String code = accountService.addAccount(accountVO);
        if (code!=null){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code",code);
            return ResultDTO.success(jsonObject);
        }
        return ResultDTO.error("新建客户头失败");
    }

    @ApiOperation(value="查询客户头")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
            @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int"),
            @ApiImplicitParam(paramType="query", name="code", value="客户编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="name", value="客户名称", dataType="String"),
            @ApiImplicitParam(paramType="query", name="nameEnu", value="客户英文名", dataType="String"),
            @ApiImplicitParam(paramType="query", name="type", value="客户类型", dataType="String"),
            @ApiImplicitParam(paramType="query", name="taxCode", value="统一信用编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="parAccntCode", value="父客户code", dataType="String"),
            @ApiImplicitParam(paramType="query", name="priEmpCode", value="跟进人code", dataType="String"),
            @ApiImplicitParam(paramType="query", name="orgCode", value="组织code", dataType="String"),
            @ApiImplicitParam(paramType="query", name="dunsCode", value="邓白氏编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="status", value="状态", dataType="String"),
            @ApiImplicitParam(paramType="query", name="periodCode", value="客户周期", dataType="String"),
            @ApiImplicitParam(paramType="query", name="priCtctCode", value="客户法人(主要联系人)", dataType="String"),
            @ApiImplicitParam(paramType="query", name="createdBy", value="创建人", dataType="String"),
            @ApiImplicitParam(paramType="query", name="created", value="创建日期", dataType="String"),
            @ApiImplicitParam(paramType="query", name="updatedBy", value="更新人", dataType="String"),
            @ApiImplicitParam(paramType="query", name="updated", value="更新时间", dataType="String"),

    })
    @GetMapping("/getAccInfo")
    public ServiceData getAccInfo(int currentPage, int pageSize,
                                  @RequestParam(value = "code",required = false) String code, @RequestParam(value = "name",required = false) String name,
                                  @RequestParam(value = "nameEnu",required = false) String nameEnu, @RequestParam(value = "taxCode",required = false) String taxCode,
                                  @RequestParam(value = "type",required = false) String type, @RequestParam(value = "parAccntCode",required = false) String parAccntCode,
                                  @RequestParam(value = "priEmpCode",required = false) String priEmpCode, @RequestParam(value = "orgCode",required = false) String orgCode,
                                  @RequestParam(value = "dunsCode",required = false) String dunsCode,@RequestParam(value = "status",required = false) String status,
                                  @RequestParam(value = "periodCode",required = false) String periodCode,@RequestParam(value = "priCtctCode",required = false) String priCtctCode,
                                  @RequestParam(value = "createdBy",required = false) String createdBy,@RequestParam(value = "created",required = false) String created,
                                  @RequestParam(value = "updatedBy",required = false) String updatedBy,@RequestParam(value = "updated",required = false) String updated){
        AccountVO accountVO = new AccountVO();
        accountVO.setCode(code);
        accountVO.setName(name);
        accountVO.setNameEnu(nameEnu);
        accountVO.setTaxCode(taxCode);
        accountVO.setType(type);
        accountVO.setParAccntCode(parAccntCode);
        accountVO.setPriEmpCode(priEmpCode);
        accountVO.setOrgCode(orgCode);
        accountVO.setDunsCode(dunsCode);
        accountVO.setStatus(status);
        accountVO.setPeriodCode(periodCode);
        accountVO.setPriCtctCode(priCtctCode);
        accountVO.setCreatedBy(createdBy);
        accountVO.setCreated(DateFormatUtil.strToDate(created));
        accountVO.setUpdatedBy(updatedBy);
        accountVO.setUpdated(DateFormatUtil.strToDate(updated));
        accountVO.setLangId(langId);
        PageQuery<AccountVO> pageQuery = new PageQuery<AccountVO>(accountVO, currentPage, pageSize);
        return  ServiceData.success(accountService.getAccount(pageQuery), pageQuery.getMapOfPageQuery());
    }

    @ApiOperation(value="修改客户头")
    @PutMapping("/modifyAccount")
    public ResultDTO modifyAccount(@RequestBody AccountVO accountVO){
        if (accountService.modifyAccount(accountVO)){
            return ResultDTO.success();
        }
        return ResultDTO.error("修改客户头信息失败");
    }
}
