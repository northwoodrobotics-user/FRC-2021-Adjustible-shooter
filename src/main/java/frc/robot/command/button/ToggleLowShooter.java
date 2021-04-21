package frc.robot.command.button;

import frc.robot.OI;

/**
 * Toggles Low Shooter system
 * 
 * NEEDED IF SET TO BUTTON
 * 
 */
public class ToggleLowShooter {
    public static double getLowShooterStatus() {
		if (OI.coDriverController.getRawButton(2)) {
			return 1;
		} else {
			return 0;
		}
    }
}

