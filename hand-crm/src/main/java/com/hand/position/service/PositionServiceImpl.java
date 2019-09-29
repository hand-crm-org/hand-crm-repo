package com.hand.position.service;

import com.alibaba.fastjson.JSONObject;
import com.hand.frame.model.ResultDTO;
import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import com.hand.position.access.dao.PositionDao;
import com.hand.position.access.vo.PositionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService{
    @Autowired
    PositionDao positionDao;

    /**
     * 新建职位
     * @UpdateBy lln
     * @param positionVO
     * @Return int
     */
    @Override
    public ResultDTO addPosition(PositionVO positionVO) {
        if(!StringUtil.isEmpty(positionVO.getType())
                &&!StringUtil.isEmpty(positionVO.getName())&&!StringUtil.isEmpty(positionVO.getOrgCode())
                &&!StringUtil.isEmpty(positionVO.getUpdatedBy())&&!StringUtil.isEmpty(positionVO.getStatus())) {
            String code = StringUtil.getCode();
            positionVO.setCode(code);
            int count = positionDao.insertPosition(positionVO);
            if (count > 0) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code",code);
                return ResultDTO.success(jsonObject);
            }
            return ResultDTO.error("新建职位失败");
        }
        return ResultDTO.error("缺失参数");
    }

    /**
     * 根据条件查询职位
     * @UpdateBy lln
     * @param pageQuery
     * @Return List<PositionVO>
     */
    @Override
    public List<PositionVO> getPosition(PageQuery<PositionVO> pageQuery) {
        int count = positionDao.queryPositionCount(pageQuery);
        pageQuery.setCount(count);
        if(count > 0) {
            return positionDao.queryPosition(pageQuery);
        }
        return null;
    }

    /**
     * 修改职位
     * @UpdateBy lln
     * @param positionVO
     * @Return int
     */
    @Override
    public ResultDTO modifyPosition(PositionVO positionVO) {
        if(!StringUtil.isEmpty(positionVO.getCode())&&!StringUtil.isEmpty(positionVO.getUpdatedBy())) {
            int count = positionDao.updatePosition(positionVO);
            if (count > 0) {
                return ResultDTO.success();
            }
            return ResultDTO.error("修改职位失败");
        }
        return ResultDTO.error("缺失参数");
    }

    /**
     * 删除职位
     * @UpdateBy lln
     * @param code
     * @Return int
     */
    @Override
    public ResultDTO removePosition(String code) {
        if(!StringUtil.isEmpty(code)) {
            int count = positionDao.deletePosition(code);
            if (count > 0) {
                return ResultDTO.success();
            }
            return ResultDTO.error("删除职位失败");
        }
        return ResultDTO.error("缺失参数");
    }
}
