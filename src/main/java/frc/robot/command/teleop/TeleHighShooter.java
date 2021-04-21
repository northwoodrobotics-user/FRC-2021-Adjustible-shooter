
package frc.robot.command.teleop;

import frc.robot.subsystems.HighShooter;
import frc.robot.OI;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleHighShooter extends Command {

    private HighShooter highShooter;
    private double highShooterSpeed;
    /**
     * if using logitech f310 controller
     * private Joystick controller = OI.coDriverController;
     */
    private XboxController controller = OI.coDriverController;

	public TeleHighShooter(HighShooter highShooter) {
    	this.highShooter = highShooter;
    	requires(highShooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        /**
         * if set on button
         * lowShooter.setSpeed(TogglelowShooter.getLowShooterStatus());
         * 
         * if using logitech f310 controller
         * lowShooterSpeed = OI.deadBand(-controller.getRawAxis(5));
         */
        highShooterSpeed = OI.deadBand(-controller.getY(Hand.kLeft));
        highShooter.setSpeedHighShooter(highShooterSpeed);
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