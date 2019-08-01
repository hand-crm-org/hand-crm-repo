package com.hand.position.access.dao;

import com.hand.frame.util.PageQuery;
import com.hand.position.access.vo.PositionVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionDao {
    /**
     * 新建职位
     * @UpdateBy lln
     * @param positionVO
     * @Return int
     */
    int insertPosition(PositionVO positionVO);
    /**
     * 根据条件查询职位
     * @UpdateBy lln
     * @param pageQuery
     * @Return List<PositionVO>
     */
    List<PositionVO> queryPosition(PageQuery<PositionVO> pageQuery);
    /**
     * 根据条件查询职位得到的数量
     * @UpdateBy lln
     * @param pageQuery
     * @Return List<PositionVO>
     */
    int queryPositionCount(PageQuery<PositionVO> pageQuery);
    /**
     * 修改职位
     * @UpdateBy lln
     * @param positionVO
     * @Return int
     */
    int updatePosition(PositionVO positionVO);
    /**
     * 删除职位
     * @UpdateBy lln
     * @param code
     * @Return int
     */
    int deletePosition(String code);
}
