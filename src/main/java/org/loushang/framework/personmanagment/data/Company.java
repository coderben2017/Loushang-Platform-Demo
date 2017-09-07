package org.loushang.framework.personmanagment.data;

/**
 * Company Bean
 *
 * Created by Traveler on 2017/8/4.
 */

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "demo_company")
public class Company {
    @Id
    @Column(name = "company_id")
    private int companyId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "company_property")
    private String companyProperty;
    @Column(name = "company_num")
    private int companyNum;
    @Column(name = "income")
    private int income;
    @Column(name = "legal_representative")
    private String legalRepresentative;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyProperty() {
        return companyProperty;
    }

    public void setCompanyProperty(String companyProperty) {
        this.companyProperty = companyProperty;
    }

    public int getCompanyNum() {
        return companyNum;
    }

    public void setCompanyNum(int companyNum) {
        this.companyNum = companyNum;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }
}
