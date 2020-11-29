package src.main.java.frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.XboxController;

public class Robot extends TimedRobot {
    int FRONT_LEFT = 0;
    int FRONT_RIGHT = 1;
    int BACK_LEFT = 2;
    int BACK_RIGHT = 3;

    int SHOOTER_ID = 4;

    int CONTROLLER_PORT = 0;

    XboxController xboxPad;

    PWMVictorSPX leftFront;
    PWMVictorSPX leftBack;
    PWMVictorSPX rightFront;
    PWMVictorSPX rightBack;
    PWMVictorSPX shooter;

    SpeedControllerGroup leftGroup;
    SpeedControllerGroup rightGroup;

    DifferentialDrive driveTrain;

    @Override
    public void robotInit() {
        if(driveTrain == null) {
            leftFront = new PWMVictorSPX(FRONT_LEFT);
            leftBack = new PWMVictorSPX(BACK_LEFT);
            rightFront = new PWMVictorSPX(FRONT_RIGHT);
            rightBack = new PWMVictorSPX(BACK_RIGHT);

            leftGroup = new SpeedControllerGroup(leftFront, leftBack);
            rightGroup = new SpeedControllerGroup(rightFront, rightBack);

            driveTrain = new DifferentialDrive(leftGroup, rightGroup);
        }
        if(xboxPad == null) {
            xboxPad = new XboxController(CONTROLLER_PORT);
        }
        if(shooter == null) {
            shooter = new PWMVictorSPX(SHOOTER_ID);
        }
    }

    @Override
    public void teleopPeriodic() {
        driveTrain.arcadeDrive(xboxPad.getRawAxis(1), xboxPad.getRawAxis(0));
        if(xboxPad.getAButton()) {
            shooter.set(1.0);
        }
        else {
            shooter.set(0.0);
        }
    }
}
