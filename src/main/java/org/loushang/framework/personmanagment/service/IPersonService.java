package org.loushang.framework.personmanagment.service;

import org.loushang.framework.personmanagment.data.Person;

import java.util.List;
import java.util.Map;

/**
 * Service层 接口类，用于业务逻辑处理，事务控制等
 *
 * Created by Traveler on 2017/8/4.
 */
public interface IPersonService {
    /**
     * 条件查询所有员工信息
     *
     * @param map key 分别为 ：
     *            orderfield[排序列]
     *            orderdir[排序方向desc或asc]
     *            start[起始行]
     *            limit[每页显示条数]
     * @return List， 内容为Person对象
     */
    public List<Person> findAll(Map map);

    /**
     * 查询一个员工信息
     *
     * @param personId 员工编号
     * @return Person 员工信息
     */
    public Person findOne(int personId);

    /**
     * 查询员工的同事信息
     *
     * @param id 员工编号
     * @return List, 内容为Person对象
     */
    public List<Person> findColleague(int id);
}
