package edu.wpi.first.wpilibj;

public class TimedRobot {
    public void robotInit() {
        System.out.println("Default robotInit() method... Override me!");
    }
    
    public void disabledInit() {
        System.out.println("Default disabledInit() method... Override me!");
    }

    public void autonomousInit() {
        System.out.println("Default autonomousInit() method... Override me!");
    }

    public void teleopInit() {
        System.out.println("Default teleopInit() method... Override me!");
    }

    public void testInit() {
        System.out.println("Default testInit() method... Override me!");
    }

    public void robotPeriodic() {
        System.out.println("Default robotPeriodic() method... Override me!");
    }

    public void disabledPeriodic() {
        System.out.println("Default disabledPeriodic() method... Override me!");
    }

    public void autonomousPeriodic() {
        System.out.println("Default autonomousPeriodic() method... Override me!");
    }

    public void teleopPeriodic() {
        System.out.println("Default teleopPeriodic() method... Override me!");
    }

    public void testPeriodic() {
        System.out.println("Default testPeriodic() method... Override me!");
    }
}