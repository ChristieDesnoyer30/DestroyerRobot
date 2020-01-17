/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveForwardTimeoutCommand extends Command {
  double speed;
  double rotationalSpeed;
  public DriveForwardTimeoutCommand() {
   
  }

  public DriveForwardTimeoutCommand(double speed, double rotationalSpeed) {
    this.speed = speed;
    this.rotationalSpeed = rotationalSpeed;
   
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.drive_subsystem.stop();
    setTimeout(5);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.drive_subsystem.drive(speed, rotationalSpeed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.drive_subsystem.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
