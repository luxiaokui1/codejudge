package com.codejudge.platform.config;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.region.Region;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 鑵捐浜戝璞″瓨鍌ㄥ鎴风
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
@Configuration
@ConfigurationProperties(prefix = "cos.client")
@Data
public class CosClientConfig {

    /**
     * accessKey
     */
    private String accessKey;

    /**
     * secretKey
     */
    private String secretKey;

    /**
     * 鍖哄煙
     */
    private String region;

    /**
     * 妗跺悕
     */
    private String bucket;

    @Bean
    public COSClient cosClient() {
        // 鍒濆鍖栫敤鎴疯韩浠戒俊鎭?secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials(accessKey, secretKey);
        // 璁剧疆bucket鐨勫尯鍩? COS鍦板煙鐨勭畝绉拌鍙傜収 https://www.qcloud.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region(region));
        // 鐢熸垚cos瀹㈡埛绔?
        return new COSClient(cred, clientConfig);
    }
}
