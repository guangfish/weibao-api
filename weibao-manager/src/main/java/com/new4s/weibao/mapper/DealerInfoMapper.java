package com.new4s.weibao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.new4s.weibao.entity.DealerInfo;

public interface DealerInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dealer_info
     *
     * @mbg.generated Thu May 17 13:25:40 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dealer_info
     *
     * @mbg.generated Thu May 17 13:25:40 CST 2018
     */
    int insert(DealerInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dealer_info
     *
     * @mbg.generated Thu May 17 13:25:40 CST 2018
     */
    int insertSelective(DealerInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dealer_info
     *
     * @mbg.generated Thu May 17 13:25:40 CST 2018
     */
    DealerInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dealer_info
     *
     * @mbg.generated Thu May 17 13:25:40 CST 2018
     */
    int updateByPrimaryKeySelective(DealerInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dealer_info
     *
     * @mbg.generated Thu May 17 13:25:40 CST 2018
     */
    int updateByPrimaryKey(DealerInfo record);
    
    List<DealerInfo> selectAll();
    
    int selectDealerCount(Map<String, Object> searchMap);

    List<DealerInfo> selectDealerList(Map<String, Object> searchMap, RowBounds rowBounds);
}