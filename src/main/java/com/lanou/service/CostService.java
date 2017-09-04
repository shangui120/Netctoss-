package com.lanou.service;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Cost;

import java.util.List;

/**
 * Created by dllo on 17/8/30.
 */
public interface CostService {

    //分页
    PageInfo<Cost> querypage(Integer pageNum, Integer pageSize);

    Cost insert(Cost cost);

    void deleteId(Integer id);

    void update(Cost cost);

    Cost selectById(Integer id);


}
