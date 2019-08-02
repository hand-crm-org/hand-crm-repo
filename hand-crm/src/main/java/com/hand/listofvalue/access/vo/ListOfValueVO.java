package com.hand.listofvalue.access.vo;

import java.util.Date;

public class ListOfValueVO {
    private String code;//值列表编码
    private Date created;//创建日期
    private String createdBy;//创建人
    private Date updated;//更新日期
    private String updatedBy;//更新人
    private String type;//类型
    private String langId;//语言
    private String value;//显示值
    private String name;//独立语言代码
    private String parLstCode;//父值列表编码
    private Integer level;//层级
    private String actFlg;//生效标识
    private String desc;//描述

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLangId() {
        return langId;
    }

    public void setLangId(String langId) {
        this.langId = langId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParLstCode() {
        return parLstCode;
    }

    public void setParLstCode(String parLstCode) {
        this.parLstCode = parLstCode;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getActFlg() {
        return actFlg;
    }

    public void setActFlg(String actFlg) {
        this.actFlg = actFlg;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "ListOfValueVO{" +
                "code='" + code + '\'' +
                ", created=" + created +
                ", createdBy='" + createdBy + '\'' +
                ", updated=" + updated +
                ", updatedBy='" + updatedBy + '\'' +
                ", type='" + type + '\'' +
                ", langId='" + langId + '\'' +
                ", value='" + value + '\'' +
                ", name='" + name + '\'' +
                ", parLstCode='" + parLstCode + '\'' +
                ", level=" + level +
                ", actFlg='" + actFlg + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
