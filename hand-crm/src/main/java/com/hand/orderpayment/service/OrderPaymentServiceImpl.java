package com.hand.orderpayment.service;

import com.alibaba.fastjson.JSONObject;
import com.hand.frame.model.ResultDTO;
import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import com.hand.orderpayment.access.dao.OrderPaymentDao;
import com.hand.orderpayment.access.vo.OrderPaymentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderPaymentServiceImpl implements OrderPaymentService {

    @Autowired
    private OrderPaymentDao orderPaymentDao;

    @Override
    public ResultDTO addOrderPayment(OrderPaymentVO orderPaymentVO) {
        if (!StringUtil.isEmpty(orderPaymentVO.getPaymentName()) && !StringUtil.isEmpty(orderPaymentVO.getUpdatedBy())
                && orderPaymentVO.getBillAmount()!=null && orderPaymentVO.getPlanPaymentAmount()!=null
                && orderPaymentVO.getPlanPaymentTime()!=null && orderPaymentVO.getReceivedAmount()!=null) {
            String code = StringUtil.getCode();
            orderPaymentVO.setCode(code);
            int count = orderPaymentDao.insertPayment(orderPaymentVO);
            if (count > 0) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code", code);
                return ResultDTO.success(jsonObject);
            }
            return ResultDTO.error("新建订单回款");
        }
        return ResultDTO.error("缺失参数");
    }

    @Override
    public List<OrderPaymentVO> getOrderPayment(PageQuery<OrderPaymentVO> pageQuery) {
        int count = orderPaymentDao.queryPaymentCount(pageQuery);
        pageQuery.setCount(count);
        if (count > 0) {
            return orderPaymentDao.queryPaymentList(pageQuery);
        }
        return null;
    }

    @Override
    public ResultDTO modifyOrderPayment(OrderPaymentVO orderPaymentVO) {
        if (!StringUtil.isEmpty(orderPaymentVO.getCode()) && !StringUtil.isEmpty(orderPaymentVO.getUpdatedBy())) {
            int count = orderPaymentDao.updatePayment(orderPaymentVO);
            if (count > 0) {
                return ResultDTO.success();
            }
            return ResultDTO.error("修改订单回款失败");
        }
        return ResultDTO.error("缺失参数");
    }

    @Override
    public ResultDTO removeOrderPayment(OrderPaymentVO orderPaymentVO) {
        if (!StringUtil.isEmpty(orderPaymentVO.getCode())) {
            int count = orderPaymentDao.deletePayment(orderPaymentVO.getCode());
            if (count > 0) {
                return ResultDTO.success();
            }
            return ResultDTO.error("删除订单回款失败");
        }
        return ResultDTO.error("缺失参数");
    }
}
