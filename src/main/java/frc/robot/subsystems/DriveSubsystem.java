/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  Victor frontRight = new Victor(RobotMap.frontRight);
	Victor frontLeft = new Victor(RobotMap.frontLeft);
	Victor backRight = new Victor(RobotMap.backRight);
  Victor backLeft = new Victor(RobotMap.backLeft);
  
  //PWM
  PWM motor = new PWM(1);


  //Groups left and right speed controllers for drive train
	SpeedControllerGroup left = new SpeedControllerGroup(frontLeft, backLeft);
	SpeedControllerGroup right = new SpeedControllerGroup(frontRight, backRight);


  // Encoders begin to count as soon as the robot is on and the motors move
  Encoder leftEnc = new Encoder(RobotMap.leftEnc1, RobotMap.leftEnc2, false, 
		Encoder.EncodingType.k4X);
	Encoder rightEnc = new Encoder(RobotMap.rightEnc1, RobotMap.rightEnc2, false, 
		Encoder.EncodingType.k4X);

	// Initial instantiation of our drivetrain object 

  public DifferentialDrive drive;
  

	public DriveSubsystem() {
    //motor inversions set to false to begin with
    //if motor goes backwards then set to true to go forwards
		frontRight.setInverted(false);
		frontLeft.setInverted(false);
		backRight.setInverted(false);
		backLeft.setInverted(false);

		// Finalising instantiation of the drivetrain object
		// after setting motor inversions
		drive = new DifferentialDrive(left, right);

		// Sample showing how to invert the counting direction
		// after instantiation of an encoder

		rightEnc.setReverseDirection(true);
		
	}
	// Drives drivetrain based on joystick input and dampening value (speed)
	// from 0 to 1
	public void driveJoystick(Joystick joystick, double speed) {
		
		drive.arcadeDrive(joystick.getY()*speed, joystick.getX()*speed);
	}
	
	// Drives drivetrain based on given speed and roation values
	public void drive(double speed, double rotationSpeed) {
		drive.arcadeDrive(speed, rotationSpeed);
	}

	// Stops the motors on the drivetrain
	public void stop() {
		drive.stopMotor();
	}

	// Gets a Raw encoder value
	public double getLeftRaw(){
		return leftEnc.getRaw();
	}

	// Averages the raw values of the left and right encoders
	public double getRawAvg(){
		return (leftEnc.getRaw() + rightEnc.getRaw())/2; 
	}

	// Gets a distance based on a factor for units per
	// encoder value
	// Units used is up to the team
	public double getAvgDistance(){
		return getRawAvg() * 0.0008;
	}

	//Resets the encoders so that they read from 0 again
	public void encReset(){
		leftEnc.reset();
		rightEnc.reset();
	}


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
