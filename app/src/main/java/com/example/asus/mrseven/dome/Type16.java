package com.example.asus.mrseven.dome;

import android.graphics.Rect;

import com.example.asus.mrseven.framework.FMXGraphics;

public class Type16 extends Monster{
    public Type16(float x, float y, float delay) {
        super(x, y, delay);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
    }

    @Override
    public void paint(float deltaTime, FMXGraphics g) {
        m_fcountDelay+=deltaTime*0.01;
        if (m_fcountDelay>=m_fDelay){
            
        }
        super.paint(deltaTime, g);
    }

    @Override
    public Rect getBounds() {
        return super.getBounds();
    }
}
