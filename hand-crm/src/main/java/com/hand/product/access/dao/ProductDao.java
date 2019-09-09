package com.hand.product.access.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hand.frame.util.PageQuery;
import com.hand.product.access.vo.ProductVO;

@Repository
public interface ProductDao {
    /**
     * 新建产品
     * @UpdateBy fuzw
     * @param productVO
     * @Return int
     */
    int insertProduct(ProductVO productVO);
    /**
     * 根据条件查询产品
     * @UpdateBy fuzw
     * @param pageQuery
     * @Return List<ProductVO>
     */
    List<ProductVO> queryProduct(PageQuery<ProductVO> pageQuery);
    /**
     * 根据条件查询产品得到的数量
     * @UpdateBy fuzw
     * @param pageQuery
     * @Return List<ProductVO>
     */
    int queryProductCount(PageQuery<ProductVO> pageQuery);
    /**
     * 修改产品
     * @UpdateBy fuzw
     * @param productVO 
     * @Return int
     */
    int updateProduct(ProductVO productVO);
    /**
     * 删除产品
     * @UpdateBy fuzw
     * @param code
     * @Return int
     */
    int deleteProduct(String code);
}