package com.maxie;

import com.maxie.cli.CommandExecutor;

/**
 * @desc：示例
 * @author: 徐健
 * @date：2023/12/4 20:21
 */
public class Main {
    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        // args = new String[]{"generator","-l","-a","-o"};
        // args = new String[]{"list"};
        // args = new String[]{"config"};
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecutor(args);

    }
}