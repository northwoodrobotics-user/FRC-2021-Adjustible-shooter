package frc.robot.command.button;

import frc.robot.OI;

/**
 * Toggles intake system
 * 
 * NEEDED IF INTAKE IS SET TO BUTTON
 */
public class ToggleIntake {
    public static double getIntakeStatus() {
		if (OI.coDriverController.getRawButton(4)){
			return 1;
		} else {
			return 0;
    	}
	}
}

