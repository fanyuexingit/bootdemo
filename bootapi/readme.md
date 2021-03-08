# springboot api

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
### lombok
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
### Swagger2 /swagger-ui.html
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