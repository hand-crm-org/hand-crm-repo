package com.hand.listofvalue.service;

import com.alibaba.fastjson.JSONObject;
import com.hand.frame.model.ResultDTO;
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
        int count = listOfValueDao.queryListOfValCount(pageQuery);
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
                &&!StringUtil.isEmpty(listOfValueVO.getType())&&!StringUtil.isEmpty(listOfValueVO.getVal())){
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
    public ResultDTO insertLstOfVal(ListOfValueVO listOfValueVO) {
        if(!StringUtil.isEmpty(listOfValueVO.getType())
                &&!StringUtil.isEmpty(listOfValueVO.getLangId())&&!StringUtil.isEmpty(listOfValueVO.getName())
                &&!StringUtil.isEmpty(listOfValueVO.getVal())&&listOfValueVO.getLevel()!=null)
        {
            String code = StringUtil.getCode();
            listOfValueVO.setCode(code);
            int count = listOfValueDao.insertLstOfVal(listOfValueVO);
            if(count>0){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code",code);
                return ResultDTO.success(jsonObject);
            }
            else{
                return ResultDTO.error("新建值列表失败");
            }
        }
        else {
            return ResultDTO.error("缺失参数");
        }

    }
    /**
     * 修改值列表
     * @UpdateBy lln
     * @param listOfValueVO
     * @Return string
     */
    @Override
    public ResultDTO updateLstOfVal(ListOfValueVO listOfValueVO) {
        if(!StringUtil.isEmpty(listOfValueVO.getCode()))
        {
            int count = listOfValueDao.updateLstOfVal(listOfValueVO);
            if(count>0){
                return ResultDTO.success();
            }
            else{
                return ResultDTO.error("修改值列表失败");
            }
        }
        else {
            return ResultDTO.error("缺失参数");
        }

    }

    @Override
    public ResultDTO removeLstOfValByCode(String code) {
        if(!StringUtil.isEmpty(code)){
            int rows = listOfValueDao.deleteLstOfValByCode(code);
            if (rows>=1) {
                return ResultDTO.success();
            }
        }
        return ResultDTO.error("删除值列表失败");
    }
}
