package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.*;
import frc.robot.Robot;

public class hatchTriangleServo extends Command {
  public String trianglePosition = "Center";
  //sets center and up servo angles
  double center = 15;
  double up = 90;
  public hatchTriangleServo() {
    requires(Robot.hatchSystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //set servo triangle to up position
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // set triangle servo to down position
      Robot.hatchSystem.turn(center,"triangle");
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    //set triangle servo to up position
  }
}