package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.*;
import frc.robot.Robot;

public class hatchTriangleServoToggle extends Command {
  public String trianglePosition = "Center";
  //sets center and up servo angles
  double center = 35;
  double up = 90;
  public hatchTriangleServoToggle() {
    requires(Robot.hatchSystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    if (trianglePosition == "Up"){
      Robot.hatchSystem.turn(center,"triangle");
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // if statement to check which servo is being used
    if (trianglePosition == "Up"){
      Robot.hatchSystem.turn(center,"triangle");
    } else if (trianglePosition == "Center"){
      Robot.hatchSystem.turn(up,"triangle");
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (trianglePosition == "Up")
    {
      trianglePosition = "Center";
      SmartDashboard.putString("Triangle Postition","center");
    }
    else if (trianglePosition == "Center")
    {
      trianglePosition = "Up";
      SmartDashboard.putString("Triangle Postition","up");
    }
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
  }
}