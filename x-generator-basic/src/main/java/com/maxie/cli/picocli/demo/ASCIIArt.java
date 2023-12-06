package com.maxie.cli.picocli.demo;

/**
 * 关于Picocli的Demo
 *
 * @author: xujian
 * @create: 2023-12-06 13:57
 **/
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
// some exports omitted for the sake of brevity

//name命令的名字
//mixinStandardHelpOptions代表是否可以使用--help --version
@Command(name = "maxie", version = "v_1.0", mixinStandardHelpOptions = true)
public class ASCIIArt implements Runnable {

    //两种方式Option和Parameters
    @Option(names = { "-s", "--font-size" }, description = "Font size")
    int fontSize = 19;

    @Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli",
            description = "Words to be translated into ASCII art.")
    private String[] words = { "Hello,", "picocli" };

    @Override
    public void run() {
        // The business logic of the command goes here...
        // In this case, code for generation of ASCII art graphics
        // (omitted for the sake of brevity).
        System.out.println("font_size是："+fontSize);
        System.out.println("font_size是："+String.join(",",words));
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new ASCIIArt()).execute(args);
        System.exit(exitCode);
    }

    // 参数设置
        // -s 33 maxie man
            // font_size是：33
            // font_size是：maxie,man
        // --version
             // v_1.0
        // --help
            //Usage: maxie [-hV] [-s=<fontSize>] [<word>...]
            //       [<word>...]   Words to be translated into ASCII art.
            //   -h, --help        Show this help message and exit.
            //   -s, --font-size=<fontSize>
            //                     Font size
            //   -V, --version     Print version information and exit.
}
