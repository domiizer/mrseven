package com.example.asus.mrseven.dome;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Region;

import com.example.asus.mrseven.framework.FMXGraphics;

public class Type32 extends Monster {

    public Type32(float x, float y, float delay) {
        super(x, y, delay);
        this.paint.setColor(Color.MAGENTA);
        this.m_fHP=500;
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
