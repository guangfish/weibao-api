package com.new4s.weibao.entity;

public class District {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column district.id
     *
     * @mbg.generated Fri May 18 15:59:12 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column district.name
     *
     * @mbg.generated Fri May 18 15:59:12 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column district.level
     *
     * @mbg.generated Fri May 18 15:59:12 CST 2018
     */
    private Byte level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column district.usetype
     *
     * @mbg.generated Fri May 18 15:59:12 CST 2018
     */
    private Boolean usetype;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column district.upid
     *
     * @mbg.generated Fri May 18 15:59:12 CST 2018
     */
    private Integer upid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column district.displayorder
     *
     * @mbg.generated Fri May 18 15:59:12 CST 2018
     */
    private Short displayorder;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column district.fletter
     *
     * @mbg.generated Fri May 18 15:59:12 CST 2018
     */
    private String fletter;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column district.id
     *
     * @return the value of district.id
     *
     * @mbg.generated Fri May 18 15:59:12 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column district.id
     *
     * @param id the value for district.id
     *
     * @mbg.generated Fri May 18 15:59:12 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column district.name
     *
     * @return the value of district.name
     *
     * @mbg.generated Fri May 18 15:59:12 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column district.name
     *
     * @param name the value for district.name
     *
     * @mbg.generated Fri May 18 15:59:12 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column district.level
     *
     * @return the value of district.level
     *
     * @mbg.generated Fri May 18 15:59:12 CST 2018
     */
    public Byte getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column district.level
     *
     * @param level the value for district.level
     *
     * @mbg.generated Fri May 18 15:59:12 CST 2018
     */
    public void setLevel(Byte level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column district.usetype
     *
     * @return the value of district.usetype
     *
     * @mbg.generated Fri May 18 15:59:12 CST 2018
     */
    public Boolean getUsetype() {
        return usetype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column district.usetype
     *
     * @param usetype the value for district.usetype
     *
     * @mbg.generated Fri May 18 15:59:12 CST 2018
     */
    public void setUsetype(Boolean usetype) {
        this.usetype = usetype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column district.upid
     *
     * @return the value of district.upid
     *
     * @mbg.generated Fri May 18 15:59:12 CST 2018
     */
    public Integer getUpid() {
        return upid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column district.upid
     *
     * @param upid the value for district.upid
     *
     * @mbg.generated Fri May 18 15:59:12 CST 2018
     */
    public void setUpid(Integer upid) {
        this.upid = upid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column district.displayorder
     *
     * @return the value of district.displayorder
     *
     * @mbg.generated Fri May 18 15:59:12 CST 2018
     */
    public Short getDisplayorder() {
        return displayorder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column district.displayorder
     *
     * @param displayorder the value for district.displayorder
     *
     * @mbg.generated Fri May 18 15:59:12 CST 2018
     */
    public void setDisplayorder(Short displayorder) {
        this.displayorder = displayorder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column district.fletter
     *
     * @return the value of district.fletter
     *
     * @mbg.generated Fri May 18 15:59:12 CST 2018
     */
    public String getFletter() {
        return fletter;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column district.fletter
     *
     * @param fletter the value for district.fletter
     *
     * @mbg.generated Fri May 18 15:59:12 CST 2018
     */
    public void setFletter(String fletter) {
        this.fletter = fletter == null ? null : fletter.trim();
    }
}