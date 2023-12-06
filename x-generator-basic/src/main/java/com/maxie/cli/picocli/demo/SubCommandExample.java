package com.maxie.cli.picocli.demo;

/**
 * 声明子命令：
 * 两种方式：编程式（代码）、声明式（注解）
 *
 * 、下面Demo是一个编程式的例子
 * @author: xujian
 * @create: 2023-12-06 14:47
 **/
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "main", mixinStandardHelpOptions = true)
public class SubCommandExample implements Runnable {

    @Override
    public void run() {
        System.out.println("执行主命令");
    }

    @Command(name = "add", description = "增加", mixinStandardHelpOptions = true)
    static class AddCommand implements Runnable {
        public void run() {
            System.out.println("执行增加命令");
        }
    }

    @Command(name = "delete", description = "删除", mixinStandardHelpOptions = true)
    static class DeleteCommand implements Runnable {
        public void run() {
            System.out.println("执行删除命令");
        }
    }

    @Command(name = "query", description = "查询", mixinStandardHelpOptions = true)
    static class QueryCommand implements Runnable {
        public void run() {
            System.out.println("执行查询命令");
        }
    }

    public static void main(String[] args) {
        // 执行主命令
        // String[] myArgs = new String[]{};
        // 查看主命令的帮助手册
//        String[] myArgs = new String[]{"--help"};
        // 执行增加命令
       String[] myArgs = new String[]{"add"};
       // String[] myArgs = new String[]{"ad"};
                // Unmatched argument at index 0: 'ad'
                // Did you mean: main add?
        // 执行删除命令的帮助手册
//        String[] myArgs = new String[]{"delete", "--help"};
        // 执行不存在的命令，会报错
//        String[] myArgs = new String[]{"update"};

        int exitCode = new CommandLine(new SubCommandExample())
                .addSubcommand(new AddCommand())
                .addSubcommand(new DeleteCommand())
                .addSubcommand(new QueryCommand())
                .execute(myArgs);
        System.exit(exitCode);
    }
}
