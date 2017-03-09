package com.hc.core.config;

import com.google.common.base.Predicate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by milk.huchan on 2017/3/9.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value("${spring.jersey.application-path}")
    private String apiPath;

    /**
     * 设置请求
     *
     * @return
     */
    public SecurityScheme apiKey(){
        return new ApiKey("access_token", "accessToken", "header");
    }

    @Bean
    public Docket apiConfig(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("controller").
                apiInfo(apiInfo()).select()
                // 控制暴露出去的路径下的实例
                // 如果某个接口不想暴露,可以使用以下注解
                // @ApiIgnore 这样,该接口就不会暴露在 swagger2 的页面下
                .apis(RequestHandlerSelectors.basePackage("com.hc.ws")).paths(PathSelectors.any())
                .build().useDefaultResponseMessages(false).securitySchemes(Arrays.asList(apiKey()));
    }

    @Bean
    public Docket restConfig(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("jax-rs").apiInfo(restInfo()).forCodeGeneration(true)
                .pathMapping("/").select().paths(paths())// 过滤的接口
                .build().useDefaultResponseMessages(false);
    }

    /**
     * 过滤路径
     *
     * @return 过滤路径正则表达式
     */
    private Predicate<String> paths(){
        return or(regex("/test/.*"), regex("/rest/.*")); //
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("milk平台API") //大标题
                .description("RestController API") //小标题
                .version("2.0").build();
    }

    private ApiInfo restInfo(){
        return new ApiInfoBuilder().title("milk平台API")
                .description("RestController API")
                .version("2.0").build();
    }
}
