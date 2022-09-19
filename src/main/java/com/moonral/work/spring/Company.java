package com.moonral.work.spring;

/**
 * @author 江梦原
 * @date 2022-08-24
 */
public class Company {

    // 特意把属性的名字做了改变。
    private Employee emp;
//
//    public Company(Employee emp){
//        this.emp = emp;
//    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    @Override
    public String toString() {
        return "Company{" +
                "employee=" + emp +
                '}';
    }

}
