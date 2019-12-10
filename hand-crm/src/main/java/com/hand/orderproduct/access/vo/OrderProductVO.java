package com.hand.orderproduct.access.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OrderProductVO {

    private String code;//订单行编码
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date created;//创建日期
    private String createdBy;//创建人
    private String createdName;//创建人
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date updated;//更新日期
    private String updatedBy;//更新人
    private String orderCode;//订单头编码
    private String productNum;//产品编码
    private String productCtlg;//产品大类
    private String productCtgy;//产品小类
    private String productUnit;//单位
    private String productPrice;//单价
    private String productQuantity;//数量
    private String description;//备注
    private String langId;

    public String getLangId() {
        return langId;
    }

    public void setLangId(String langId) {
        this.langId = langId;
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

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
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

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
