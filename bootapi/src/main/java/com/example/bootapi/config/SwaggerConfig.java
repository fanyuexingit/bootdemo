/**
 * @description:
 * @author: Andy
 * @time: 2021/03/04 16:18
 */
package com.example.bootapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by fanyuexin on 2021/03/04
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){

        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("whatever")
                .contact(new Contact("fanyuexin", "fanyuexin", "13588888888@163.com"))
                .version("v1.0")
                .description("API 描述")
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.bootapi.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
