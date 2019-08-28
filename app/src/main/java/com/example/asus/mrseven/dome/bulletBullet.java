package com.example.asus.mrseven.dome;

import android.graphics.Color;
import android.graphics.Rect;

import com.example.asus.mrseven.framework.FMXGraphics;

public class bulletBullet extends bulletMain {
    //    float upper = 0;
    float m_positionX;
    float m_positionY;
    float m_fBGx = 0;
    //    float side;
    float m_fDamage = 1;

    public bulletBullet(float x, float y) {
        super(x, y);

    }

    @Override
    public void update(float deltaTime) {
        m_fUpdateY -= deltaTime * 0.01 * 500;
//        for (int i = 0; i <= gameController.m_arrSplash.size() - 1; i++) {
//            if (getBounds().intersect(gameController.m_arrSplash.get(i).getBounds())){
//                Log.i("yayayay", "update: ");
//            }
//        }
        super.update(deltaTime);
    }

    @Override
    public void paint(float deltaTime, FMXGraphics g) {

//        g.drawRect((int) (m_positionX + side), (int) (m_positionY + upper), 10, 10, Color.RED);
        g.drawRect(getBounds(), Color.CYAN);
        super.paint(deltaTime, g);

    }

    @Override
    public Rect getBounds() {
        return super.getBounds();
    }

}
