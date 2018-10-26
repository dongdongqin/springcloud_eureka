package com.didispace.web;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;

/**
 * Created by dongdongqin on 2018-09-22.
 */
@Component
public class TestValue implements ApplicationContextAware {

    @Override
    @SuppressWarnings("unchecked")
    public void setApplicationContext(ApplicationContext context) throws BeansException {

        System.out.println("requiredInjectValue2 is ");
        System.out.println("requiredInjectValue3 is " +context.getBeansWithAnnotation(RestController.class).values());

        context.getBeansWithAnnotation(RestController.class).values().forEach(restcontroller
                ->{

            System.out.println("requiredInjectValue2 is ");
            System.out.println(restcontroller.getClass().getDeclaredFields());
            Field[] fields = restcontroller.getClass().getDeclaredFields();
            for(int i = 0; i < fields.length; i++ ) {
                fields[i].setAccessible(true);
                Value valueFrom = fields[i].getAnnotation(Value.class);
                System.out.println("requiredInjectValue2 is " + valueFrom);
                if(valueFrom != null) {
                    String requiredInjectValue = valueFrom.value();
                    System.out.println("requiredInjectValue is " + requiredInjectValue);
                    try {
                        fields[i].set(restcontroller, "hello");
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                }

            }

        });

    }

}
