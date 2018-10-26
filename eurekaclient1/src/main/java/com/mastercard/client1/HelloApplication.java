package com.mastercard.client1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by dongdongqin on 2018-05-03.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class HelloApplication {

    public static void main(String[] args) {

        // priority is lower than the configuration
        new SpringApplicationBuilder(HelloApplication.class)
                    .properties("spring.application.name:hellokitty")
                    .web(true).
                    run(args);
        }

    }

