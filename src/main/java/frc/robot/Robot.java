/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import frc.robot.commands.ResetDrivetrainEncoders;
import frc.robot.subsystems.*;
import frc.robot.command.button.*;
import frc.robot.command.autonomous.autoMove;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.Compressor;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	// Subsystems
  public final Drivetrain drivetrain = new Drivetrain();
  public final Intake intake = new Intake();
  public final ColorSensor colorSensor = new ColorSensor();
  public final LowShooter lowShooter = new LowShooter();
  public final HighShooter highShooter = new HighShooter();
  public final Flipper flipper = new Flipper();
  public final Compressor compressor = new Compressor();
  

  public autoMove autonomousCommand;
  private enum Direction {FORWARD, BACKWARD}
	  SendableChooser<Direction> sideChooser= new SendableChooser<>();
  


	// Other
	public static OI oi;

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		// Subsystems
		drivetrain.init();
		ColorSensor.init();
		compressor.start();

		// Other
		oi = new OI(this);
		 //SmartDashboard.putData("Reset Encoders", new
		 //ResetDrivetrainEncoders(drivetrain));
		 sideChooser.setDefaultOption("Square", Direction.FORWARD);
		 sideChooser.setDefaultOption("Move Backward", Direction.BACKWARD);
		 

	}

	/**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
	 */
	@Override
	public void disabledInit() {
	}
	
	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		// schedule the autonomous command
		autonomousCommand = new autoMove(this);
		Direction direction = sideChooser.getSelected();
		
			if(direction == Direction.FORWARD) {
				autonomousCommand.goForward(this);
			} else if (direction == Direction.BACKWARD){
				autonomousCommand.goBackward(this);
			}
		
		autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
	@Override
  public void robotPeriodic() {
	SmartDashboard.putString("Centric mode", drivetrain.getCentricMode().toString() + "-CENTRIC");
	SmartDashboard.putBoolean("Front is Forward : ", drivetrain.isBackForward());

	SmartDashboard.putBoolean("Charlie Mode", drivetrain.LimitSpeed());
	
	//prints mod360 to get absolute wheel angle
	SmartDashboard.putNumber("Front Left wheel angle is : ", drivetrain.getWheelAngles()[0] % 360);
	SmartDashboard.putNumber("Front Right wheel angle is : ", drivetrain.getWheelAngles()[1] % 360);
	SmartDashboard.putNumber("Back Right wheel angle is : ", drivetrain.getWheelAngles()[2] % 360);
	SmartDashboard.putNumber("Back wheel angle is : ", drivetrain.getWheelAngles()[3] % 360);
	SmartDashboard.putNumber("Back Left wheel angle is : ", drivetrain.getWheelAngles()[4] % 360);

	//prints intake status
	SmartDashboard.putNumber("Intake speed : ", ToggleIntake.getIntakeStatus());
	SmartDashboard.putString("Most likely color : ", ColorSensor.getDetectedColor().toString());
	//Gyro Reading 
	SmartDashboard.putNumber("Gyro Angle", drivetrain.getHeading());

	// Autonomous Chooser 
	SmartDashboard.putData("Pick Autonomous", sideChooser);

	//show Shooter Speed
	SmartDashboard.putBoolean("Highshooter Speed", highShooter.LimitShoot());
	SmartDashboard.putBoolean("HighShooter Speed Mod 2 ", highShooter.LimitShoot2());

	//Show Flipper State: 
	SmartDashboard.putBoolean("Flipper is Up", flipper.FlipState());



  }
}
