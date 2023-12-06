package com.maxie.cli.picocli.demo;

import picocli.CommandLine;
import picocli.CommandLine.Option;

/**
 * 实现一个交互式输入
 *
 * @author: xujian
 * @create: 2023-12-06 14:09
 **/
// @Command(name="")
public class Login implements Runnable{

    @Option(names = {"-u","--username"},description = "用户名")
    String name;

    @Option(names = {"-p","--password"},description = "密码",interactive = true)
    String password;

    @Override
    public void run() {
        System.out.println("密码是："+password);

    }

    public static void main(String[] args) {
        //o通过在这直接执行Login对应的命令
        new CommandLine(new Login()).execute("-u","maxie","-p");
    }
}
