package edu.wpi.first.wpilibj;

public class PWMVictorSPX {
    boolean isInverted = false;
    int deviceID;
    public PWMVictorSPX(int CAN_ID) {
        System.out.println("Motor Controller created with CAN_ID " + CAN_ID);
        deviceID = CAN_ID;
    }

    public void setInverted() {
        isInverted = true;
        System.out.println("WARNING! Direction of motor controller " + deviceID + " was inverted!");
    }

    public void set(double speed) {
        System.out.println("Motor controller " + deviceID + " was set to: " + (isInverted ? -speed : speed));
    }
}
