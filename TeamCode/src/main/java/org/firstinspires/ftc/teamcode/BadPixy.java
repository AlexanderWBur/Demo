package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;
import com.qualcomm.robotcore.util.TypeConversion;

import java.util.ArrayList;

/**
 * Created by Michael Vierra, FTC 8461 on 9/13/2017.
 */

/*
Bytes    16-bit word    Description
        ----------------------------------------------------------------
        0, 1     y              sync: 0xaa55=normal object, 0xaa56=color code object
        2, 3     y              checksum (sum of all 16-bit words 2-6, that is, bytes 4-13)
        4, 5     y              signature number
        6, 7     y              x center of object
        8, 9     y              y center of object
        10, 11   y              width of object
        12, 13   y              height of object
        */
@TeleOp
public class BadPixy extends LinearOpMode {
    PixyCam pixy;

    @Override
    public void runOpMode() throws InterruptedException {

        ArrayList<PixyBlock> rawData = new ArrayList<>();
        pixy = hardwareMap.get(PixyCam.class, "pixy");

        waitForStart();

        while (opModeIsActive()) {
            pixy.
            rawData = pixy.read();
//
            if(!rawData.isEmpty()){
                telemetry.addData("signature", rawData.get(0).signature);
                telemetry.addData("x", rawData.get(0).centerX);


            }
            //telemetry.addData("byte", pixy.cvt(rawData.get(4), rawData.get(6)));
            telemetry.update();
        }
    }
}
