package com.maxie.designpattern;

/**
 * 客户端（调用者相当于人）
 *
 * @author: xujian
 * @create: 2023-12-06 15:00
 **/

public class Clinet {
    public static void main(String[] args) {
        Device tv = new Device("电视机");
        Device compute = new Device("电脑");
        //发起开启tv
        TurnOnCommand turnOnCommand = new TurnOnCommand(tv);
        turnOnCommand.execute();
        TurnOffCommand turnOffCommand = new TurnOffCommand(tv);
        turnOffCommand.execute();

        TurnOnCommand turnOnCommandCom = new TurnOnCommand(compute);
        turnOnCommandCom.execute();
        TurnOffCommand turnOffCommandCOm = new TurnOffCommand(compute);
        turnOffCommandCOm.execute();

        // 电视机被打开了
        // 电视机被关闭了
        // 电脑被打开了
        // 电脑被关闭了
    }
}
