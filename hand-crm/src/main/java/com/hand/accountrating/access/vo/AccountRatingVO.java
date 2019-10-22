package com.hand.accountrating.access.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class AccountRatingVO {
    private String code;  //客户-评级编码
    private Date created;  //创建日期
    private String createdBy;  //创建人
    private Date updated;  //更新日期
    private String updatedBy;  //更新人
    private String accountCode;  //客户Code
    private String ratingLevel;  //评级等级
    private String qixinLevel;  //启信宝资信等级
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date startDate;  //生效时间
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date endDate;  //失效时间
    private String status;  //状态
    private Double creditAll;  //可用信用额度
    private Double creditUsed;  //已用信用额度
    private String attachmentCode;  //评级附件Code
    private Integer version;  //版本
    private String currency;  //币种
    private String comment;  //备注
    private String statusCode;  //状态Code
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

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getRatingLevel() {
        return ratingLevel;
    }

    public void setRatingLevel(String ratingLevel) {
        this.ratingLevel = ratingLevel;
    }

    public String getQixinLevel() {
        return qixinLevel;
    }

    public void setQixinLevel(String qixinLevel) {
        this.qixinLevel = qixinLevel;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getCreditAll() {
        return creditAll;
    }

    public void setCreditAll(Double creditAll) {
        this.creditAll = creditAll;
    }

    public Double getCreditUsed() {
        return creditUsed;
    }

    public void setCreditUsed(Double creditUsed) {
        this.creditUsed = creditUsed;
    }

    public String getAttachmentCode() {
        return attachmentCode;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setAttachmentCode(String attachmentCode) {
        this.attachmentCode = attachmentCode;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getLangId() {
        return langId;
    }

    public void setLangId(String langId) {
        this.langId = langId;
    }

    @Override
    public String toString() {
        return "AccountRatingVO{" +
                "code='" + code + '\'' +
                ", created=" + created +
                ", createdBy='" + createdBy + '\'' +
                ", updated=" + updated +
                ", updatedBy='" + updatedBy + '\'' +
                ", accountCode='" + accountCode + '\'' +
                ", ratingLevel='" + ratingLevel + '\'' +
                ", qixinLevel='" + qixinLevel + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status='" + status + '\'' +
                ", creditAll=" + creditAll +
                ", creditUsed=" + creditUsed +
                ", attachmentCode='" + attachmentCode + '\'' +
                ", version='" + version + '\'' +
                ", currency='" + currency + '\'' +
                ", comment='" + comment + '\'' +
                ", statusCode='" + statusCode + '\'' +
                '}';
    }
}
