package com.example.asus.mrseven.dome;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.Log;

import com.example.asus.mrseven.framework.FMXGraphics;

import java.util.ArrayList;

public class obsSequence {

    private ArrayList<obsSet> m_arrObsSet;
    public String m_strObsType;
    private obsSet m_objObsSet;
    private int m_dNowSetID = 0;
    float biger0, biger1;
    float ccaas=20;
    float m_fTickOn;
    boolean tte = false;
    double angle;
    int xx, yy;
    private float m_fCountDelayBU = 0, m_fCountDelaySW = 0, m_fCountDelaySP = 0;
    private int m_dGabBU = 0, m_dGabSW = 0, m_dGabSP = 0; // =m_fCountDelayBU-m_dGabBU
    private int m_dBulletSecBU = 20, m_dBulletSecSW = 5, m_dBulletSecSP = 5;
    public obsSequence() {
        m_strObsType = "SKY";
        m_arrObsSet = new ArrayList<>();

        m_objObsSet = new obsSet();
        m_objObsSet.initSampleSet(-1);
        m_objObsSet.m_fTriggerTL = 20;
            m_arrObsSet.add(m_objObsSet);

        m_objObsSet = new obsSet();
        m_objObsSet.m_fTriggerTL = 30;
        m_objObsSet.initSampleSet(0);
        m_arrObsSet.add(m_objObsSet);
        m_objObsSet = new obsSet();
        m_objObsSet.m_fTriggerTL = 50;
        m_objObsSet.initSampleSet(1);
        m_arrObsSet.add(m_objObsSet);
        m_objObsSet = new obsSet();
        m_objObsSet.m_fTriggerTL = 70;
        m_objObsSet.initSampleSet(2);
        m_arrObsSet.add(m_objObsSet);

    }

    public void SampleSequence() {

    }

    public boolean Waiting(float CurrentSector) {
        if (m_dNowSetID < m_arrObsSet.size() - 1) {
            if (CurrentSector >= m_arrObsSet.get(m_dNowSetID).m_fTriggerTL) {
                return true;
            }
        }
        return false;
    }

    public void TriggerCurrentSequence() {
        m_dNowSetID++;
    }

    public void SkipCurrentSequence() {

    }

    public void update(float deltaTime) {
        ccaas+=2;
        m_fCountDelayBU +=  2;
        m_dGabBU = (int) m_fCountDelayBU;
        if (m_fCountDelayBU >= m_dBulletSecBU) {
            constan.c_arrBullet.add(new bulletHeros(constan.SCREEN_WIDTH / 2 - (constan.shipsdf.getWidth() / 3 / 2) + constan.shipsdf.getWidth() / 3 / 2, constan.SCREEN_HEIGHT-constan.shipsizeH));
            m_fCountDelayBU = (m_fCountDelayBU - m_dGabBU);
        }
        for (int i = 0; i <= m_dNowSetID; i++) {
            m_arrObsSet.get(i).update(deltaTime);
            for (int j = 0; j <= m_arrObsSet.get(i).m_arrMonster.size() - 1; j++) {
                if (MissileAssis().intersect(m_arrObsSet.get(i).m_arrMonster.get(j).getBounds())) {
//                    xx = (int) m_arrObsSet.get(i).m_arrMonster.get(j).locateX;
//                    yy = (int) m_arrObsSet.get(i).m_arrMonster.get(j).locateY;
                    tte = true;
                    biger0 = 0;
                    biger1 = 0;
                    if (ccaas>=20) {
                        constan.c_arrBullet.add(new bulletMissile(constan.SCREEN_WIDTH / 2 - (constan.shipsdf.getWidth() / 3 / 2) + constan.shipsdf.getWidth() / 3 / 2, constan.SCREEN_HEIGHT - 100,  m_arrObsSet.get(i).m_arrMonster.get(j)));
                        ccaas=0;
                    }
                } else if (biger1 <= constan.SCREEN_HEIGHT) {
//                    tte = false;
                    biger0 +=  15;
                    biger1 += 60;
                } else {
                    tte = false;
                    biger0 = 0;
                    biger1 = 0;
                }

            }

        }

        for (int i = 0; i <= constan.c_arrBullet.size() - 1; i++) {
            constan.c_arrBullet.get(i).m_fBGx = gameController.m_objPosX.m_fAcc;
            constan.c_arrBullet.get(i).update(deltaTime);
            if (constan.c_arrBullet.get(i).m_fLocateY < -10) {
                constan.c_arrBullet.remove(i);
            }
        }
    }
    private void funBullet(float deltaTime) {


    }
    public void paint(float deltaTime, FMXGraphics g) {
        for (int i = 0; i <= m_dNowSetID; i++) {
            m_arrObsSet.get(i).paint(deltaTime, g);
        }
        for (int i = 0; i < constan.c_arrBullet.size() - 1; i++) {
            constan.c_arrBullet.get(i).paint(deltaTime, g);
        }
//        g.drawRect(MissileAssis(),Color.LTGRAY);
//        if (tte)
//        g.drawLine(constan.SCREEN_WIDTH / 2, constan.SCREEN_HEIGHT - 200, xx, yy, Color.MAGENTA);
    }


    protected double bearing(double x1, double y1, double x2, double y2) {
        return (Math.atan2(y2 - y1, x2 - x1) * 180 / Math.PI) + 180;
    }

    public Rect MissileAssis() {
        return new Rect((int) (constan.SCREEN_WIDTH / 2 - 10 - biger0), (int) (constan.SCREEN_HEIGHT - 100 - biger1), (int) (constan.SCREEN_WIDTH / 2 + 10 + biger0), constan.SCREEN_HEIGHT - 100);
    }

}
