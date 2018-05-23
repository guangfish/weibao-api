package com.new4s.weibao.entity;

import java.util.Date;

public class DealerInfo {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dealer_info.id
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dealer_info.name
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dealer_info.province
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	private String province;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dealer_info.province_name
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	private String provinceName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dealer_info.city
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	private String city;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dealer_info.city_name
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	private String cityName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dealer_info.address
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	private String address;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dealer_info.brand
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	private String brand;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dealer_info.dms_account
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	private String dmsAccount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dealer_info.dms_password
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	private String dmsPassword;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dealer_info.create_time
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	private Date createTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dealer_info.update_time
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	private Date updateTime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dealer_info.id
	 * @return  the value of dealer_info.id
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dealer_info.id
	 * @param id  the value for dealer_info.id
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dealer_info.name
	 * @return  the value of dealer_info.name
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dealer_info.name
	 * @param name  the value for dealer_info.name
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dealer_info.province
	 * @return  the value of dealer_info.province
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dealer_info.province
	 * @param province  the value for dealer_info.province
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	public void setProvince(String province) {
		this.province = province == null ? null : province.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dealer_info.province_name
	 * @return  the value of dealer_info.province_name
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	public String getProvinceName() {
		return provinceName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dealer_info.province_name
	 * @param provinceName  the value for dealer_info.province_name
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName == null ? null : provinceName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dealer_info.city
	 * @return  the value of dealer_info.city
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	public String getCity() {
		return city;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dealer_info.city
	 * @param city  the value for dealer_info.city
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dealer_info.city_name
	 * @return  the value of dealer_info.city_name
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dealer_info.city_name
	 * @param cityName  the value for dealer_info.city_name
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName == null ? null : cityName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dealer_info.address
	 * @return  the value of dealer_info.address
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dealer_info.address
	 * @param address  the value for dealer_info.address
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dealer_info.brand
	 * @return  the value of dealer_info.brand
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dealer_info.brand
	 * @param brand  the value for dealer_info.brand
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	public void setBrand(String brand) {
		this.brand = brand == null ? null : brand.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dealer_info.dms_account
	 * @return  the value of dealer_info.dms_account
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	public String getDmsAccount() {
		return dmsAccount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dealer_info.dms_account
	 * @param dmsAccount  the value for dealer_info.dms_account
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	public void setDmsAccount(String dmsAccount) {
		this.dmsAccount = dmsAccount == null ? null : dmsAccount.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dealer_info.dms_password
	 * @return  the value of dealer_info.dms_password
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	public String getDmsPassword() {
		return dmsPassword;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dealer_info.dms_password
	 * @param dmsPassword  the value for dealer_info.dms_password
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	public void setDmsPassword(String dmsPassword) {
		this.dmsPassword = dmsPassword == null ? null : dmsPassword.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dealer_info.create_time
	 * @return  the value of dealer_info.create_time
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dealer_info.create_time
	 * @param createTime  the value for dealer_info.create_time
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dealer_info.update_time
	 * @return  the value of dealer_info.update_time
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dealer_info.update_time
	 * @param updateTime  the value for dealer_info.update_time
	 * @mbg.generated  Fri May 18 16:23:10 CST 2018
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}