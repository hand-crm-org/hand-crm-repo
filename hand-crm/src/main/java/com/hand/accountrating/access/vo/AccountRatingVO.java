package com.hand.accountrating.access.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class AccountRatingVO {
    private String code;
    private Date created;
    private String createdBy;
    private Date updated;
    private String updatedBy;
    private String accountCode;
    private String ratingLevel;
    private String qixinLevel;
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss")
    private Date startDate;
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss")
    private Date endDate;
    private String status;
    private double creditAll;
    private double creditUsed;
    private String attachmentCode;
    private String version;
    private String currency;
    private String comment;

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

    public double getCreditAll() {
        return creditAll;
    }

    public void setCreditAll(double creditAll) {
        this.creditAll = creditAll;
    }

    public double getCreditUsed() {
        return creditUsed;
    }

    public void setCreditUsed(double creditUsed) {
        this.creditUsed = creditUsed;
    }

    public String getAttachmentCode() {
        return attachmentCode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
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

    @Override
    public String toString() {
        return "AccountRatingVO{" +
                "code='" + code + '\'' +
                ", created='" + created + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", updated='" + updated + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", accountCode='" + accountCode + '\'' +
                ", ratingLevel='" + ratingLevel + '\'' +
                ", qixinLevel='" + qixinLevel + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", status='" + status + '\'' +
                ", creditAll='" + creditAll + '\'' +
                ", creditUsed='" + creditUsed + '\'' +
                ", attachmentCode='" + attachmentCode + '\'' +
                '}';
    }
}
