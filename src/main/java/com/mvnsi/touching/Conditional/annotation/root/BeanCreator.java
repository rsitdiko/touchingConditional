package com.mvnsi.touching.Conditional.annotation.root;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanCreator {

    @Bean
    public PropertiesManager propertiesManager() {
        PropertiesManager propertiesManager = new PropertiesManager();
        propertiesManager.setType(TriggerType.SIMPLE);
        return propertiesManager;
    }

    @Bean
    @ConditionalOnBean(name = "propertiesManager")
    @ConditionalOnExpression("propertiesManager.type.name() == 'CRON'")
    public CronTrigger cronTrigger() {
        CronTrigger cronTrigger = new CronTrigger();
        return cronTrigger;
    }

    @Bean
    @ConditionalOnBean(name = "propertiesManager")
    @ConditionalOnExpression("propertiesManager.type.name() == 'SIMPLE'")
    public SimpleTrigger simpleTrigger() {
        SimpleTrigger simpleTrigger = new SimpleTrigger();
        return simpleTrigger;
    }
}
