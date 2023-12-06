package com.maxie.cli.picocli.demo;

import picocli.CommandLine.Option;

import java.lang.reflect.Field;
import java.util.*;

/**
 * 解决强制性交互下，如何自动补充用户必须填写的参数
 *  使用反射
 * @author: xujian
 * @create: 2023-12-06 14:30
 **/
public class OptionUtil {

    /**
     * @return: String[]
     * @description: 对用户输入的命令进行补全确实的必填参数项
     * @author: xujian
     * @date: 2023/12/6 14:33
     * @param clazz
     * @param args
    */
    public static String[] processInteractiveOptions(Class<?> clazz,String[] args){
        //为了方便添加参数，先将args转换为Set
        Set<String> argsSet = new LinkedHashSet<>(Arrays.asList(args));

        //1.获取注解Options
        Field[] declaredFields = clazz.getDeclaredFields();
        //
        for(Field field:declaredFields){
            //遍历每一个属性，看其是否使用注解Option
            Option annotation = field.getAnnotation(Option.class);
            //注解是否使用属性interactive
            if(annotation != null && annotation.interactive()){
                //如果当前参数args中不包含该参数，加入
                if(!argsSet.contains(annotation.names()[0])){
                    argsSet.add(annotation.names()[0]);
                }
            }
        }
        return argsSet.toArray(new String[0]);
    }
}
