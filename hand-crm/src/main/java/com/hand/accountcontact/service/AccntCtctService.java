package com.hand.accountcontact.service;

import com.hand.accountcontact.access.vo.AccntCtctVO;
import com.hand.frame.util.PageQuery;

import java.util.List;

public interface AccntCtctService {
    /**
     * 获取客户联系人列表
     * @param pageQuery
     * @return
     */
    List<AccntCtctVO> getAccntCtctList(PageQuery<AccntCtctVO> pageQuery);

    /**
     * 增加客户联系人
     * @param accntCtctVO
     * @return
     */
    boolean addAccntCtct(AccntCtctVO accntCtctVO);

    /**
     * 更新客户联系人
     * @param accntCtctVO
     * @return
     */
    boolean modifyAccntCtct(AccntCtctVO accntCtctVO);
}
