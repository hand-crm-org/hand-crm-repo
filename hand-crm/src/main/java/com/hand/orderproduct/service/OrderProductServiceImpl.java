package com.hand.orderproduct.service;

import com.alibaba.fastjson.JSONObject;
import com.hand.frame.model.ResultDTO;
import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import com.hand.orderproduct.access.dao.OrderProductDao;
import com.hand.orderproduct.access.vo.OrderProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductServiceImpl implements OrderProductService {

    @Autowired
    private OrderProductDao orderProductDao;

    @Override
    public ResultDTO addOrderProd(OrderProductVO orderProductVO) {
        if (!StringUtil.isEmpty(orderProductVO.getProductCtlg()) && !StringUtil.isEmpty(orderProductVO.getUpdatedBy())
                && !StringUtil.isEmpty(orderProductVO.getProductCtgy()) && !StringUtil.isEmpty(orderProductVO.getProductNum())
                && !StringUtil.isEmpty(orderProductVO.getProductUnit()) && !StringUtil.isEmpty(orderProductVO.getProductPrice())
                && !StringUtil.isEmpty(orderProductVO.getProductQuantity())) {
            String code = StringUtil.getCode();
            orderProductVO.setCode(code);
            int count = orderProductDao.insertOrderProd(orderProductVO);
            if (count > 0) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code", code);
                return ResultDTO.success(jsonObject);
            }
            return ResultDTO.error("新建订单产品失败");
        }
        return ResultDTO.error("缺失参数");
    }

    @Override
    public List<OrderProductVO> getOrderProd(PageQuery<OrderProductVO> pageQuery) {
        int count = orderProductDao.queryOrderProdCount(pageQuery);
        pageQuery.setCount(count);
        if (count > 0) {
            return orderProductDao.queryOrderProdList(pageQuery);
        }
        return null;
    }

    @Override
    public ResultDTO modifyOrderProd(OrderProductVO orderProductVO) {
        if (!StringUtil.isEmpty(orderProductVO.getCode()) && !StringUtil.isEmpty(orderProductVO.getUpdatedBy())) {
            int count = orderProductDao.updateOrderProd(orderProductVO);
            if (count > 0) {
                return ResultDTO.success();
            }
            return ResultDTO.error("修改订单产品失败");
        }
        return ResultDTO.error("缺失参数");
    }

    @Override
    public ResultDTO removeOrderProd(OrderProductVO orderProd) {
        if (!StringUtil.isEmpty(orderProd.getCode())) {
            int count = orderProductDao.deleteOrderProd(orderProd.getCode());
            if (count > 0) {
                return ResultDTO.success();
            }
            return ResultDTO.error("删除订单产品失败");
        }
        return ResultDTO.error("缺失参数");
    }
}
