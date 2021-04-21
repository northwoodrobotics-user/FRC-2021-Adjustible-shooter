package frc.robot.subsystems;


import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Flipper extends Subsystem{


    public DoubleSolenoid RFlipper = new DoubleSolenoid(1, 0);
    public DoubleSolenoid LFlipper = new DoubleSolenoid(2, 3);
    private boolean flipIsUp = false;

    public void FlipUp(){
        RFlipper.set(Value.kForward);
        LFlipper.set(Value.kForward);
        flipIsUp = true;
       
    }


    public void  FlipDown(){
        RFlipper.set(Value.kReverse);
        LFlipper.set(Value.kReverse);
        flipIsUp = false;
    }
    public boolean FlipState(){
        return flipIsUp;

    }


    public Value getPosition(){
        return RFlipper.get();
    }

    public Value getPosition2(){
        return LFlipper.get();

    }













    public void initDefaultCommand(){
        // this is just here so its happy
        // you can set the default command for this subsytem here. 
    }


}



