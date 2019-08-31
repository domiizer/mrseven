package com.example.asus.mrseven.dome;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Region;
import android.util.Log;

import com.example.asus.mrseven.framework.FMXGraphics;

public class bulletHeros extends bulletMain {


    public bulletHeros(float x, float y) {
        super(x, y);
        if (constan.setfillter) {
            if (constan.changeColor) {
                this.paint.setColor(Color.rgb(255, 255, 0));
                this.Yellow=true;
                this.m_fDamage=20;
            } else {
                this.paint.setColor(Color.rgb(102, 204, 255));
                this.m_fDamage=20;
                this.Yellow=false;
            }
        }else {
            this.paint.setColor(Color.rgb(255, 0, 0));
            this.m_fDamage = 0;
        }
        this.m_fSideX = 10;
        this.m_fSideY = 20;
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        m_fUpdateY -= deltaTime * 0.01 * m_fSpeed;

    }

    @Override
    public void paint(float deltaTime, FMXGraphics g) {
        super.paint(deltaTime, g);
        g.drawLine((int) (m_fPosX), (int) (m_fPosY), (int) m_fPosX, 0, Color.GREEN);

        x1 = (int) (m_fPosX + m_fUpdateX);
        y1 = (int) (m_fPosY + m_fUpdateY);
        x2 = (int) (m_fPosX + m_fUpdateX + m_fSideY);
        y2 = (int) (m_fPosY + m_fUpdateY);
        x3 = (int) (m_fPosX + m_fUpdateX + m_fSideY);
        y3 = (int) (m_fPosY + m_fUpdateY + m_fSideX);
        x4 = (int) (m_fPosX + m_fUpdateX);
        y4 = (int) (m_fPosY + m_fUpdateY + m_fSideX);


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
