package com.hand.accountcontact.controller;

import com.hand.accountcontact.access.vo.AccntCtctVO;
import com.hand.accountcontact.service.AccntCtctService;
import com.hand.frame.model.ServiceData;
import com.hand.frame.util.PageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("客户联系人相关api")
public class AccntCtctController {
    @Autowired
    AccntCtctService accntCtctService;

    @ApiOperation("查询客户联系人列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
            @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int"),
            @ApiImplicitParam(paramType = "query",name = "code",value = "客户-联系人编码",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "accntCode",value = "客户编码",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "ctctCode",value = "联系人编码",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "status",value = "状态",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "desc",value = "描述",dataType = "String"),
    })
    @GetMapping("/getAccntCtctList")
    public ServiceData getAccntCtctList(int currentPage, int pageSize, String code, String accntCode,
                                        String ctctCode, String status, String desc){
        AccntCtctVO accntCtctVO = new AccntCtctVO();
        accntCtctVO.setCode(code);
        accntCtctVO.setAccntCode(accntCode);
        accntCtctVO.setCtctCode(ctctCode);
        accntCtctVO.setStatus(status);
        accntCtctVO.setDesc(desc);
        PageQuery<AccntCtctVO> pageQuery = new PageQuery<AccntCtctVO>(accntCtctVO,currentPage,pageSize);
        return ServiceData.success(accntCtctService.getAccntCtctList(pageQuery), pageQuery.getMapOfPageQuery());
    }
    @ApiOperation(value="客户-联系人信息新建")
    @PostMapping("/addAccntCtct")
    public String addAccntCtct(@RequestBody AccntCtctVO accntCtctVO){
        if (accntCtctService.addAccntCtct(accntCtctVO)){
            return "success";
        }
        return "failed";
    }
    @ApiOperation(value="客户-联系人信息更新")
    @PutMapping("/modifyAccntCtct")
    public String modifyAccntCtct(@RequestBody AccntCtctVO accntCtctVO){
        if (accntCtctService.modifyAccntCtct(accntCtctVO)){
            return "success";
        }
        return "failed";
    }
}
