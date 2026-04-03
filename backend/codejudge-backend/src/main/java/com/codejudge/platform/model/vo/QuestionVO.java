package com.codejudge.platform.model.vo;

import cn.hutool.json.JSONUtil;
import com.google.gson.reflect.TypeToken;
import com.codejudge.platform.model.dto.question.JudgeConfig;
import com.codejudge.platform.model.entity.Question;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 棰樼洰灏佽绫? * @TableName question
 */
@Data
public class QuestionVO implements Serializable {
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
     * 鏍囩鍒楄〃
     */
    private List<String> tags;

    /**
     * 棰樼洰鎻愪氦鏁?     */
    private Integer submitNum;

    /**
     * 棰樼洰閫氳繃鏁?     */
    private Integer acceptedNum;

    /**
     * 鍒ら閰嶇疆锛坖son 瀵硅薄锛?     */
    private JudgeConfig judgeConfig;

    /**
     * 鐐硅禐鏁?     */
    private Integer thumbNum;

    /**
     * 鏀惰棌鏁?     */
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
     * 鍒涘缓棰樼洰浜虹殑淇℃伅
     */
    private UserVO userVO;

    /**
     * 鍖呰绫昏浆瀵硅薄
     *
     * @param questionVO
     * @return
     */
    public static Question voToObj(QuestionVO questionVO) {
        if (questionVO == null) {
            return null;
        }
        Question question = new Question();
        BeanUtils.copyProperties(questionVO, question);
        List<String> tagList = questionVO.getTags();
        if (tagList != null) {
            question.setTags(JSONUtil.toJsonStr(tagList));
        }
        JudgeConfig voJudgeConfig = questionVO.getJudgeConfig();
        if (voJudgeConfig != null) {
            question.setJudgeConfig(JSONUtil.toJsonStr(voJudgeConfig));
        }
        return question;
    }

    /**
     * 瀵硅薄杞寘瑁呯被
     *
     * @param question
     * @return
     */
    public static QuestionVO objToVo(Question question) {
        if (question == null) {
            return null;
        }
        QuestionVO questionVO = new QuestionVO();
        BeanUtils.copyProperties(question, questionVO);
        List<String> tagList = JSONUtil.toList(question.getTags(), String.class);
        questionVO.setTags(tagList);
        String judgeConfigStr = question.getJudgeConfig();
        questionVO.setJudgeConfig(JSONUtil.toBean(judgeConfigStr, JudgeConfig.class));
        return questionVO;
    }

    private static final long serialVersionUID = 1L;
}
