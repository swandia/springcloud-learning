package serviceribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient

//通过@EnableDiscoveryClient向服务中心注册，并向程序的ioc注入一个bean: restTemplate
@EnableDiscoveryClient

//开启Hystrix
@EnableHystrix
public class ServiceRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRibbonApplication.class, args);
    }

    @Bean
    //通过@LoadBalanced注解表明这个restTemplate开启负载均衡功能
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
