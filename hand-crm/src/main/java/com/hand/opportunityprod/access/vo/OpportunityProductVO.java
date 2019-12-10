package com.hand.opportunityprod.access.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OpportunityProductVO {
    private String code;//商机产品编码
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date created;//创建日期
    private String createdBy;//创建人code
    private String createdName;//创建人
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date updated;//更新日期
    private String updatedBy;//更新人code
    private String updatedName;//更新人
    private String optyCode;//商机Code
    private Double amount;//预计销售额度（万）
    @JsonFormat( pattern="yyyy-MM-dd", timezone="GMT+8")
    private Date expectSignTime;//预计签单时间
    private String productCode;//产品Code
    private String productName;//产品名称
    private String productNum;//产品编码
    private String productCtlg;//产品大类
    private String productCtgy;//产品小类
    private String productCtlgCode;//产品大类
    private String productCtgyCode;//产品小类
    private String primaryFlag;//主要标识
    private String langId;

    public String getProductCtlgCode() {
        return productCtlgCode;
    }

    public void setProductCtlgCode(String productCtlgCode) {
        this.productCtlgCode = productCtlgCode;
    }

    public String getProductCtgyCode() {
        return productCtgyCode;
    }

    public void setProductCtgyCode(String productCtgyCode) {
        this.productCtgyCode = productCtgyCode;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductCtlg() {
        return productCtlg;
    }

    public void setProductCtlg(String productCtlg) {
        this.productCtlg = productCtlg;
    }

    public String getProductCtgy() {
        return productCtgy;
    }

    public void setProductCtgy(String productCtgy) {
        this.productCtgy = productCtgy;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedName() {
        return createdName;
    }

    public void setCreatedName(String createdName) {
        this.createdName = createdName;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedName() {
        return updatedName;
    }

    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName;
    }

    public String getOptyCode() {
        return optyCode;
    }

    public void setOptyCode(String optyCode) {
        this.optyCode = optyCode;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getExpectSignTime() {
        return expectSignTime;
    }

    public void setExpectSignTime(Date expectSignTime) {
        this.expectSignTime = expectSignTime;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrimaryFlag() {
        return primaryFlag;
    }

    public void setPrimaryFlag(String primaryFlag) {
        this.primaryFlag = primaryFlag;
    }

    public String getLangId() {
        return langId;
    }

    public void setLangId(String langId) {
        this.langId = langId;
    }

}
