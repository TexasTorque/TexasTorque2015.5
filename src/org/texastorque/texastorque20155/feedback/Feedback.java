package org.texastorque.texastorque20155.feedback;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.texastorque.texastorque20155.constants.Ports;
import org.texastorque.torquelib.component.TorqueEncoder;

public class Feedback {

    private final double ELEVATOR_CONVERSION = 1.6;

    private TorqueEncoder elevatorEncoder;

//    private TorqueEncoder leftDriveEncoder;
//    private TorqueEncoder rightDriveEncoder;
    private double elevatorPosition;
    private double elevatorVelocity;
    private double elevatorAcceleration;

    private double leftDrivePosition;
    private double leftDriveVelocity;
    private double leftDriveAcceleration;

    private double rightDrivePosition;
    private double rightDriveVelocity;
    private double rightDriveAcceleration;

    private Feedback() {
        elevatorEncoder = new TorqueEncoder(Ports.ELEVATOR_ENCODER_A, Ports.ELEVATOR_ENCODER_B, true, EncodingType.k4X);

//        leftDriveEncoder = new TorqueEncoder(Ports.LEFT_DRIVE_ENCODER_A, Ports.LEFT_DRIVE_ENCODER_B, false, EncodingType.k4X);
//        rightDriveEncoder = new TorqueEncoder(Ports.RIGHT_DRIVE_ENCODER_A, Ports.RIGHT_DRIVE_ENCODER_B, false, EncodingType.k4X);
    }

    public void update() {
        //elevator conversion: rotations * (1.6 / 12) = height in feet
        elevatorEncoder.calc();
        elevatorPosition = (elevatorEncoder.get() / 250.0) * ELEVATOR_CONVERSION;
        elevatorVelocity = (elevatorEncoder.getRate() / 250.0) * ELEVATOR_CONVERSION;
        elevatorAcceleration = (elevatorEncoder.getAcceleration() / 250.0) * ELEVATOR_CONVERSION;
    }

    public void pushToDashboard() {
    }

    //getters
    public double getElevatorPosition() {
        return elevatorPosition;
    }

    public double getElevatorVelocity() {
        return elevatorVelocity;
    }

    public double getElevatorAcceleration() {
        return elevatorAcceleration;
    }

    public double getLeftDrivePosition() {
        return leftDrivePosition;
    }

    public double getLeftDriveVelocity() {
        return leftDriveVelocity;
    }

    public double getLeftDriveAcceleration() {
        return leftDriveAcceleration;
    }

    public double getRightDrivePosition() {
        return rightDrivePosition;
    }

    public double getRightDriveVelocity() {
        return rightDriveVelocity;
    }

    public double getRightDriveAcceleration() {
        return rightDriveAcceleration;
    }

    public void resetElevatorEncoders() {
//        elevatorEncoder.reset();
    }

    public void resetDriveEncoders() {
//        leftDriveEncoder.reset();
//        rightDriveEncoder.reset();
    }

    //singleton
    private static Feedback instance;

    public static Feedback getInstance() {
        if (instance == null) {
            instance = new Feedback();
        }
        return instance;
    }
}
