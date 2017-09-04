package com.lanou.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Cost;
import com.lanou.service.CostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/8/30.
 */
@Controller
public class CostController {

    @Resource
    private CostService service;

    @RequestMapping("/")
    public String frontPage(){
        return "index";

    }
//    @RequestParam("name")String name
//            ,@RequestParam("cost_type")String cost_type
//            ,@RequestParam("base_duration")String base_duration
//            ,@RequestParam("base_cost")String base_cost
//            ,@RequestParam("unit_cost")String unit_cost
//            ,@RequestParam("descr")String descr)

    //点击资费管理
    @RequestMapping("/fee/fee_list")
    public String fee(){
        return "/fee/fee_list";
    }
    //点击添加
    @RequestMapping("/fee/toAddCost.do")
    public String add(){
        return "/fee/fee_add";
    }
    //点击添加保存
    @RequestMapping("/fee/addCost.do")
    public String prAdd (Cost cost){
        service.insert(cost);
        return "redirect:fee_list";    //########重定向问题
    }
    //点击删除
    @RequestMapping("/delete")
    public  void delete(@RequestParam("cost_id")Integer id){

        service.deleteId(id);

    }

    //点击修改
   @RequestMapping("/fee/fee_modi")
   public String update(@RequestParam("cost_id1")Integer id,HttpSession session){
       Cost cost = service.selectById(id);
       session.setAttribute("cost",cost);
       return "/fee/fee_modi";

   }

   @RequestMapping("/show")
   @ResponseBody   //controller到页面
   public Map<String,Object> show(HttpSession session){
       Cost cost = (Cost) session.getAttribute("cost");
       HashMap<String, Object> m = new HashMap<String, Object>();
       m.put("show2",cost);
       return m;

   }
    //点击保存
    @RequestMapping("/fee/aa")
    public String prupdate(Cost cost){
        service.update(cost);
        return "redirect:fee_list";
    }


    //点击链接
    @RequestMapping("/fee/fee_detail")
    public String detail(@RequestParam("cost_id2")Integer id,HttpSession session){
        Cost cost = service.selectById(id);
        System.out.println(id);
        session.setAttribute("cost1",cost);
        return "/fee/fee_detail";
    }
    @RequestMapping("/show1")
    @ResponseBody
    public Map<String,Object> show1(HttpSession session){
        Cost cost1 = (Cost) session.getAttribute("cost1");
        HashMap<String, Object> m = new HashMap<String, Object>();
        m.put("show3",cost1);
        System.out.println(m);
        return m;
    }

//    @RequestMapping(value = "/getall")
//    @ResponseBody
//    public List<Cost> findAll(){
//        List<Cost> allCost = service.findAllCost();
//        System.out.println(allCost);
//        return allCost;
//    }

    //分页
    @RequestMapping(value = "/pagetest")
    @ResponseBody
    public PageInfo<Cost> pagetest(@RequestParam("pageNum")Integer pageNum,
                                   @RequestParam("pageSize")Integer pageSize,
                                   HttpServletRequest request){

        PageInfo<Cost> page = service.querypage(pageNum, pageSize);
        request.setAttribute("url","/pagetest");
        return page;
    }


}

