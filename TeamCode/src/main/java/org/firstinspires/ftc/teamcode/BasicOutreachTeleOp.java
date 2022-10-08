package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp

public class BasicOutreachTeleOp extends LinearOpMode {

    private DcMotorEx fL, fR, bL, bR;
    private double fLPower, fRPower, bLPower, bRPower;

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
            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x * 1.1;
            double rx = gamepad1.right_stick_x;
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs (rx), 1);

            fLPower = y + x - rx;
            fLPower /= denominator;
            fRPower = y - x + rx;
            fRPower /= denominator;
            bLPower = y - x - rx;
            bLPower /= denominator;
            bRPower = y + x + rx;
            bRPower /= denominator;

            fL.setPower(fLPower);
            fR.setPower(fRPower);
            bL.setPower(bLPower);
            bR.setPower(bRPower);
        }

    }
}
