package cn.wellt.config;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Value("${swagger2.enable}")
    private Boolean enable;

    //配置swagger参数
    @Bean
    public Docket apis(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("FastGo")
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .build()
                .apiInfo(apiInfo())
                .enable(enable);
    }

    //api基本信息
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Fastgo快速开发平台接口文档")
                .description("一个基于springboot的Java快速开发脚手架项目")
                .termsOfServiceUrl("https://github.com/jnchen/fastgo")
                .version("1.0")
                .build();
    }
}
