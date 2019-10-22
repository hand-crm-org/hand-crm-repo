package com.hand.account.access.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class AccountVO {
    private String code;//客户code
    private String accntNum;//客户编码
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date created;//创建日期
    private String createdBy;//创建人
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date updated;//更新日期
    private String updatedBy;//更新人
    private String name;//客户名称
    private String nameEnu;//客户英文名
    private String type;//客户类型
    private String typeCode;//客户类型code
    private String taxCode;//统一信用编码
    private String parAccntCode;//父客户code
    private String priEmpCode;//跟进人code
    private String priEmpName;//跟进人
    private String orgCode;//组织code
    private String orgName;//组织名称
    private String dunsCode;//邓白氏编码
    private String status;//状态
    private String statusCode;//状态
    private String period;//客户周期
    private String periodCode;//客户周期
    private String currency;//币种
    private String priCtctCode;//客户法人code(主要联系人)
    /**
     * 主要联系人姓名
     */
    private String priCtct;
    private String phNum;//客户电话
    private String faxNum;//客户传真
    private String email;//客户邮箱
    private String homeUrl;//客户网址
    private String industry;//行业
    private String industryCode;//行业
    private String subIndustry;//子行业
    private String subIndustryCode;//子行业
    private String regFund;//注册资金
    private String addrCode;//地址code
    private String langId;

    /**
     * 销售团队
     */
    private String salesTeam;
    private String salesTeamCode;
    /**
     * 国家
     */
    private String country;
    /**
     * 省份
     */
    private String state;
    /**
     * 城市
     */
    private String city;
    /**
     * 县
     */
    private String county;
    /**
     * 镇
     */
    private String street;
    /**
     * 地址1
     */
    private String addr1;
    /**
     * 地址2
     */
    private String addr2;

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

    public String getPriCtct() {
        return priCtct;
    }

    public void setPriCtct(String priCtct) {
        this.priCtct = priCtct;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getLangId() {
        return langId;
    }

    public void setLangId(String langId) {
        this.langId = langId;
    }

    public String getAccntNum() {
        return accntNum;
    }

    public void setAccntNum(String accntNum) {
        this.accntNum = accntNum;
    }

    public String getSalesTeam() {
        return salesTeam;
    }

    public void setSalesTeam(String salesTeam) {
        this.salesTeam = salesTeam;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSalesTeamCode() {
        return salesTeamCode;
    }

    public void setSalesTeamCode(String salesTeamCode) {
        this.salesTeamCode = salesTeamCode;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    public String getSubIndustryCode() {
        return subIndustryCode;
    }

    public void setSubIndustryCode(String subIndustryCode) {
        this.subIndustryCode = subIndustryCode;
    }

    public String getPriEmpName() {
        return priEmpName;
    }

    public void setPriEmpName(String priEmpName) {
        this.priEmpName = priEmpName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Override
    public String toString() {
        return "AccountVO{" +
                "code='" + code + '\'' +
                ", accntNum='" + accntNum + '\'' +
                ", created=" + created +
                ", createdBy='" + createdBy + '\'' +
                ", updated=" + updated +
                ", updatedBy='" + updatedBy + '\'' +
                ", name='" + name + '\'' +
                ", nameEnu='" + nameEnu + '\'' +
                ", type='" + type + '\'' +
                ", typeCode='" + typeCode + '\'' +
                ", taxCode='" + taxCode + '\'' +
                ", parAccntCode='" + parAccntCode + '\'' +
                ", priEmpCode='" + priEmpCode + '\'' +
                ", priEmpName='" + priEmpName + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", orgName='" + orgName + '\'' +
                ", dunsCode='" + dunsCode + '\'' +
                ", status='" + status + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", period='" + period + '\'' +
                ", periodCode='" + periodCode + '\'' +
                ", currency='" + currency + '\'' +
                ", priCtctCode='" + priCtctCode + '\'' +
                ", priCtct='" + priCtct + '\'' +
                ", phNum='" + phNum + '\'' +
                ", faxNum='" + faxNum + '\'' +
                ", email='" + email + '\'' +
                ", homeUrl='" + homeUrl + '\'' +
                ", industry='" + industry + '\'' +
                ", industryCode='" + industryCode + '\'' +
                ", subIndustry='" + subIndustry + '\'' +
                ", subIndustryCode='" + subIndustryCode + '\'' +
                ", regFund='" + regFund + '\'' +
                ", addrCode='" + addrCode + '\'' +
                ", langId='" + langId + '\'' +
                ", salesTeam='" + salesTeam + '\'' +
                ", salesTeamCode='" + salesTeamCode + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", street='" + street + '\'' +
                ", addr1='" + addr1 + '\'' +
                ", addr2='" + addr2 + '\'' +
                '}';
    }
}
