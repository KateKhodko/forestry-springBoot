package com.khodko.forestryspringBoot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
}
