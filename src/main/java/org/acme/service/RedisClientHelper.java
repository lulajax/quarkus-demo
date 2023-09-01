package org.acme.service;

import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisClientHelper {

    private final RedissonClient redissonClient;

    @Autowired
    public RedisClientHelper(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    public void setKey(String key, String value) {
        redissonClient.getBucket(key).set(value);
    }

    public String getValue(String key) {
        return (String) redissonClient.getBucket(key).get();
    }
}
