package com.maxie.designpattern;

/**
 * 具体的命令
 *
 * @author: xujian
 * @create: 2023-12-06 15:02
 **/
public class TurnOnCommand implements Command{
    Device device;

    public TurnOnCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }
}
