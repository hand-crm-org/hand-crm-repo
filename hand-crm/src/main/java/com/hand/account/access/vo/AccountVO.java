package com.hand.account.access.vo;

import java.util.Date;

public class AccountVO {
    private String code;//客户编码
    private Date created;//创建日期
    private String createdBy;//创建人
    private Date updated;//更新日期
    private String updatedBy;//更新人
    private String name;//客户名称
    private String nameEnu;//客户英文名
    private String type;//客户类型
    private String taxCode;//统一信用编码
    private String parAccntCode;//父客户code
    private String priEmpCode;//跟进人code
    private String orgCode;//组织code
    private String dunsCode;//邓白氏编码
    private String status;//状态
    private String periodCode;//客户周期
    private String currency;//币种
    private String priCtctCode;//客户法人code(主要联系人)
    private String phNum;//客户电话
    private String faxNum;//客户传真
    private String email;//客户邮箱
    private String homeUrl;//客户网址
    private String industry;//行业
    private String subIndustry;//子行业
    private String regFund;//注册资金
    private String addrCode;//地址code

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

    public String getNameEnu() {
        return nameEnu;
    }

    public void setNameEnu(String nameEnu) {
        this.nameEnu = nameEnu;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getParAccntCode() {
        return parAccntCode;
    }

    public void setParAccntCode(String parAccntCode) {
        this.parAccntCode = parAccntCode;
    }

    public String getPriEmpCode() {
        return priEmpCode;
    }

    public void setPriEmpCode(String priEmpCode) {
        this.priEmpCode = priEmpCode;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getDunsCode() {
        return dunsCode;
    }

    public void setDunsCode(String dunsCode) {
        this.dunsCode = dunsCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPeriodCode() {
        return periodCode;
    }

    public void setPeriodCode(String periodCode) {
        this.periodCode = periodCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPriCtctCode() {
        return priCtctCode;
    }

    public void setPriCtctCode(String priCtctCode) {
        this.priCtctCode = priCtctCode;
    }

    public String getPhNum() {
        return phNum;
    }

    public void setPhNum(String phNum) {
        this.phNum = phNum;
    }

    public String getFaxNum() {
        return faxNum;
    }

    public void setFaxNum(String faxNum) {
        this.faxNum = faxNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeUrl() {
        return homeUrl;
    }

    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getSubIndustry() {
        return subIndustry;
    }

    public void setSubIndustry(String subIndustry) {
        this.subIndustry = subIndustry;
    }

    public String getRegFund() {
        return regFund;
    }

    public void setRegFund(String regFund) {
        this.regFund = regFund;
    }

    public String getAddrCode() {
        return addrCode;
    }

    public void setAddrCode(String addrCode) {
        this.addrCode = addrCode;
    }

    @Override
    public String toString() {
        return "AccountVO{" +
                "code='" + code + '\'' +
                ", created=" + created +
                ", createdBy='" + createdBy + '\'' +
                ", updated=" + updated +
                ", updatedBy='" + updatedBy + '\'' +
                ", name='" + name + '\'' +
                ", nameEnu='" + nameEnu + '\'' +
                ", type='" + type + '\'' +
                ", taxCode='" + taxCode + '\'' +
                ", parAccntCode='" + parAccntCode + '\'' +
                ", priEmpCode='" + priEmpCode + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", dunsCode='" + dunsCode + '\'' +
                ", status='" + status + '\'' +
                ", periodCode='" + periodCode + '\'' +
                ", currency='" + currency + '\'' +
                ", priCtctCode='" + priCtctCode + '\'' +
                ", phNum='" + phNum + '\'' +
                ", faxNum='" + faxNum + '\'' +
                ", email='" + email + '\'' +
                ", homeUrl='" + homeUrl + '\'' +
                ", industry='" + industry + '\'' +
                ", subIndustry='" + subIndustry + '\'' +
                ", regFund='" + regFund + '\'' +
                ", addrCode='" + addrCode + '\'' +
                '}';
    }
}