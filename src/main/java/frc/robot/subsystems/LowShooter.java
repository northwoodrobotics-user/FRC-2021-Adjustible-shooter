
package frc.robot.subsystems;
import frc.robot.RobotMap;
import frc.robot.command.teleop.*;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LowShooter extends Subsystem {
	private VictorSP lowShooter;

	public LowShooter() {
        lowShooter = new VictorSP(RobotMap.lowShootMotor);
		
		lowShooter.setInverted(RobotMap.lowShootInverse);

	}

	public void setSpeedLowShooter(double lowShooterSpeed) {
		lowShooter.set(lowShooterSpeed);
	}

	
	public void initDefaultCommand() {
		setDefaultCommand(new TeleLowShooter(this));
	}
}