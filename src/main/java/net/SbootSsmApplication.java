package net;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@tk.mybatis.spring.annotation.MapperScan(basePackages = "net.business.*.dao")
@SpringBootApplication
public class SbootSsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbootSsmApplication.class, args);
    }
}
