package com.example.asus.mrseven.dome;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Region;

import com.example.asus.mrseven.framework.FMXGraphics;

public class Type31prismStage extends Monster{

    public Type31prismStage(float x, float y, float delay) {
        super(x, y, delay);
        this.m_fHP=10;
        this.m_dSizeX=100;
        this.m_dSizeY=50;
        this.paint.setColor(Color.rgb(207, 208, 0));//Yellow
        this.Type=31;

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
