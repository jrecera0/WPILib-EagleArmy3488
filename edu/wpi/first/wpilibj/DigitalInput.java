package edu.wpi.first.wpilibj;

import java.util.Scanner;

public class DigitalInput {
    // Just so we can name off the sensor channel
    int objChannel;

    public DigitalInput(int channel) {
        System.out.println("New sensor connected on channel " + channel);
        objChannel = channel;
    }

    public boolean get() {
        Scanner forcedInput = new Scanner(System.in);
        System.out.print("Is the sensor on channel " + objChannel + " triggered? (y/n): ");
        return forcedInput.next().toLowerCase().equals("y");
    }
}
