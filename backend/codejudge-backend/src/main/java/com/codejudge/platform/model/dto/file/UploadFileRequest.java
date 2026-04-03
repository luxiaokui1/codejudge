package com.codejudge.platform.model.dto.file;

import java.io.Serializable;
import lombok.Data;

/**
 * 鏂囦欢涓婁紶璇锋眰
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
@Data
public class UploadFileRequest implements Serializable {

    /**
     * 涓氬姟
     */
    private String biz;

    private static final long serialVersionUID = 1L;
}
