package com.khodko.forestryspringBoot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
//@EnableScheduling
//@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableJpaRepositories(
        basePackages = "com.khodko.forestryspringBoot.repository", repositoryImplementationPostfix = "CustomImpl")
public class AppConfig {
}
