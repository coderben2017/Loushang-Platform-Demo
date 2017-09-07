package org.loushang.framework.personmanagment.dao;

import org.loushang.framework.mybatis.mapper.EntityMapper;
import org.loushang.framework.personmanagment.data.Person;

import java.util.List;
import java.util.Map;

/**
 * Dao层 接口类，用于持久化数据处理
 *
 * Created by Traveler on 2017/8/4.
 */
public interface PersonMapper extends EntityMapper<Person> {

    /**
     * 查询所有员工信息
     *
     * @param map key 分别为 ：
     *            orderfield[排序列]
     *            orderdir[排序方向desc或asc]
     *            start[起始行]
     *            limit[每页显示条数]
     * @return List, 内容为Person对象列表
     */
    List<Person> findAll(Map map);

    /**
     * 查询员工所在部门的所有同事信息
     *
     * @param map key 分别为 ：
     *            orderfield[排序列]
     *            orderdir[排序方向desc或asc]
     *            start[起始行]
     *            limit[每页显示条数]
     * @return List, 内容为Person对象列表
     */
    List<Person> findColleague(Map map);
}
