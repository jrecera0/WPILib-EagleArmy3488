// LStickX: 0
// LStickY: 1
// RStickX: 4
// RStickY: 5

package edu.wpi.first.wpilibj;

import edu.wpi.first.ds.DriverStation;
import edu.wpi.first.ds.MainFrame;

public class XboxController {
    // Controller input, now featuring janky window!
    MainFrame xboxFrame;

    // Initial Object Creation
    public XboxController(int USB_PORT) {
        xboxFrame = new MainFrame();
        System.out.println("Xbox Controller connected at USB Port " + USB_PORT);
    }

    // Crappy axis getter via MainFrame
    public double getRawAxis(int axis) {
        // Verify that we aren't running autonomous
        verifyMode();
        verifyAxis(axis);

        // Simulate springback of controller
        xboxFrame.zeroXAxis();
        xboxFrame.zeroYAxis();

        // Differentiate between x or y
        if(axis == 0 || axis == 4) {
            xboxFrame.xAxis = Math.abs(xboxFrame.xAxis) > 1 ? xboxFrame.xAxis > 1 ? 1 : -1 : xboxFrame.xAxis;
            return xboxFrame.xAxis;
        }
        else {
            xboxFrame.yAxis = Math.abs(xboxFrame.yAxis) > 1 ? xboxFrame.yAxis > 1 ? 1 : -1 : xboxFrame.yAxis;
            return xboxFrame.yAxis;
        }
    }

    public boolean getAButton() {
        return xboxFrame.aPressed;
    }

    public boolean getBButton() {
        return xboxFrame.bPressed;
    }

    public boolean getXButton() {
        return xboxFrame.xPressed;
    }

    public boolean getYButton() {
        return xboxFrame.yPressed;
    }

    private void verifyMode() {
        if (!DriverStation.controllerIsLocked) {
            return;
        }
        else {
            try {
                throw new Exception("CANNOT USE CONTROLLER DURING AUTONOMOUS");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    private void verifyAxis(int axis) {
        if(axis == 0 || axis == 1 || axis == 4 || axis == 5) {
            return;
        }
        else {
            try {
                throw new Exception("INVALID AXIS CALLED ON XBOXCONTROLLER");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
}