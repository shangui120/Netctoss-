package com.lanou.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.Cost;
import com.lanou.mapper.CostMapper;
import com.lanou.service.CostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/8/30.
 */
@Service
public class CostServiceImpl implements CostService {
    @Resource
    private CostMapper mapper;

    //分页
    public PageInfo<Cost> querypage(Integer pageNum, Integer pageSize) {
        pageNum = pageNum ==null ? 1: pageNum;
        pageSize = pageSize == null ? 3 :pageSize;

        PageHelper.startPage(pageNum,pageSize);
        List<Cost> list = mapper.findAll();
        PageInfo<Cost> pageInfo = new PageInfo<Cost>(list);

        return pageInfo;
    }

    public Cost insert(Cost cost) {
        mapper.insert(cost);
        return cost;
    }

    public void deleteId(Integer id) {
        mapper.delete(id);
    }



    public void update(Cost cost) {

        mapper.update(cost);

    }

    public Cost selectById(Integer id) {
      return  mapper.findById(id);

    }
}
