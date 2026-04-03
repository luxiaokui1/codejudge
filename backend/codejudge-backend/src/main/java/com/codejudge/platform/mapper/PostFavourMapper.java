package com.codejudge.platform.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codejudge.platform.model.entity.Post;
import com.codejudge.platform.model.entity.PostFavour;
import org.apache.ibatis.annotations.Param;

/**
 * 甯栧瓙鏀惰棌鏁版嵁搴撴搷浣?
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
public interface PostFavourMapper extends BaseMapper<PostFavour> {

    /**
     * 鍒嗛〉鏌ヨ鏀惰棌甯栧瓙鍒楄〃
     *
     * @param page
     * @param queryWrapper
     * @param favourUserId
     * @return
     */
    Page<Post> listFavourPostByPage(IPage<Post> page, @Param(Constants.WRAPPER) Wrapper<Post> queryWrapper,
            long favourUserId);

}





