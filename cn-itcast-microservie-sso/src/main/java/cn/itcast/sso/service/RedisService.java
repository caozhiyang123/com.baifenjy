package cn.itcast.sso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Service
public class RedisService {

    @Autowired(required = false)
    private ShardedJedisPool shardedJedisPool;

    private interface Function<T> {
        T run(ShardedJedis shardedJedis);
    }

    private <T> T execute(Function<T> func) {
        ShardedJedis shardedJedis = null;
        try {
            // 从连接池中获取到jedis分片对象
            shardedJedis = shardedJedisPool.getResource();
            // 执行set
            return func.run(shardedJedis);
        } finally {
            if (shardedJedis != null) {
                // 关闭，检测连接是否有效，有效则重置后放回到连接池中，无效则销毁
                shardedJedis.close();
            }
        }
    }

    /**
     * 执行SET命令
     * 
     * @param key
     * @param value
     * @return
     */
    public String set(final String key, final String value) {
        return execute(new Function<String>() {
            @Override
            public String run(ShardedJedis shardedJedis) {
                return shardedJedis.set(key, value);
            }
        });
    }

    /**
     * 执行SETEX命令
     * 
     * @param key
     * @param value
     * @return
     */
    public String setex(final String key, final String value, final Integer seconds) {
        return execute(new Function<String>() {
            @Override
            public String run(ShardedJedis shardedJedis) {
                return shardedJedis.setex(key, seconds, value);
            }
        });
    }

    /**
     * 执行GET命令
     * 
     * @param key
     * @param value
     * @return
     */
    public String get(final String key) {
        return execute(new Function<String>() {
            @Override
            public String run(ShardedJedis shardedJedis) {
                return shardedJedis.get(key);
            }
        });
    }

    /**
     * 执行del命令
     * 
     * @param key
     * @param value
     * @return
     */
    public Long del(final String key) {
        return execute(new Function<Long>() {
            @Override
            public Long run(ShardedJedis shardedJedis) {
                return shardedJedis.del(key);
            }
        });
    }

    /**
     * 执行expire命令
     * 
     * @param key
     * @param value
     * @return
     */
    public Long expire(final String key, final Integer seconds) {
        return execute(new Function<Long>() {
            @Override
            public Long run(ShardedJedis shardedJedis) {
                return shardedJedis.expire(key, seconds);
            }
        });
    }
}
