package org.acme.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;

@ApplicationScoped
public class RedissonConfig {

    @Value("${redisson.host}")
    private String host;
    @Value("${redisson.database}")
    private Integer database;
    @Value("${redisson.timeout}")
    private Integer timeout;

    @Produces
    @ApplicationScoped
    public RedissonClient createRedissonClient() {
        Config config = new Config();
        // 配置Redis连接等
        config.useSingleServer().setAddress(host).setDatabase(database).setTimeout(timeout);
        RedissonClient redissonClient = Redisson.create(config);
        return redissonClient;
    }
}