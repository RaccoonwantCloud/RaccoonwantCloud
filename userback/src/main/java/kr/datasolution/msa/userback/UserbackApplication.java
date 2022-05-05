package kr.datasolution.msa.userback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UserbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserbackApplication.class, args);
    }

}
