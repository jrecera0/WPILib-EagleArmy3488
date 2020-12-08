package edu.wpi.first.wpilibj.drive;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.PWMVictorSPX;

public class DifferentialDrive {
    public DifferentialDrive(SpeedControllerGroup leftGroup, SpeedControllerGroup rightGroup) {
        verify(leftGroup, rightGroup);
        System.out.println("Successfully created DifferentialDrive (via SpeedControllerGroups)!");
    }

    public DifferentialDrive(PWMVictorSPX leftMotor, PWMVictorSPX rightMotor) {
        verify(leftMotor, rightMotor);
        System.out.println("Successfully created DifferentialDrive (via MotorControllers)!");
    }

    public void arcadeDrive(double xSpeed, double zRotation) {
        System.out.println("Robot is moving fwd/back with a speed of:     " + xSpeed);
        System.out.println("Robot is rotating left/right with a speed of: " + zRotation);
    }

    private void verify(Object leftSide, Object rightSide) {
        if(leftSide != null && rightSide != null) {
            return;
        }
        else {
            throw new NullPointerException();
        }
    }
}
