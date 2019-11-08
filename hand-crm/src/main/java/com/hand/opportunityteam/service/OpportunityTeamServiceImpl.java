package com.hand.opportunityteam.service;

import com.alibaba.fastjson.JSONObject;
import com.hand.frame.model.ResultDTO;
import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import com.hand.opportunityteam.access.dao.OpportunityTeamDao;
import com.hand.opportunityteam.access.vo.OpportunityTeamVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpportunityTeamServiceImpl implements OpportunityTeamService {

    @Autowired
    OpportunityTeamDao opportunityTeamDao;
    @Override
    public ResultDTO addOpportunityTeam(OpportunityTeamVO opportunityTeamVO) {
        if (!StringUtil.isEmpty(opportunityTeamVO.getOptyCode())&& !StringUtil.isEmpty(opportunityTeamVO.getEmpCode())
            && !StringUtil.isEmpty(opportunityTeamVO.getTypeCode()) && !StringUtil.isEmpty(opportunityTeamVO.getPrimaryFlag()))
        {
            String code = StringUtil.getCode();
            opportunityTeamVO.setCode(code);
            int count = opportunityTeamDao.insertOpportunityTeam(opportunityTeamVO);
            if (count > 0) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code",code);
                return ResultDTO.success(jsonObject);
            }
            return ResultDTO.error("新建商机团队失败");
        }
        return ResultDTO.error("缺失参数");
    }

    @Override
    public List<OpportunityTeamVO> getOpportunityTeam(PageQuery<OpportunityTeamVO> pageQuery) {
        int count = opportunityTeamDao.queryOpportunityTeamCount(pageQuery);
        pageQuery.setCount(count);
        if(count > 0) {
            return opportunityTeamDao.queryOpportunityTeam(pageQuery);
        }
        return null;
    }

    @Override
    public ResultDTO modifyOpportunityTeam(OpportunityTeamVO opportunityTeamVO) {
        if(!StringUtil.isEmpty(opportunityTeamVO.getCode())&&!StringUtil.isEmpty(opportunityTeamVO.getUpdatedBy())) {
            int count = opportunityTeamDao.updateOpportunityTeam(opportunityTeamVO);
            if (count > 0) {
                return ResultDTO.success();
            }
            return ResultDTO.error("修改商机团队失败");
        }
        return ResultDTO.error("缺失参数");
    }

    @Override
    public ResultDTO deleteOpportunityTeam(OpportunityTeamVO opportunityTeamVO) {
        if (!StringUtil.isEmpty(opportunityTeamVO.getUpdatedBy())) {
            int count = opportunityTeamDao.deleteOpportunityTeam(opportunityTeamVO);
            if (count > 0) {
                return ResultDTO.success();
            }
            return ResultDTO.error("删除商机周报失败");
        }
        return ResultDTO.error("缺失参数");
    }
}
