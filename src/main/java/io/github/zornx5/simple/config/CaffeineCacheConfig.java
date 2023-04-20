package io.github.zornx5.simple.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * Caffeine 缓存配置
 *
 * @author zornx5
 */
@Configuration
@EnableCaching
@Slf4j
public class CaffeineCacheConfig {

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        caffeineCacheManager.setCaffeine(Caffeine.newBuilder().recordStats()
                .expireAfterWrite(Duration.ofSeconds(60))
                .maximumSize(1000));
        return caffeineCacheManager;
    }

}
