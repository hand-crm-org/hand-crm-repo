package com.hand.listofvalue.service;

import com.hand.frame.util.PageQuery;
import com.hand.frame.util.StringUtil;
import com.hand.listofvalue.access.dao.ListOfValueDao;
import com.hand.listofvalue.access.vo.ListOfValueVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ListOfValueServiceImpl implements ListOfValueService{
    @Autowired
    ListOfValueDao listOfValueDao;

    @Override
    public List<ListOfValueVO> getLstOfVaL(PageQuery<ListOfValueVO> pageQuery) {
        int count = listOfValueDao.queryLstOfVaLCount(pageQuery);
        pageQuery.setCount(count);
        if(count > 0) {
            return listOfValueDao.queryLstOfVaL(pageQuery);
        }
        return null;
    }

    /**
     * 唯一性验证（独立语言代码+语言+Type+父code 和 显示值+语言+type+父code唯一）
     * @UpdateBy lln
     * @param listOfValueVO
     * @Return boolean
     */
    @Override
    public Map<String,Object> toUniqueVerify(ListOfValueVO listOfValueVO, String str) {
        String msg = "";
        boolean status = true;
        Map<String,Object> map = new HashMap<>();
        if(!StringUtil.isEmpty(listOfValueVO.getName())&&!StringUtil.isEmpty(listOfValueVO.getLangId())
                &&!StringUtil.isEmpty(listOfValueVO.getType())&&!StringUtil.isEmpty(listOfValueVO.getValue())){
            int count = listOfValueDao.toUniqueVerify(listOfValueVO,str);
            if(count>0){
                //验证失败，不唯一
                msg = "唯一性验证失败";
                status = false;
            }
            else {
                //验证成功，唯一
                msg = "success";
                status = true;
            }
        }
        else {
            msg = "参数缺失";
            status = false;
        }
        map.put("msg",msg);
        map.put("status",status);
        return map;
    }
    /**
     * 新建值列表
     * @UpdateBy lln
     * @param listOfValueVO
     * @Return code
     */
    @Override
    public String insertLstOfVal(ListOfValueVO listOfValueVO) {
        if(!StringUtil.isEmpty(listOfValueVO.getCode())&&!StringUtil.isEmpty(listOfValueVO.getType())
                &&!StringUtil.isEmpty(listOfValueVO.getLangId())&&!StringUtil.isEmpty(listOfValueVO.getName())
                &&!StringUtil.isEmpty(listOfValueVO.getValue())&&listOfValueVO.getLevel()!=null)
        {
            int count = listOfValueDao.insertLstOfVal(listOfValueVO);
            if(count>0){
                return "success";
            }
            else{
                return "failed";
            }
        }
        else {
            return "miss param";
        }

    }
    /**
     * 修改值列表
     * @UpdateBy lln
     * @param listOfValueVO
     * @Return string
     */
    @Override
    public String updateLstOfVal(ListOfValueVO listOfValueVO) {
        if(!StringUtil.isEmpty(listOfValueVO.getCode()))
        {
            int count = listOfValueDao.updateLstOfVal(listOfValueVO);
            if(count>0){
                return "success";
            }
            else{
                return "failed";
            }
        }
        else {
            return "miss param";
        }

    }

    @Override
    public boolean removeLstOfValByCode(String code) {
        if(!StringUtil.isEmpty(code)){
            int rows = listOfValueDao.deleteLstOfValByCode(code);
            if (rows>=1) {
                return true;
            }
        }
        return false;
    }
}
