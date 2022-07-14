shiro-redis
=============

## Introduction

shiro only provide the support of ehcache and concurrentHashMap. Here is an implement of redis cache can be used by shiro. Hope it will help you!

## Documentation

Official documentation [is located here](http://alexxiyang.github.io/shiro-redis/).


## This is a fork of [alexxiyang/shiro-redis](https://github.com/alexxiyang/shiro-redis) to fix bugs and add some new features.
## Update
- 3.7.0 Update dependencies
 
   1、jedis -> 3.9.0
 
   2、lettuce-core -> 6.1.9.RELEASE
 
   3、shiro-core -> 1.9.1
 
 Maven
 ```xml
<dependency>
    <groupId>io.github.LiJunYi2</groupId>
    <artifactId>shiro-redis</artifactId>
    <version>3.7</version>
</dependency>
 ```
- 3.5.0  Add FstSerialize support.  
    Usage:  
    
    ```java
    @Bean
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        // custom session key prefix
        redisSessionDAO.setKeyPrefix(SESSION_KEY_PREFIX);
        // custom session value serializer, default is jdk serializer.
        redisSessionDAO.setValueSerializer(new FstSerializer());
        return redisSessionDAO;
    }
    ```
- 3.4.0  Add Lettuce redis client support.  
    Usage:  
    
    ```java
    @Bean
    public IRedisManager redisManager() {
        LettuceRedisManager manager = new LettuceRedisManager("127.0.0.1", 6379);
        manager.setDatabase(Integer.parseInt(database));
        // or: LettuceRedisManager manager = LettuceRedisManager.builder().host("127.0.0.1").port(6379).build();
        return manager;
    }
    ```
