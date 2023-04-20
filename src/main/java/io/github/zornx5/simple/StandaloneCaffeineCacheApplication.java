package io.github.zornx5.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 独立的 Caffeine 缓存应用
 *
 * @author zornx5
 */
@SpringBootApplication
public class StandaloneCaffeineCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(StandaloneCaffeineCacheApplication.class, args);
    }

}
