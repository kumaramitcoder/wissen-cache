# Wissen Cache

This projects holds the wissen cache starter plus examples of using wissen cache starter with cache servers like Redis, Memcache & Hazelcast...etc.

## Modules
1. Wissen Cache Starter
2. Wissen Redis Cache Example
3. Wissen Memcache Cache Example

### 1. Wissen Cache Starter (wissen-cache-starter)
It has cache abstraction layer built on top of Spring Cache Abstraction (spring-boot-starter-cache).

Wissen cache starter has logics to implement cache configs for Redis as well according to provided properties in application.properties file.

Wissen cache starter also has logic to save/get/remove cache from cache servers.

### 2. Wissen Redis Cache Example (wissen-redis-cache-example)
Redis cache example has application.properties with redis cluster configurations plus using 'Wissen Cache Starter' as dependency.
Docker composer helps to bring redis 6 servers up with replicas as 1 (means 3 master nodes & 3 replica nodes).

### 3. Wissen Memcache Cache Example (wissen-memcache-cache-example)
Memcache cache example has application.properties with Memcache cluster configurations plus using 'Wissen Cache Starter' as dependency.


## Spring Boot Compatibility

| Module Name | Spring Boot Version | Minimum Java Version |
| --- | :---: | :---: |
| wissen-cache-starter | 2.7.9 | 1.8 |
| wissen-redis-cache-example | 2.7.9 | 1.8 |
| wissen-memcache-cache-example | 2.1.8-RELEASE | 1.8 |
