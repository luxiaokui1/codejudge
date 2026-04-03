package com.codejudge.platform.service;

import com.codejudge.platform.model.entity.PostThumb;
import com.baomidou.mybatisplus.extension.service.IService;
import com.codejudge.platform.model.entity.User;

/**
 * 甯栧瓙鐐硅禐鏈嶅姟
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
public interface PostThumbService extends IService<PostThumb> {

    /**
     * 鐐硅禐
     *
     * @param postId
     * @param loginUser
     * @return
     */
    int doPostThumb(long postId, User loginUser);

    /**
     * 甯栧瓙鐐硅禐锛堝唴閮ㄦ湇鍔★級
     *
     * @param userId
     * @param postId
     * @return
     */
    int doPostThumbInner(long userId, long postId);
}

