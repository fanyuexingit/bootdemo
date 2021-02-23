# springboot

## 1. 自动装配原理
### 注解详解
```text
@SpringBootApplication
    @SpringBootConfiguration 声明为配置类
        @Configuration
            @Component
    @EnableAutoConfiguration 自动配置
        @AutoConfigurationPackage
            @Import(AutoConfigurationPackages.Registrar.class) 注册配置
        @Import(AutoConfigurationImportSelector.class) 选择配置：spring.factories
    @ComponentScan 扫描配置类
```
AutoConfigurationImportSelector 加载 /META-INF/spring.factories (spring-boot-autoconfigure) 里面所有的类
里面的类都有 @ConditionalOnXXX 当条件成立 springboot 才会让这个配置类自动生效

### SpringApplication.run() 详解
1. 判断应用类型是普通项目还是web项目
2. 查找并加载所有可用初始化器，设置到initializers属性中
3. 找出所有应用程序监听器，设置到listeners属性中
4. 推断并设置main方法的定义类，找到运行的主类

## 2. yml properties
### 作用
1. 覆盖自动配置
2. 自定义配置并注入值
    1. @ConfigurationProperties(prefix = "person")
    2. @PropertySource(value = "application.properties") + @Value("${name}")
    3. todo

### 优先级
bootstrap.yml
bootstrap.properties
application.yml
application.properties
### 对比
yml文件更灵活，更简单，支持数组等用法


