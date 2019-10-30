package com.hand.opportunityweekly.access.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OpportunityWeeklyVO {
    private String code;//商机周报编码
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date created;//创建日期
    private String createdBy;//创建人code
    private String createdName;//创建人
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date updated;//更新日期
    private String updatedBy;//更新人code
    private String updatedName;//更新人
    private String optyCode;//商机Code
    private String name;//周报序列
    private String weeklySummary;//进展计划
    private String weeklyRisk;//问题风险
    private String weeklyPushStatus;//推进状态
    private String weeklyPushStatusCode;//推进状态code
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date actived;//生效时间
    private String Status;//周报状态
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeeklySummary() {
        return weeklySummary;
    }

    public void setWeeklySummary(String weeklySummary) {
        this.weeklySummary = weeklySummary;
    }

    public String getWeeklyRisk() {
        return weeklyRisk;
    }

    public void setWeeklyRisk(String weeklyRisk) {
        this.weeklyRisk = weeklyRisk;
    }

    public String getWeeklyPushStatus() {
        return weeklyPushStatus;
    }

    public void setWeeklyPushStatus(String weeklyPushStatus) {
        this.weeklyPushStatus = weeklyPushStatus;
    }

    public String getWeeklyPushStatusCode() {
        return weeklyPushStatusCode;
    }

    public void setWeeklyPushStatusCode(String weeklyPushStatusCode) {
        this.weeklyPushStatusCode = weeklyPushStatusCode;
    }

    public Date getActived() {
        return actived;
    }

    public void setActived(Date actived) {
        this.actived = actived;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getLangId() {
        return langId;
    }

    public void setLangId(String langId) {
        this.langId = langId;
    }
}
