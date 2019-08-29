package com.hand.accountsalesteam.access.vo;

import java.util.Date;

/**
 * @author nan.yao@hand-china.com 2019/8/28 17:30
 */
public class AccountSalesTeamVO {
    /**
     * 客户-销售团队编码
     */
    private String code;
    /**
     * 创建日期
     */
    private Date created;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 更新日期
     */
    private Date updated;
    /**
     * 更新人
     */
    private String updatedBy;
    /**
     * 客户Code
     */
    private String accntCode;
    /**
     * 员工Code
     */
    private String empCode;
    /**
     * 主要标识
     */
    private String priFlg;
    /**
     * 备注
     */
    private String desc;
    /**
     * 状态
     */
    private String status;

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

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getPriFlg() {
        return priFlg;
    }

    public void setPriFlg(String priFlg) {
        this.priFlg = priFlg;
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
        return "AccountSalesTeamVO{" +
                "code='" + code + '\'' +
                ", created=" + created +
                ", createdBy='" + createdBy + '\'' +
                ", updated=" + updated +
                ", updatedBy='" + updatedBy + '\'' +
                ", accntCode='" + accntCode + '\'' +
                ", empCode='" + empCode + '\'' +
                ", priFlg='" + priFlg + '\'' +
                ", desc='" + desc + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
