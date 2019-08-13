package com.hand.accountcontact.service;

import com.hand.accountcontact.access.dao.AccntCtctDao;
import com.hand.accountcontact.access.vo.AccntCtctVO;
import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccntCtctServiceImpl implements AccntCtctService{
    @Autowired
    AccntCtctDao accntCtctDao;
    @Override
    public List<AccntCtctVO> getAccntCtctList(PageQuery<AccntCtctVO> pageQuery) {
        int count = accntCtctDao.queryAccntCtctCount(pageQuery);
        if (count>0){
            pageQuery.setCount(count);
            return accntCtctDao.queryAccntCtctList(pageQuery);
        }
        return null;
    }

    @Override
    public boolean addAccntCtct(AccntCtctVO accntCtctVO) {
        if (!StringUtil.isEmpty(accntCtctVO.getCode())&&!StringUtil.isEmpty(accntCtctVO.getUpdatedBy())&&
            !StringUtil.isEmpty(accntCtctVO.getAccntCode())&&!StringUtil.isEmpty(accntCtctVO.getCtctCode())){
            int count = accntCtctDao.insertAccntCtct(accntCtctVO);
            return count>0;
        }
        else{
            throw new RuntimeException("miss param");
        }
    }

    @Override
    public boolean modifyAccntCtct(AccntCtctVO accntCtctVO) {
        if (!StringUtil.isEmpty(accntCtctVO.getCtctCode())&&!StringUtil.isEmpty(accntCtctVO.getCtctCode())&&
            !StringUtil.isEmpty(accntCtctVO.getUpdatedBy())){
            int count = accntCtctDao.updateAccntCtct(accntCtctVO);
            return count>0;
        }else {
            throw new RuntimeException("miss param");
        }
    }
}
