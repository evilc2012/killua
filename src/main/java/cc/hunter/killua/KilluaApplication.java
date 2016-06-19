package cc.hunter.killua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Created by Administrator on 2016/6/15.
 */

@SpringBootApplication
public class KilluaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KilluaApplication.class, args);
    }

}
