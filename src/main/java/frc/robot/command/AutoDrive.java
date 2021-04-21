package frc.robot.command;

import frc.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

// this may not work, here goes//

public class AutoDrive extends Command {
    private Drivetrain drivetrain;
    private double fwd;
    private double strafe;
    private double rotateCW;
    private double durationMillis;
    private long startTime;





    public AutoDrive(Drivetrain drivetrain, double fwd, double strafe, double rotateCW, double seconds){
        this.drivetrain = drivetrain;
        this.fwd = fwd;
        this.strafe = strafe;
        this.rotateCW = rotateCW;
        durationMillis = seconds * 1000;
        requires(drivetrain);
    }



    // called before this command runs the first time
    protected void initialize(){
        startTime = System.currentTimeMillis();
        System.out.println("Started Autodrive");
        drivetrain.LimitSpeed();

    
    }

    // called repeateadly when this Command is scheduled to run
    protected void execute(){
        drivetrain.drive(fwd, strafe, rotateCW);
    }

    // make this return true when this Command no longer needs to run execute()
    protected boolean isFinished(){
        return System.currentTimeMillis() > startTime + durationMillis;
      }


    //called once after isFinished returns true
    protected void end(){
        drivetrain.drive(0,0,0);
        System.out.println("Ran" + this.toString() + "For " + (System.currentTimeMillis() - startTime) / 1000.0 + "seconds.");


    }


    // called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted(){
        System.out.println("Ran" + this.toString() + "for" + (System.currentTimeMillis() - startTime) / 1000.0 + "seconds, then got interrupted.");
        drivetrain.drive(0,0,0);
    }







}




















