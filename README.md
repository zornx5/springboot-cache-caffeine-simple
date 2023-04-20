# springboot caffeine 简单使用示例

## 依赖

```gradle
implementation 'org.springframework.boot:spring-boot-starter-cache'
implementation 'com.github.ben-manes.caffeine:caffeine'
```

## 重点

### 配置

[CaffeineCacheConfig.java](src%2Fmain%2Fjava%2Fio%2Fgithub%2Fzornx5%2Fsimple%2Fconfig%2FCaffeineCacheConfig.java)

1. 添加一个 `CacheManager` 的 `Bean`
2. 添加注解 `@EnableCaching` 启动缓存

### 正常的业务逻辑

1. 用户实体 [User.java](src%2Fmain%2Fjava%2Fio%2Fgithub%2Fzornx5%2Fsimple%2Fentity%2FUser.java)
2.
用于模拟用户数据存储的仓储文件 [UserRepository.java](src%2Fmain%2Fjava%2Fio%2Fgithub%2Fzornx5%2Fsimple%2Frepository%2FUserRepository.java)
3. 用户服务 [UserService.java](src%2Fmain%2Fjava%2Fio%2Fgithub%2Fzornx5%2Fsimple%2Fservice%2FUserService.java)
4. 用户接口 [UserRestResource.java](src%2Fmain%2Fjava%2Fio%2Fgithub%2Fzornx5%2Fsimple%2Frest%2FUserRestResource.java)

### 使用

[UserServiceImpl.java](src%2Fmain%2Fjava%2Fio%2Fgithub%2Fzornx5%2Fsimple%2Fservice%2FUserServiceImpl.java)

1. 在方法上使用注解 `@Caching` `@Cacheable` `@CachePut` `@CacheEvict`, 表示当前方法适用
2. 在类上使用 `@Cacheable` `@Caching`, 表示所有方法适用
3. `@Cacheable` 在执行后 Spring Cache 将缓存其返回结果
4. `@CachePut` 在方法执行前或者执行后更新 Spring Cache 中的某些元素
5. `@CacheEvict` 在方法执行前或者执行后移除 Spring Cache 中的某些元素
6. `@Caching` 可以组合上述注解
7. 上述注解中 key 属性是用来指定 Spring 缓存方法的返回结果时对应的 key 的。该属性支持 SpringEL 表达式。当我们没有指定该属性时，Spring
   将使用默认策略生成 key。
