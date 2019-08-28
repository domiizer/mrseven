package com.example.asus.mrseven.dome;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Region;
import android.util.Log;

import com.example.asus.mrseven.framework.FMXGraphics;

public class bulletMissile extends bulletMain {
    float m_fAngle;
    Monster m_ObjMonster;


    public bulletMissile(float x, float y, Monster monster) {
        super(x, y);
        this.m_fPosX = x;
        this.m_fPosY = y;
        this.m_ObjMonster = monster;
        this.paint.setColor(Color.RED);
        this.a = 0;
        this.m_fDamage = 0;
        this.m_fSideX=10;
        this.m_fSideY=20;
        x1 = (int) x;
        y1 = (int) y;
        x2 = (int) (x + m_fSideX);
        y2 = (int) y;
        x3 = (int) (x + m_fSideX);
        y3 = (int) (y + m_fSideY);
        x4 = (int) x;
        y4 = (int) (y + m_fSideY);
    }

    @Override
    public void update(float deltaTime) {

        super.update(deltaTime);
    }

    @Override
    public void paint(float deltaTime, FMXGraphics g) {
        if (y1>m_ObjMonster.locateY) {
        g.drawLine((int) (m_fPosX), (int) (m_fPosY), m_ObjMonster.locateX, m_ObjMonster.locateY, Color.MAGENTA);
        a = (float) bearing(m_fPosX , m_fPosY, m_ObjMonster.locateX, m_ObjMonster.locateY);
        m_fUpdateX += 2 *(Math.sin(Math.toRadians(a - 90)));
        m_fUpdateY -= 2 * (Math.cos(Math.toRadians(a - 90)));
        x1 += (int) (m_fUpdateX);
        y1 += (int) (m_fUpdateY);
        x2 += (int) (m_fUpdateX);
        y2 += (int) (m_fUpdateY);
        x3 += (int) (m_fUpdateX);
        y3 += (int) (m_fUpdateY);
        x4 += (int) (m_fUpdateX);
        y4 += (int) (m_fUpdateY);
        }
        else {
            this.delete=true;
        }
//        Log.i("m_ObjMonster", "paint: "+m_ObjMonster.locateY+"xxxx"+m_ObjMonster.locateX);
        super.paint(deltaTime, g);
    }


    protected double bearing(double x1, double y1, double x2, double y2) {
        return (Math.atan2(y2 - y1, x2 - x1) * 180 / Math.PI) + 180;
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
