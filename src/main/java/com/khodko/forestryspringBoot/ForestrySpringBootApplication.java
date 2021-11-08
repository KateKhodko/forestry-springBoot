package com.khodko.forestryspringBoot;


import com.khodko.forestryspringBoot.properties.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class ForestrySpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForestrySpringBootApplication.class, args);
    }
}
