package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import java.util.ArrayList;

public class OpMode extends LinearOpMode {

    PixyCam pixy;

    @Override
    public void runOpMode() {

        ArrayList<PixyBlock> rawData;
        pixy = hardwareMap.get(PixyCam.class, "pixy");

        waitForStart();
        while (opModeIsActive()) {
            rawData = pixy.read();
            if(!rawData.isEmpty()){
                telemetry.addData("signature", rawData.get(0).signature);
                telemetry.addData("x", rawData.get(0).centerX);
                telemetry.addData("y", rawData.get(0).centerY);
                telemetry.addData("height", rawData.get(0).height);
                telemetry.addData("width", rawData.get(0).width);
            }

            telemetry.update();
        }
    }
}
