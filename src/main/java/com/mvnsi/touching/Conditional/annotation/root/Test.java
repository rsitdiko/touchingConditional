package com.mvnsi.touching.Conditional.annotation.root;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@EnableScheduling
@Service
public class Test {

    @Autowired
    private ApplicationContext context;

    @Scheduled(fixedDelay = 600000L)
    public void test() {

        try {

            System.out.println("------------------------------------------------------------------------------------");
            for (int i = 0; i < 10; i++) {
                CronTrigger cronTrigger = (CronTrigger) context.getBean("cronTrigger");
                System.out.printf("%12d    %s%n", cronTrigger.hashCode(), cronTrigger);
            }
            System.out.println("------------------------------------------------------------------------------------");


        } catch (NoSuchBeanDefinitionException e) {
            System.out.println("--------------------------------");
            System.out.println(e.getBeanName() + " не существует");
            System.out.println("--------------------------------");
        }

    }
}
