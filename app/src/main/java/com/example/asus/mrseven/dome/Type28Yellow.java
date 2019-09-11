package com.example.asus.mrseven.dome;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;

import com.example.asus.mrseven.framework.FMXGraphics;

public class Type28Yellow extends obstacleType01 {

    public Type28Yellow(float x, float y, int Radius) {
        super(x, y, Radius);
        this.paint.setColor(Color.rgb(207, 208, 0));//Yellow
        this.Type=28;
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
    }

    @Override
    public void paint(float deltaTime, FMXGraphics g) {
        super.paint(deltaTime, g);
    }

    @Override
    public Rect getBounds() {
        return super.getBounds();
    }

    @Override
    public Region getBoundaryPath() {
        return super.getBoundaryPath();
    }
}
