package com.maxie.generator;

import java.io.*;
import java.util.Map;

/**
 * *
 *
 * @author: xujian
 * @create: 2023-12-10 19:19
 **/
public class JarGenerator {
    /**
     * @return:
     * @description: maven 构建jar包的命令
     * @author: xujian
     * @date: 2023/12/10 20:22
     * @param projectDir 代表执行执行mvn命令目录
    */
    public static void doGenerate(String projectDir) throws IOException, InterruptedException {
        String macOS = "mvn clean package -DskipTests=true";
        // mvn clean package -DskipTests=true

        // String winOS = " mvn.cmd clear package -DskipTests=true";
        String mavenCommand = macOS;

        ProcessBuilder processBuilder = new ProcessBuilder(mavenCommand.split(" "));
        processBuilder.directory(new File(projectDir));
        Map<String, String> environment = processBuilder.environment();
        // System.out.println(environment);
        Process process = processBuilder.start();

        // 读取命令的输出
        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        // 等待命令执行完成
        int exitCode = process.waitFor();
        System.out.println("命令执行结束，退出码：" + exitCode);
    }
}
