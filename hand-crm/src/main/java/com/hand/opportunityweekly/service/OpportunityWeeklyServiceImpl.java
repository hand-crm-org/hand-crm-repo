package com.hand.opportunityweekly.service;

import com.alibaba.fastjson.JSONObject;
import com.hand.frame.model.ResultDTO;
import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import com.hand.opportunityweekly.access.dao.OpportunityWeeklyDao;
import com.hand.opportunityweekly.access.vo.OpportunityWeeklyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpportunityWeeklyServiceImpl implements OpportunityWeeklyService {
    @Autowired
    private OpportunityWeeklyDao opportunityWeeklyDao;

    @Override
    public ResultDTO addOpportunityWeekly(OpportunityWeeklyVO opportunityWeeklyVO) {
        if (!StringUtil.isEmpty(opportunityWeeklyVO.getOptyCode()) && !StringUtil.isEmpty(opportunityWeeklyVO.getUpdatedBy())
                && !StringUtil.isEmpty(opportunityWeeklyVO.getName()) && !StringUtil.isEmpty(opportunityWeeklyVO.getWeeklySummary())
                && !StringUtil.isEmpty(opportunityWeeklyVO.getWeeklyPushStatusCode())) {
            String code = StringUtil.getCode();
            opportunityWeeklyVO.setCode(code);
            int count = opportunityWeeklyDao.insertOpportunityWeekly(opportunityWeeklyVO);
            if (count > 0) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code", code);
                return ResultDTO.success(jsonObject);
            }
            return ResultDTO.error("新建商机周报失败");
        }
        return ResultDTO.error("缺失参数");
    }

    @Override
    public List<OpportunityWeeklyVO> getOpportunityWeekly(PageQuery<OpportunityWeeklyVO> pageQuery) {
        int count = opportunityWeeklyDao.queryOpportunityWeeklyCount(pageQuery);
        pageQuery.setCount(count);
        if (count > 0) {
            return opportunityWeeklyDao.queryOpportunityWeekly(pageQuery);
        }
        return null;
    }

    @Override
    public ResultDTO modifyOpportunityWeekly(OpportunityWeeklyVO opportunityWeeklyVO) {
        if (!StringUtil.isEmpty(opportunityWeeklyVO.getCode()) && !StringUtil.isEmpty(opportunityWeeklyVO.getUpdatedBy())) {
            int count = opportunityWeeklyDao.updateOpportunityWeekly(opportunityWeeklyVO);
            if (count > 0) {
                return ResultDTO.success();
            }
            return ResultDTO.error("修改商机周报失败");
        }
        return ResultDTO.error("缺失参数");
    }

    @Override
    public ResultDTO deleteOpportunityWeekly(OpportunityWeeklyVO opportunityWeeklyVO) {
        if (!StringUtil.isEmpty(opportunityWeeklyVO.getUpdatedBy())) {
            int count = opportunityWeeklyDao.deleteOpportunityWeekly(opportunityWeeklyVO);
            if (count > 0) {
                return ResultDTO.success();
            }
            return ResultDTO.error("删除商机周报失败");
        }
        return ResultDTO.error("缺失参数");
    }
}
