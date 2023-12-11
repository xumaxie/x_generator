package com.maxie.generator.file;

import cn.hutool.core.io.FileUtil;

/**
 * *
 *
 * @author: xujian
 * @create: 2023-12-04 20:35
 **/
public class StaticFileGenerator {

    /**
     * @return:
     * @description: 复制文件
     * @author: xujian
     * @date: 2023/12/4 21:16 
     * @param inputPath
     * @param outputPath
    */
    public static void copyFile(String inputPath,String outputPath){
        FileUtil.copyFile(inputPath,outputPath);
    }

}
