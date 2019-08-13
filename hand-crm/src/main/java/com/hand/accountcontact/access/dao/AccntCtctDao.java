package com.hand.accountcontact.access.dao;

import com.hand.accountcontact.access.vo.AccntCtctVO;
import com.hand.frame.util.PageQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccntCtctDao {
    /**
     * 查询客户联系人列表
     * @param pageQuery
     * @return
     */
    List<AccntCtctVO> queryAccntCtctList(PageQuery<AccntCtctVO> pageQuery);

    /**
     * 对所有客户联系人计数
     * @param pageQuery
     * @return
     */
    int queryAccntCtctCount(PageQuery<AccntCtctVO> pageQuery);

    /**
     * 新建客户联系人信息
     * @param accntCtctVO
     * @return
     */
    int insertAccntCtct(AccntCtctVO accntCtctVO);

    /**
     * 修改客户联系人信息
     * @param accntCtctVO
     * @return
     */
    int updateAccntCtct(AccntCtctVO accntCtctVO);
}
