package org.loushang.framework.personmanagment.service;

import org.loushang.framework.personmanagment.data.Company;

/**
 * Service层 接口类，用于业务逻辑处理，事务控制等
 *
 * Created by Traveler on 2017/8/4.
 */
public interface ICompanyService {
    /**
     * 查询一个公司部门信息
     *
     * @param companyId 部门编号
     * @return Company 部门信息
     */
    public Company findOne(int companyId);
}
