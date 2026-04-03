package com.codejudge.platform.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codejudge.platform.annotation.AuthCheck;
import com.codejudge.platform.common.BaseResponse;
import com.codejudge.platform.common.ErrorCode;
import com.codejudge.platform.common.ResultUtils;
import com.codejudge.platform.constant.UserConstant;
import com.codejudge.platform.exception.BusinessException;
import com.codejudge.platform.model.dto.question.QuestionQueryRequest;
import com.codejudge.platform.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.codejudge.platform.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.codejudge.platform.model.entity.Question;
import com.codejudge.platform.model.entity.QuestionSubmit;
import com.codejudge.platform.model.entity.User;
import com.codejudge.platform.model.vo.QuestionSubmitVO;
import com.codejudge.platform.service.QuestionSubmitService;
import com.codejudge.platform.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 棰樼洰鎻愪氦鎺ュ彛
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
@RestController
//@RequestMapping("/question_submit")
@Slf4j
@Deprecated
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

//    /**
//     * 鎻愪氦棰樼洰
//     *
//     * @param questionSubmitAddRequest
//     * @param request
//     * @return 鎻愪氦璁板綍鐨?id
//     */
//    @PostMapping("/")
//    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
//            HttpServletRequest request) {
//        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
//            throw new BusinessException(ErrorCode.PARAMS_ERROR);
//        }
//        // 鐧诲綍鎵嶈兘鐐硅禐
//        final User loginUser = userService.getLoginUser(request);
//        long questionSubmitId = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
//        return ResultUtils.success(questionSubmitId);
//    }
//
//    /**
//     * 鍒嗛〉鑾峰彇棰樼洰鎻愪氦鍒楄〃锛堥櫎浜嗙鐞嗗憳澶栵紝鏅€氱敤鎴峰彧鑳界湅鍒伴潪绛旀銆佹彁浜や唬鐮佺瓑鍏紑淇℃伅锛?//     *
//     * @param questionSubmitQueryRequest
//     * @param request
//     * @return
//     */
//    @PostMapping("/list/page")
//    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitByPage(@RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest,
//                                                                         HttpServletRequest request) {
//        long current = questionSubmitQueryRequest.getCurrent();
//        long size = questionSubmitQueryRequest.getPageSize();
//        // 浠庢暟鎹簱涓煡璇㈠師濮嬬殑棰樼洰鎻愪氦鍒嗛〉淇℃伅
//        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
//                questionSubmitService.getQueryWrapper(questionSubmitQueryRequest));
//        final User loginUser = userService.getLoginUser(request);
//        // 杩斿洖鑴辨晱淇℃伅
//        return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage, loginUser));
//    }


}

