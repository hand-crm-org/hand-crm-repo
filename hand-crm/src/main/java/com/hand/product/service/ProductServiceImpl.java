package com.hand.product.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.hand.frame.model.ResultDTO;
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
	public ResultDTO addProduct(ProductVO productVO) {
		if(!StringUtil.isEmpty(productVO.getType())
                &&!StringUtil.isEmpty(productVO.getName())&&!StringUtil.isEmpty(productVO.getExtCode())
                &&!StringUtil.isEmpty(productVO.getUpdatedBy())&&!StringUtil.isEmpty(productVO.getStatus())) {
            String code = StringUtil.getCode();
            productVO.setCode(code);
		    int count = productDao.insertProduct(productVO);
            if (count > 0) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code",code);
                return ResultDTO.success(jsonObject);
            }
            return ResultDTO.error("新建产品失败");
        }
        return ResultDTO.error("缺失参数");
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
	public ResultDTO modifyProduct(ProductVO productVO) {
		if(!StringUtil.isEmpty(productVO.getCode())&&!StringUtil.isEmpty(productVO.getUpdatedBy())) {
            int count = productDao.updateProduct(productVO);
            if (count > 0) {
                return ResultDTO.success();
            }
            return ResultDTO.error("修改产品失败");
        }
        return ResultDTO.error("缺失参数");
	}
	/**
     * 删除产品
     * @UpdateBy fuzw
     * @param code
     * @Return int
     */
	@Override
	public ResultDTO removeProduct(String code) {
		if(!StringUtil.isEmpty(code)) {
            int count = productDao.deleteProduct(code);
            if (count > 0) {
                return ResultDTO.success();
            }
            return ResultDTO.error("删除产品失败");
        }
        return ResultDTO.error("缺失参数");
	}

}
