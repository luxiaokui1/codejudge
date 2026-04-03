package com.codejudge.sandbox.utils;

import cn.hutool.core.util.StrUtil;
import com.codejudge.sandbox.model.ExecuteMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.StopWatch;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 杩涚▼宸ュ叿绫? */
public class ProcessUtils {

    /**
     * 鎵ц杩涚▼骞惰幏鍙栦俊鎭?     *
     * @param runProcess
     * @param opName
     * @return
     */
    public static ExecuteMessage runProcessAndGetMessage(Process runProcess, String opName) {
        ExecuteMessage executeMessage = new ExecuteMessage();

        try {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            // 绛夊緟绋嬪簭鎵ц锛岃幏鍙栭敊璇爜
            int exitValue = runProcess.waitFor();
            executeMessage.setExitValue(exitValue);
            // 姝ｅ父閫€鍑?            if (exitValue == 0) {
                System.out.println(opName + "鎴愬姛");
                // 鍒嗘壒鑾峰彇杩涚▼鐨勬甯歌緭鍑?                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(runProcess.getInputStream()));
                List<String> outputStrList = new ArrayList<>();
                // 閫愯璇诲彇
                String compileOutputLine;
                while ((compileOutputLine = bufferedReader.readLine()) != null) {
                    outputStrList.add(compileOutputLine);
                }
                executeMessage.setMessage(StringUtils.join(outputStrList, "\n"));
            } else {
                // 寮傚父閫€鍑?                System.out.println(opName + "澶辫触锛岄敊璇爜锛?" + exitValue);
                // 鍒嗘壒鑾峰彇杩涚▼鐨勬甯歌緭鍑?                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(runProcess.getInputStream()));
                List<String> outputStrList = new ArrayList<>();
                // 閫愯璇诲彇
                String compileOutputLine;
                while ((compileOutputLine = bufferedReader.readLine()) != null) {
                    outputStrList.add(compileOutputLine);
                }
                executeMessage.setMessage(StringUtils.join(outputStrList, "\n"));

                // 鍒嗘壒鑾峰彇杩涚▼鐨勯敊璇緭鍑?                BufferedReader errorBufferedReader = new BufferedReader(new InputStreamReader(runProcess.getErrorStream()));
                // 閫愯璇诲彇
                List<String> errorOutputStrList = new ArrayList<>();
                // 閫愯璇诲彇
                String errorCompileOutputLine;
                while ((errorCompileOutputLine = errorBufferedReader.readLine()) != null) {
                    errorOutputStrList.add(errorCompileOutputLine);
                }
                executeMessage.setErrorMessage(StringUtils.join(errorOutputStrList, "\n"));
            }
            stopWatch.stop();
            executeMessage.setTime(stopWatch.getLastTaskTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return executeMessage;
    }

    /**
     * 鎵ц浜や簰寮忚繘绋嬪苟鑾峰彇淇℃伅
     *
     * @param runProcess
     * @param args
     * @return
     */
    public static ExecuteMessage runInteractProcessAndGetMessage(Process runProcess, String args) {
        ExecuteMessage executeMessage = new ExecuteMessage();

        try {
            // 鍚戞帶鍒跺彴杈撳叆绋嬪簭
            OutputStream outputStream = runProcess.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            String[] s = args.split(" ");
            String join = StrUtil.join("\n", s) + "\n";
            outputStreamWriter.write(join);
            // 鐩稿綋浜庢寜浜嗗洖杞︼紝鎵ц杈撳叆鐨勫彂閫?            outputStreamWriter.flush();

            // 鍒嗘壒鑾峰彇杩涚▼鐨勬甯歌緭鍑?            InputStream inputStream = runProcess.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder compileOutputStringBuilder = new StringBuilder();
            // 閫愯璇诲彇
            String compileOutputLine;
            while ((compileOutputLine = bufferedReader.readLine()) != null) {
                compileOutputStringBuilder.append(compileOutputLine);
            }
            executeMessage.setMessage(compileOutputStringBuilder.toString());
            // 璁板緱璧勬簮鐨勯噴鏀撅紝鍚﹀垯浼氬崱姝?            outputStreamWriter.close();
            outputStream.close();
            inputStream.close();
            runProcess.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return executeMessage;
    }
}

