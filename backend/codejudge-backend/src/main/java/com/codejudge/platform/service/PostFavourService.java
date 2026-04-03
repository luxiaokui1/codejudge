package com.codejudge.platform.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.codejudge.platform.model.entity.Post;
import com.codejudge.platform.model.entity.PostFavour;
import com.codejudge.platform.model.entity.User;

/**
 * 甯栧瓙鏀惰棌鏈嶅姟
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
public interface PostFavourService extends IService<PostFavour> {

    /**
     * 甯栧瓙鏀惰棌
     *
     * @param postId
     * @param loginUser
     * @return
     */
    int doPostFavour(long postId, User loginUser);

    /**
     * 鍒嗛〉鑾峰彇鐢ㄦ埛鏀惰棌鐨勫笘瀛愬垪琛?
     *
     * @param page
     * @param queryWrapper
     * @param favourUserId
     * @return
     */
    Page<Post> listFavourPostByPage(IPage<Post> page, Wrapper<Post> queryWrapper,
            long favourUserId);

    /**
     * 甯栧瓙鏀惰棌锛堝唴閮ㄦ湇鍔★級
     *
     * @param userId
     * @param postId
     * @return
     */
    int doPostFavourInner(long userId, long postId);
}

