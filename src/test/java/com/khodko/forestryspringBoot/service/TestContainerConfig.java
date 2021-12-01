package com.khodko.forestryspringBoot.service;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.images.PullPolicy;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
public abstract class TestContainerConfig {

    private static final String IMAGE_VERSION = "postgres:11.1";
    public static PostgreSQLContainer<?> postgreDBContainer;

    static {
        postgreDBContainer = new PostgreSQLContainer<>(IMAGE_VERSION)
                .withImagePullPolicy(PullPolicy.alwaysPull());
        postgreDBContainer.start();
    }

    @DynamicPropertySource
    static void postgresqlProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgreDBContainer::getJdbcUrl);
        registry.add("spring.datasource.password", postgreDBContainer::getPassword);
        registry.add("spring.datasource.username", postgreDBContainer::getUsername);
    }
}
