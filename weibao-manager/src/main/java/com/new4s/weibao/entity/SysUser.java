package com.new4s.weibao.entity;

import java.util.Date;

public class SysUser extends ID {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.id
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.username
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.password
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.realname
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    private String realname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.mobile
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    private String mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.usertype
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    private Integer usertype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.status
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.remark
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.login_ip
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    private String loginIp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.login_time
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    private Date loginTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.default_page
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    private String defaultPage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.create_time
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.update_time
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.id
     *
     * @return the value of sys_user.id
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.id
     *
     * @param id the value for sys_user.id
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.username
     *
     * @return the value of sys_user.username
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.username
     *
     * @param username the value for sys_user.username
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.password
     *
     * @return the value of sys_user.password
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.password
     *
     * @param password the value for sys_user.password
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.realname
     *
     * @return the value of sys_user.realname
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    public String getRealname() {
        return realname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.realname
     *
     * @param realname the value for sys_user.realname
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.mobile
     *
     * @return the value of sys_user.mobile
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.mobile
     *
     * @param mobile the value for sys_user.mobile
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.usertype
     *
     * @return the value of sys_user.usertype
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    public Integer getUsertype() {
        return usertype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.usertype
     *
     * @param usertype the value for sys_user.usertype
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.status
     *
     * @return the value of sys_user.status
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.status
     *
     * @param status the value for sys_user.status
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.remark
     *
     * @return the value of sys_user.remark
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.remark
     *
     * @param remark the value for sys_user.remark
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.login_ip
     *
     * @return the value of sys_user.login_ip
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.login_ip
     *
     * @param loginIp the value for sys_user.login_ip
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.login_time
     *
     * @return the value of sys_user.login_time
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.login_time
     *
     * @param loginTime the value for sys_user.login_time
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.default_page
     *
     * @return the value of sys_user.default_page
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    public String getDefaultPage() {
        return defaultPage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.default_page
     *
     * @param defaultPage the value for sys_user.default_page
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    public void setDefaultPage(String defaultPage) {
        this.defaultPage = defaultPage == null ? null : defaultPage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.create_time
     *
     * @return the value of sys_user.create_time
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.create_time
     *
     * @param createTime the value for sys_user.create_time
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.update_time
     *
     * @return the value of sys_user.update_time
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.update_time
     *
     * @param updateTime the value for sys_user.update_time
     *
     * @mbggenerated Tue Jan 16 16:41:44 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    private Integer platform;

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }
}