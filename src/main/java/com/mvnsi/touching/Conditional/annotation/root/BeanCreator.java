package com.mvnsi.touching.Conditional.annotation.root;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanCreator {

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public PropertiesManager propertiesManager() {
        PropertiesManager propertiesManager = new PropertiesManager();
        propertiesManager.setType(TriggerType.CRON);
        return propertiesManager;
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @ConditionalOnExpression("propertiesManager.type.name() == 'CRON'")
    public CronTrigger cronTrigger() {
        CronTrigger cronTrigger = new CronTrigger();
        return cronTrigger;
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @ConditionalOnExpression("propertiesManager.type.name() == 'SIMPLE'")
    public SimpleTrigger simpleTrigger() {
        SimpleTrigger simpleTrigger = new SimpleTrigger();
        System.out.println("ASDF");
        return simpleTrigger;
    }

}
