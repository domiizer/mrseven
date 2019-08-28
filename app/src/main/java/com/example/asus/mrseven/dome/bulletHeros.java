package com.example.asus.mrseven.dome;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Region;
import android.util.Log;

import com.example.asus.mrseven.framework.FMXGraphics;

public class bulletHeros extends bulletMain {


    public bulletHeros(float x, float y) {
        super(x, y);
        this.m_fDamage=0;
        this.paint.setColor(Color.rgb(255, 255, 0));

    }

    @Override
    public void update(float deltaTime) {
        m_fUpdateY -= deltaTime * 0.01 * m_fSpeed;
        m_fSideX=10;
        m_fSideY=20;
        super.update(deltaTime);
    }

    @Override
    public void paint(float deltaTime, FMXGraphics g) {
        x1 = (int) (m_fPosX + m_fUpdateX);
        y1 = (int) (m_fPosY + m_fUpdateY);
        x2 = (int) (m_fPosX + m_fUpdateX+m_fSideY);
        y2 = (int) (m_fPosY + m_fUpdateY);
        x3 = (int) (m_fPosX + m_fUpdateX+m_fSideY);
        y3 = (int) (m_fPosY + m_fUpdateY+m_fSideX);
        x4 = (int) (m_fPosX + m_fUpdateX);
        y4 = (int) (m_fPosY + m_fUpdateY+m_fSideX);
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
