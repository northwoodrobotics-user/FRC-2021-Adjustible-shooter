//Marty was here 
//thanks Kirk was here
package frc.robot.command.autonomous;

import frc.robot.Robot;
import frc.robot.command.AutoDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;



public class autoMove  extends CommandGroup {
	public AutoDrive autonomousCommand; 


	public autoMove(final Robot robot) {
	}

	public void goForward(final Robot robot) {

	//addSequential(new AutoDrive(robot.drivetrain, forward. strafe, rotate, Time));//turn right
	 addSequential(new AutoDrive(robot.drivetrain, 0.5, 0.0, 0.0, 2.0));//go foward
	 addSequential(new AutoDrive(robot.drivetrain, 0.0, 0.0, 0.0, 1.0)); // stay still
	 addSequential(new AutoDrive(robot.drivetrain, 0.0, -0.5, 0.0, 2.0));//go foward
	 addSequential(new AutoDrive(robot.drivetrain, 0.0, 0.0, 0.0, 1.0)); // stay still
	 addSequential(new AutoDrive(robot.drivetrain, -0.5, 0.0, 0.0, 2.0)); // reverse 
	 addSequential(new AutoDrive(robot.drivetrain, 0.0, 0.0, 0.0, 1.0)); // stay still
	 addSequential(new AutoDrive(robot.drivetrain, 0.0, 0.5, 0.0, 2.0));
	 //addSequential(new AutoDrive(robot.drivetrain, 0.0, 0.0, 0.0, 0.2)); // stay still
	 //addSequential(new AutoDrive(robot.drivetrain, -0.5, -0.5, 0.0, 2.0));
	 //addSequential(new AutoDrive(robot.drivetrain, 0.0, 0.0, 0.0, 0.2)); // stay still
	 //addSequential(new AutoDrive(robot.drivetrain, 0.0, 0.0, 1.0, 5.0));
	 //addSequential(new AutoDrive(robot.drivetrain, 0.5, 0.0, 0.8));//Turn right

	}

	public void goBackward(final Robot robot) {
		addSequential(new AutoDrive(robot.drivetrain, 0.5, 0.0, 0.0, 0.5));//go foward
		addSequential(new AutoDrive(robot.drivetrain,0.0, 0.5, 0.0, 0.5)); // reverse 
		addSequential(new AutoDrive(robot.drivetrain, 0.0, 0.0, 0.0, 2.0)); // stay still
		addSequential(new AutoDrive(robot.drivetrain, 0.0, -0.5, 0.0, 0.5));//go foward
	 	addSequential(new AutoDrive(robot.drivetrain,-0.5, 0.0, 0.0, 0.5)); // reverse 
	}
}