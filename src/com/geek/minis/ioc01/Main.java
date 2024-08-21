package com.geek.minis.ioc01;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
        SuperMan man = (SuperMan) classPathXmlApplicationContext.getBean("superman");
        man.bang();
    }
}
