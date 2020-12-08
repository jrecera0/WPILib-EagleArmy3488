package edu.wpi.first.wpilibj;

import edu.wpi.first.ds.DriverStation;
import edu.wpi.first.ds.MainFrame;
import java.util.Scanner;

public class _XboxController {
    public _XboxController(int USB_PORT) {
        new MainFrame();
        System.out.println("Xbox Controller connected at USB Port " + USB_PORT);
    }

    // I have no good way of simulating xbox controller input, plz help
    
    public double getRawAxis(int axis) {
        // LStickX: 0
        // LStickY: 1
        // RStickX: 4
        // RStickY: 5
        // Verify that we aren't running autonomous
        verifyMode();

        // Check what axis we're using
        switch (axis) {
            case 0:
                break;
            case 1:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                System.out.println("Unknown Axis! Please use either 0, 1, 4, or 5 as your axis in code.");
                break;
        }
        // Return axis value
        MainFrame.decrement();
        double axisVal = MainFrame.getMe();
        if(Math.abs(axisVal) > 1) {
            MainFrame.joystickValue = axisVal > 0 ? 1 : -1;
            axisVal = MainFrame.joystickValue;
        }
        return axisVal;
    }

    public boolean getAButton() {
        Scanner forcedInput = new Scanner(System.in);
        System.out.print("Is the A button being pressed? (y/n): ");
        return forcedInput.next().toLowerCase().equals("y");
    }

    public boolean getBButton() {
        Scanner forcedInput = new Scanner(System.in);
        System.out.print("Is the B button being pressed? (y/n): ");
        return forcedInput.next().toLowerCase().equals("y");
    }

    public boolean getXButton() {
        Scanner forcedInput = new Scanner(System.in);
        System.out.print("Is the X button being pressed? (y/n): ");
        return forcedInput.next().toLowerCase().equals("y");
    }

    public boolean getYButton() {
        Scanner forcedInput = new Scanner(System.in);
        System.out.print("Is the Y button being pressed? (y/n): ");
        return forcedInput.next().toLowerCase().equals("y");
    }

    private void verifyMode() {
        if (!DriverStation.controllerIsLocked) {
            return;
        } else {
            try {
                throw new Exception("CANNOT USE CONTROLLER DURING AUTONOMOUS");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
}
