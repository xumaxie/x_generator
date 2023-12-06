package com.maxie.cli;

import com.maxie.cli.command.ConfigCommand;
import com.maxie.cli.command.GenerateCommand;
import com.maxie.cli.command.ListCommand;
import picocli.CommandLine;

/**
 * 命令执行器：代表主命令maxie
 * *  实际步骤：
 *          * 1. 创建命令执行器（主命令）
 *          * 2. 分别实现每种子命令
 *          * 3. 提供项目的全局调用入口
 *          * 4. 构建程序jar包
 *          * 5. 测试使用
 *          * 6. 简化使用
 *
 * @author: xujian
 * @create: 2023-12-06 15:20
 **/
@CommandLine.Command(name = "maxie",mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable{

    //使用代码快初始化CommandLine
    private final CommandLine commandLine;
    {
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ListCommand())
                .addSubcommand(new ConfigCommand());
    }

    @Override
    public void run() {
        //如果米有输入子命令，则默认提示一句友好提示
        System.out.println("请输入具体命令，或者输入 --help 查看命令提示");
    }

    public Integer doExecutor(String[] args){
        return commandLine.execute(args);
    }
}
