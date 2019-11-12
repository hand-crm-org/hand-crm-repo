package com.hand.opportunityprod.service;

import com.alibaba.fastjson.JSONObject;
import com.hand.frame.model.ResultDTO;
import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import com.hand.opportunityprod.access.dao.OpportunityProductDao;
import com.hand.opportunityprod.access.vo.OpportunityProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpportunityProductServiceImpl implements OpportunityProductService {
    @Autowired
    OpportunityProductDao opportunityProductDao;
    @Override
    public ResultDTO addOpportunityProd(OpportunityProductVO opportunityProductVO) {
        if (!StringUtil.isEmpty(opportunityProductVO.getOptyCode())&& !StringUtil.isEmpty(opportunityProductVO.getUpdatedBy())
                && !StringUtil.isEmpty(opportunityProductVO.getPrimaryFlag())
                && (opportunityProductVO.getExpectSignTime()!=null) && (opportunityProductVO.getAmount()!=null))
        {
            String code = StringUtil.getCode();
            opportunityProductVO.setCode(code);
            int count = opportunityProductDao.insertOpportunityProd(opportunityProductVO);
            if (count > 0) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code",code);
                return ResultDTO.success(jsonObject);
            }
            return ResultDTO.error("新建商机产品失败");
        }
        return ResultDTO.error("缺失参数");
    }

    @Override
    public List<OpportunityProductVO> getOpportunityProd(PageQuery<OpportunityProductVO> pageQuery) {
        int count = opportunityProductDao.queryOpportunityProdCount(pageQuery);
        pageQuery.setCount(count);
        if(count > 0) {
            return opportunityProductDao.queryOpportunityProd(pageQuery);
        }
        return null;
    }

    @Override
    public ResultDTO modifyOpportunityProd(OpportunityProductVO opportunityProductVO) {
        if(!StringUtil.isEmpty(opportunityProductVO.getCode())&&!StringUtil.isEmpty(opportunityProductVO.getUpdatedBy())) {
            int count = opportunityProductDao.updateOpportunityProd(opportunityProductVO);
            if (count > 0) {
                return ResultDTO.success();
            }
            return ResultDTO.error("修改商机产品失败");
        }
        return ResultDTO.error("缺失参数");
    }

    @Override
    public ResultDTO deleteOpportunityProd(OpportunityProductVO opportunityProductVO) {
        if(!StringUtil.isEmpty(opportunityProductVO.getUpdatedBy())) {
            int count = opportunityProductDao.deleteOpportunityProd(opportunityProductVO);
            if (count > 0) {
                return ResultDTO.success();
            }
            return ResultDTO.error("删除商机产品失败");
        }
        return ResultDTO.error("缺失参数");
    }
}
