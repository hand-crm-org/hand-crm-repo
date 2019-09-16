package com.hand.product.service;

import com.hand.frame.model.ResultDTO;
import com.hand.frame.util.PageQuery;
import com.hand.product.access.vo.ProductVO;

import java.util.List;

public interface ProductService {
    /**
     * 新建产品
     * @UpdateBy fuzw
     * @param productVO
     * @Return int
     */
    ResultDTO addProduct(ProductVO productVO);


    /**
     * 根据条件查询产品
     * @UpdateBy fuzw
     * @param pageQuery
     * @Return List<ProductVO>
     */
    List<ProductVO> getProduct(PageQuery<ProductVO> pageQuery);


    /**
     * 更新产品
     * @UpdateBy fuzw
     * @param productVO
     * @Return int
     */
    ResultDTO modifyProduct(ProductVO productVO);


    /**
     * 删除产品
     * @UpdateBy fuzw
     * @param code
     * @Return int
     */
    ResultDTO removeProduct(String code);
}
