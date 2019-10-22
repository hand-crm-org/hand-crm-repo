package com.hand.opportunity.access.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OpportunityVO {
    private String code;//商机编码
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date created;//创建日期
    private String createdBy;//创建人code
    private String createdName;//创建人
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date updated;//更新日期
    private String updatedBy;//更新人code
    private String updatedName;//更新人
    private String name;//商机名称
    private String type;//商机类型
    private String status;//商机状态
    private String statusCode;//商机状态code
    private String accntCode;//客户code
    private String accntName;//客户名称
    private String optySource;//商机来源
    private Double optyFsctAmount;//预计销售额度(万)
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date expectSignTime;//预计签单时间
    private String desc;//备注
    private String ownOrgCode;//归属部门code
    private String orgName;//归属部门
    private String lostReason;//失单原因
    private String finalUse;//最终用途
    private String langId;
    private String winRate;//商机赢单率
    private String prSalesCode;//商机负责人Code
    private String prSales;//商机负责人
    private String optyStageCode;//商机阶段code
    private String optyStage;//商机阶段

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccntCode() {
        return accntCode;
    }

    public void setAccntCode(String accntCode) {
        this.accntCode = accntCode;
    }

    public String getOptySource() {
        return optySource;
    }

    public void setOptySource(String optySource) {
        this.optySource = optySource;
    }

    public Double getOptyFsctAmount() {
        return optyFsctAmount;
    }

    public void setOptyFsctAmount(Double optyFsctAmount) {
        this.optyFsctAmount = optyFsctAmount;
    }

    public Date getExpectSignTime() {
        return expectSignTime;
    }

    public void setExpectSignTime(Date expectSignTime) {
        this.expectSignTime = expectSignTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getOwnOrgCode() {
        return ownOrgCode;
    }

    public void setOwnOrgCode(String ownOrgCode) {
        this.ownOrgCode = ownOrgCode;
    }

    public String getLostReason() {
        return lostReason;
    }

    public void setLostReason(String lostReason) {
        this.lostReason = lostReason;
    }

    public String getFinalUse() {
        return finalUse;
    }

    public void setFinalUse(String finalUse) {
        this.finalUse = finalUse;
    }

    public String getCreatedName() {
        return createdName;
    }

    public void setCreatedName(String createdName) {
        this.createdName = createdName;
    }

    public String getUpdatedName() {
        return updatedName;
    }

    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName;
    }

    public String getAccntName() {
        return accntName;
    }

    public void setAccntName(String accntName) {
        this.accntName = accntName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getLangId() {
        return langId;
    }

    public void setLangId(String langId) {
        this.langId = langId;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getWinRate() {
        return winRate;
    }

    public void setWinRate(String winRate) {
        this.winRate = winRate;
    }

    public String getPrSalesCode() {
        return prSalesCode;
    }

    public void setPrSalesCode(String prSalesCode) {
        this.prSalesCode = prSalesCode;
    }

    public String getOptyStage() {
        return optyStage;
    }

    public void setOptyStage(String optyStage) {
        this.optyStage = optyStage;
    }

    public String getPrSales() {
        return prSales;
    }

    public void setPrSales(String prSales) {
        this.prSales = prSales;
    }

    public String getOptyStageCode() {
        return optyStageCode;
    }

    public void setOptyStageCode(String optyStageCode) {
        this.optyStageCode = optyStageCode;
    }

    @Override
    public String toString() {
        return "OpportunityVO{" +
                "code='" + code + '\'' +
                ", created=" + created +
                ", createdBy='" + createdBy + '\'' +
                ", createdName='" + createdName + '\'' +
                ", updated=" + updated +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedName='" + updatedName + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", accntCode='" + accntCode + '\'' +
                ", accntName='" + accntName + '\'' +
                ", optySource='" + optySource + '\'' +
                ", optyFsctAmount=" + optyFsctAmount +
                ", expectSignTime=" + expectSignTime +
                ", desc='" + desc + '\'' +
                ", ownOrgCode='" + ownOrgCode + '\'' +
                ", orgName='" + orgName + '\'' +
                ", lostReason='" + lostReason + '\'' +
                ", finalUse='" + finalUse + '\'' +
                ", langId='" + langId + '\'' +
                ", winRate='" + winRate + '\'' +
                ", prSalesCode='" + prSalesCode + '\'' +
                ", prSales='" + prSales + '\'' +
                ", optyStageCode='" + optyStageCode + '\'' +
                ", optyStage='" + optyStage + '\'' +
                '}';
    }
}
