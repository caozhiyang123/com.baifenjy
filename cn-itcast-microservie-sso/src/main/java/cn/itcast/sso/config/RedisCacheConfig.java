package cn.itcast.sso.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport{
    @Value("${spring.redis.host}")
    private  String redisHost;
 
    @Value("${spring.redis.port}")
    private  int redisPort;
 
    @Value("${spring.redis.password}")
    private  String password;
    
    @Value("${spring.redis.pool.max-wait}")
    private int maxWaitMillis;

    @Value("${spring.redis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.pool.max-active}")
    private int maxTotal;

    @Value("${spring.redis.pool.min-idle}")
    private int minIdle;

    @Value("${spring.redis.timeout}")
    private int timeout;
 
    @Bean
    @ConditionalOnMissingBean(name="shardedJedisPool")
    public ShardedJedisPool shardedJedisPool(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMinIdle(minIdle);
        
        ArrayList<JedisShardInfo> list = new ArrayList<JedisShardInfo>();
        JedisShardInfo jedisShardInfo = new JedisShardInfo(redisHost,redisPort);
        jedisShardInfo.setPassword(password);
        jedisShardInfo.setConnectionTimeout(timeout);
        
        list.add(jedisShardInfo);
        
        ShardedJedisPool shardedJedisPool = new ShardedJedisPool(jedisPoolConfig,new ArrayList<JedisShardInfo>());
        
        return  shardedJedisPool;
    }
}