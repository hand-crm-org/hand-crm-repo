package com.hand.employee.access.vo;

/**
 * @author nan.yao@hand-china.com 2019/9/30 16:36
 */
public class EmployeeVO {

    /**
     * 客户编码
     */
    private String code;
    /**
     * 创建时间
     */
    private String created;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 更新时间
     */
    private String updated;
    /**
     * 更新人
     */
    private String updatedBy;
    /**
     * 是否用户
     */
    private String userFlg;
    /**
     * 登录账号
     */
    private String login;
    /**
     * 密码
     */
    private String password;
    /**
     * 名称
     */
    private String name;
    /**
     * 外文名
     */
    private String nameForeign;
    /**
     * 简称
     */
    private String nameShort;
    /**
     * 工作电话
     */
    private String workNum;
    /**
     * 个人电话
     */
    private String personalNum;
    /**
     * 微信号
     */
    private String wechatNum;
    /**
     * QQ号
     */
    private String qqNum;
    /**
     * 微信openId
     */
    private String openId;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 职级
     */
    private String jobLevel;
    /**
     * 主要职位Id
     */
    private String priPostnCode;
    /**
     * 地址Id
     */
    private String addrCode;
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

    public String getUserFlg() {
        return userFlg;
    }

    public void setUserFlg(String userFlg) {
        this.userFlg = userFlg;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameForeign() {
        return nameForeign;
    }

    public void setNameForeign(String nameForeign) {
        this.nameForeign = nameForeign;
    }

    public String getNameShort() {
        return nameShort;
    }

    public void setNameShort(String nameShort) {
        this.nameShort = nameShort;
    }

    public String getWorkNum() {
        return workNum;
    }

    public void setWorkNum(String workNum) {
        this.workNum = workNum;
    }

    public String getPersonalNum() {
        return personalNum;
    }

    public void setPersonalNum(String personalNum) {
        this.personalNum = personalNum;
    }

    public String getWechatNum() {
        return wechatNum;
    }

    public void setWechatNum(String wechatNum) {
        this.wechatNum = wechatNum;
    }

    public String getQqNum() {
        return qqNum;
    }

    public void setQqNum(String qqNum) {
        this.qqNum = qqNum;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobLevel() {
        return jobLevel;
    }

    public void setJobLevel(String jobLevel) {
        this.jobLevel = jobLevel;
    }

    public String getPriPostnCode() {
        return priPostnCode;
    }

    public void setPriPostnCode(String priPostnCode) {
        this.priPostnCode = priPostnCode;
    }

    public String getAddrCode() {
        return addrCode;
    }

    public void setAddrCode(String addrCode) {
        this.addrCode = addrCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EmployeeVO{" +
                "code='" + code + '\'' +
                ", created='" + created + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", updated='" + updated + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", userFlg='" + userFlg + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", nameForeign='" + nameForeign + '\'' +
                ", nameShort='" + nameShort + '\'' +
                ", workNum='" + workNum + '\'' +
                ", personalNum='" + personalNum + '\'' +
                ", wechatNum='" + wechatNum + '\'' +
                ", qqNum='" + qqNum + '\'' +
                ", openId='" + openId + '\'' +
                ", email='" + email + '\'' +
                ", jobLevel='" + jobLevel + '\'' +
                ", priPostnCode='" + priPostnCode + '\'' +
                ", addrCode='" + addrCode + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
