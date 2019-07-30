package com.hand.listofvalue.service;

import com.hand.frame.util.PageQuery;
import com.hand.listofvalue.access.vo.ListOfValueVO;

import java.util.List;
import java.util.Map;


public interface ListOfValueService {

    /**
     * 根据查询条件查询值列表
     * @UpdateBy yne
     * @param pageQuery
     * @Return List<ListOfValueVO>
     */
    List<ListOfValueVO> getLstOfVaL(PageQuery<ListOfValueVO> pageQuery);
    /**
     * 唯一性验证（独立语言代码+语言+Type 和 显示值+语言+type唯一）
     * @UpdateBy lln
     * @param listOfValueVO
     * @Return boolean
     */
    public Map<String,Object> toUniqueVerify(ListOfValueVO listOfValueVO, String str);
    /**
     * 新建值列表
     * @UpdateBy lln
     * @param listOfValueVO
     * @Return code
     */
    public String insertLstOfVal(ListOfValueVO listOfValueVO);
    /**
     * 修改值列表
     * @UpdateBy lln
     * @param listOfValueVO
     * @Return code
     */
    public String updateLstOfVal(ListOfValueVO listOfValueVO);

    /**
     * 根据唯一code删除值列表
     * @UpdateBy yne
     * @param code
     * @Return List<ListOfValueVO>
     */
    boolean removeLstOfValByCode(String code);
}
