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
### RESTful API
### RESTful API