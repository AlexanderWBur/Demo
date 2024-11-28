package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.TypeConversion;

import java.util.Vector;

public class PixyBlockList extends Vector<BadPixyBlock> {
    public final int totalCount;

    public PixyBlockList(byte totalCount){
        this.totalCount = TypeConversion.unsignedByteToInt(totalCount);
    }
}
