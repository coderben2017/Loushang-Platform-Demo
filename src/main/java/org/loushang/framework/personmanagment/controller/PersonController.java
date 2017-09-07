package org.loushang.framework.personmanagment.controller;

import org.loushang.framework.mybatis.PageUtil;
import org.loushang.framework.personmanagment.data.Company;
import org.loushang.framework.personmanagment.data.Person;
import org.loushang.framework.personmanagment.service.ICompanyService;
import org.loushang.framework.personmanagment.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller层，用于前后台交互、前后台数据格式转换
 *
 * Created by Traveler on 2017/8/4.
 */
@Controller
@RequestMapping(value = "/framework/personmanagment")
public class PersonController {
    @Autowired
    IPersonService personService;
    @Autowired
    ICompanyService companyService;

    /**
     * 跳转用户列表页面
     *
     * @return 员工列表页面
     */
    @RequestMapping("/home")
    public String home() {
        return "/framework/personmanagment/employee/queryemp";
    }

    @RequestMapping("/query")
    @ResponseBody
    public Map query(@RequestBody Map<String, Object> param) {
        System.out.println("query all controller in");
        Map<String, Object> map = new HashMap<String, Object>();
        List<Person> personList = personService.findAll(param);
        System.out.println("list length:" + personList.size());
        for (Person person : personList) {
            System.out.println(person.getPersonName());
        }
        map.put("data", personList);
        // 获取总记录条数
        int total = PageUtil.getTotalCount();
        map.put("total", total != -1 ? total : personList.size());

        return map;
    }

    /**
     * 查询一个员工的基本信息
     *
     * @param id 员工编号
     * @return Person 员工信息
     */
    @RequestMapping("/queryPerson/{id}")
    @ResponseBody
    public Object queryPerson(@PathVariable int id) {
        Person person = personService.findOne(id);
        return person;
    }

    /**
     * 查询员工所在部门的信息
     *
     * @param id 部门编号
     * @return Company 部门信息
     */
    @RequestMapping("/queryCompany/{id}")
    @ResponseBody
    public Object queryCompany(@PathVariable int id) {
        Company company = companyService.findOne(id);
        return company;
    }

    /**
     * 查询员工所在部门的同事信息列表
     *
     * @param id 员工编号
     * @return List, 内容为Person,同事信息
     */
    @RequestMapping("/queryColleague/{id}")
    @ResponseBody
    public Object queryColleague(@PathVariable int id) {
        return personService.findColleague(id);
    }
}