package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.sensors.Gyro;
import frc.robot.subsystems.HatchPanelManipulator;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Compressor;

public class Robot extends TimedRobot {
  public static WPI_TalonSRX leftDriveMaster;
  public static WPI_TalonSRX leftDriveFollower;
  public static WPI_TalonSRX rightDriveMaster;
  public static WPI_TalonSRX rightDriveFollower;
  public static DifferentialDrive roboDrive;

  public static HatchPanelManipulator hatchPanelManipulator;

  public static Gyro gyro;
  public static OI oi;
  public PowerDistributionPanel pdp;
  public static Compressor compressor;

  @Override
  public void robotInit() {
    leftDriveMaster = new WPI_TalonSRX(RobotMap.CAN.kLeftDriveMaster);
    leftDriveFollower = new WPI_TalonSRX(RobotMap.CAN.kLeftDriveFollower);
    rightDriveMaster = new WPI_TalonSRX(RobotMap.CAN.kRightDriveMaster);
    rightDriveFollower = new WPI_TalonSRX(RobotMap.CAN.kRightDriveFollower);
    roboDrive = new DifferentialDrive(new SpeedControllerGroup(leftDriveMaster, leftDriveFollower), new SpeedControllerGroup(rightDriveMaster, rightDriveFollower));

    hatchPanelManipulator = new HatchPanelManipulator();

    gyro = new Gyro();
    oi = new OI();
    pdp = new PowerDistributionPanel(RobotMap.CAN.kPDP);
    pdp.clearStickyFaults();
    compressor = new Compressor(RobotMap.CAN.kPCM);
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    roboDrive.arcadeDrive(oi.joystick.getY()*RobotMap.Multipliers.kDriveMagnitude, oi.joystick.getX()*RobotMap.Multipliers.kDriveRotation);
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }
}