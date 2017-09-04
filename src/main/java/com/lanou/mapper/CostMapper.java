package com.lanou.mapper;

import com.lanou.bean.Cost;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dllo on 17/8/30.
 */
@Repository
public interface CostMapper {
    @Select("select *from cost")
    List<Cost> findAll();

    @Insert("insert into cost values (null,#{name,jdbcType=VARCHAR}" +
            ",#{base_duration,jdbcType=INTEGER}" +
            ",#{base_cost,jdbcType=INTEGER}" +
            ",#{unit_cost,jdbcType=INTEGER}" +
            ",#{status,jdbcType=VARCHAR}" +
            ",#{descr,jdbcType=VARCHAR}" +
            ",#{creatime,jdbcType=TIMESTAMP}" +
            ",#{startime,jdbcType=TIMESTAMP}" +
            ",#{cost_type,jdbcType=VARCHAR})")
    void insert(Cost cost);

    @Delete("delete from cost where cost_id = #{cost_id,jdbcType = INTEGER}")
    void delete(Integer id);


    @Update("update cost set name=#{name,jdbcType=VARCHAR}" +
            ",base_duration=#{base_duration,jdbcType=INTEGER}" +
            ",base_cost=#{base_cost,jdbcType=INTEGER}" +
            ",unit_cost=#{unit_cost,jdbcType=INTEGER}" +
            ",descr=#{descr,jdbcType=VARCHAR}" +
            ",cost_type=#{cost_type,jdbcType=VARCHAR}" +
            " where cost_id =#{cost_id,jdbcType=INTEGER}")
    void update(Cost cost);

    @Select("select *from cost where cost_id = #{cost_id,jdbcType=VARCHAR}")
    Cost findById(Integer id);

//    @Update("update cost set ")
//    void updateQY(Cost cost);

}
