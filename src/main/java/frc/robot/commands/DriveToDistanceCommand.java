/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveToDistanceCommand extends Command {
  DriveCommand driveCommand = new DriveCommand();
  double speed = 0.0;
  double distance = 0.0;

  public DriveToDistanceCommand(double distance, double speed) {
    this.distance = distance;
    this.speed = speed;
  }

//Resets encoders to read 0 and stop the motor to ensure no prior movement 
  @Override
  protected void initialize() {
    Robot.drive_subsystem.stop();

    //This command resets encoders so theyre at 0.
    // Robot.drive_subsystem.encReset();
    driveCommand.cancel();
  }

  //Drives forward until isFinished is executed
  @Override
  protected void execute() {
    Robot.drive_subsystem.drive(speed, 0);
  }

//Returns true when the error between the desired distance and the encoder distance is less than 
//or equal to 0.1. 0.1 is just a fake value for now and may differ depending on the application
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.drive_subsystem.stop();
    driveCommand.start();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
