package kr.datasolution.msa.backemd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BackEmdApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackEmdApplication.class, args);
    }

}
