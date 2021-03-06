package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.HoldSlowMode;
import frc.robot.commands.HoldTurboMode;
import frc.robot.commands.LoadCargoFromGround;
import frc.robot.commands.MExtenderPiston;
import frc.robot.commands.MGripperPiston;
import frc.robot.commands.MoveElevatorToPosition;
import frc.robot.commands.RunBackClimber;
import frc.robot.commands.RunClimberWheels;
import frc.robot.commands.RunElevator;
import frc.robot.commands.RunFrontClimber;
import frc.robot.commands.RunIntake;
import frc.robot.commands.RunIntakeTimed;
import frc.robot.commands.RunLauncher;
import frc.robot.commands.RunLauncherTimed;
import frc.robot.commands.ToggleDefenseMode;
import frc.robot.commands.ToggleReverseMode;
import frc.robot.commands.ZeroElevator;

public class OI {

  public XboxController driver = new XboxController(RobotMap.ControllerPort.kDriver);
  public Joystick operator = new Joystick(RobotMap.ControllerPort.kOperator);
  public Joystick climber = new Joystick(RobotMap.ControllerPort.kClimber);

  public Button turboMode = new JoystickButton(driver, 2);
  public Button slowMode = new JoystickButton(driver, 5);
  public Button defenseMode = new JoystickButton(driver, 3);
  public Button reverseMode = new JoystickButton(driver, 6);

  public Button scoreCargo = new JoystickButton(operator, 1);
  public Button loadCargoFromGround = new JoystickButton(operator, 2);
  public Button elevatorForward = new JoystickButton(operator, 3);
  public Button toggleMGripper = new JoystickButton(operator, 4);
  public Button elevatorReverse = new JoystickButton(operator, 5);
  public Button toggleMExtender = new JoystickButton(operator, 6);

  public Button zero = new JoystickButton(operator, 7);
  public Button bottomPosition = new JoystickButton(operator, 9);
  public Button hatchLevel2 = new JoystickButton(operator, 10);
  public Button cargoRocket = new JoystickButton(operator, 11);
  public Button cargoShip = new JoystickButton(operator, 12);
 

  public Button cWheelsForward = new JoystickButton(climber, 1);
  public Button cWheelsReverse = new JoystickButton(climber, 2);
  public Button fClimberReverse = new JoystickButton(climber, 10);  
  public Button fClimberForward = new JoystickButton(climber, 9); 
  public Button bClimberReverse = new JoystickButton(climber, 12); 
  public Button bClimberForward = new JoystickButton(climber, 11); 
  public Button climbersForward = new JoystickButton(climber, 7); 
  public Button climbersReverse = new JoystickButton(climber, 8);

  public OI() {  
    turboMode.whileHeld(new HoldTurboMode());                                                                                                                                                                                                                                                                                                                                                     
    slowMode.whileHeld(new HoldSlowMode());
    defenseMode.whenPressed(new ToggleDefenseMode());
    reverseMode.whenPressed(new ToggleReverseMode());

    toggleMExtender.whenPressed(new MExtenderPiston());
    toggleMGripper.whenPressed(new MGripperPiston());
    loadCargoFromGround.whileHeld(new LoadCargoFromGround());
    loadCargoFromGround.whenPressed(new RunLauncher(true));  
    loadCargoFromGround.whenReleased(new RunIntakeTimed(false, 1));   
    scoreCargo.whenPressed(new RunLauncherTimed(false, .7));
    elevatorForward.whileHeld(new RunElevator(true));
    elevatorReverse.whileHeld(new RunElevator(false));
    elevatorReverse.whileHeld(new RunIntake(false));
    zero.whenPressed(new ZeroElevator());
    bottomPosition.whenPressed(new MoveElevatorToPosition(RobotMap.ElevatorControl.kBottomPosition));
    hatchLevel2.whenPressed(new MoveElevatorToPosition(RobotMap.ElevatorControl.kHatchPanelLevel2));
    cargoRocket.whenPressed(new MoveElevatorToPosition(RobotMap.ElevatorControl.kCargoRocketLevel1));
    cargoShip.whenPressed(new MoveElevatorToPosition(RobotMap.ElevatorControl.kCargoShip));

    cWheelsForward.whileHeld(new RunClimberWheels(true));
    cWheelsReverse.whileHeld(new RunClimberWheels(false));
    fClimberForward.whileHeld(new RunFrontClimber(true));
    fClimberReverse.whileHeld(new RunFrontClimber(false));
    bClimberForward.whileHeld(new RunBackClimber(true));
    bClimberReverse.whileHeld(new RunBackClimber(false));
    climbersForward.whileHeld(new RunFrontClimber(true));
    climbersForward.whileHeld(new RunBackClimber(true));
    climbersReverse.whileHeld(new RunFrontClimber(false));
    climbersReverse.whileHeld(new RunBackClimber(false));
  }
}