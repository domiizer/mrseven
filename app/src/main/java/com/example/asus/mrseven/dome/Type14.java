package com.example.asus.mrseven.dome;

import android.graphics.Rect;
import android.util.Log;

import com.example.asus.mrseven.framework.FMXGraphics;

public class Type14 extends Monster {
    float countWait;
    boolean isR, isCenter = false;

    public Type14(float x, float y, float delay) {
        super(x, y, delay);
        this.m_fHP=200;
        if (x > constan.SCREEN_WIDTH / 2) {
            isR = false;
        } else if (x < constan.SCREEN_WIDTH / 2) {
            isR = true;
        } else {
            isCenter = true;
        }
        this.m_fUpdatexSpeed=100;
    }

    @Override
    public void update(float deltaTime) {
        m_fcountDelay += deltaTime * 0.01;
        if (m_fcountDelay >= m_fDelay) {
            if (!isR && !isCenter) {
                Log.i("sdfsdf", "update: ");
                m_fUpdateX -= deltaTime * 0.01 * m_fUpdatexSpeed;
                m_fUpdateY += deltaTime * 0.01 * 100;
                if (m_fPosX + m_fUpdateX + (m_dSizeX / 2) < constan.SCREEN_WIDTH / 2) {
                    isCenter = true;
                    m_fPosX = constan.SCREEN_WIDTH / 2 - m_dSizeX / 2;
                    m_fUpdateX = 0;
                }
            } else if (!isR) {
                countWait += deltaTime * 0.01;
                if (countWait >= 2) {
                    m_fUpdateY += deltaTime * 0.01 * 500;
                }
            }

            if (isR && !isCenter) {
                m_fUpdateX += deltaTime * 0.01 * m_fUpdatexSpeed;
                m_fUpdateY += deltaTime * 0.01 * 100;
                if (m_fPosX + m_fUpdateX + (m_dSizeX / 2) > constan.SCREEN_WIDTH / 2) {
                    isCenter = true;
                    m_fPosX = constan.SCREEN_WIDTH / 2 - m_dSizeX / 2;
                    m_fUpdateX = 0;
                    m_fUpdatexSpeed=0;
                }
            } else if (isR) {
                countWait += deltaTime * 0.01;
                if (countWait >= 2) {
                    m_fUpdateY += deltaTime * 0.01 * 500;
                }
            }
        }
        super.update(deltaTime);
    }

    @Override
    public void paint(float deltaTime, FMXGraphics g) {
        super.paint(deltaTime, g);
    }

    @Override
    public Rect getBounds() {
        return super.getBounds();
    }
}
