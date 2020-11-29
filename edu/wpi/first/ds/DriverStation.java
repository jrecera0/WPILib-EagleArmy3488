package edu.wpi.first.ds;

import java.util.Scanner;
import src.main.java.frc.robot.Robot;

public class DriverStation {
    private static boolean robotIsRunning = true;
    private static boolean takingUserInput = true;

    public static boolean controllerIsLocked = false;

    public static void main(String[] args) {
        boolean firstRun = true;
        int mode = 0;
        Scanner consoleInput = new Scanner(System.in);

        while(robotIsRunning) {
            // Initial Run Message
            if(firstRun) {
                System.out.println("Welcome to the mock FRC Driver Station!");
                System.out.println("Directions to run: Input the number of");
                System.out.println("the mode you want to run in the console");
                System.out.println("prompt, and afterwards you code will be");
                System.out.println("executed. Happy coding! - James \n");
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

    private static void run(int mode) {
        Robot robot = new Robot();
        boolean loopStatus = true;
        switch(mode) {
            case 0:
                robotIsRunning = false;
                break;
            case 1:
                controllerIsLocked = true;
                robot.robotInit();
                robot.autonomousInit();
                while(runningPeriodic(loopStatus)) {
                    loopStatus = false;
                    robot.robotPeriodic();
                    robot.autonomousPeriodic();
                }
                break;
            case 2:
                robot.robotInit();
                robot.teleopInit();
                while(runningPeriodic(loopStatus)) {
                    loopStatus = false;
                    robot.robotPeriodic();
                    robot.teleopPeriodic();
                }
                break;
            case 3:
                robot.robotInit();
                robot.testInit();
                while(runningPeriodic(loopStatus)) {
                    loopStatus = false;
                    robot.robotPeriodic();
                    robot.testPeriodic();
                }
                break;
            case 4:
                System.out.println("WARNING! This mode can be hard to understand so use at your own discretion.");
                robot.robotInit();
                robot.autonomousInit();
                controllerIsLocked = true;
                while(runningPeriodic(loopStatus)) {
                    loopStatus = false;
                    robot.robotPeriodic();
                    robot.autonomousPeriodic();
                }
                controllerIsLocked = false;
                loopStatus = true;
                robot.teleopInit();
                while(runningPeriodic(loopStatus)) {
                    robot.teleopPeriodic();
                    loopStatus = false;
                }
                break;
            default:
                System.out.println("Error! Invalid mode.");
        }
        takingUserInput = true;
        controllerIsLocked = false;
    }

    private static boolean runningPeriodic(boolean firstRun) {
        Scanner consoleInput = new Scanner(System.in);
        if(firstRun) {
            return true;
        }
        else {
            System.out.println("==============END CODE==============");
            System.out.print("End of periodic loop. Keep running? (y/n): ");
            String in = consoleInput.next().toLowerCase();
            if(!in.equals("y")) {
                return false;
            }
            System.out.println("=============START CODE=============");
            return true;
        }
    }
}
