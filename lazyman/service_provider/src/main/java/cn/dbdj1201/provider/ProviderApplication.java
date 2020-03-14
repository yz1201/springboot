package cn.dbdj1201.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("cn.dbdj1201.provider.mapper")
@EnableDiscoveryClient//启用eureka客户端 netflix 提供的@EnableEurekaClient，前边是SpringCloud原生
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

}
