package com.codejudge.platform.model.vo;

import cn.hutool.json.JSONUtil;
import com.codejudge.platform.judge.codesandbox.model.JudgeInfo;
import com.codejudge.platform.model.entity.QuestionSubmit;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * 棰樼洰鎻愪氦灏佽绫? * @TableName question
 */
@Data
public class QuestionSubmitVO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 缂栫▼璇█
     */
    private String language;

    /**
     * 鐢ㄦ埛浠ｇ爜
     */
    private String code;

    /**
     * 鍒ら淇℃伅
     */
    private JudgeInfo judgeInfo;

    /**
     * 鍒ら鐘舵€侊紙0 - 寰呭垽棰樸€? - 鍒ら涓€? - 鎴愬姛銆? - 澶辫触锛?     */
    private Integer status;

    /**
     * 棰樼洰 id
     */
    private Long questionId;

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
     * 鎻愪氦鐢ㄦ埛淇℃伅
     */
    private UserVO userVO;

    /**
     * 瀵瑰簲棰樼洰淇℃伅
     */
    private QuestionVO questionVO;

    /**
     * 鍖呰绫昏浆瀵硅薄
     *
     * @param questionSubmitVO
     * @return
     */
    public static QuestionSubmit voToObj(QuestionSubmitVO questionSubmitVO) {
        if (questionSubmitVO == null) {
            return null;
        }
        QuestionSubmit questionSubmit = new QuestionSubmit();
        BeanUtils.copyProperties(questionSubmitVO, questionSubmit);
        JudgeInfo judgeInfoObj = questionSubmitVO.getJudgeInfo();
        if (judgeInfoObj != null) {
            questionSubmit.setJudgeInfo(JSONUtil.toJsonStr(judgeInfoObj));
        }
        return questionSubmit;
    }

    /**
     * 瀵硅薄杞寘瑁呯被
     *
     * @param questionSubmit
     * @return
     */
    public static QuestionSubmitVO objToVo(QuestionSubmit questionSubmit) {
        if (questionSubmit == null) {
            return null;
        }
        QuestionSubmitVO questionSubmitVO = new QuestionSubmitVO();
        BeanUtils.copyProperties(questionSubmit, questionSubmitVO);
        String judgeInfoStr = questionSubmit.getJudgeInfo();
        questionSubmitVO.setJudgeInfo(JSONUtil.toBean(judgeInfoStr, JudgeInfo.class));
        return questionSubmitVO;
    }

    private static final long serialVersionUID = 1L;
}
