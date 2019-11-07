package com.hand.accountcontact.controller;

import com.alibaba.fastjson.JSONObject;
import com.hand.accountcontact.access.vo.AccountContactVO;
import com.hand.accountcontact.service.AccountContactService;
import com.hand.contact.access.vo.ContactVO;
import com.hand.frame.model.ResultDTO;
import com.hand.frame.model.ServiceData;
import com.hand.frame.util.PageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("客户-联系人相关api")
public class AccountContactController {
    //@Value(value = "${lang.language}")
    //private String langId;
    @Autowired
    AccountContactService accountContactService;

    @ApiOperation("查询客户联系人列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
            @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int"),
            @ApiImplicitParam(paramType = "query",name = "accntCode",value = "客户编码",dataType = "String"),
                @ApiImplicitParam(paramType = "query",name = "name",value = "联系人姓名",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "nameForeign",value = "外文名",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "phNum",value = "联系电话",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "email",value = "邮箱",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "hobby",value = "喜好",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "status",value = "状态",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "jobTitle",value = "职位",dataType = "String")
    })
    @GetMapping("/get-account-contact-info")
    public ServiceData getAccountContactList(int currentPage, int pageSize,String accntCode,String name,String nameForeign
            ,String phNum,String email,String hobby,String status,String jobTitle,String langId){
        ContactVO contactVO = new ContactVO();
        contactVO.setAccntCode(accntCode);
        contactVO.setName(name);
        contactVO.setNameForeign(nameForeign);
        contactVO.setPhNum(phNum);
        contactVO.setEmail(email);
        contactVO.setHobby(hobby);
        contactVO.setJobTitle(jobTitle);
        contactVO.setStatus(status);
        contactVO.setLangId(langId);
        PageQuery<ContactVO> pageQuery = new PageQuery<ContactVO>(contactVO,currentPage,pageSize);
        return ServiceData.success(accountContactService.getAccountContactList(pageQuery), pageQuery.getMapOfPageQuery());
    }
    @ApiOperation(value="客户-联系人信息新建")
    @PostMapping("/add-account-contact")
    public ResultDTO addAccountContact(@RequestBody AccountContactVO accountContactVO){
        String code = accountContactService.addAccountContact(accountContactVO);
        if (code!=null){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code",code);
            return ResultDTO.success(jsonObject);
        }
        return ResultDTO.error("客户-联系人信息新建失败");
    }
    @ApiOperation(value="客户-联系人信息更新")
    @PutMapping("/modify-account-contact")
    public ResultDTO modifyAccountContact(@RequestBody AccountContactVO accountContactVO){
        if (accountContactService.modifyAccountContact(accountContactVO)){
            return ResultDTO.success();
        }
        return ResultDTO.error("客户-联系人信息更新失败");
    }
}
