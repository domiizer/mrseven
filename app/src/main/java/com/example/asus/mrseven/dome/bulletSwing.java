package com.example.asus.mrseven.dome;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;

import com.example.asus.mrseven.framework.FMXGraphics;

public class bulletSwing extends bulletMain{
    float upper;
    float m_positionX;
    float m_positionY;
    float m_fBGx = 0;
    float side;

    public bulletSwing(float positionX, float positionY) {
        super(positionX,positionY);

        this.m_positionX = positionX;
        this.m_positionY = positionY;

    }
    @Override
    public void update(float deltaTime) {
        upper -= deltaTime * 0.01 * 400;

        side += m_fBGx*deltaTime*0.01*50;
    }
    @Override
    public void paint(float deltaTime, FMXGraphics g) {
        g.drawRect((int) ((m_positionX) + side), (int) (m_positionY + upper), 10, 10, Color.GREEN);
    }

    @Override
    public Rect getBounds() {
        return super.getBounds();
    }
}