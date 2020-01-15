/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
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

  //Victor controls how much voltage do I send to the motor, so then it knows how to spin

  //port 0 is left side on Murhphy
  //port 1 is right side on Murphy

  Victor rightMotor = new Victor(RobotMap.robotRightMotor);
  Victor leftMotor = new Victor(RobotMap.robotLeftMotor);



  // Encoders begin to count as soon as the robot is on and the motors move
  // Encoder is a way of translating angles of rotation to something digital
  //how far along 360 degrees am I 
//   Encoder leftEnc = new Encoder(RobotMap.leftEnc1, RobotMap.leftEnc2, false, 
// 		Encoder.EncodingType.k4X);
// 	Encoder rightEnc = new Encoder(RobotMap.rightEnc1, RobotMap.rightEnc2, false, 
// 		Encoder.EncodingType.k4X);

	// Initial instantiation of our drivetrain object 

 //Java representation of how we drive the motor 
  public DifferentialDrive drive;
  

	public DriveSubsystem() {
    //motor inversions set to false to begin with
	//if motor goes backwards then set to true to go forwards
	//May not need to be set to false once Robot is powered up. 
		rightMotor.setInverted(false);
		leftMotor.setInverted(false);
	
		// Finalising instantiation of the drivetrain object
		// after setting motor inversions
		drive = new DifferentialDrive(leftMotor,rightMotor);

		// Sample showing how to invert the counting direction
		// after instantiation of an encoder
		// rightEnc.setReverseDirection(true);
		
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

	// // Gets a Raw encoder value
	// public double getLeftRaw(){
	// 	return leftEnc.getRaw();
	// }

	// // Averages the raw values of the left and right encoders
	// public double getRawAvg(){
	// 	return (leftEnc.getRaw() + rightEnc.getRaw())/2; 
	// }

	// Gets a distance based on a factor for units per
	// encoder value
	// Units used is up to the team
	// public double getAvgDistance(){
	// 	return getRawAvg() * 0.0008;
	// }

	// //Resets the encoders so that they read from 0 again
	// public void encReset(){
	// 	leftEnc.reset();
	// 	rightEnc.reset();
	// }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
