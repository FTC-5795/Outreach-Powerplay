package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp

public class NFS extends LinearOpMode {

    private DcMotorEx fL, fR, bL, bR;
    private double fLPower, fRPower, bLPower, bRPower;
    private double setSpeed;

    @Override
    public void runOpMode() throws InterruptedException{

        fL = hardwareMap.get(DcMotorEx.class, "leftFront");
        fR = hardwareMap.get(DcMotorEx.class, "rightFront");
        bL = hardwareMap.get(DcMotorEx.class, "leftRear");
        bR = hardwareMap.get(DcMotorEx.class, "rightRear");
        fR.setDirection(DcMotorSimple.Direction.REVERSE);
        bR.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()) {
            double gas = gamepad1.right_trigger;
            double brake = gamepad1.left_trigger;
            double turn = gamepad1.left_stick_x;
            double trueSpeed = (fL.getVelocity() + fR.getVelocity() + bL.getVelocity() + bR.getVelocity()) / 4;

            if (gas > 0 && trueSpeed < 50 && brake < 0.05) {
                setSpeed = trueSpeed + 10*gas;
            }
            else if (gas > 0 && trueSpeed < 100 && brake < 0.05) {
                setSpeed = trueSpeed + 8*gas;
            }
            else if (gas > 0 && trueSpeed < 150 && brake < 0.05) {
                setSpeed = trueSpeed + 7*gas;
            }
            else if (gas > 0 && trueSpeed < 200 && brake < 0.05) {
                setSpeed = trueSpeed + 6*gas;
            }
            else if (gas > 0 && trueSpeed < 250 && brake < 0.05) {
                setSpeed = trueSpeed + 5*gas;
            }
            else if (gas > 0 && trueSpeed < 300 && brake < 0.05) {
                setSpeed = trueSpeed + 4*gas;
            }
            else if (gas > 0 && trueSpeed < 384.5 && brake < 0.05) {
                setSpeed = trueSpeed + 3*gas;
            }
            else if (brake > 0) {
                setSpeed = trueSpeed - 100*brake;
            }

            fL.setVelocity(setSpeed);
            fR.setVelocity(setSpeed);
            bL.setVelocity(setSpeed);
            bR.setVelocity(setSpeed);

        }
    }
}
