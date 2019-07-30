package com.hand.listofvalue.controller;

import com.hand.frame.model.ServiceData;
import com.hand.frame.util.PageQuery;
import com.hand.listofvalue.access.vo.ListOfValueVO;
import com.hand.listofvalue.service.ListOfValueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Api("值列表相关api")
public class ListOfValueController {
    @Autowired
    ListOfValueService listOfValueService;

    @ApiOperation(value="值列表查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
            @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int")
    })
    @GetMapping("/getLstOfVal")
    public ServiceData getLstOfVal(@RequestBody(required = false) ListOfValueVO listOfValueVO, int currentPage, int pageSize){
        PageQuery<ListOfValueVO> pageQuery = new PageQuery<ListOfValueVO>(listOfValueVO, currentPage, pageSize);
        return  ServiceData.success(listOfValueService.getLstOfVaL(pageQuery), pageQuery.getMapOfPageQuery());
    }

    @ApiOperation(value="新建值列表")
    @PostMapping("/addLstOfVal")
    public String addListOfValue(@RequestBody ListOfValueVO listOfValueVO){
        String str = "insert";
        Map<String,Object> map = listOfValueService.toUniqueVerify(listOfValueVO,str);
        String msg = "";
        boolean flag = (boolean) map.get("status");
        if(flag){
            msg = listOfValueService.insertLstOfVal(listOfValueVO);
        }
        else{
            msg= (String) map.get("msg");
        }
        return msg;
    }

    @ApiOperation(value="修改值列表")
    @PutMapping("/modifyLstOfVal")
    public String modifyListOfValue(@RequestBody ListOfValueVO listOfValueVO){
        String str = "update";
        Map<String,Object> map = listOfValueService.toUniqueVerify(listOfValueVO,str);
        String msg = "";
        boolean flag = (boolean) map.get("status");
        if(flag){
            msg = listOfValueService.updateLstOfVal(listOfValueVO);
        }
        else{
            msg= (String) map.get("msg");
        }
        return msg;
    }
    @ApiOperation(value = "删除值列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="delete", name="code", value="值列表code", dataType="String")
    })
    @DeleteMapping("/removeLstOfVal")
    public String removeLstOfVal(@RequestParam("code") String code){
        if (listOfValueService.removeLstOfValByCode(code)){
            return "success";
        }
        return "failed";
    }
}
