package com.hand.order.access.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OrderVO {

    private String code;//订单头编码
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date created;//创建日期
    private String createdBy;//创建人
    private String createdName;//创建人
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date updated;//更新日期
    private String updatedBy;//更新人
    private String orderNumber;//订单编号
    private String accountCode;//客户编码
    private String accountName;//客户
    private String accountAddrCode;//客户地址编码
    private String refOptyCode;//关联商机编码
    private String refOptyName;//关联商机名称
    private String ownerDeptCode;//业绩归属部门编码
    private String ownerDeptName;//业绩归属部门
    private String orderType;//合同类型
    private String orderTypeCode;//合同类型
    private String orderEntity;//经营单位（签约主体）
    private String orderProperty;//合同属性
    private String country;//国家
    private String countryCode;//国家
    private Double rate;// 税率
    private String amountRatedFlag;//合同金额是否含税
    private Double totalAmount;//签单金额
    private Double ratedAmount;//含税金额
    private Double unratedAmount;//不含税金额
    private String currency;//币种
    private String currencyCode;//币种
    private String industy;//行业
    private String industyCode;
    private String subIndusty;//子行业
    private String subIndustyCode;//子行业
    private String salesMethod;//销售模式
    private String salesMethodCode;//销售模式
    private String orderCondition;//合同生效条件
    private String shipCondition;//发货条件
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date orderSignTime;//合同签订时间
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date orderEffectTime;//合同生效时间
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date orderApproveTime;//审批通过时间
    private String orderStatus;//订单状态
    private String orderStatusCode;//订单状态
    private String state;
    private String city;
    private String county;
    private String street;
    private String addr1;
    private String langId;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getIndustyCode() {
        return industyCode;
    }

    public void setIndustyCode(String industyCode) {
        this.industyCode = industyCode;
    }

    public String getSubIndustyCode() {
        return subIndustyCode;
    }

    public void setSubIndustyCode(String subIndustyCode) {
        this.subIndustyCode = subIndustyCode;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLangId() {
        return langId;
    }

    public void setLangId(String langId) {
        this.langId = langId;
    }

    public String getRefOptyName() {
        return refOptyName;
    }

    public void setRefOptyName(String refOptyName) {
        this.refOptyName = refOptyName;
    }

    public String getOwnerDeptName() {
        return ownerDeptName;
    }

    public void setOwnerDeptName(String ownerDeptName) {
        this.ownerDeptName = ownerDeptName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
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

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountAddrCode() {
        return accountAddrCode;
    }

    public void setAccountAddrCode(String accountAddrCode) {
        this.accountAddrCode = accountAddrCode;
    }

    public String getRefOptyCode() {
        return refOptyCode;
    }

    public void setRefOptyCode(String refOptyCode) {
        this.refOptyCode = refOptyCode;
    }

    public String getOwnerDeptCode() {
        return ownerDeptCode;
    }

    public void setOwnerDeptCode(String ownerDeptCode) {
        this.ownerDeptCode = ownerDeptCode;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderTypeCode() {
        return orderTypeCode;
    }

    public void setOrderTypeCode(String orderTypeCode) {
        this.orderTypeCode = orderTypeCode;
    }

    public String getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(String orderEntity) {
        this.orderEntity = orderEntity;
    }

    public String getOrderProperty() {
        return orderProperty;
    }

    public void setOrderProperty(String orderProperty) {
        this.orderProperty = orderProperty;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getAmountRatedFlag() {
        return amountRatedFlag;
    }

    public void setAmountRatedFlag(String amountRatedFlag) {
        this.amountRatedFlag = amountRatedFlag;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getRatedAmount() {
        return ratedAmount;
    }

    public void setRatedAmount(Double ratedAmount) {
        this.ratedAmount = ratedAmount;
    }

    public Double getUnratedAmount() {
        return unratedAmount;
    }

    public void setUnratedAmount(Double unratedAmount) {
        this.unratedAmount = unratedAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getIndusty() {
        return industy;
    }

    public void setIndusty(String industy) {
        this.industy = industy;
    }

    public String getSubIndusty() {
        return subIndusty;
    }

    public void setSubIndusty(String subIndusty) {
        this.subIndusty = subIndusty;
    }

    public String getSalesMethod() {
        return salesMethod;
    }

    public void setSalesMethod(String salesMethod) {
        this.salesMethod = salesMethod;
    }

    public String getSalesMethodCode() {
        return salesMethodCode;
    }

    public void setSalesMethodCode(String salesMethodCode) {
        this.salesMethodCode = salesMethodCode;
    }

    public String getOrderCondition() {
        return orderCondition;
    }

    public void setOrderCondition(String orderCondition) {
        this.orderCondition = orderCondition;
    }

    public String getShipCondition() {
        return shipCondition;
    }

    public void setShipCondition(String shipCondition) {
        this.shipCondition = shipCondition;
    }

    public Date getOrderSignTime() {
        return orderSignTime;
    }

    public void setOrderSignTime(Date orderSignTime) {
        this.orderSignTime = orderSignTime;
    }

    public Date getOrderEffectTime() {
        return orderEffectTime;
    }

    public void setOrderEffectTime(Date orderEffectTime) {
        this.orderEffectTime = orderEffectTime;
    }

    public Date getOrderApproveTime() {
        return orderApproveTime;
    }

    public void setOrderApproveTime(Date orderApproveTime) {
        this.orderApproveTime = orderApproveTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusCode() {
        return orderStatusCode;
    }

    public void setOrderStatusCode(String orderStatusCode) {
        this.orderStatusCode = orderStatusCode;
    }
}
