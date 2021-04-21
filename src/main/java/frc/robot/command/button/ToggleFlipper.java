package frc.robot.command.button;



import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.Flipper;




public class ToggleFlipper extends Command {
    private Flipper flipper;

    public ToggleFlipper(Flipper charlie){
        flipper = charlie;
        requires(flipper);



    }


    public ToggleFlipper(){

    }

    @Override
    protected void initialize(){
        
    }


    @Override
    protected void execute(){

    }
    
    @Override 
    protected boolean isFinished(){
        return true;
    }


    @Override
    protected void end(){
        if (flipper.getPosition() == Value.kForward){
            flipper.FlipDown();
            System.out.println("Shooter is High");
        } else {
            flipper.FlipUp();

            System.out.println("Shooting is Low");
        }


    }

    @Override
    protected void interrupted(){
        
    }






}

