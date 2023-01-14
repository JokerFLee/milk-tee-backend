package top.jokeme.milktee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("top.jokeme.milktee.mapper")
@SpringBootApplication
public class MilkTeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MilkTeeApplication.class, args);
    }

}
