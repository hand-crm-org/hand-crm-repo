package com.hand.opportunity.access.vo;

import java.util.Date;

public class OpportunityVO {
    private String code;//商机编码
    private Date created;//创建日期
    private String createdBy;//创建人
    private Date updated;//更新日期
    private String updatedBy;//更新人
    private String name;//商机名称
    private String type;//商机类型
    private String status;//商机状态
    private String accntCode;//客户code
    private String optySource;//商机来源
    private Integer optyFsctAmount;//预计销售额度(万)
    private Date expectSignTime;//预计签单时间
    private String desc;//备注
    private String ownOrgCode;//归属部门
    private String lostReason;//失单原因
    private String finalUse;//最终用途

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

    public Integer getOptyFsctAmount() {
        return optyFsctAmount;
    }

    public void setOptyFsctAmount(Integer optyFsctAmount) {
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

    @Override
    public String toString() {
        return "OpportunityVO{" +
                "code='" + code + '\'' +
                ", created=" + created +
                ", createdBy='" + createdBy + '\'' +
                ", updated=" + updated +
                ", updatedBy='" + updatedBy + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", accntCode='" + accntCode + '\'' +
                ", optySource='" + optySource + '\'' +
                ", optyFsctAmount=" + optyFsctAmount +
                ", expectSignTime=" + expectSignTime +
                ", desc='" + desc + '\'' +
                ", ownOrgCode='" + ownOrgCode + '\'' +
                ", lostReason='" + lostReason + '\'' +
                ", finalUse='" + finalUse + '\'' +
                '}';
    }
}
