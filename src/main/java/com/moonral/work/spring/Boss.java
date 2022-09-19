package com.moonral.work.spring;

/**
 * @author 江梦原
 * @date 2022-08-24
 */
public class Boss extends Employee {


    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "title='" + title + '\'' +
                '}';
    }
}
