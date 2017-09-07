package org.loushang.framework.personmanagment.service.impl;

import org.loushang.framework.personmanagment.dao.PersonMapper;
import org.loushang.framework.personmanagment.data.Person;
import org.loushang.framework.personmanagment.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service层 实现类，用于业务逻辑处理，事务控制等
 *
 * Created by Traveler on 2017/8/4.
 */
@Service("personService")
public class PersonServiceImpl implements IPersonService {
    @Autowired
    PersonMapper personMapper;

    /**
     * 按条件查询全部员工信息
     *
     * @param map key 分别为 ：
     *            orderfield[排序列]
     *            orderdir[排序方向desc或asc]
     *            start[起始行]
     *            limit[每页显示条数]
     * @return List, 内容为Person对象
     */
    public List<Person> findAll(Map map) {
        System.out.println("map length:" + map.size());
        return personMapper.findAll(map);
    }

    /**
     * 查询一个员工的信息
     *
     * @param personId 员工编号
     * @return Person 员工信息
     */
    public Person findOne(int personId) {
        return personMapper.get(personId);
    }

    /**
     * 查询员工的同事信息
     *
     * @param id 员工编号
     * @return List, 内容为Person对象
     */
    public List<Person> findColleague(int id) {
        Person person = findOne(id);
        Map map = new HashMap();
        map.put("companyId", person.getCompanyId());
        List<Person> res = personMapper.findColleague(map);
        for (int i = 0, size = res.size(); i < size; i++) {
            if (person.getPersonId() == res.get(i).getPersonId()) {
                res.remove(i);
                break;
            }
        }
        return res;
    }
}
