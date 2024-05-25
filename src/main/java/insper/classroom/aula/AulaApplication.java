package insper.classroom.aula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cache.annotation.EnableCaching;


@EnableDiscoveryClient
@SpringBootApplication
@EnableCaching
public class AulaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AulaApplication.class, args);
    }
    
}
