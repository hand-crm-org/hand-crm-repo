package com.hand.address.service;

import com.hand.address.access.dao.AddressDao;
import com.hand.address.access.vo.AddressVO;
import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    AddressDao addressDao;

    @Override
    public List<AddressVO> getAddrList(PageQuery<AddressVO> pageQuery) {
        int count = addressDao.queryAddrCount(pageQuery);
        pageQuery.setCount(count);
        if (count>0){
            return addressDao.queryAddrList(pageQuery);
        }
        return null;
    }

    @Override
    public boolean addAddr(AddressVO addressVO) {
        if (!StringUtil.isEmpty(addressVO.getCode())&&!StringUtil.isEmpty(addressVO.getUpdatedBy())&&
            !StringUtil.isEmpty(addressVO.getObjCode())&&!StringUtil.isEmpty(addressVO.getServiceCode())&&
            !StringUtil.isEmpty(addressVO.getCountry())&&!StringUtil.isEmpty(addressVO.getAddr1())){
            int count = addressDao.insertAddr(addressVO);
            return count>0;
        } else{
            throw new RuntimeException("miss param!");
        }
    }

    @Override
    public boolean modifyAddr(AddressVO addressVO) {
        if (!StringUtil.isEmpty(addressVO.getCode())&&!StringUtil.isEmpty(addressVO.getUpdatedBy())){
            int count = addressDao.updateAddr(addressVO);
            return count>0;
        }else{
            throw new RuntimeException("miss param");
        }
    }
}
