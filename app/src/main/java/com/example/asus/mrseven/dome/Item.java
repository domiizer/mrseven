package com.example.asus.mrseven.dome;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import com.example.asus.mrseven.framework.FMXGraphics;

public class Item  {
    float m_fPosX;
    float m_fPosY;
    float m_fUp;
    float lr = 0;
    Paint paintex = new Paint();

    public Item(float x, float y) {
        this.m_fPosX = x;
        this.m_fPosY = y;
        paintex.setColor(Color.YELLOW);
        paintex.setTextSize(50);
    }

    public void update(float deltaTime) {
//        m_fUpdateY -= deltaTime * 0.01 * 50;
        m_fUp+=constan.gridY;
        lr+=constan.gridX;
    }
    public void paint(float deltaTime, FMXGraphics g) {
        g.drawString("It-01",(int) (m_fPosX + lr), (int) (m_fPosY + m_fUp+200),paintex);
    }
    public Rect getBounds() {
        return new Rect((int) (m_fPosX + lr), (int) (m_fPosY + m_fUp+200), (int) (m_fPosX +lr+ 200), (int) (m_fPosY +m_fUp));
    }
}
