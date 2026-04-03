package com.codejudge.platform.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 棰樼洰鎻愪氦
 * @TableName question_submit
 */
@TableName(value ="question_submit")
@Data
public class QuestionSubmit implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
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
     * 鍒ら淇℃伅锛坖son 瀵硅薄锛?     */
    private String judgeInfo;

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
     * 鏄惁鍒犻櫎
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
