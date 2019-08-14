package com.hand.accountcontact.access.vo;

public class AccountContactVO {
    private String code;
    private String created;
    private String createdBy;
    private String updated;
    private String updatedBy;
    private String accntCode;
    private String ctctCode;
    private String status;
    private String desc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
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

    public String getCtctCode() {
        return ctctCode;
    }

    public void setCtctCode(String ctctCode) {
        this.ctctCode = ctctCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "AccountContactVO{" +
                "code='" + code + '\'' +
                ", created='" + created + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", updated='" + updated + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", accntCode='" + accntCode + '\'' +
                ", ctctCode='" + ctctCode + '\'' +
                ", status='" + status + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
