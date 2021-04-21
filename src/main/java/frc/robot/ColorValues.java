package frc.robot;

import com.revrobotics.ColorMatch;

import edu.wpi.first.wpilibj.util.Color;


public final class ColorValues {
    
    //Yellow RGB values
    private static final double yellowRVal = .300;
    private static final double yellowGVal = .600;
    private static final double yellowBVal = .100;

    //Red RGB values
    private static final double redRVal = .500;
    private static final double redGVal = .300;
    private static final double redBVal = .100;

    //Green RGB values
    private static final double greenRVal = .100;
    private static final double greenGVal = .600;
    private static final double greenBVal = .300;

    //Blue RGB values
    private static final double blueRVal = .100;
    private static final double blueGVal = .400;
    private static final double blueBVal = .500;

    public static final Color blueColor = ColorMatch.makeColor(blueRVal, blueGVal, blueBVal);
    public static final Color greenColor = ColorMatch.makeColor(greenRVal, greenGVal, greenBVal);
    public static final Color redColor = ColorMatch.makeColor(redRVal, redGVal, redBVal);
    public static final Color yellowColor = ColorMatch.makeColor(yellowRVal, yellowGVal, yellowBVal);
}
