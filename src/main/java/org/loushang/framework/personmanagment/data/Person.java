package org.loushang.framework.personmanagment.data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Person Bean
 *
 * Created by Traveler on 2017/8/4.
 */

@Table(name = "demo_person")
public class Person {
    @Id
    @Column(name = "person_id")
    private int personId;
    @Column(name = "person_name")
    private String personName;
    @Column(name = "person_num")
    private String personNum;
    @Column(name = "person_sex")
    private String personSex;
    @Column(name = "person_age")
    private int personAge;
    @Column(name = "person_birth")
    private String personBirth;
    @Column(name = "person_address")
    private String personAddress;
    @Column(name = "company_id")
    private int companyId;
    @Column(name = "company_name")
    private String companyName;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonNum() {
        return personNum;
    }

    public void setPersonNum(String personNum) {
        this.personNum = personNum;
    }

    public String getPersonSex() {
        return personSex;
    }

    public void setPersonSex(String personSex) {
        this.personSex = personSex;
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }

    public String getPersonBirth() {
        return personBirth;
    }

    public void setPersonBirth(String personBirth) {
        this.personBirth = personBirth;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
