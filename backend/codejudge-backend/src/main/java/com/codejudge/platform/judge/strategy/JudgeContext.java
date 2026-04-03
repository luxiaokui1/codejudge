package com.codejudge.platform.judge.strategy;

import com.codejudge.platform.model.dto.question.JudgeCase;
import com.codejudge.platform.judge.codesandbox.model.JudgeInfo;
import com.codejudge.platform.model.entity.Question;
import com.codejudge.platform.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * 涓婁笅鏂囷紙鐢ㄤ簬瀹氫箟鍦ㄧ瓥鐣ヤ腑浼犻€掔殑鍙傛暟锛?
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;

}

