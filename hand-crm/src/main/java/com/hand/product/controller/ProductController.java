package com.hand.product.controller;

import com.hand.frame.model.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.hand.frame.model.ServiceData;
import com.hand.frame.util.PageQuery;
import com.hand.product.access.vo.ProductVO;
import com.hand.product.service.ProductService;

@RestController
@Api("产品相关api")
public class ProductController {
	 @Autowired
	 ProductService productService;
	
	 @ApiOperation(value="新建产品")
     @PostMapping("/addProduct")
	 public ResultDTO addProduct(@RequestBody ProductVO productVO){
         return productService.addProduct(productVO);
     }
	
	 @ApiOperation(value="查询产品")
	 @ApiImplicitParams({
	     @ApiImplicitParam(paramType="query", name="currentPage", value="当前页", dataType="int"),
	     @ApiImplicitParam(paramType="query", name="pageSize", value="页大小", dataType="int"),
	     @ApiImplicitParam(paramType="query", name="code", value="职位编码", dataType="String"),
	     @ApiImplicitParam(paramType="query", name="name", value="名称", dataType="String"),
	     @ApiImplicitParam(paramType="query", name="desc", value="描述", dataType="String"),
	     @ApiImplicitParam(paramType="query", name="prodLevel", value="职级", dataType="String"),
	     @ApiImplicitParam(paramType="query", name="type", value="类型", dataType="String"),
	     @ApiImplicitParam(paramType="query", name="extCode", value="外部编码", dataType="String"),
	     @ApiImplicitParam(paramType="query", name="parCode", value="父编码", dataType="String"),
	     @ApiImplicitParam(paramType="query", name="status", value="是否有效", dataType="String"),
		 @ApiImplicitParam(paramType="query", name="category", value="产品类别", dataType="String")
	 })
	 
	 @GetMapping("/getProdInfo")
	 public ServiceData getProdInfo(int currentPage, int pageSize,
             @RequestParam(value = "code",required = false) String code, @RequestParam(value = "name",required = false) String name,
             @RequestParam(value = "desc",required = false) String desc, @RequestParam(value = "prodLevel",required = false) String prodLevel,
             @RequestParam(value = "type",required = false) String type, @RequestParam(value = "extCode",required = false) String extCode,
             @RequestParam(value = "parCode",required = false) String parCode, @RequestParam(value = "status",required = false) String status,
			 @RequestParam(value = "category",required = false) String category){
			ProductVO productVO = new ProductVO();
			productVO.setCode(code);
			productVO.setName(name);
			productVO.setDesc(desc);
			productVO.setProdLevel(prodLevel);
			productVO.setType(type);
			productVO.setExtCode(extCode);
			productVO.setParCode(parCode);
			productVO.setStatus(status);
		 	productVO.setCategory(category);
			PageQuery<ProductVO> pageQuery = new PageQuery<ProductVO>(productVO, currentPage, pageSize);
			return  ServiceData.success(productService.getProduct(pageQuery), pageQuery.getMapOfPageQuery());
	}
	
	@ApiOperation(value="修改产品")
    @PutMapping("/modifyProduct")
    public ResultDTO modifyProduct(@RequestBody ProductVO productVO){
        return productService.modifyProduct(productVO);
    }
	
	@ApiOperation(value = "删除产品")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="code", value="产品code", dataType="String")
    })
    @DeleteMapping("/removeProduct")
    public ResultDTO removeProduct(@RequestParam("code") String code){
        return productService.removeProduct(code);
    }
	 
}
