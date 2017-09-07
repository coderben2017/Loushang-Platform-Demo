package org.loushang.framework.personmanagment.service.impl;

import org.loushang.framework.personmanagment.dao.CompanyMapper;
import org.loushang.framework.personmanagment.data.Company;
import org.loushang.framework.personmanagment.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service层 实现类，用于业务逻辑处理，事务控制等
 *
 * Created by Traveler on 2017/8/4.
 */
@Service("companyService")
public class CompanyServiceImpl implements ICompanyService {
    @Autowired
    CompanyMapper companyMapper;

    /**
     * 查询一个公司部门的信息
     *
     * @param companyId 公司部门编号
     * @return Company 公司部门信息
     */
    public Company findOne(int companyId) {
        return companyMapper.get(companyId);
    }
}
