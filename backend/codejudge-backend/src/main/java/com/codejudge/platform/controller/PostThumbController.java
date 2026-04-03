package com.codejudge.platform.controller;

import com.codejudge.platform.common.BaseResponse;
import com.codejudge.platform.common.ErrorCode;
import com.codejudge.platform.common.ResultUtils;
import com.codejudge.platform.exception.BusinessException;
import com.codejudge.platform.model.dto.postthumb.PostThumbAddRequest;
import com.codejudge.platform.model.entity.User;
import com.codejudge.platform.service.PostThumbService;
import com.codejudge.platform.service.UserService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 甯栧瓙鐐硅禐鎺ュ彛
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
@RestController
@RequestMapping("/post_thumb")
@Slf4j
public class PostThumbController {

    @Resource
    private PostThumbService postThumbService;

    @Resource
    private UserService userService;

    /**
     * 鐐硅禐 / 鍙栨秷鐐硅禐
     *
     * @param postThumbAddRequest
     * @param request
     * @return resultNum 鏈鐐硅禐鍙樺寲鏁?
     */
    @PostMapping("/")
    public BaseResponse<Integer> doThumb(@RequestBody PostThumbAddRequest postThumbAddRequest,
            HttpServletRequest request) {
        if (postThumbAddRequest == null || postThumbAddRequest.getPostId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 鐧诲綍鎵嶈兘鐐硅禐
        final User loginUser = userService.getLoginUser(request);
        long postId = postThumbAddRequest.getPostId();
        int result = postThumbService.doPostThumb(postId, loginUser);
        return ResultUtils.success(result);
    }

}

