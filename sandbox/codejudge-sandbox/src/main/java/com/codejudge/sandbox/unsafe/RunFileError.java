package com.codejudge.sandbox.unsafe;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 杩愯鍏朵粬绋嬪簭锛堟瘮濡傚嵄闄╂湪椹級
 */
public class RunFileError {

    public static void main(String[] args) throws InterruptedException, IOException {
        String userDir = System.getProperty("user.dir");
        String filePath = userDir + File.separator + "src/main/resources/鏈ㄩ┈绋嬪簭.bat";
        Process process = Runtime.getRuntime().exec(filePath);
        process.waitFor();
        // 鍒嗘壒鑾峰彇杩涚▼鐨勬甯歌緭鍑?        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        // 閫愯璇诲彇
        String compileOutputLine;
        while ((compileOutputLine = bufferedReader.readLine()) != null) {
            System.out.println(compileOutputLine);
        }
        System.out.println("鎵ц寮傚父绋嬪簭鎴愬姛");
    }
}

