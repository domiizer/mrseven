package com.example.asus.mrseven.dome;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.util.Log;

import com.example.asus.mrseven.framework.FMXGraphics;

import java.util.ArrayList;

public class obsSet {
    float m_fTriggerTL;
    ArrayList<obstacleType01> m_arrType01;
    ArrayList<Monster> m_arrMonster;
    ArrayList<Item> m_arrItem;

    public obsSet() {
        m_arrType01 = new ArrayList<>();
        m_arrMonster = new ArrayList<>();
        m_arrItem = new ArrayList<>();
    }

    public void initSampleSet(int nID) {
        if (nID == 0) {
//            m_fTriggerTL=35;
            m_arrMonster.add(new Type14(constan.SCREEN_WIDTH + 60, -30, 5));
            m_arrMonster.add(new Type14(-60, -30, 0));
        } else if (nID == 1) {
//            m_fTriggerTL=60;
            m_arrMonster.add(new Type31prismStage(constan.SCREEN_WIDTH/2 - 50, 400, 0));
            m_arrMonster.add(new mid1(50, 450, 5));
        } else if (nID == 2) {
//            m_fTriggerTL=200;
            m_arrItem.add(new Item(0, -200));
        }
    }


    public void update(float deltaTime) {
        for (int i = 0; i <= m_arrType01.size() - 1; i++) {
            m_arrType01.get(i).update(deltaTime);
        }
        for (int i = 0; i <= m_arrMonster.size() - 1; i++) {
            m_arrMonster.get(i).update(deltaTime);
        }
        for (int j = 0; j <= constan.c_arrBullet.size() - 1; j++) {
            for (int i = 0; i <= m_arrMonster.size() - 1; i++) {
                if (m_arrMonster.get(i).getBoundaryPath().op(constan.c_arrBullet.get(j).getBoundaryPath(), Region.Op.INTERSECT)) {
                    Log.i("asdfasdfasdf", "update: ");

                    if (m_arrMonster.get(i).m_fHP - constan.c_arrBullet.get(j).m_fDamage <= 0) {
                        m_arrMonster.remove(i);
                        constan.c_arrBullet.remove(j);
                        break;
                    } else {
                        m_arrMonster.get(i).m_fHP -= constan.c_arrBullet.get(j).m_fDamage;
                        constan.c_arrBullet.remove(j);
                    }

                }
            }
            if (constan.c_arrBullet.get(j).delete) {
                constan.c_arrBullet.remove(j);
            }
        }
        for (int i = 0; i <= m_arrItem.size() - 1; i++) {
            m_arrItem.get(i).update(deltaTime);
        }

    }

    public void paint(float deltaTime, FMXGraphics g) {


        for (int i = 0; i <= m_arrType01.size() - 1; i++) {
            m_arrType01.get(i).paint(deltaTime, g);
        }
        for (int i = 0; i <= m_arrMonster.size() - 1; i++) {
            m_arrMonster.get(i).paint(deltaTime, g);

        }
        for (int i = 0; i <= m_arrItem.size() - 1; i++) {
            m_arrItem.get(i).paint(deltaTime, g);
        }

    }


}
