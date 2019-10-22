package com.hand.opportunityteam.access.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OpportunityTeamVO {
    private String code;//商机团队编码
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date created;//创建日期
    private String createdBy;//创建人code
    private String createdName;//创建人
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date updated;//更新日期
    private String updatedBy;//更新人code
    private String updatedName;//更新人
    private String optyCode;//商机Code
    private String optyName;//商机名称
    private String empCode;//人员Code
    private String empName;//人员姓名
    private String empWorkPhone;//人员办公电话
    private String empPersonalPhone;//人员个人电话
    private String primaryFlag;//主要标识
    private String type;//类型
    private String typeCode;//类型code
    private String langId;

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

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpWorkPhone() {
        return empWorkPhone;
    }

    public void setEmpWorkPhone(String empWorkPhone) {
        this.empWorkPhone = empWorkPhone;
    }

    public String getEmpPersonalPhone() {
        return empPersonalPhone;
    }

    public void setEmpPersonalPhone(String empPersonalPhone) {
        this.empPersonalPhone = empPersonalPhone;
    }

    public String getPrimaryFlag() {
        return primaryFlag;
    }

    public void setPrimaryFlag(String primaryFlag) {
        this.primaryFlag = primaryFlag;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getOptyName() {
        return optyName;
    }

    public void setOptyName(String optyName) {
        this.optyName = optyName;
    }

    public String getLangId() {
        return langId;
    }

    public void setLangId(String langId) {
        this.langId = langId;
    }

    @Override
    public String toString() {
        return "OpportunityTeamVO{" +
                "code='" + code + '\'' +
                ", created=" + created +
                ", createdBy='" + createdBy + '\'' +
                ", createdName='" + createdName + '\'' +
                ", updated=" + updated +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedName='" + updatedName + '\'' +
                ", optyCode='" + optyCode + '\'' +
                ", optyName='" + optyName + '\'' +
                ", empCode='" + empCode + '\'' +
                ", empName='" + empName + '\'' +
                ", empWorkPhone='" + empWorkPhone + '\'' +
                ", empPersonalPhone='" + empPersonalPhone + '\'' +
                ", primaryFlag='" + primaryFlag + '\'' +
                ", type='" + type + '\'' +
                ", typeCode='" + typeCode + '\'' +
                ", langId='" + langId + '\'' +
                '}';
    }
}
