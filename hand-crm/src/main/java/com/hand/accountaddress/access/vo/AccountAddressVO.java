package com.hand.accountaddress.access.vo;

import java.util.Date;

public class AccountAddressVO {
    private String code;//客户-地址编码
    private Date created;//创建日期
    private String createdBy;//创建人
    private Date updated;//更新日期
    private String updatedBy;//更新人
    private String accntCode;//客户code
    private String addrCode;//地址code
    private String desc;//备注
    private String ctct;//联系人
    private String phNum;//联系方式
    private String priFlg;//是否主要
    private String type;//地址类型
    private String status;//状态

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

    public String getAccntCode() {
        return accntCode;
    }

    public void setAccntCode(String accntCode) {
        this.accntCode = accntCode;
    }

    public String getAddrCode() {
        return addrCode;
    }

    public void setAddrCode(String addrCode) {
        this.addrCode = addrCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCtct() {
        return ctct;
    }

    public void setCtct(String ctct) {
        this.ctct = ctct;
    }

    public String getPhNum() {
        return phNum;
    }

    public void setPhNum(String phNum) {
        this.phNum = phNum;
    }

    public String getPriFlg() {
        return priFlg;
    }

    public void setPriFlg(String priFlg) {
        this.priFlg = priFlg;
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

    @Override
    public String toString() {
        return "AccountAddressVO{" +
                "code='" + code + '\'' +
                ", created=" + created +
                ", createdBy='" + createdBy + '\'' +
                ", updated=" + updated +
                ", updatedBy='" + updatedBy + '\'' +
                ", accntCode='" + accntCode + '\'' +
                ", addrCode='" + addrCode + '\'' +
                ", desc='" + desc + '\'' +
                ", ctct='" + ctct + '\'' +
                ", phNum='" + phNum + '\'' +
                ", priFlg='" + priFlg + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
