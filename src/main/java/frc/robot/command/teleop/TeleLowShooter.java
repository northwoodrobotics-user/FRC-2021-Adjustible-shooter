
package frc.robot.command.teleop;

import frc.robot.subsystems.LowShooter;
import frc.robot.OI;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleLowShooter extends Command {

    private LowShooter lowShooter;
    private double lowShooterSpeed;
    /**
     * if using logitech f310 controller
     * private Joystick controller = OI.coDriverController;
     */
    private XboxController controller = OI.coDriverController;

	public TeleLowShooter(LowShooter lowShooter) {
    	this.lowShooter = lowShooter;
    	requires(lowShooter);
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
        lowShooterSpeed = OI.deadBand(-controller.getY(Hand.kRight));
        lowShooter.setSpeedLowShooter(lowShooterSpeed);
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