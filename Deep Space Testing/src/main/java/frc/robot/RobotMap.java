package frc.robot;

public class RobotMap {
  public static class CAN {
    // PDP [0] | PCM [0] | TalonSRX [1,10] | VictorSPX [11,14]
    public static int kPDP = 0;
    public static int kPCM = 0;
    public static int kLeftDriveMaster = 2;
    public static int kLeftDriveFollower = 3;
    public static int kRightDriveMaster = 1;
    public static int kRightDriveFollower = 4;
    public static int kSingle = 5;
    public static int kDouble1 = 6;
    public static int kDouble2 = 7;
  }

  public static class PCM {
    public static int kHatchPanelManipulatorExtend = 0;
    public static int kHatchPanelManipulatorRetract = 1;
  }

  public static class ControllerPort {
    public static int kJoystick = 0;
  }
  
  public static class Multipliers {
    public static double kDriveMagnitude = .8;
    public static double kDriveRotation = .8;
  }

  public static double kIntakeSpeed = 0.7; 
  //Change this number between 0 and 1 to change the speed of the motors in any testing. 1 is full speed, 0 means that the motors will not turn. For a single motor, joystick buttons 7 and 8 should be held. For two motors, joystick buttons 11 and 12 should be held.
}