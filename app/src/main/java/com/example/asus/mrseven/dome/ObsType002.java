package com.example.asus.mrseven.dome;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;

import com.example.asus.mrseven.framework.FMXGraphics;

public class ObsType002 extends obstacleType01 {
    public ObsType002(float x, float y) {
        super(x, y);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
    }

    @Override
    public void paint(float deltaTime, FMXGraphics g) {
        g.drawRect((int)m_fPosX,(int)m_fPosY,50,50, Color.YELLOW);
        super.paint(deltaTime, g);
    }

    @Override
    public Rect getBounds() {
        return super.getBounds();
    }

    @Override
    public RectF getBoundsf() {
        return super.getBoundsf();
    }
}
