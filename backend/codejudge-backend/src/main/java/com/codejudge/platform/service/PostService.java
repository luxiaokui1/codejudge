package com.codejudge.platform.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.codejudge.platform.model.dto.post.PostQueryRequest;
import com.codejudge.platform.model.entity.Post;
import com.codejudge.platform.model.vo.PostVO;
import javax.servlet.http.HttpServletRequest;

/**
 * 甯栧瓙鏈嶅姟
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
public interface PostService extends IService<Post> {

    /**
     * 鏍￠獙
     *
     * @param post
     * @param add
     */
    void validPost(Post post, boolean add);

    /**
     * 鑾峰彇鏌ヨ鏉′欢
     *
     * @param postQueryRequest
     * @return
     */
    QueryWrapper<Post> getQueryWrapper(PostQueryRequest postQueryRequest);

    /**
     * 浠?ES 鏌ヨ
     *
     * @param postQueryRequest
     * @return
     */
    Page<Post> searchFromEs(PostQueryRequest postQueryRequest);

    /**
     * 鑾峰彇甯栧瓙灏佽
     *
     * @param post
     * @param request
     * @return
     */
    PostVO getPostVO(Post post, HttpServletRequest request);

    /**
     * 鍒嗛〉鑾峰彇甯栧瓙灏佽
     *
     * @param postPage
     * @param request
     * @return
     */
    Page<PostVO> getPostVOPage(Page<Post> postPage, HttpServletRequest request);
}

