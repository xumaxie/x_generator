package com.maxie.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.maxie.generator.file.FileGenerator;
import com.maxie.model.DataModel;
import lombok.Data;
import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * generate命令
 *

 * @author: xujian
 * @create: 2023-12-06 15:14
 **/
@Data
@CommandLine.Command(name = "generator",mixinStandardHelpOptions = true)
public class GenerateCommand implements Callable<Integer> {

    //loop
    @CommandLine.Option(names = {"-l","--loop"},arity = "0..1",description = "是否需要循环",interactive = true,echo = true)
    private boolean loop;
    // 作者
    @CommandLine.Option(names = {"-a","--author"},arity = "0..1",description = "作者名字",interactive = true,echo = true)
    private String author = "maxie" ;
    // 输出文本
    @CommandLine.Option(names = {"-o","--outputText"},arity = "0..1",description = "输出文本内容",interactive = true,echo = true)
    private String outputText = "GOOD MaXie !~ ~ ~ " ;

    @Override
    public Integer call() throws Exception {
        DataModel dataModel = new DataModel();
        // mainTemplateConfig.setAuthor("maxie");
        // mainTemplateConfig.setLoop(false);
        // mainTemplateConfig.setOutputText("GOOD JOB !~ ~ ~ ");
        //或者根据BeanUtil复制当前对象的值 (注意属性必须拥有get set方法才能成功赋值)
        BeanUtil.copyProperties(this,dataModel);
        FileGenerator.doGenerate(dataModel);
        return 0;
    }
}