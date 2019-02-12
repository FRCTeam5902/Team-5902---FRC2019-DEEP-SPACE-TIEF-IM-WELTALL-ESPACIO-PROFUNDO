package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.*;
import frc.robot.Robot;

public class cargoDrive extends Command {

    public cargoDrive() {
        requires(Robot.cargoSystem);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() { 
    //Ramp up Speed
    }
        public double RSpeedY;
    
    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double driveSpeed = 1;
        //forward and backward sensitivity, y value of joystick
        double driveSensitivity = .5;
        
        //turning sensitivity, z value of joystick
        double turnSensitivity = .5;
        double gety = Robot.oi.getlogitechJoy2().getY();
        //double getz = Robot.oi.getlogitechJoy2().getZ();
        Robot.speed = (driveSpeed);
        SmartDashboard.putNumber("Robot.speed", Robot.speed);
        // added minimum gety so that small adjustments don't power the motors
        if (gety < -.1) {
          Robot.cargoSystem.eject(driveSensitivity*gety);
        }
        else if (gety > .1) {
          Robot.cargoSystem.intake(driveSensitivity*gety);
        }
        else {
          Robot.cargoSystem.stop();
        }
      }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	//Robot.cargoSystem.driveStraight(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	end();
    }
}