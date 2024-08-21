package com.geek.minis.ioc01;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext {

    private List<BeanDefinition> beanDefinitions = new ArrayList<>();
    private Map<String,Object> singletons = new HashMap<>();

    public ClassPathXmlApplicationContext(String xmlFileName) {
        this.readXml(xmlFileName);
        this.initBeans();
    }

    public void readXml(String fileName){
        SAXReader saxReader = new SAXReader();
        URL resource = this.getClass().getClassLoader().getResource(fileName);
        Document document = null;
        try {
            document = saxReader.read(resource);
            Element rootElement = document.getRootElement();
            List<Element> elements = rootElement.elements();
            for (Element element:elements){
                String id = element.attributeValue("id");
                String aClass = element.attributeValue("class");
                BeanDefinition definition = new BeanDefinition(id,aClass);
                beanDefinitions.add(definition);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public Object getBean(String beanName){
        return singletons.get(beanName);
    }

    private void initBeans(){
        for(BeanDefinition beanDefinition: beanDefinitions){
            try{
                singletons.put(beanDefinition.getId(),Class.forName(beanDefinition.getClassName()).newInstance());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

}
