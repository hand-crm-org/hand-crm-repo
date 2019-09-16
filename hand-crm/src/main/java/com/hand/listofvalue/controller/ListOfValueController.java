package com.hand.listofvalue.controller;

import com.hand.frame.model.ResultDTO;
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
            @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int"),
            @ApiImplicitParam(paramType="query", name="code", value="值列表编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="type", value="类型", dataType="String"),
            @ApiImplicitParam(paramType="query", name="langId", value="语言", dataType="String"),
            @ApiImplicitParam(paramType="query", name="val", value="显示值", dataType="String"),
            @ApiImplicitParam(paramType="query", name="name", value="独立源代码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="parLstCode", value="父值列表编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="level", value="等级", dataType="int"),
            @ApiImplicitParam(paramType="query", name="actFlg", value="生效标识", dataType="String"),
            @ApiImplicitParam(paramType="query", name="desc", value="描述", dataType="String")
    })
    @GetMapping("/getLstOfVal")
    public ServiceData getLstOfVal(int currentPage, int pageSize,String code,String type,
                                   String langId,String val,String name,String parLstCode,
                                   Integer level,String actFlg,String desc){
        ListOfValueVO listOfValueVO = new ListOfValueVO();
        listOfValueVO.setCode(code);
        listOfValueVO.setType(type);
        listOfValueVO.setLangId(langId);
        listOfValueVO.setVal(val);
        listOfValueVO.setName(name);
        listOfValueVO.setParLstCode(parLstCode);
        listOfValueVO.setLevel(level);
        listOfValueVO.setActFlg(actFlg);
        listOfValueVO.setDesc(desc);
        PageQuery<ListOfValueVO> pageQuery = new PageQuery<ListOfValueVO>(listOfValueVO, currentPage, pageSize);
        return  ServiceData.success(listOfValueService.getLstOfVaL(pageQuery), pageQuery.getMapOfPageQuery());
    }

    @ApiOperation(value="新建值列表")
    @PostMapping("/addLstOfVal")
    public ResultDTO addListOfValue(@RequestBody ListOfValueVO listOfValueVO){
        String str = "insert";
        Map<String,Object> map = listOfValueService.toUniqueVerify(listOfValueVO,str);
        String msg = "";
        boolean flag = (boolean) map.get("status");
        if(flag){
            return listOfValueService.insertLstOfVal(listOfValueVO);
        }
        else{
            msg= (String) map.get("msg");
            return ResultDTO.error(msg);
        }
    }

    @ApiOperation(value="修改值列表")
    @PutMapping("/modifyLstOfVal")
    public ResultDTO modifyListOfValue(@RequestBody ListOfValueVO listOfValueVO){
        String str = "update";
        Map<String,Object> map = listOfValueService.toUniqueVerify(listOfValueVO,str);
        String msg = "";
        boolean flag = (boolean) map.get("status");
        if(flag){
            return listOfValueService.updateLstOfVal(listOfValueVO);
        }
        else{
            msg= (String) map.get("msg");
            return ResultDTO.error(msg);
        }

    }
    @ApiOperation(value = "删除值列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="code", value="值列表code", dataType="String")
    })
    @DeleteMapping("/removeLstOfVal")
    public ResultDTO removeLstOfVal(@RequestParam("code") String code){
        return listOfValueService.removeLstOfValByCode(code);
    }
}
