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
```text
AutoConfigurationImportSelector 加载 /META-INF/spring.factories (spring-boot-autoconfigure) 里面所有的类
所有的类都叫 XXXAutoConfiguration 每个类都会包括一些 bean 或 properties(XXXProperties)
所有的类都有 @ConditionalOnXXX 当条件成立 springboot 才会让这个配置类自动生效
可以通过 debug:true 启动项目 看哪些配置生效
```

### SpringApplication.run() 详解
1. 判断应用类型是普通项目还是web项目
2. 查找并加载所有可用初始化器，设置到initializers属性中
3. 找出所有应用程序监听器，设置到listeners属性中
4. 推断并设置main方法的定义类，找到运行的主类

## 2. yml & properties 文件
### 作用 
1. 覆盖自动配置
2. 自定义配置并注入值
    1. @ConfigurationProperties(prefix = "person")
    2. @PropertySource(value = "classpath:application.properties") + @Value("${name}")
    3. todo

|                       | @ConfigurationProperties  | @Value  |
| ---  | ---  | ---  |
|功能					|批量注入配置文件中的属性	    |一个个指定|
|松散绑定（松散语法）	    |支持						|不支持|
|SpEL					|不支持						|支持|
|JSR303数据校验			|支持						|不支持|
|复杂类型封装			    |支持						|不支持|

### 优先级
* boostrap 由父 ApplicationContext 加载，比 applicaton 优先加载
* boostrap 里面的属性不能被覆盖
* bootstrap.yml(properties)
* application.yml(properties)
* 注意：spring默认使用yml中的配置，要用传统的xml或properties配置，需要使用spring-boot-configuration-processor
### 对比
* yml文件更灵活，更简单，支持数组等用法
todo

## 3. 其他
* JSR303数据校验
@Validated
https://www.jianshu.com/p/554533f88370

* banner.txt

* 多环境配置，多文件，也可以单文件用---分隔


# springboot Web 开发
* 静态资源
```text
在springboot中，处理静态资源放在
1.使用webjar localhost:8080/webjars
2.目录public static resources /**
3.一般存放js,css等在static

优先级
resources > static(默认) > public

templates目录(需要模板引擎)
通过controller跳转 才能访问templates目录

```

* 模板引擎 thymeleaf
```text
语法
th:
```

* springMVC 配置原理
```text
springboot 中有很多 XXXConfiguration 帮助我们做拓展配置
创建配置类，实现该接口或继承该类，重写方法或注入bean
```





