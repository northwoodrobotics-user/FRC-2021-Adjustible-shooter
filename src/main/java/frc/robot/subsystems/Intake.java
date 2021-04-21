
package frc.robot.subsystems;
import frc.robot.RobotMap;
import frc.robot.command.teleop.*;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
	private VictorSP intake;
	private VictorSP intake2;


	public Intake() {
        intake = new VictorSP(RobotMap.intakeMotor);
		
		intake.setInverted(RobotMap.intakeInverse);

		intake2 = new VictorSP(RobotMap.intakeMotor2);

		intake.setInverted(RobotMap.intakeInverse2);

	}

	public void setSpeedIntake(double intakeSpeed) {
		intake.set(intakeSpeed);
		intake2.set(intakeSpeed);
	}

	
	public void initDefaultCommand() {
		setDefaultCommand(new TeleIntake(this));
	}
}