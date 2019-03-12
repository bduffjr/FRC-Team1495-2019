/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DoubleMotorTest extends Command {

  double speed;

  public DoubleMotorTest(double s) {
    requires(Robot.doubleMotor);
    speed = s;
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.doubleMotor.motor1.set(speed);
    Robot.doubleMotor.motor2.set(speed);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.doubleMotor.motor1.stopMotor();
    Robot.doubleMotor.motor2.stopMotor();
  }

  @Override
  protected void interrupted() {
    Robot.doubleMotor.motor1.stopMotor();
    Robot.doubleMotor.motor2.stopMotor();
  }
}
