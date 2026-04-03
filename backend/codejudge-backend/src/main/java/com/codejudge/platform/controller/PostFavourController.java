package com.codejudge.platform.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codejudge.platform.common.BaseResponse;
import com.codejudge.platform.common.ErrorCode;
import com.codejudge.platform.common.ResultUtils;
import com.codejudge.platform.exception.BusinessException;
import com.codejudge.platform.exception.ThrowUtils;
import com.codejudge.platform.model.dto.post.PostQueryRequest;
import com.codejudge.platform.model.dto.postfavour.PostFavourAddRequest;
import com.codejudge.platform.model.dto.postfavour.PostFavourQueryRequest;
import com.codejudge.platform.model.entity.Post;
import com.codejudge.platform.model.entity.User;
import com.codejudge.platform.model.vo.PostVO;
import com.codejudge.platform.service.PostFavourService;
import com.codejudge.platform.service.PostService;
import com.codejudge.platform.service.UserService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 甯栧瓙鏀惰棌鎺ュ彛
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
@RestController
@RequestMapping("/post_favour")
@Slf4j
public class PostFavourController {

    @Resource
    private PostFavourService postFavourService;

    @Resource
    private PostService postService;

    @Resource
    private UserService userService;

    /**
     * 鏀惰棌 / 鍙栨秷鏀惰棌
     *
     * @param postFavourAddRequest
     * @param request
     * @return resultNum 鏀惰棌鍙樺寲鏁?
     */
    @PostMapping("/")
    public BaseResponse<Integer> doPostFavour(@RequestBody PostFavourAddRequest postFavourAddRequest,
            HttpServletRequest request) {
        if (postFavourAddRequest == null || postFavourAddRequest.getPostId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 鐧诲綍鎵嶈兘鎿嶄綔
        final User loginUser = userService.getLoginUser(request);
        long postId = postFavourAddRequest.getPostId();
        int result = postFavourService.doPostFavour(postId, loginUser);
        return ResultUtils.success(result);
    }

    /**
     * 鑾峰彇鎴戞敹钘忕殑甯栧瓙鍒楄〃
     *
     * @param postQueryRequest
     * @param request
     */
    @PostMapping("/my/list/page")
    public BaseResponse<Page<PostVO>> listMyFavourPostByPage(@RequestBody PostQueryRequest postQueryRequest,
            HttpServletRequest request) {
        if (postQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User loginUser = userService.getLoginUser(request);
        long current = postQueryRequest.getCurrent();
        long size = postQueryRequest.getPageSize();
        // 闄愬埗鐖櫕
        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR);
        Page<Post> postPage = postFavourService.listFavourPostByPage(new Page<>(current, size),
                postService.getQueryWrapper(postQueryRequest), loginUser.getId());
        return ResultUtils.success(postService.getPostVOPage(postPage, request));
    }

    /**
     * 鑾峰彇鐢ㄦ埛鏀惰棌鐨勫笘瀛愬垪琛?
     *
     * @param postFavourQueryRequest
     * @param request
     */
    @PostMapping("/list/page")
    public BaseResponse<Page<PostVO>> listFavourPostByPage(@RequestBody PostFavourQueryRequest postFavourQueryRequest,
            HttpServletRequest request) {
        if (postFavourQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        long current = postFavourQueryRequest.getCurrent();
        long size = postFavourQueryRequest.getPageSize();
        Long userId = postFavourQueryRequest.getUserId();
        // 闄愬埗鐖櫕
        ThrowUtils.throwIf(size > 20 || userId == null, ErrorCode.PARAMS_ERROR);
        Page<Post> postPage = postFavourService.listFavourPostByPage(new Page<>(current, size),
                postService.getQueryWrapper(postFavourQueryRequest.getPostQueryRequest()), userId);
        return ResultUtils.success(postService.getPostVOPage(postPage, request));
    }
}

