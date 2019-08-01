package com.hand.position.service;

import com.hand.frame.util.PageQuery;
import com.hand.position.access.vo.PositionVO;

import java.util.List;

public interface PositionService {
    /**
     * 新建职位
     * @UpdateBy lln
     * @param positionVO
     * @Return int
     */
    String addPosition(PositionVO positionVO);


    /**
     * 根据条件查询职位
     * @UpdateBy lln
     * @param pageQuery
     * @Return List<PositionVO>
     */
    List<PositionVO> getPosition(PageQuery<PositionVO> pageQuery);


    /**
     * 修改职位
     * @UpdateBy lln
     * @param positionVO
     * @Return int
     */
    String modifyPosition(PositionVO positionVO);


    /**
     * 删除职位
     * @UpdateBy lln
     * @param code
     * @Return int
     */
    String removePosition(String code);
}
