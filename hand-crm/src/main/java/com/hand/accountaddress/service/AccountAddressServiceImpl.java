package com.hand.accountaddress.service;

import com.alibaba.fastjson.JSONObject;
import com.hand.accountaddress.access.dao.AccountAddressDao;
import com.hand.accountaddress.access.vo.AccountAddressVO;
import com.hand.address.access.vo.AddressVO;
import com.hand.frame.model.ResultDTO;
import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountAddressServiceImpl implements AccountAddressServcice{
    @Autowired
    AccountAddressDao accountAddressDao;

    /**
     * 新建客户-地址
     * @UpdateBy lln
     * @param accountAddressVO
     * @Return String
     */
    @Override
    public ResultDTO addAccountAddr(AccountAddressVO accountAddressVO) {
        if (!StringUtil.isEmpty(accountAddressVO.getAddrCode())
                && !StringUtil.isEmpty(accountAddressVO.getPriFlg()) && !StringUtil.isEmpty(accountAddressVO.getStatus()))
        {
            String code = StringUtil.getCode();
            accountAddressVO.setCode(code);
            int count = accountAddressDao.insertAccountAddr(accountAddressVO);
            if (count > 0) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code",code);
                return ResultDTO.success(jsonObject);
            }
            return ResultDTO.error("新建客户地址失败");
        }
        return ResultDTO.error("缺失参数");
    }

    /**
     * 根据条件查询客户-地址
     * @UpdateBy lln
     * @param pageQuery
     * @Return List<AccountAddressVO>
     */
    @Override
    public List<AddressVO> getAccountAddr(PageQuery<AddressVO> pageQuery) {
        int count = accountAddressDao.queryAccountAddrCount(pageQuery);
        pageQuery.setCount(count);
        if(count > 0) {
            return accountAddressDao.queryAccountAddr(pageQuery);
        }
        return null;
    }

    /**
     * 修改客户-地址
     * @UpdateBy lln
     * @param accountAddressVO
     * @Return String
     */
    @Override
    public ResultDTO modifyAccountAddr(AccountAddressVO accountAddressVO) {
        if(!StringUtil.isEmpty(accountAddressVO.getCode())&&!StringUtil.isEmpty(accountAddressVO.getUpdatedBy())) {
            int count = accountAddressDao.updateAccountAddr(accountAddressVO);
            if (count > 0) {
                return ResultDTO.success();
            }
            return ResultDTO.error("修改客户地址失败");
        }
        return ResultDTO.error("缺失参数");
    }
}
