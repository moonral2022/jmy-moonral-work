package com.moonral.work.spring;

/**
 * @author 江梦原
 * @date 2022-08-24
 */
public class Employee {
    private Integer id;

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
