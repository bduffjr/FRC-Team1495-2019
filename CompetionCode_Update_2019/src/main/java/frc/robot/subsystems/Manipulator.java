package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Manipulator extends Subsystem {

  DoubleSolenoid piston;
  Value latest = Value.kReverse;
  boolean locked = false;

  public Manipulator() {
    piston = new DoubleSolenoid(RobotMap.PCM.kManipulatorForward, RobotMap.PCM.kManipulatorReverse);
  }

  public void setPiston(Value v) {
    if (!locked) {
      piston.set(v);
      latest = v;
    }
  }

  public void TogglePiston() {
    if (!locked) {
      if (latest == Value.kForward) {
        piston.set(Value.kReverse);
        latest = Value.kReverse;
      } else if (latest == Value.kReverse) {
        piston.set(Value.kForward);
        latest = Value.kForward;
      }
    }
  }

  public void Lock() {
    locked = true;
  }

  public void Unlock() {
    locked = false;
  }

  @Override
  public void initDefaultCommand() {
  }
}
