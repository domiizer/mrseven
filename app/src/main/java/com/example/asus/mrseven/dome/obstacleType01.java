package com.example.asus.mrseven.dome;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;

import com.example.asus.mrseven.framework.FMXGraphics;

public class obstacleType01 {
    float m_fPosX;
    float m_fPosY;
    float m_fUp;
    float m_fDown;
    float m_fHP = 2;
    float lr = 0;
    Paint paintex = new Paint();

    public obstacleType01(float x, float y) {
        paintex.setColor(Color.YELLOW);
        paintex.setTextSize(50);
        this.m_fPosX = x;
        this.m_fPosY = y;
    }

    public void update(float deltaTime) {
        m_fUp -= deltaTime * 0.01 * 50;
        lr += gameController.m_objPosX.m_fAcc;
        Log.i("dsfgdg", "update: sdfsdf");
//        if (gameController.m_arrBullet.size()>0){
//            Log.i("000002", "update: ");
//            for (int i = 0; i <= gameController.m_arrBullet.size() - 1; i++) {
//                Log.i("000003", "update: "+gameController.m_arrBullet.size());
//                if (gameController.m_arrBullet.get(i).getBounds().intersect(getBounds())){
//                    Log.i("000004", "update: ");
//                    gameController.m_arrBullet.remove(i);
//                }
//            }
//        }
    }

    public void paint(float deltaTime, FMXGraphics g) {
//        g.drawRect(getBounds(),Color.MAGENTA);
        g.drawRectF(getBoundsf(),Color.GREEN);
        g.drawString("T-01", (int) (m_fPosX + lr), (int) (m_fPosY + m_fUp), paintex);

    }

    public Rect getBounds() {
        return new Rect((int) (m_fPosX + lr), (int) (m_fPosY + m_fUp+200), (int) (m_fPosX +lr+ 200), (int) (m_fPosY +m_fUp));
    }
    public RectF getBoundsf() {
        return new RectF((int) (m_fPosX + lr), (int) (m_fPosY + m_fUp+200), (int) (m_fPosX +lr+ 200), (int) (m_fPosY +m_fUp));
    }

}
