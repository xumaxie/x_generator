package com.maxie.cli.picocli.demo;

import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

/**
 * 交互式输入：
 * ● 可选交互式：用户可以直接在整行命令中输入选项，而不用给用户提示信息
 * ● 强制交互式：用户必须获得提示并输入某个选项，不允许不填写
 *
 * 一般需要：@Option注解中的arity属性:指定每个选项可接收的参数个数
 *
 * @author: xujian
 * @create: 2023-12-06 14:14
 **/
public class LoginMore implements Callable<Integer> {

    /**
     * 用户名
     */
    @Option(names = {"-u","--username"},description = "用户名")
    String name;

    /**
     * 密码
     */
    @Option(names = {"-p","--password"},arity = "0..1",description = "密码",interactive = true,prompt = "请输入密码")
    String password;


    /**
     * 确认密码
     */
    @Option(names = {"-cp", "--checkPassword"}, arity = "0..1",description = "确认 密码", interactive = true,prompt = "请再次输入密码")
    String checkPassword;

    @Override
    public Integer call() {
        System.out.println("密码是："+password);
        System.out.println("确认密码是：" + checkPassword);

        return 0;
    }

    public static void main(String[] args) {

        //非强制交互式场景下
        // new CommandLine(new LoginMore()).execute("-u","maxie","-p","-cp");
        // 请输入密码123
        // 请再次输入密码123
        // 密码是：123
        // 确认密码是：123

        // new CommandLine(new LoginMore()).execute("-u","maxie","-p","xxx","-cp");
        // 请再次输入密码aaa
        // 密码是：xxx
        // 确认密码是：aaa
        // new CommandLine(new LoginMore()).execute("-u","maxie","-p","-cp","xxx");
        // 请输入密码aaa
        // 密码是：aaa
        // 确认密码是：xxx

        //强制交互式场景下
        //例如 mysql -uroot -p (如果用户没有输入-p,如何设置？)
        String[] argu = new String[]{"-u","maxie","-p"};
        new CommandLine(new LoginMore()).execute(OptionUtil.processInteractiveOptions(LoginMore.class,argu));
        // 请输入密码qqq
        // 请再次输入密码qqq
        // 密码是：qqq
        // 确认密码是：qqq

    }
}
