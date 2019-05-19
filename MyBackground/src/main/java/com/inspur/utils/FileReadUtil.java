package com.inspur.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件操作工具类
 * 
 * @author xuehong
 * 
 */
@Slf4j
public final class FileReadUtil
{

    // 读一行数据的最大数据行数
    private static final int MAX_STR_LEN = 20000000;
    private static final int BUFFER_SIZE = 1024*1024;
    
    /**
     * 读数据安全处理
     * 
     * @param br5
     *            BufferedReader
     * @return 一行数据
     * @throws IOException
     *             输入输出异常
     */
    public static String readLine(BufferedReader br5)
        throws IOException
    {
        String lines = null;
        int intC;
        while ((intC = br5.read()) != -1)
        {
            char c = (char)intC;
            /**
             * 当字符为\r\n结束
             * 
             * add on 1.14,2014
             * 
             */
            if (c == '\r')
            {
                //过滤\n
                br5.read();
                if (lines == null)
                {
                    lines = "";
                }
                break;
            }
            if (c == '\n')
            {
                if (lines == null)
                {
                    lines = "";
                }
                break;
            }
            if (lines != null && lines.length() >= MAX_STR_LEN)
            {
                throw new IOException("readLine : input too long.");
            }
            if (lines == null)
            {
                lines = "";
            }
            lines += c;
        }
        return lines;
    }

    public static List<String> channelReadBuffer(FileInputStream fin) throws IOException {
        List<String> list = new ArrayList<>();
        try(FileChannel source = fin.getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
            int bytesRead;
            int countReadNum = 0;
            StringBuffer stringBuffer = new StringBuffer();
            while ((bytesRead = source.read(buffer)) != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    char c = (char) buffer.get();

                    if (c == '\r') {
                        //过滤\n
                        buffer.get();
                        if (stringBuffer.length() == 0) {
                            list.add("");
                        } else {
                            list.add(stringBuffer.toString());
                        }
                        stringBuffer.delete(0, stringBuffer.length() - 1);
                    }
                    if (c == '\n') {
                        if (stringBuffer.length() == 0) {
                            list.add("");
                        } else {
                            list.add(stringBuffer.toString());
                        }
                        stringBuffer.delete(0, stringBuffer.length() - 1);
                    } else {
                        stringBuffer.append(c);
                    }
                }
                buffer.clear();

                countReadNum++;
            }
            log.info("channelReadBuffer read count num: " + countReadNum);
        }catch (Exception e){
            log.info("Exception");
        }
        return list;
    }
}
