package com.hand.businessopportunity.service;

import com.hand.businessopportunity.access.dao.BusinessOpportunityDao;
import com.hand.businessopportunity.access.vo.BusinessOpportunityVO;
import com.hand.frame.model.ResultDTO;
import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessOpportunityServiceImpl implements BusinessOpportunityService {

    @Autowired
    BusinessOpportunityDao businessOptyDao;
    /**
     * 新建商机竞品
     * @UpdateBy fuzw
     * @param businessOptyVO
     * @Return int
     */
    @Override
    public ResultDTO addBusinessOpty(BusinessOpportunityVO businessOptyVO){
        if(!StringUtil.isEmpty(businessOptyVO.getCode())&&!StringUtil.isEmpty(businessOptyVO.getOptycode())
        &&!StringUtil.isEmpty(businessOptyVO.getBrand())&&!StringUtil.isEmpty(businessOptyVO.getGoodness())
        &&!StringUtil.isEmpty(businessOptyVO.getBadness())){
            int count = businessOptyDao.insertBusinessOpty(businessOptyVO);
            if(count > 0){
                return ResultDTO.success();
            }
            return ResultDTO.error("新建商机竞品失败");
        }
        return ResultDTO.error("缺失参数");
    }

    /**
     * 查询商机竞品
     * @UpdateBy fuzw
     * @param pageQuery
     * @Return  List<BusinessOpportunityVO>
     */
    @Override
    public List<BusinessOpportunityVO> getBusinessOpty(PageQuery<BusinessOpportunityVO> pageQuery) {
        int count = businessOptyDao.queryBusinessOptyCount(pageQuery);
        if(count > 0) {
            return businessOptyDao.queryBusinessOpty(pageQuery);
        }
        return null;
    }
    /**
     * 更新商机竞品信息
     * @UpdateBy fuzw
     * @param businessOptyVO
     * @Return int
     */
    @Override
    public ResultDTO modifyBusinessOpty(BusinessOpportunityVO businessOptyVO) {
        if(!StringUtil.isEmpty(businessOptyVO.getCode())&&!StringUtil.isEmpty(businessOptyVO.getUpdatedBy())){
            int count = businessOptyDao.updateBusinessOpty(businessOptyVO);
            if(count > 0){
                return ResultDTO.success();
            }
            return ResultDTO.error("更新失败");
        }
        return ResultDTO.error("缺失参数");
    }

    /**
     * 删除商机竞品
     * @UpdateBy fuzw
     * @param code
     * @Return int
     */
    @Override
    public ResultDTO removeBusinessOpty(String code) {
        if(!StringUtil.isEmpty(code)){
            int count = businessOptyDao.deleteBusinessOpty(code);
            if(count > 0){
                return ResultDTO.success();
            }
            return ResultDTO.error("删除失败");
        }
        return ResultDTO.error("缺失参数");
    }
}
