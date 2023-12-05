package com.maxie.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * *
 *
 * @author: xujian
 * @create: 2023-12-04 20:35
 **/
public class StaticGenerator {


    public static void main(String[] args) {

        //System.getProperty("user.dir")获取的是当前IDEA对应跟项目的路径：
        //  /Users/xujian/Desktop/my_project_idea/x_generator
        String currentRootPath = System.getProperty("user.dir");
        // System.out.println(currentRootPath);
        //关于路径分割符号：考虑不同操作系统的分隔符不同，推荐 File.separator


        //复制文件夹 samples/
        String inputFileRoot = currentRootPath+File.separator+"samples"+File.separator+"acm-template";
        String outputFileRoot = currentRootPath;
        copyFile(inputFileRoot,outputFileRoot);
    }
        
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
