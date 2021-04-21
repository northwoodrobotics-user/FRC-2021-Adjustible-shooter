package frc.robot.command.teleop;

import frc.robot.subsystems.Intake;
import frc.robot.OI;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleIntake extends Command {

    private Intake intake;
    private double intakeSpeedPos;
    private double intakeSpeedNeg;
    /**
     * if using Logitech f310 controller :
     * private Joystick controller = OI.coDriverController;
    */
    private XboxController controller = OI.coDriverController;
    
	public TeleIntake(Intake intake) {
    	this.intake = intake;
    	requires(intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        /** 
         * if setting to button:
         * intake.setSpeed(ToggleIntake.getIntakeStatus());
         * 
         * if using Logitech f310 controller:
         * intakeSpeed = OI.deadBand(-controller.getRawAxis(1));
         */
        intakeSpeedPos = OI.deadBand(-controller.getTriggerAxis(Hand.kLeft));
        intakeSpeedNeg = OI.deadBand(controller.getTriggerAxis(Hand.kRight));
        intake.setSpeedIntake(intakeSpeedPos + intakeSpeedNeg);
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