package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubSystem extends SubsystemBase{
    
    CANSparkMax armDrive;
    CANSparkMax handSuction;
    CANSparkMax ringHolding;

    public ArmSubSystem(int armCANid, int handCANid, int ringHoldingCANid) {
        armDrive = new CANSparkMax(armCANid, CANSparkMax.MotorType.kBrushed);
         handSuction = new CANSparkMax(handCANid, CANSparkMax.MotorType.kBrushed);
         ringHolding = new CANSparkMax(ringHoldingCANid, CANSparkMax.MotorType.kBrushed);
    }
    public void armControl(double rightTrigger, double leftTrigger) {
        if (leftTrigger > 0.02 && rightTrigger < 0.02) {
          armDrive.setVoltage(-6 * leftTrigger);
        }
        else if (rightTrigger > 0.02 && leftTrigger < 0.02) {
          armDrive.setVoltage(12 * rightTrigger);
        }
        else {
          armDrive.stopMotor();
        }
       boolean rightBumper = false;
        if (rightBumper == true) {
          handSuction.setVoltage(4);
          ringHolding.setVoltage(4);
        }
        else {
          handSuction.stopMotor();
          ringHolding.stopMotor();
        }
        boolean leftBumper = false;
        if (leftBumper == true) {
          //handSuction.setVoltage(-4);
          //ringHolding.setVoltage(-4);
        }
        else {
          handSuction.stopMotor();
          ringHolding.stopMotor();
        }
      }

      public void endMotors() {
        armDrive.stopMotor();
        ringHolding.stopMotor();
        handSuction.stopMotor();
      }
}
