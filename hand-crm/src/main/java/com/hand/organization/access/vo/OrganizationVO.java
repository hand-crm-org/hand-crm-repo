package com.hand.organization.access.vo;

import java.util.Date;

public class OrganizationVO {
    private String code;//组织编码（唯一性标识）
    private Date created;//创建日期
    private String createdBy;//创建人
    private Date updated;//更新日期
    private String updatedBy;//更新人
    private String name;//名称
    private String level;//层级
    private String type;//类型
    private String parOrgCode;//父组织编码
    private String extFlg;//内/外部标识
    private String desc;//描述
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParOrgCode() {
        return parOrgCode;
    }

    public void setParOrgCode(String parOrgCode) {
        this.parOrgCode = parOrgCode;
    }

    public String getExtFlg() {
        return extFlg;
    }

    public void setExtFlg(String extFlg) {
        this.extFlg = extFlg;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "code='" + code + '\'' +
                ", created=" + created +
                ", createdBy='" + createdBy + '\'' +
                ", updated=" + updated +
                ", updatedBy='" + updatedBy + '\'' +
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", type='" + type + '\'' +
                ", parOrgCode='" + parOrgCode + '\'' +
                ", extFlg='" + extFlg + '\'' +
                ", desc='" + desc + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
