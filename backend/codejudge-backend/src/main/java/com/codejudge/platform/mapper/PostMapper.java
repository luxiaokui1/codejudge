package com.codejudge.platform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codejudge.platform.model.entity.Post;
import java.util.Date;
import java.util.List;

/**
 * 甯栧瓙鏁版嵁搴撴搷浣?
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
public interface PostMapper extends BaseMapper<Post> {

    /**
     * 鏌ヨ甯栧瓙鍒楄〃锛堝寘鎷凡琚垹闄ょ殑鏁版嵁锛?
     */
    List<Post> listPostWithDelete(Date minUpdateTime);

}





