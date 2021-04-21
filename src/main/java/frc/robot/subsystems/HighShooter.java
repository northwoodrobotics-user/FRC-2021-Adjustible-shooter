
package frc.robot.subsystems;
import frc.robot.RobotMap;
import frc.robot.command.teleop.*;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**Marty Fixed This
 *
 */
public class HighShooter extends Subsystem {
	private VictorSP highShooter1;
        private VictorSP highShooter2;
        private boolean limitShoot = false;
        private boolean limitShoot2 = false;
        private double multiplier = 1.0;

	public HighShooter() {
        // motor 1 
        highShooter1 = new VictorSP(RobotMap.highShootMotor1);
		
        highShooter1.setInverted(RobotMap.highShootInverse1);

        //motor 2 
        highShooter2 = new VictorSP(RobotMap.highShootMotor2);
		
        highShooter1.setInverted(RobotMap.highShootInverse2);


	}

	public void setSpeedHighShooter(double highShooterSpeed) {
        highShooter1.set((highShooterSpeed)*multiplier);
        highShooter2.set((highShooterSpeed)*multiplier);
        }
        
        public boolean LimitShoot() {
		return limitShoot;
        }
        public boolean LimitShoot2() {
                return limitShoot2;
        }

        public void setLimitSpeed2() {
                limitShoot2 = true;
                limitShoot = false;
                multiplier = 0.65;
        }

	public void setLimitSpeed(){
                limitShoot = true;
                limitShoot2 = false;
                multiplier = 0.75;
        }
        
        public void setFullSpeed(){
                limitShoot = false;
                limitShoot2 = false;
                multiplier = 1.0;
	}

	public void initDefaultCommand() {
		setDefaultCommand(new TeleHighShooter(this));
	}
}