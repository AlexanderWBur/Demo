package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.TypeConversion;

public class BadPixyBlock {
    /**
     * this is a number 1 - 7 corresponding to the training on the pixy cam
     */
    public final int signature;

    /**
     * the x,y location of the center of the block.
     * x is in the range(0, 255)
     * 0 is left side field of view and 255 is right side
     * y is in the range (0, 199)
     * 0 is the top of the field of view and 199 is the bottom
     */
    public final int x, y;

    /**
     * the size of the detected block
     * width or height of 0 indicates no detected block
     * maximum width is 255
     * maximum height is 199
     */
    public final int width, height;

    /**
     * the count of blocks detected for a given signature
     * will be -1 for a block of the general query
     */
    public final int blockCount;

    public BadPixyBlock(int signature, byte blockCount, byte x, byte y, byte width, byte height) {
        this(signature, TypeConversion.unsignedByteToInt(blockCount), x, y, width, height);
    }

    public BadPixyBlock(int signature, int blockCount, byte x, byte y, byte width, byte height) {
        this.signature = signature;
        this.x = TypeConversion.unsignedByteToInt(x);
        this.y = TypeConversion.unsignedByteToInt(y);
        this.width = TypeConversion.unsignedByteToInt(width);
        this.height = TypeConversion.unsignedByteToInt(height);
        this.blockCount = blockCount;
    }

    public boolean isEmpty() {
        return x == 0 && y == 0 && height == 0 && width == 0 && blockCount == -1;
    }

    @Override
    public String toString(){
        return String.format("x: %d, y: %d, w: %d, h: %d", this.x, this.y, this.width, this.height, this.blockCount);
    }
}
