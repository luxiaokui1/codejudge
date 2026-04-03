package com.codejudge.sandbox.unsafe;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * 鍚戞湇鍔″櫒鍐欐枃浠讹紙妞嶅叆鍗遍櫓绋嬪簭锛? */
public class WriteFileError {

    public static void main(String[] args) throws InterruptedException, IOException {
        String userDir = System.getProperty("user.dir");
        String filePath = userDir + File.separator + "src/main/resources/鏈ㄩ┈绋嬪簭.bat";
        String errorProgram = "java -version 2>&1";
        Files.write(Paths.get(filePath), Arrays.asList(errorProgram));
        System.out.println("鍐欐湪椹垚鍔燂紝浣犲畬浜嗗搱鍝?);
    }
}

