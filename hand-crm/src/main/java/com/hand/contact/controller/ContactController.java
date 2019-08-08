package com.hand.contact.controller;

import com.hand.contact.access.vo.ContactVO;
import com.hand.contact.service.ContactService;
import com.hand.frame.model.ServiceData;
import com.hand.frame.util.PageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("联系人相关api")
public class ContactController {
    @Autowired
    ContactService contactService;

    @ApiOperation(value="联系人列表查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
            @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int"),
            @ApiImplicitParam(paramType="query", name="code", value="联系人编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="objCode", value="对象编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="serviceCode", value="服务编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="name", value="姓名", dataType="String"),
            @ApiImplicitParam(paramType="query", name="nameForeign", value="英文名", dataType="String"),
            @ApiImplicitParam(paramType="query", name="phNum", value="电话", dataType="String"),
            @ApiImplicitParam(paramType="query", name="email", value="邮箱地址", dataType="String"),
            @ApiImplicitParam(paramType="query", name="jobTitle", value="职位", dataType="String"),
            @ApiImplicitParam(paramType="query", name="hobby", value="喜好", dataType="String"),
            @ApiImplicitParam(paramType="query", name="desc", value="备注", dataType="String"),
            @ApiImplicitParam(paramType="query", name="status", value="状态", dataType="String")
    })
    @GetMapping("/getContactList")
    public ServiceData getContactList(int currentPage,int pageSize,String code,String objCode, String serviceCode,
                                      String name,String nameForeign,String phNum,String email,String jobTitle,
                                      String hobby,String desc,String status){
        ContactVO contactVO = new ContactVO();
        contactVO.setCode(code);
        contactVO.setObjCode(objCode);
        contactVO.setServiceCode(serviceCode);
        contactVO.setName(name);
        contactVO.setNameForeign(nameForeign);
        contactVO.setPhNum(phNum);
        contactVO.setEmail(email);
        contactVO.setJobTitle(jobTitle);
        contactVO.setHobby(hobby);
        contactVO.setDesc(desc);
        contactVO.setStatus(status);
        PageQuery<ContactVO> pageQuery = new PageQuery<ContactVO>(contactVO,currentPage,pageSize);
        return ServiceData.success(contactService.getContactList(pageQuery), pageQuery.getMapOfPageQuery());
    }
    @ApiOperation(value="联系人信息新建")
    @PostMapping("/addContact")
    public String addContact(@RequestBody ContactVO contactVO){
        if (contactService.addContact(contactVO)){
            return "success";
        }
        return "failed";
    }
    @ApiOperation(value="联系人信息更新")
    @PutMapping("/modifyContact")
    public String modifyContact(@RequestBody ContactVO contactVO){
        if (contactService.modifyContact(contactVO)){
            return "success";
        }
        return "failed";
    }
}
