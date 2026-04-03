package com.codejudge.platform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Knife4j 鎺ュ彛鏂囨。閰嶇疆
 * https://doc.xiaominfo.com/knife4j/documentation/get_start.html
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
@Configuration
@EnableSwagger2
@Profile({"dev", "test"})
public class Knife4jConfig {

    @Bean
    public Docket defaultApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("鎺ュ彛鏂囨。")
                        .description("yuoj-backend")
                        .version("1.0")
                        .build())
                .select()
                // 鎸囧畾 Controller 鎵弿鍖呰矾寰?
                .apis(RequestHandlerSelectors.basePackage("com.codejudge.platform.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
