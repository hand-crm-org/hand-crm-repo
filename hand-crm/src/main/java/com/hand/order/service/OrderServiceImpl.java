package com.hand.order.service;

import com.alibaba.fastjson.JSONObject;
import com.hand.frame.model.ResultDTO;
import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import com.hand.order.access.dao.OrderDao;
import com.hand.order.access.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Override
    public ResultDTO addOrder(OrderVO orderVO) {
        if (!StringUtil.isEmpty(orderVO.getAccountCode()) && !StringUtil.isEmpty(orderVO.getUpdatedBy())
                && !StringUtil.isEmpty(orderVO.getAccountAddrCode()) && !StringUtil.isEmpty(orderVO.getOwnerDeptCode())
                && !StringUtil.isEmpty(orderVO.getOrderTypeCode()) && !StringUtil.isEmpty(orderVO.getOrderEntity())
                && !StringUtil.isEmpty(orderVO.getCountry())&& (orderVO.getRate()!= null)
                && !StringUtil.isEmpty(orderVO.getAmountRatedFlag())&& (orderVO.getTotalAmount()!=null)
                && (orderVO.getRatedAmount()!=null)&& (orderVO.getUnratedAmount()!=null)
                && !StringUtil.isEmpty(orderVO.getCurrency())&& !StringUtil.isEmpty(orderVO.getSalesMethodCode())
                && (orderVO.getOrderSignTime()!=null)&& (orderVO.getOrderEffectTime()!=null)) {
            String code = StringUtil.getCode();
            orderVO.setCode(code);
            int count = orderDao.insertOrder(orderVO);
            if (count > 0) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code", code);
                return ResultDTO.success(jsonObject);
            }
            return ResultDTO.error("新建销售订单失败");
        }
        return ResultDTO.error("缺失参数");
    }

    @Override
    public List<OrderVO> getOderList(PageQuery<OrderVO> pageQuery) {
        int count = orderDao.queryOrderCount(pageQuery);
        pageQuery.setCount(count);
        if (count > 0) {
            return orderDao.queryOrderList(pageQuery);
        }
        return null;
    }

    @Override
    public ResultDTO modifyOrder(OrderVO orderVO) {
        if (!StringUtil.isEmpty(orderVO.getCode()) && !StringUtil.isEmpty(orderVO.getUpdatedBy())) {
            int count = orderDao.updateOrder(orderVO);
            if (count > 0) {
                return ResultDTO.success();
            }
            return ResultDTO.error("修改订单信息失败");
        }
        return ResultDTO.error("缺失参数");
    }
}
