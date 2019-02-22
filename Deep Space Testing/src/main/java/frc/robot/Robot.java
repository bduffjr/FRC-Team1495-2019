package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.cameraserver.CameraServer;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.PanelPgripper;
import frc.robot.subsystems.Pdropper;
import frc.robot.subsystems.Launcher;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Dropper;
import frc.robot.subsystems.CargoClawmp;
import frc.robot.subsystems.Climber;
import edu.wpi.first.wpilibj.DigitalInput;

public class Robot extends TimedRobot {
  public static WPI_TalonSRX leftDriveMaster, leftDriveFollower, rightDriveMaster, rightDriveFollower;
  public static DifferentialDrive roboDrive;

  public static Lift lift;
  public static PanelPgripper panelPgripper;
  public static Pdropper pdropper;
  public static Launcher launcher;
  public static Intake intake;
  public static Dropper dropper;
  public static CargoClawmp cargoClawmp;
  public static Climber frontClimber;
  public static Climber backClimber;

  public static DigitalInput liftLowerBound;

  public static OI oi;
  public static PowerDistributionPanel pdp;
  public static Compressor compressor;
  //public static CameraServer cam;

  @Override
  public void robotInit() {
    leftDriveMaster = new WPI_TalonSRX(RobotMap.CAN.kLeftDriveMaster);
    leftDriveFollower = new WPI_TalonSRX(RobotMap.CAN.kLeftDriveFollower);
    rightDriveMaster = new WPI_TalonSRX(RobotMap.CAN.kRightDriveMaster);
    rightDriveFollower = new WPI_TalonSRX(RobotMap.CAN.kRightDriveFollower);
    roboDrive = new DifferentialDrive(new SpeedControllerGroup(leftDriveMaster, leftDriveFollower), new SpeedControllerGroup(rightDriveMaster, rightDriveFollower));

    launcher = new Launcher();
    intake = new Intake();
    lift = new Lift();
    panelPgripper = new PanelPgripper();
    pdropper = new Pdropper();
    dropper = new Dropper();
    cargoClawmp = new CargoClawmp();
    frontClimber = new Climber(RobotMap.CAN.kFrontClimber);
    backClimber = new Climber(RobotMap.CAN.kBackClimber);
    
    liftLowerBound = new DigitalInput(RobotMap.DIO.kElevatorLowerBound);

    oi = new OI();
    pdp = new PowerDistributionPanel(RobotMap.CAN.kPDP);
    pdp.clearStickyFaults();
    compressor = new Compressor(RobotMap.CAN.kPCM);
    //cam = CameraServer.getInstance();
    //cam.startAutomaticCapture("cam1", 0);
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
    roboDrive.arcadeDrive(-oi.driver.getY(Hand.kLeft)*0.75, oi.driver.getX(Hand.kRight)*0.75);
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }
}