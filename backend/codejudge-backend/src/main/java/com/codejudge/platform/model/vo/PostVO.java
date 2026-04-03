package com.codejudge.platform.model.vo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.codejudge.platform.model.entity.Post;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * 甯栧瓙瑙嗗浘
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
@Data
public class PostVO implements Serializable {

    private final static Gson GSON = new Gson();

    /**
     * id
     */
    private Long id;

    /**
     * 鏍囬
     */
    private String title;

    /**
     * 鍐呭
     */
    private String content;

    /**
     * 鐐硅禐鏁?
     */
    private Integer thumbNum;

    /**
     * 鏀惰棌鏁?
     */
    private Integer favourNum;

    /**
     * 鍒涘缓鐢ㄦ埛 id
     */
    private Long userId;

    /**
     * 鍒涘缓鏃堕棿
     */
    private Date createTime;

    /**
     * 鏇存柊鏃堕棿
     */
    private Date updateTime;

    /**
     * 鏍囩鍒楄〃
     */
    private List<String> tagList;

    /**
     * 鍒涘缓浜轰俊鎭?
     */
    private UserVO user;

    /**
     * 鏄惁宸茬偣璧?
     */
    private Boolean hasThumb;

    /**
     * 鏄惁宸叉敹钘?
     */
    private Boolean hasFavour;

    /**
     * 鍖呰绫昏浆瀵硅薄
     *
     * @param postVO
     * @return
     */
    public static Post voToObj(PostVO postVO) {
        if (postVO == null) {
            return null;
        }
        Post post = new Post();
        BeanUtils.copyProperties(postVO, post);
        List<String> tagList = postVO.getTagList();
        if (tagList != null) {
            post.setTags(GSON.toJson(tagList));
        }
        return post;
    }

    /**
     * 瀵硅薄杞寘瑁呯被
     *
     * @param post
     * @return
     */
    public static PostVO objToVo(Post post) {
        if (post == null) {
            return null;
        }
        PostVO postVO = new PostVO();
        BeanUtils.copyProperties(post, postVO);
        postVO.setTagList(GSON.fromJson(post.getTags(), new TypeToken<List<String>>() {
        }.getType()));
        return postVO;
    }
}

