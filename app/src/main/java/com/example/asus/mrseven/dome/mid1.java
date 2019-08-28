package com.example.asus.mrseven.dome;

import android.graphics.Rect;

import com.example.asus.mrseven.framework.FMXGraphics;

public class mid1 extends Monster {
    float countDelay;
    boolean testertestest=false;
    public mid1(float x, float y,float delay) {
        super(x, y,delay);
        this.m_fDelay=delay;
        this.m_dSizeX=100;
        this.m_dSizeY=100;
        this.m_fHP=30;
        this.m_fUpdatexSpeed=50;
    }

    @Override
    public void update(float deltaTime) {
        countDelay+=deltaTime*0.01;
        if (countDelay>=m_fDelay) {
            if (testertestest){
                m_fUpdateX-=deltaTime*0.01*m_fUpdatexSpeed;
                if (m_fUpdateX<0){
                    testertestest=false;
                }
            }else {
                m_fUpdateX+=deltaTime*0.01*m_fUpdatexSpeed;
                if (m_fUpdateX>300){
                    testertestest=true;
                }
            }
//            this.m_fUpdateY += deltaTime * 0.01 * constan.gridSpeed;

        }
        super.update(deltaTime);
    }

    @Override
    public void paint(float deltaTime, FMXGraphics g) {
//        g.drawRect(getBounds(), Color.WHITE);
        super.paint(deltaTime, g);

    }

    @Override
    public Rect getBounds() {
        return super.getBounds();
    }
}
