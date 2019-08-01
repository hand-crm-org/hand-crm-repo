package com.hand.position.service;

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
    public String addPosition(PositionVO positionVO) {
        if(!StringUtil.isEmpty(positionVO.getCode())&&!StringUtil.isEmpty(positionVO.getType())
                &&!StringUtil.isEmpty(positionVO.getName())&&!StringUtil.isEmpty(positionVO.getOrgCode())
                &&!StringUtil.isEmpty(positionVO.getUpdatedBy())&&!StringUtil.isEmpty(positionVO.getStatus())) {
            int count = positionDao.insertPosition(positionVO);
            if (count > 0) {
                return "success";
            }
            return "failed";
        }
        return "miss param";
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
    public String modifyPosition(PositionVO positionVO) {
        if(!StringUtil.isEmpty(positionVO.getCode())&&!StringUtil.isEmpty(positionVO.getUpdatedBy())) {
            int count = positionDao.updatePosition(positionVO);
            if (count > 0) {
                return "success";
            }
            return "failed";
        }
        return "miss param";
    }

    /**
     * 删除职位
     * @UpdateBy lln
     * @param code
     * @Return int
     */
    @Override
    public String removePosition(String code) {
        if(!StringUtil.isEmpty(code)) {
            int count = positionDao.deletePosition(code);
            if (count > 0) {
                return "success";
            }
            return "failed";
        }
        return "miss param";
    }
}
