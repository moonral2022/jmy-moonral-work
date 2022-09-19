package com.moonral.work.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 江梦原
 * @date 2022-08-24
 */
public class SpringTest {

    public static void main(String[] args) {
        ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        Company company = (Company) cxt.getBean("beanId2");
        System.out.println(company);
    }

}
