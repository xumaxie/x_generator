package com.maxie.designpattern;

/**
 * *
 *
 * @author: xujian
 * @create: 2023-12-06 15:05
 **/
public class TurnOffCommand implements Command{
    Device device;
    public TurnOffCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnDown();
    }
}
