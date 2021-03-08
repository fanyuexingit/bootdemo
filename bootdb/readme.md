# springboot db

### boot jdbc 框架  JdbcTemplate 简化原生jdbc
```text
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
Spring Boot提供自动配置的嵌入式数据库有 H2、HSQL、Derby，你不需要提供任何连接配置就能使用。
<dependency>
    <groupId>org.hsqldb</groupId>
    <artifactId>hsqldb</artifactId>
    <scope>runtime</scope>
</dependency>

jdbcTemplate.execute()
jdbcTemplate.update()
jdbcTemplate.queryXXX()
```
### 数据源 Hikari springboot 默认数据源
```text
# 数据源 hikari
spring.datasource.hikari.minimum-idle=10
spring.datasource.hikari.maximum-pool-size=20
spring.datasource.hikari.idle-timeout=500000
spring.datasource.hikari.max-lifetime=540000
spring.datasource.hikari.connection-timeout=60000
spring.datasource.hikari.connection-test-query=SELECT 1
```
### 数据源 druid
```text
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid-spring-boot-starter</artifactId>
    <version>1.1.21</version>
</dependency>

# 数据源 druid
spring.datasource.druid.initialSize=10
spring.datasource.druid.maxActive=20
spring.datasource.druid.maxWait=60000
spring.datasource.druid.minIdle=1
spring.datasource.druid.timeBetweenEvictionRunsMillis=60000
spring.datasource.druid.minEvictableIdleTimeMillis=300000
spring.datasource.druid.testWhileIdle=true
spring.datasource.druid.testOnBorrow=true
spring.datasource.druid.testOnReturn=false
spring.datasource.druid.poolPreparedStatements=true
spring.datasource.druid.maxOpenPreparedStatements=20
spring.datasource.druid.validationQuery=SELECT 1
spring.datasource.druid.validation-query-timeout=500
spring.datasource.druid.filters=stat
# 数据源 druid 监控
spring.datasource.druid.stat-view-servlet.enabled=true
spring.datasource.druid.stat-view-servlet.url-pattern=/druid/*
spring.datasource.druid.stat-view-servlet.reset-enable=true
spring.datasource.druid.stat-view-servlet.login-username=admin
spring.datasource.druid.stat-view-servlet.login-password=admin
```
### 整合 data-jpa 框架
```text
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>


spring.jpa.properties.hibernate.hbm2ddl.auto=create

spring.jpa.properties.hibernate.hbm2ddl.auto是hibernate的配置属性，其主要作用是：自动创建、更新、验证数据库表结构。该参数的几种配置如下：
create：每次加载hibernate时都会删除上一次的生成的表，然后根据你的model类再重新来生成新表，哪怕两次没有任何改变也要这样执行，这就是导致数据库表数据丢失的一个重要原因。
create-drop：每次加载hibernate时根据model类生成表，但是sessionFactory一关闭,表就自动删除。
update：最常用的属性，第一次加载hibernate时根据model类会自动建立起表的结构（前提是先建立好数据库），以后加载hibernate时根据model类自动更新表结构，即使表结构改变了但表中的行仍然存在不会删除以前的行。要注意的是当部署到服务器后，表结构是不会被马上建立起来的，是要等应用第一次运行起来后才会。
validate：每次加载hibernate时，验证创建数据库表结构，只会和数据库中的表进行比较，不会创建新表，但是会插入新值。


@Entity
@Id
@GeneratedValue

@Entity注解标识了User类是一个持久化的实体
@Data和@NoArgsConstructor是Lombok中的注解。用来自动生成各参数的Set、Get函数以及不带参数的构造函数。如果您对Lombok还不了解，可以看看这篇文章：Java开发神器Lombok的使用与原理
@Id和@GeneratedValue用来标识User对应对应数据库表中的主键


public interface UserRepository extends JpaRepository<User, Long>{}

可以通过解析方法名创建查询
可以通过使用@Query 注解来创建查询，您只需要编写JPQL语句，并通过类似“:name”来映射@Param指定的参数
@Modifying操作、分页排序、原生SQL支持以及与Spring MVC的结合等等
......

```
### 整合 mybatis 框架
```text
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>2.1.1</version>
</dependency>

@Mapper
@Select
@Insert
@Update
@Delete

使用@Param传参
@Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
int insert(@Param("name") String name, @Param("age") Integer age);

使用Map<String, Object>对象来作为传递参数的容器
@Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
int insertByMap(Map<String, Object> map);

使用普通的Java对象
@Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
int insertByUser(User user);

返回结果绑定
需要返回一个与数据库实体不同的包装类，就可以通过@Results和@Result注解来进行绑定

```
### springboot 中 JDBC JPA Mybatis 的多数据源配置
```text
看代码
```
### @Transactional
```text
在Spring Boot中，当我们使用了spring-boot-starter-jdbc或spring-boot-starter-data-jpa依赖的时候，
框架会自动默认分别注入DataSourceTransactionManager或JpaTransactionManager。
所以我们不需要任何额外配置就可以用@Transactional注解进行事务的使用。

通常在service层接口中使用@Transactional来对各个业务逻辑进行事务管理的配置


@Transactional
@Rollback


在声明事务时，只需要通过value属性指定配置的事务管理器名即可，
例如：@Transactional(value="transactionManagerPrimary")

```
```text
隔离级别
@Transactional(isolation = Isolation.DEFAULT)
DEFAULT：这是默认值，表示使用底层数据库的默认隔离级别。对大部分数据库而言，通常这值就是：READ_COMMITTED。
READ_UNCOMMITTED：该隔离级别表示一个事务可以读取另一个事务修改但还没有提交的数据。该级别不能防止脏读和不可重复读，因此很少使用该隔离级别。
READ_COMMITTED：该隔离级别表示一个事务只能读取另一个事务已经提交的数据。该级别可以防止脏读，这也是大多数情况下的推荐值。
REPEATABLE_READ：该隔离级别表示一个事务在整个过程中可以多次重复执行某个查询，并且每次返回的记录都相同。即使在多次查询之间有新增的数据满足该查询，这些新增的记录也会被忽略。该级别可以防止脏读和不可重复读。
SERIALIZABLE：所有的事务依次逐个执行，这样事务之间就完全不可能产生干扰，也就是说，该级别可以防止脏读、不可重复读以及幻读。但是这将严重影响程序的性能。通常情况下也不会用到该级别。
```
```text
传播行为
@Transactional(propagation = Propagation.REQUIRED)
REQUIRED：如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。
SUPPORTS：如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。
MANDATORY：如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。
REQUIRES_NEW：创建一个新的事务，如果当前存在事务，则把当前事务挂起。
NOT_SUPPORTED：以非事务方式运行，如果当前存在事务，则把当前事务挂起。
NEVER：以非事务方式运行，如果当前存在事务，则抛出异常。
NESTED：如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；如果当前没有事务，则该取值等价于REQUIRED。

```




