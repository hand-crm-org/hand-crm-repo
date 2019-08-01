package com.hand.position.controller;

import com.hand.frame.model.ServiceData;
import com.hand.frame.util.PageQuery;
import com.hand.position.access.vo.PositionVO;
import com.hand.position.service.PositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("职位相关api")
public class PositionController {
    @Autowired
    PositionService positionService;

    @ApiOperation(value="新建职位")
    @PostMapping("/addPosition")
    public String addPosition(@RequestBody PositionVO positionVO){
        return positionService.addPosition(positionVO);
    }

    @ApiOperation(value="查询职位")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
            @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int")
    })
    @PostMapping("/getPosInfo")
    public ServiceData getPosInfo(@RequestBody(required = false) PositionVO positionVO, int currentPage, int pageSize){
        PageQuery<PositionVO> pageQuery = new PageQuery<PositionVO>(positionVO, currentPage, pageSize);
        return  ServiceData.success(positionService.getPosition(pageQuery), pageQuery.getMapOfPageQuery());
    }

    @ApiOperation(value="修改值列表")
    @PutMapping("/modifyPosition")
    public String modifyPosition(@RequestBody PositionVO positionVO){
        return positionService.modifyPosition(positionVO);
    }

    @ApiOperation(value = "删除值列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="code", value="职位code", dataType="String")
    })
    @DeleteMapping("/removePosition")
    public String removePosition(@RequestParam("code") String code){
        return positionService.removePosition(code);
    }
}
