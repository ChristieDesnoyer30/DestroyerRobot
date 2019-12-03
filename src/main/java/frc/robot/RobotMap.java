/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {


	public static final int robotLeftMotor = 0;
	public static final int robotRightMotor = 1;


      // Drivetrain Encoder Ports
      public static final int leftEnc1 = 0;
      public static final int leftEnc2 = 1;
      public static final int rightEnc1 = 2;
      public static final int rightEnc2 = 3;
  


    //Ultrasonic ports
    public static final int ping = 4;
    public static final int echo = 5;
}
