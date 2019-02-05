package com.arefin.beanlifecycle4;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Employee {
    private Long id;
    private String position;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", position='" + position + '\'' +
                '}';
    }

    @PostConstruct
    public void initIt() throws Exception{
        System.out.println("Init method after properties are set: " + id + " " + position);
    }

    @PreDestroy
    public void destroy() throws  Exception{
        System.out.println("Spring Cleanup! Employee is cleaed up now");
    }

    /**
     * @PostConstruct and @PreDestroy annotations
     *
     *                The easiest way to control a bean’s lifecycle is by using the
     *                two lifecycle annotations above custom methods that will be
     *                invoked upon bean initialization and destruction.
     *
     *                The Employee bean has the same two methods that we created
     *                above, but now the @PostConstruct and @PreDestroy annotations
     *                are applied to the methods.
     */
}
