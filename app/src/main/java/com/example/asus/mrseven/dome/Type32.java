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
        this.m_fPosX=x;
        this.m_fPosY=y;
        this.m_dSizeX=100;
        this.m_dSizeY=100;
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        a = (float) bearing(x1+m_dSizeX/2 , y1+m_dSizeY/2, constan.ObjHeros.locateX, constan.ObjHeros.locateY);
        m_fUpdateX += 25 *(Math.sin(Math.toRadians(a - 90)));
        m_fUpdateY -= 25 * (Math.cos(Math.toRadians(a - 90)));
    }

    protected double bearing(double x1, double y1, double x2, double y2) {
        return (Math.atan2(y2 - y1, x2 - x1) * 180 / Math.PI) + 180;
    }
    @Override
    public void paint(float deltaTime, FMXGraphics g) {
        super.paint(deltaTime, g);
        g.drawLine((int) (x1+m_dSizeX/2), (int) (y1+m_dSizeY/2),  constan.ObjHeros.locateX, constan.ObjHeros.locateY, Color.MAGENTA);
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
