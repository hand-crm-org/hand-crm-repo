package com.hand.orderpayterm.service;

import com.alibaba.fastjson.JSONObject;
import com.hand.frame.model.ResultDTO;
import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import com.hand.orderpayterm.access.dao.OrderPayTermDao;
import com.hand.orderpayterm.access.vo.OrderPayTermVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderPayTermServiceImpl implements OrderPayTermService {
    @Autowired
    private OrderPayTermDao orderPayTermDao;

    @Override
    public ResultDTO addOrderPayTerm(OrderPayTermVO orderPayTermVO) {
        if (!StringUtil.isEmpty(orderPayTermVO.getPayCondition()) && !StringUtil.isEmpty(orderPayTermVO.getUpdatedBy())
                && !StringUtil.isEmpty(orderPayTermVO.getPayMethod()) && orderPayTermVO.getPayAmount()!=null
                && orderPayTermVO.getPayTime()!=null) {
            String code = StringUtil.getCode();
            orderPayTermVO.setCode(code);
            int count = orderPayTermDao.insertPayTerm(orderPayTermVO);
            if (count > 0) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code", code);
                return ResultDTO.success(jsonObject);
            }
            return ResultDTO.error("新建订单付款条件");
        }
        return ResultDTO.error("缺失参数");
    }

    @Override
    public List<OrderPayTermVO> getOrderPayTerm(PageQuery<OrderPayTermVO> pageQuery) {
        int count = orderPayTermDao.queryPayTermCount(pageQuery);
        pageQuery.setCount(count);
        if (count > 0) {
            return orderPayTermDao.queryPayTermList(pageQuery);
        }
        return null;
    }

    @Override
    public ResultDTO modifyOrderPayTerm(OrderPayTermVO orderPayTermVO) {
        if (!StringUtil.isEmpty(orderPayTermVO.getCode()) && !StringUtil.isEmpty(orderPayTermVO.getUpdatedBy())) {
            int count = orderPayTermDao.updatePayTerm(orderPayTermVO);
            if (count > 0) {
                return ResultDTO.success();
            }
            return ResultDTO.error("修改订单付款条件失败");
        }
        return ResultDTO.error("缺失参数");
    }

    @Override
    public ResultDTO removeOrderPayTerm(OrderPayTermVO orderPayTermVO) {
        if (!StringUtil.isEmpty(orderPayTermVO.getCode())) {
            int count = orderPayTermDao.deletePayTerm(orderPayTermVO.getCode());
            if (count > 0) {
                return ResultDTO.success();
            }
            return ResultDTO.error("删除订单付款条件失败");
        }
        return ResultDTO.error("缺失参数");
    }
}
