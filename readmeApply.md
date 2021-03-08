### RESTful API
```text
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

@Controller
@RestController：相当于@Controller + @ResponseBody， Spring4之后加入的注解，默认返回json，
@RequestMapping：配置url映射,GetMapping、PostMapping、DeleteMapping、PutMapping
@GetMapping: 相当于@RequestMapping(method = RequestMethod.GET)

```
lombok
```text
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
</dependency>

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
```
### 单元测试
```text
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <scope>test</scope>
</dependency>

@RunWith(SpringRunner.class)
@SpringBootTest

MockMvcBuilders
RequestBuilder
```
### devtools
```text
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <optional>true</optional>
</dependency>
```
### Swagger2
```text
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
</dependency>
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>
或
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>

@Api(value = "用户操作接口")
@ApiOperation(value = "获取users", notes="获取users notes")
@ApiModel(description="用户实体")
@ApiModelProperty("用户编号")
@ApiImplicitParam

Docket
ApiInfo
```
### JSR-303 校验
```text
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
或
<dependency>
  <groupId>org.hibernate.validator</groupId>
  <artifactId>hibernate-validator</artifactId>
  <version>6.1.7.Final</version>
  <scope>compile</scope>
</dependency>

@Valid
@NotNull
@Size(min = 2, max = 5)
@Max(100)
@Min(10)
@Email
```
### JdbcTemplate 简化原生jdbc
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
### 数据源 Hikari springboot默认数据源
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
### spring-boot-starter-data-jpa
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
### RESTful API