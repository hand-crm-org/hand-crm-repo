package com.hand.ordershipment.service;

import com.alibaba.fastjson.JSONObject;
import com.hand.frame.model.ResultDTO;
import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import com.hand.ordershipment.access.dao.OrderShipmentDao;
import com.hand.ordershipment.access.vo.OrderShipmentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderShipmentServiceImpl implements OrderShipmentService {
    @Autowired
    private OrderShipmentDao orderShipmentDao;

    @Override
    public ResultDTO addOrderShipment(OrderShipmentVO orderShipmentVO) {
        if (!StringUtil.isEmpty(orderShipmentVO.getShipCondition()) && !StringUtil.isEmpty(orderShipmentVO.getUpdatedBy())
                && !StringUtil.isEmpty(orderShipmentVO.getReceiveCondition())) {
            String code = StringUtil.getCode();
            orderShipmentVO.setCode(code);
            int count = orderShipmentDao.insertOrderShipment(orderShipmentVO);
            if (count > 0) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code", code);
                return ResultDTO.success(jsonObject);
            }
            return ResultDTO.error("新建订单发到货失败");
        }
        return ResultDTO.error("缺失参数");
    }

    @Override
    public List<OrderShipmentVO> getOrderShipment(PageQuery<OrderShipmentVO> pageQuery) {
        int count = orderShipmentDao.queryOrderShipmentCount(pageQuery);
        pageQuery.setCount(count);
        if (count > 0) {
            return orderShipmentDao.queryOrderShipmentList(pageQuery);
        }
        return null;
    }

    @Override
    public ResultDTO modifyOrderShipment(OrderShipmentVO orderShipmentVO) {
        if (!StringUtil.isEmpty(orderShipmentVO.getCode()) && !StringUtil.isEmpty(orderShipmentVO.getUpdatedBy())) {
            int count = orderShipmentDao.updateOrderShipment(orderShipmentVO);
            if (count > 0) {
                return ResultDTO.success();
            }
            return ResultDTO.error("修改订单发到货失败");
        }
        return ResultDTO.error("缺失参数");
    }

    @Override
    public ResultDTO removeOrderShipment(OrderShipmentVO orderShipmentVO) {
        if (!StringUtil.isEmpty(orderShipmentVO.getCode())) {
            int count = orderShipmentDao.deleteOrderShipment(orderShipmentVO.getCode());
            if (count > 0) {
                return ResultDTO.success();
            }
            return ResultDTO.error("删除订单发到货失败");
        }
        return ResultDTO.error("缺失参数");
    }
}
