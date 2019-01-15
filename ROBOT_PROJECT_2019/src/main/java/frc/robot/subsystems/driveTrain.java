/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import org.usfirst.frc5902.Driver2.RobotMap;
import org.usfirst.frc5902.Driver2.commands.*;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
// DEPRECIATED import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class driveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public final WPI_TalonSRX leftDriveLead = RobotMap.driveTrainleftDriveLead;
    public final WPI_TalonSRX rightDriveLead = RobotMap.driveTrainrightDriveLead;
    public final WPI_TalonSRX leftDriveFollow = RobotMap.driveTrainleftDriveFollow;
    public final WPI_TalonSRX rightDriveFollow = RobotMap.driveTrainrightDriveFollow;
    public ADXRS450_Gyro gyro;
	private double angle;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public final DifferentialDrive robotDrive = RobotMap.driveTrainrobotDrive;
    @Override
    public void initDefaultCommand() {

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    	
    	leftDriveFollow.follow(leftDriveLead);
    	rightDriveFollow.follow(rightDriveLead);
    	gyro = new ADXRS450_Gyro(); 
		gyro.reset();
		gyro.calibrate();
        setDefaultCommand(new arcadeDrive());



    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        

        // Set the default command for a subsystem here.

        // setDefaultCommand(new MySpecialCommand());

    }

    public void arcadeDrive(double move, double rotate, double speed) {

    	  robotDrive.arcadeDrive(move*speed, rotate*speed);

    }
    
    public void autoDrive(double speedL, double speedR) {

    	robotDrive.tankDrive(speedL, speedR);

    }
    
    public void driveStraight(double speed) {

    	robotDrive.tankDrive(speed, speed);

    }
    
    @Override
    public void periodic() {	
        // Put code here to be run every loop

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}
