package ru.lainer.springcore.ioc_container.annotation_based.value_pkg;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.lainer.springcore.ioc_container.annotation_based.value_pkg")
@PropertySource("classpath:application.properties")
public class ConfigValue {
}
