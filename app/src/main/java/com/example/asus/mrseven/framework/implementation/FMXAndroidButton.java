package com.example.asus.mrseven.framework.implementation;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.asus.mrseven.framework.FMXButton;

public class FMXAndroidButton implements FMXButton{

    private Rect rect;
    public Rect drawBTRects(int x, int y, int width, int height){
        rect =new Rect(x, y, x + width - 1, y + height - 1);
        return rect;
    }
}
