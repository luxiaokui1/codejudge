package com.codejudge.platform.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 鍏ㄥ眬璺ㄥ煙閰嶇疆
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 瑕嗙洊鎵€鏈夎姹?
        registry.addMapping("/**")
                // 鍏佽鍙戦€?Cookie
                .allowCredentials(true)
                // 鏀捐鍝簺鍩熷悕锛堝繀椤荤敤 patterns锛屽惁鍒?* 浼氬拰 allowCredentials 鍐茬獊锛?
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .exposedHeaders("*");
    }
}

