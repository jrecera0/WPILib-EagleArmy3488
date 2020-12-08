package edu.wpi.first.ds;

import java.util.Scanner;
import src.main.java.frc.robot.Robot;

public class DriverStation {
    // Internal variables for functionality
    static boolean robotIsRunning = true;
    static boolean takingUserInput = true;

    // Outside accessible variable
    public static boolean controllerIsLocked = false;

    public static void main(String[] args) throws InterruptedException {
        boolean firstRun = true;
        int mode = 0;
        Scanner consoleInput = new Scanner(System.in);

        while(robotIsRunning) {
            // Initial Run Message
            if(firstRun) {
                System.out.println("\nWelcome to the mock FRC Driver Station!");
                System.out.println("Directions to run: Input the number of");
                System.out.println("the mode you want to run in the console");
                System.out.println("prompt, and afterwards your code will");
                System.out.println("be executed. Happy coding! - James \n");
                firstRun = false;
            }

            // Main menu
            System.out.println("==========[DRIVER STATION]==========");
            System.out.println("[0] Quit Program");
            System.out.println("[1] Autonomous Mode");
            System.out.println("[2] Teleop Mode");
            System.out.println("[3] Test Mode");
            System.out.println("[4] Practice Mode (Caution!)");
            System.out.println("====================================");

            // Take user input
            while(takingUserInput) {
                System.out.print(">>> ");
                try {
                    mode = consoleInput.nextInt();
                    takingUserInput = false;
                } catch(Exception e) {
                    System.out.println("Error! Invalid input.");
                    consoleInput.next();
                }
            }

            // Run robot
            run(mode);
        }
        consoleInput.close();
    }

    private static void run(int mode) throws InterruptedException {
        Robot robot = new Robot();
        switch(mode) {
            case 0:
                robotIsRunning = false;
                break;
            case 1:
                controllerIsLocked = true;
                robot.robotInit();
                robot.autonomousInit();
                while(runningPeriodic()) {
                    robot.robotPeriodic();
                    robot.autonomousPeriodic();
                }
                break;
            case 2:
                robot.robotInit();
                robot.teleopInit();
                while(runningPeriodic()) {
                    robot.robotPeriodic();
                    robot.teleopPeriodic();
                }
                break;
            case 3:
                robot.robotInit();
                robot.testInit();
                while(runningPeriodic()) {
                    robot.robotPeriodic();
                    robot.testPeriodic();
                }
                break;
            case 4:
                System.out.println("Disabled for week 5");
                // System.out.println("WARNING! This mode can be hard to understand so use at your own discretion.");
                // robot.robotInit();
                // robot.autonomousInit();
                // controllerIsLocked = true;
                // while(runningPeriodic()) {
                //     robot.robotPeriodic();
                //     robot.autonomousPeriodic();
                // }
                // controllerIsLocked = false;
                // robot.teleopInit();
                // while(runningPeriodic()) {
                //     robot.teleopPeriodic();
                // }
                break;
            default:
                System.out.println("Error! Invalid mode.");
        }
        takingUserInput = true;
        controllerIsLocked = false;
    }

    private static boolean runningPeriodic() throws InterruptedException {
        Thread.sleep(200);
        return true;
    }
}
