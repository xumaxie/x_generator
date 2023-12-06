package com.maxie.designpattern;

/**
 * 命令的接受者（其实就是调用者和执行者之间的一个媒介）
 * 以电视遥控器为例子
 * @author: xujian
 * @create: 2023-12-06 14:55
 **/
public class Device {
    private String name;

    public Device(String name) {
        this.name = name;
    }

    /**
     * 开启
     */
    public void turnOn(){
        System.out.println(name+"被打开了");
    }

    /**
     * 关闭
     */
    public void turnDown(){
        System.out.println(name+"被关闭了");
    }
}
