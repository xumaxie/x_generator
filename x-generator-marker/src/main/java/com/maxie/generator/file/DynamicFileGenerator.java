package com.maxie.generator.file;

import cn.hutool.core.io.FileUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * *动态生成
 *
 * @author: xujian
 * @create: 2023-12-05 10:04
 **/
public class DynamicFileGenerator {


    public static void doGenerator(String inputPath,String outputPath,Object object) throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        //注意路径
        File parentFile = new File(inputPath).getParentFile();
        cfg.setDirectoryForTemplateLoading(parentFile);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setNumberFormat("0.######");
        // FreeMarker模板保存在src/main/resources/templates目录下的maxie.html.ftl文件里
        // 创建模板对象，加载指定模板
        String fileName = new File(inputPath).getName();
        Template template = cfg.getTemplate(fileName);

        // 文件不存在则创建文件和父目录
        if (!FileUtil.exist(outputPath)) {
            FileUtil.touch(outputPath);
        }

        // 指定生成的文件
        Writer out = new FileWriter(outputPath);
        // 调用process方法，处理并生成文件
        template.process(object, out);

        // 生成文件后别忘了关闭哦
        out.close();
    }
}
