/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.command.teleop;

import frc.robot.OI;
import frc.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleDrive extends Command {
	private Drivetrain drivetrain;
	private XboxController driveController = OI.driveController;
	private XboxController coDriverController = OI.coDriverController;

	private double fwd;
	private double strafe;
	private double ballsRotateCW;
	private double driveRotateCW;
	private double rotateCW;

	public TeleDrive(Drivetrain drivetrain) {
		this.drivetrain = drivetrain;
		requires(drivetrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	
	protected void execute() {
		fwd = OI.deadBand(-driveController.getY(Hand.kLeft));
		strafe = OI.deadBand(driveController.getX(Hand.kLeft));
		//ROTATE SET TO BALLS CONTROLLER FOR TESTING
		driveRotateCW = OI.deadBand(driveController.getX(Hand.kRight));
		ballsRotateCW = OI.deadBand(coDriverController.getX(Hand.kRight));
		rotateCW = ((driveRotateCW + ballsRotateCW)/2);

		drivetrain.drive(fwd, strafe, -rotateCW);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}