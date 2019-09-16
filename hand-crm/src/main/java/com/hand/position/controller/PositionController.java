package com.hand.position.controller;

import com.hand.frame.model.ResultDTO;
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
    public ResultDTO addPosition(@RequestBody PositionVO positionVO){
        return positionService.addPosition(positionVO);
    }

    @ApiOperation(value="查询职位")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
            @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int"),
            @ApiImplicitParam(paramType="query", name="code", value="职位编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="name", value="名称", dataType="String"),
            @ApiImplicitParam(paramType="query", name="desc", value="描述", dataType="String"),
            @ApiImplicitParam(paramType="query", name="level", value="职级", dataType="String"),
            @ApiImplicitParam(paramType="query", name="type", value="类型", dataType="String"),
            @ApiImplicitParam(paramType="query", name="orgCode", value="组织编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="priEmpCode", value="主要员工编码", dataType="String"),
            @ApiImplicitParam(paramType="query", name="status", value="是否有效", dataType="String")
    })
    @GetMapping("/getPosInfo")
    public ServiceData getPosInfo(int currentPage, int pageSize,
                                  @RequestParam(value = "code",required = false) String code, @RequestParam(value = "name",required = false) String name,
                                  @RequestParam(value = "desc",required = false) String desc, @RequestParam(value = "level",required = false) String level,
                                  @RequestParam(value = "type",required = false) String type, @RequestParam(value = "orgCode",required = false) String orgCode,
                                  @RequestParam(value = "priEmpCode",required = false) String priEmpCode, @RequestParam(value = "status",required = false) String status){
        PositionVO positionVO = new PositionVO();
        positionVO.setCode(code);
        positionVO.setName(name);
        positionVO.setDesc(desc);
        positionVO.setLevel(level);
        positionVO.setType(type);
        positionVO.setOrgCode(orgCode);
        positionVO.setPriEmpCode(priEmpCode);
        positionVO.setStatus(status);
        PageQuery<PositionVO> pageQuery = new PageQuery<PositionVO>(positionVO, currentPage, pageSize);
        return  ServiceData.success(positionService.getPosition(pageQuery), pageQuery.getMapOfPageQuery());
    }

    @ApiOperation(value="修改值列表")
    @PutMapping("/modifyPosition")
    public ResultDTO modifyPosition(@RequestBody PositionVO positionVO){
        return positionService.modifyPosition(positionVO);
    }

    @ApiOperation(value = "删除值列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="code", value="职位code", dataType="String")
    })
    @DeleteMapping("/removePosition")
    public ResultDTO removePosition(@RequestParam("code") String code){
        return positionService.removePosition(code);
    }
}
