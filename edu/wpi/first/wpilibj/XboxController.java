package edu.wpi.first.wpilibj;

import edu.wpi.first.ds.DriverStation;
import java.util.Scanner;

public class XboxController {
    public XboxController(int USB_PORT) {
        System.out.println("Xbox Controller connected at USB Port " + USB_PORT);
    }

    // I have no good way of simulating xbox controller input, plz help
    // LStickX: 0
    // LStickY: 1
    // RStickX: 4
    // RStickY: 5
    public double getRawAxis(int axis) {
        // Verify that we aren't running autonomous
        verifyMode();

        // Default variables and objects
        Scanner forcedInput = new Scanner(System.in);
        String axisString = "Unknown Axis! Please use either 0, 1, 4, or 5 as your axis in code.";
        boolean acceptingInput = true;
        boolean firstLoop = true;
        double axisValue = 0;

        // Check what axis we're using
        switch (axis) {
            case 0:
                axisString = "Left Stick X Value: ";
                break;
            case 1:
                axisString = "Left Stick Y Value: ";
                break;
            case 4:
                axisString = "Right Strick X Value: ";
                break;
            case 5:
                axisString = "Right Stick Y Value: ";
                break;
            default:
                acceptingInput = false;
                break;
        }

        // Prompt the user for axis value
        System.out.print(axisString);
        while (acceptingInput) {
            if(!firstLoop) {
                System.out.print(axisString);
            }
            firstLoop = false;
            try {
                axisValue = forcedInput.nextDouble();
                if (Math.abs(axisValue) > 1.0) {
                    System.out.println("Invalid axis value! Please supply a number between -1.0 and 1.0, inclusive.");
                }
                else {
                    acceptingInput = false;
                }
            } catch(Exception e) {
                System.out.println("Invalid input! Please try again.");
                forcedInput.next();
            }
        }

        // Return axis value, similar to the actual controller
        return axisValue;
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
