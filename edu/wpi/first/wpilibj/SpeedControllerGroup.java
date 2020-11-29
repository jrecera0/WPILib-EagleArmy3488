package edu.wpi.first.wpilibj;

public class SpeedControllerGroup {
    boolean isInverted = false;
    public SpeedControllerGroup(PWMVictorSPX... motorControllers) {
        for(int i = 0; i < motorControllers.length; i++) {
            verify(motorControllers[i]);
        }
        System.out.println("Created SpeedControllerGroup with " + motorControllers.length + " motor controllers");
    }

    public void setInverted() {
        isInverted = true;
        System.out.println("WARNING! Direction of a speed controller group was inverted!");
    }

    public void set(double speed) {
        System.out.println("The speed of a speed controller group was set to: " + (isInverted ? -speed : speed));
    }

    private void verify(PWMVictorSPX motorController) {
        if(motorController != null) {
            return;
        }
        else {
            throw new NullPointerException();
        }
    }
}
