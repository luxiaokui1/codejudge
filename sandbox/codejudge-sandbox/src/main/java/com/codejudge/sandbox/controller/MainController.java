package com.codejudge.sandbox.controller;

import com.codejudge.sandbox.JavaNativeCodeSandbox;
import com.codejudge.sandbox.model.ExecuteCodeRequest;
import com.codejudge.sandbox.model.ExecuteCodeResponse;
import com.codejudge.sandbox.model.JudgeInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController("/")
public class MainController {

    private static final String AUTH_REQUEST_HEADER = "auth";
    private static final String AUTH_REQUEST_SECRET = "secretKey";

    @Resource
    private JavaNativeCodeSandbox javaNativeCodeSandbox;

    @GetMapping("/health")
    public String healthCheck() {
        return "ok";
    }

    @PostMapping("/executeCode")
    ExecuteCodeResponse executeCode(@RequestBody ExecuteCodeRequest executeCodeRequest,
                                    HttpServletRequest request,
                                    HttpServletResponse response) {
        String authHeader = request.getHeader(AUTH_REQUEST_HEADER);
        if (!AUTH_REQUEST_SECRET.equals(authHeader)) {
            response.setStatus(403);
            return null;
        }
        if (executeCodeRequest == null) {
            throw new RuntimeException("The execute code request cannot be null");
        }
        try {
            // The controller only validates and authenticates requests.
            // Compilation and execution stay inside the sandbox service layer.
            return javaNativeCodeSandbox.executeCode(executeCodeRequest);
        } catch (Throwable e) {
            // Return a structured failure so the backend can persist a readable judge result.
            response.setStatus(200);
            ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
            executeCodeResponse.setStatus(2);
            executeCodeResponse.setMessage(e.getMessage());
            executeCodeResponse.setJudgeInfo(new JudgeInfo());
            return executeCodeResponse;
        }
    }
}

