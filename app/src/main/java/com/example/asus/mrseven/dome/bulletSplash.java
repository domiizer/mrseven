package com.example.asus.mrseven.dome;

import android.graphics.Color;
import android.graphics.Rect;

import com.example.asus.mrseven.framework.FMXGraphics;

public class bulletSplash extends bulletMain{
    float m_positionX;
    float m_fDelX;
    float m_positionY;
    float m_fDelY;
    int m_dAngle;
    float upper;
    float side;
    float m_fBGx = 0;

    public bulletSplash(float positionX, float positionY, int angle) {
        super(positionX,positionY);
        this.m_positionX=positionX;
        this.m_positionY=positionY;
        this.m_dAngle=angle;
    }


    protected double bearing(double x1, double y1, double x2, double y2) {
        return (Math.atan2(y2 - y1, x2 - x1) * 180 / Math.PI) + 180;
    }
    @Override
    public void update(float deltaTime) {
        upper-=deltaTime*0.01*400;
        side+=m_fBGx*deltaTime*0.01*50;
        m_fDelX+=20*Math.sin(Math.toRadians(m_dAngle))*deltaTime*0.01*20;
        m_fDelY+=20*Math.cos(Math.toRadians(m_dAngle))*deltaTime*0.01*20;
//        g.drawImageRotate(gunbullet1, (int) ((delX - 7) + leg * Math.sin(Math.toRadians(a - 90))), (int) ((delY - 72) - leg * Math.cos(Math.toRadians(a - 90))), a - 90, 255);

    }
    @Override
    public void paint(float deltaTime, FMXGraphics g) {
//        g.drawRect((int) (((m_positionX )+m_fDelX)+25* Math.sin(Math.toRadians(m_dAngle))+side), (int) ((m_positionY + m_fDelY)+5* Math.cos(Math.toRadians(m_dAngle))), 10, 10, Color.YELLOW);
        g.drawRect(getBounds(),Color.YELLOW);
    }
    @Override
    public Rect getBounds() {
        return new Rect((int) (((m_positionX )+m_fDelX)+25* Math.sin(Math.toRadians(m_dAngle))+side), (int)((m_positionY + m_fDelY)+5* Math.cos(Math.toRadians(m_dAngle))), (int) (((m_positionX )+m_fDelX)+25* Math.sin(Math.toRadians(m_dAngle))+side)+10, (int)((m_positionY + m_fDelY)+5* Math.cos(Math.toRadians(m_dAngle)))+10);
    }
}
