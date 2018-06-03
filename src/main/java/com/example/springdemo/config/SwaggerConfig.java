package com.example.springdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: wangbao02
 * @CreateDate: 2018/6/3 17:10
 * @Description:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createSwaggerApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.springdemo.controller"))
                .paths(PathSelectors.any())
                .build();
    }



    private ApiInfo apiInfo(){
        return  new ApiInfoBuilder()
                .title("springboot项目开发脚手架")
                .description("Swagger接口文档")
                .contact("基于springboot搭建的开发环境脚手架")
                .version("1.0")
                .build();
    }
}
