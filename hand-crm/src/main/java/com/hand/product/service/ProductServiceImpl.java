package com.hand.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import com.hand.product.access.dao.ProductDao;
import com.hand.product.access.vo.ProductVO;
import com.hand.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDao productDao;
	/**
     * 新建
     * @UpdateBy fuzw
     * @param productVO
     * @Return int
     */
	@Override
	public String addProduct(ProductVO productVO) {
		if(!StringUtil.isEmpty(productVO.getCode())&&!StringUtil.isEmpty(productVO.getType())
                &&!StringUtil.isEmpty(productVO.getName())&&!StringUtil.isEmpty(productVO.getExtCode())
                &&!StringUtil.isEmpty(productVO.getUpdatedBy())&&!StringUtil.isEmpty(productVO.getStatus())) {
            int count = productDao.insertProduct(productVO);
            if (count > 0) {
                return "success";
            }
            return "failed";
        }
        return "miss param";
	}
	/**
     * 根据条件查询产品
     * @UpdateBy fuzw
     * @param pageQuery
     * @Return List<ProductVO>
     */
	@Override
	public List<ProductVO> getProduct(PageQuery<ProductVO> pageQuery) {
		int count = productDao.queryProductCount(pageQuery);
        pageQuery.setCount(count);
        if(count > 0) {
            return productDao.queryProduct(pageQuery);
        }
        return null;
	}
	 /**
     * 修改产品
     * @UpdateBy fuzw
     * @param productVO
     * @Return int
     */
	@Override
	public String modifyProduct(ProductVO productVO) {
		if(!StringUtil.isEmpty(productVO.getCode())&&!StringUtil.isEmpty(productVO.getUpdatedBy())) {
            int count = productDao.updateProduct(productVO);
            if (count > 0) {
                return "success";
            }
            return "failed";
        }
        return "miss param";
	}
	/**
     * 删除产品
     * @UpdateBy fuzw
     * @param code
     * @Return int
     */
	@Override
	public String removeProduct(String code) {
		if(!StringUtil.isEmpty(code)) {
            int count = productDao.deleteProduct(code);
            if (count > 0) {
                return "success";
            }
            return "failed";
        }
        return "miss param";
	}

}
