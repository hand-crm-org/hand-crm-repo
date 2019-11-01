package com.hand.businessopportunity.access.vo;

import java.util.Date;

public class BusinessOpportunityVO {
    private String code;
    private Date created;
    private String createdBy;
    private Date updated;
    private String updatedBy;
    private String optycode;
    private String brand;
    private Float quotation;
    private String goodness;
    private String badness;
    private String comments;
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getBadness() {
        return badness;
    }

    public void setBadness(String badness) {
        this.badness = badness;
    }

    public String getGoodness() {
        return goodness;
    }

    public void setGoodness(String goodness) {
        this.goodness = goodness;
    }

    public Float getQuotation() {
        return quotation;
    }

    public void setQuotation(Float quotation) {
        this.quotation = quotation;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOptycode() {
        return optycode;
    }

    public void setOptycode(String optycode) {
        this.optycode = optycode;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
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
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
