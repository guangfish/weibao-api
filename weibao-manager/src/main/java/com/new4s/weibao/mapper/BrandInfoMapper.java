package com.new4s.weibao.mapper;

import java.util.List;

import com.new4s.weibao.entity.BrandInfo;

public interface BrandInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand_info
     *
     * @mbg.generated Thu May 17 14:31:06 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand_info
     *
     * @mbg.generated Thu May 17 14:31:06 CST 2018
     */
    int insert(BrandInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand_info
     *
     * @mbg.generated Thu May 17 14:31:06 CST 2018
     */
    int insertSelective(BrandInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand_info
     *
     * @mbg.generated Thu May 17 14:31:06 CST 2018
     */
    BrandInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand_info
     *
     * @mbg.generated Thu May 17 14:31:06 CST 2018
     */
    int updateByPrimaryKeySelective(BrandInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand_info
     *
     * @mbg.generated Thu May 17 14:31:06 CST 2018
     */
    int updateByPrimaryKey(BrandInfo record);
    
    List<BrandInfo> selectAll();
}