package com.sanwei.web.core.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
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
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @Author：SatanCY
 * @Date：2025/1/24 19:45
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
public class Knife4jConfig {

    @Bean(value = "dockerBean")
    public Docket dockerBean() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //分组名称
                .groupName("用户服务")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.sanwei"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }


    /**
     * 添加摘要信息
     */
    private ApiInfo apiInfo()
    {
        // 用ApiInfoBuilder进行定制
        return new ApiInfoBuilder()
                // 设置标题
                .title("三味管理系统_接口文档")
                // 描述
                .description("用于管理集团旗下公司的人员信息,具体包括XXX,XXX模块...")
                // 作者信息
//                .contact(new Contact(ruoyiConfig.getName(), null, null))
                .contact(new Contact("SanWei", null, null))
                // 版本
                .version("版本号:" + "0.0.1")
                .build();
    }
}
