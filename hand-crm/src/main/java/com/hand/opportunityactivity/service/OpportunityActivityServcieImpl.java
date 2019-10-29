package com.hand.opportunityactivity.service;

import com.alibaba.fastjson.JSONObject;
import com.hand.frame.model.ResultDTO;
import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import com.hand.opportunityactivity.access.dao.OpportunityActivityDao;
import com.hand.opportunityactivity.access.vo.OpportunityActivityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpportunityActivityServcieImpl implements OpportunityActivityServcie {

    @Autowired
    private OpportunityActivityDao opportunityActivityDao;

    @Override
    public ResultDTO addOpportunityActivity(OpportunityActivityVO opportunityActivityVO) {
        if (!StringUtil.isEmpty(opportunityActivityVO.getOptyCode()) && !StringUtil.isEmpty(opportunityActivityVO.getUpdatedBy())
                && !StringUtil.isEmpty(opportunityActivityVO.getName()) && !StringUtil.isEmpty(opportunityActivityVO.getType())
                && !StringUtil.isEmpty(opportunityActivityVO.getStatus()) && !StringUtil.isEmpty(opportunityActivityVO.getPriority())
                && !StringUtil.isEmpty(opportunityActivityVO.getRespCode())) {
            String code = StringUtil.getCode();
            opportunityActivityVO.setCode(code);
            int count = opportunityActivityDao.insertOpportunityActive(opportunityActivityVO);
            if (count > 0) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code", code);
                return ResultDTO.success(jsonObject);
            }
            return ResultDTO.error("新建商机活动失败");
        }
        return ResultDTO.error("缺失参数");
    }

    @Override
    public List<OpportunityActivityVO> getOpportunityActivity(PageQuery<OpportunityActivityVO> pageQuery) {
        int count = opportunityActivityDao.queryOpportunityActiveCount(pageQuery);
        pageQuery.setCount(count);
        if (count > 0) {
            return opportunityActivityDao.queryOpportunityActive(pageQuery);
        }
        return null;
    }

    @Override
    public ResultDTO modifyOpportunityActivity(OpportunityActivityVO opportunityActivityVO) {
        if (!StringUtil.isEmpty(opportunityActivityVO.getCode()) && !StringUtil.isEmpty(opportunityActivityVO.getUpdatedBy())) {
            int count = opportunityActivityDao.updateOpportunityActive(opportunityActivityVO);
            if (count > 0) {
                return ResultDTO.success();
            }
            return ResultDTO.error("修改商机活动失败");
        }
        return ResultDTO.error("缺失参数");
    }

    @Override
    public ResultDTO deleteOpportunityActivity(OpportunityActivityVO opportunityActivityVO) {
        if (!StringUtil.isEmpty(opportunityActivityVO.getUpdatedBy())) {
            int count = opportunityActivityDao.deleteOpportunityActive(opportunityActivityVO);
            if (count > 0) {
                return ResultDTO.success();
            }
            return ResultDTO.error("删除商机活动失败");
        }
        return ResultDTO.error("缺失参数");
    }
}
