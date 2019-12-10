package com.hand.ordershipment.access.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OrderShipmentVO {

    private String code;//订单发到货编码
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date created;//创建日期
    private String createdBy;//创建人
    private String createdName;//创建人
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date updated;//更新日期
    private String updatedBy;//更新人
    private String orderCode;//订单头编码
    private String shipNumber;//发货序号
    private String shipCondition;//发货条件
    @JsonFormat( pattern="yyyy-MM-dd", timezone="GMT+8")
    private Date shipDate;//发货日期
    private String receiveCondition;//到货条件
    @JsonFormat( pattern="yyyy-MM-dd", timezone="GMT+8")
    private Date receiveDate;//到货日期
    private Integer limitedDays;//期限天数
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

    public String getShipNumber() {
        return shipNumber;
    }

    public void setShipNumber(String shipNumber) {
        this.shipNumber = shipNumber;
    }

    public String getShipCondition() {
        return shipCondition;
    }

    public void setShipCondition(String shipCondition) {
        this.shipCondition = shipCondition;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public String getReceiveCondition() {
        return receiveCondition;
    }

    public void setReceiveCondition(String receiveCondition) {
        this.receiveCondition = receiveCondition;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Integer getLimitedDays() {
        return limitedDays;
    }

    public void setLimitedDays(Integer limitedDays) {
        this.limitedDays = limitedDays;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
