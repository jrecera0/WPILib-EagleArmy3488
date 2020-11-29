package edu.wpi.first.wpilibj;

public class PWMVictorSPX {
    boolean isInverted = false;
    public PWMVictorSPX(int CAN_ID) {
        System.out.println("Motor Controller created with CAN_ID " + CAN_ID);
    }

    public void setInverted() {
        isInverted = true;
        System.out.println("WARNING! Direction of a motor controller was inverted!");
    }

    public void set(double speed) {
        System.out.println("A motor controller speed was set to: " + (isInverted ? -speed : speed));
    }
}
