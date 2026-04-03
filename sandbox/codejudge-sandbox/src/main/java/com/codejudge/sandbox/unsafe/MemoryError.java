package com.codejudge.sandbox.unsafe;

import java.util.ArrayList;
import java.util.List;

/**
 * 鏃犻檺鍗犵敤绌洪棿锛堟氮璐圭郴缁熷唴瀛橈級
 */
public class MemoryError {

    public static void main(String[] args) throws InterruptedException {
        List<byte[]> bytes = new ArrayList<>();
        while (true) {
            bytes.add(new byte[10000]);
        }
    }
}

