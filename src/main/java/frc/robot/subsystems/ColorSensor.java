  
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.ColorValues;
import frc.robot.RobotMap;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

/**
 * Creates a new ColorSensorSubsystem.
 */

public class ColorSensor extends SubsystemBase{

    public static ColorSensorV3 colorSensorModule = new ColorSensorV3(RobotMap.colorSensorPort);

    public static ColorMatch colorMatcher = new ColorMatch();
    public static Color detectedColor;
    public static String likelyColor;
    
    public static void init(){
        colorMatcher.addColorMatch(ColorValues.blueColor);
        colorMatcher.addColorMatch(ColorValues.redColor);
        colorMatcher.addColorMatch(ColorValues.greenColor);
        colorMatcher.addColorMatch(ColorValues.yellowColor);   
    }
    /**
    * Run the color match algorithm on our detected color
    */
    public static ColorMatchResult match;

    public static String getDetectedColor(){
        detectedColor = colorSensorModule.getColor();
        match = colorMatcher.matchClosestColor(detectedColor);
    
        if (match.color == ColorValues.blueColor) { 
            likelyColor = ("Blue");
        } else if (match.color == ColorValues.redColor) { 
            likelyColor = ("Red");
        } else if (match.color == ColorValues.greenColor) { 
            likelyColor = ("Green");
        } else if (match.color == ColorValues.yellowColor) { 
            likelyColor = ("Yellow");
        } else{
            likelyColor = ("NULL");
        }

        return likelyColor;

    }
    
    public ColorSensor() {      
    }

    @Override
    public void periodic() {
    // This method will be called once per scheduler run
    }
}