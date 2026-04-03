package com.codejudge.platform.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 棰樼洰
 * @TableName question
 */
@TableName(value ="question")
@Data
public class Question implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
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
     * 鏍囩鍒楄〃锛坖son 鏁扮粍锛?     */
    private String tags;

    /**
     * 棰樼洰绛旀
     */
    private String answer;

    /**
     * 棰樼洰鎻愪氦鏁?     */
    private Integer submitNum;

    /**
     * 棰樼洰閫氳繃鏁?     */
    private Integer acceptedNum;

    /**
     * 鍒ら鐢ㄤ緥锛坖son 鏁扮粍锛?     */
    private String judgeCase;

    /**
     * 鍒ら閰嶇疆锛坖son 瀵硅薄锛?     */
    private String judgeConfig;

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
     * 鏄惁鍒犻櫎
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
