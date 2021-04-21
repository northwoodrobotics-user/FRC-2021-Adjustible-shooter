package frc.robot.command.button;

import frc.robot.OI;

import frc.robot.subsystems.HighShooter;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Switches the robot from field centric to robot centric, or vice versa.
 */
public class ToggleHighShooter2 extends Command {

	private HighShooter highshooter;
	private double startTime;

	public ToggleHighShooter2(HighShooter highshooter) {
		this.highshooter = highshooter;
		requires(highshooter);
	}

    // Called just before this Command runs the first time
    
	protected void initialize() {
		startTime = Timer.getFPGATimestamp();
		//OI.driveController.setRumble(RumbleType.kRightRumble, 1.0);

		if (highshooter.LimitShoot2()) {
			highshooter.setFullSpeed();
		} else {
			highshooter.setLimitSpeed2();
		}
		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Timer.getFPGATimestamp() >= startTime + 0.2;
	}

	// Called once after isFinished returns true
	protected void end() {
	//	OI.coDriverController.setRumble(RumbleType.kLeftRumble, 0.0);
	//	OI.coDriverController.setRumble(RumbleType.kRightRumble, 0.0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	//	OI.driveController.setRumble(RumbleType.kLeftRumble, 0.0);
	//	OI.driveController.setRumble(RumbleType.kRightRumble, 0.0);
	}
}