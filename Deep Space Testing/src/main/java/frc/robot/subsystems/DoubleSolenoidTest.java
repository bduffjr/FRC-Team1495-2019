/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


public class DoubleSolenoidTest extends Subsystem {
  public DoubleSolenoid solenoid1, solenoid2;

  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public DoubleSolenoidTest() {
    solenoid1 = new DoubleSolenoid(RobotMap.PCM.kExtend1, RobotMap.PCM.kRetract1);

    solenoid2 = new DoubleSolenoid(RobotMap.PCM.kExtend2, RobotMap.PCM.kRetract2);
}
}

