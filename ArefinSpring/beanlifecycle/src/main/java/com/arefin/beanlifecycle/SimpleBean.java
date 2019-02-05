package com.arefin.beanlifecycle;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBean {
    private final String DEFAULT_NAME = "Safayat Arefin";
    String name = null;
    private int age = Integer.MIN_VALUE;

    public String getDEFAULT_NAME() {
        return DEFAULT_NAME;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SimpleBean{" +
                "DEFAULT_NAME='" + DEFAULT_NAME + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void init(){
        System.out.println("Initializing bean");
        if(name == null){
            System.out.println("using default name");
            name = DEFAULT_NAME;
        }

        if(age == Integer.MIN_VALUE){
            throw new IllegalArgumentException("You must set the age property of any beans of type " + SimpleBean.class);
        }
    }

    private static SimpleBean getBean(String beanName, ApplicationContext context){
        try {
            SimpleBean simpleBean = (SimpleBean) context.getBean(beanName);
            System.out.println(simpleBean);
            return simpleBean;
        }catch (BeanCreationException e){
            System.out.println("An error occured in bean configuration: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:beanConfig.xml");
        context.refresh();

        SimpleBean simpleBean1 = getBean("sb1", context);
        SimpleBean simpleBean2 = getBean("sb2", context);
    }
}
