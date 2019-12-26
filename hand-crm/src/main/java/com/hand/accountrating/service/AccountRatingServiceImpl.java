package com.hand.accountrating.service;

import com.alibaba.fastjson.JSONObject;
import com.hand.accountrating.access.dao.AccountRatingDao;
import com.hand.accountrating.access.vo.AccountRatingVO;
import com.hand.frame.model.ResultDTO;
import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountRatingServiceImpl implements AccountRatingService {

    @Autowired
    private AccountRatingDao accountRatingDao;

    @Override
    public List<AccountRatingVO> getAccountRatingList(PageQuery<AccountRatingVO> pageQuery) {
        int count = accountRatingDao.queryAccountRatingCount(pageQuery);
        if (count>0){
            pageQuery.setCount(count);
            return accountRatingDao.queryAccountRatingList(pageQuery);
        }
        return null;
    }

    @Override
    public ResultDTO addAccountRating(AccountRatingVO accountRatingVO) {
        if (!StringUtil.isEmpty(accountRatingVO.getAccountCode()) && !StringUtil.isEmpty(accountRatingVO.getRatingLevel())
                && (accountRatingVO.getStartDate()!=null) && !StringUtil.isEmpty(accountRatingVO.getStatusCode())
                && (accountRatingVO.getCreditAll()!=0) && (accountRatingVO.getCreditUsed()!=0))
        {
            String code = StringUtil.getCode();
                accountRatingVO.setCode(code);
                int count = accountRatingDao.insertAccountRating(accountRatingVO);
                if (count > 0) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("code", code);
                    return ResultDTO.success(jsonObject);
                }
            return ResultDTO.error("新建客户评级失败");
        }
        return ResultDTO.error("缺失参数");
    }

    @Override
    public ResultDTO modifyAccountRating(AccountRatingVO accountRatingVO) {
        if (!StringUtil.isEmpty(accountRatingVO.getCode())&&!StringUtil.isEmpty(accountRatingVO.getUpdatedBy())){
            int count = accountRatingDao.updateAccountRating(accountRatingVO);
            if (count > 0) {
                return ResultDTO.success();
            }
            return ResultDTO.error("修改客户评级失败");
        }
        return ResultDTO.error("缺失参数");
    }

    @Override
    public AccountRatingVO queryAccountRatingVersion(AccountRatingVO accountRatingVO) {
        AccountRatingVO ratingVO = new AccountRatingVO();
        try{
            ratingVO = accountRatingDao.queryAccountRatingVersion(accountRatingVO);
            if(ratingVO!=null) {
                ratingVO.setVersion(accountRatingDao.queryAccountRatingVersion(accountRatingVO).getVersion()+1);
            } else {
                ratingVO = new AccountRatingVO();
                ratingVO.setVersion(1);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return ratingVO;
    }
}
