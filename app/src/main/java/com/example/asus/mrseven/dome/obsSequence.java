package com.example.asus.mrseven.dome;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
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
    public int x1, y1, x2, y2, x3, y3, x4, y4;
    Canvas canvas;
    Paint paint;
    public obsSequence() {
        m_strObsType = "SKY";
        m_arrObsSet = new ArrayList<>();
        canvas=new Canvas(constan.fram);
        paint = new Paint();
        paint.setColor(Color.LTGRAY);
        paint.setStyle(Paint.Style.FILL);
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


        x1 = (int) (constan.SCREEN_WIDTH / 2 - 10 );
        y1 = (int) (constan.SCREEN_HEIGHT - 100 );
        x2 = (int) (constan.SCREEN_WIDTH / 2 - 10 )+10;
        y2 = (int) (constan.SCREEN_HEIGHT - 100 );
        x3 = (int) (constan.SCREEN_WIDTH / 2 - 10 )+10;
        y3 = (int) (constan.SCREEN_HEIGHT - 100 )+10;
        x4 = (int) (constan.SCREEN_WIDTH / 2 - 10 );
        y4 = (int) (constan.SCREEN_HEIGHT - 100 )+10;
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

        x1 = (int) (constan.SCREEN_WIDTH / 2 - 10 );
        y1 = (int) (constan.SCREEN_HEIGHT - 100 );
        x2 = (int) (constan.SCREEN_WIDTH / 2 - 10+biger1 )+10;
        y2 = (int) (constan.SCREEN_HEIGHT - 100 );
        x3 = (int) (constan.SCREEN_WIDTH / 2 - 10+biger1 )+10;
        y3 = (int) (constan.SCREEN_HEIGHT - 100 +biger0)+10;
        x4 = (int) (constan.SCREEN_WIDTH / 2 - 10 );
        y4 = (int) (constan.SCREEN_HEIGHT - 100 +biger0)+10;
        if (m_fCountDelayBU >= m_dBulletSecBU) {
            constan.c_arrBullet.add(new bulletHeros(constan.SCREEN_WIDTH / 2 -5 , constan.SCREEN_HEIGHT-constan.shipsizeH));
            m_fCountDelayBU = (m_fCountDelayBU - m_dGabBU);
        }
        for (int i = 0; i <= m_dNowSetID; i++) {
            m_arrObsSet.get(i).update(deltaTime);
            for (int j = 0; j <= m_arrObsSet.get(i).m_arrMonster.size() - 1; j++) {
//                if (getBoundaryPath().op((m_arrObsSet.get(i).m_arrMonster.get(j).getBoundaryPath()), Region.Op.INTERSECT)) {
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
                    biger0 +=  deltaTime*0.01*15;
                    biger1 += deltaTime*0.01*60;
                } else {
                    tte = false;
                    biger0 = 0;
                    biger1 = 0;
                }

            }

        }

        for (int i = 0; i <=constan.c_arrBullet.size() - 1; i++) {
            constan.c_arrBullet.get(i).m_fBGx = gameController.m_objPosX.m_fAcc;
            constan.c_arrBullet.get(i).update(deltaTime);
            if (constan.c_arrBullet.get(i).m_fLocateY < -10|constan.c_arrBullet.get(i).m_fLocateX>constan.SCREEN_WIDTH+30|constan.c_arrBullet.get(i).m_fLocateX<-30|constan.c_arrBullet.get(i).m_fLocateY > constan.SCREEN_HEIGHT+20) {
                constan.c_arrBullet.remove(i);
            }
        }
        Log.i("asdffdsasdf", "update: "+constan.c_arrBullet.size());
    }
    private void funBullet(float deltaTime) {


    }
    public void paint(float deltaTime, FMXGraphics g) {
        for (int i = 0; i <= m_dNowSetID; i++) {
            m_arrObsSet.get(i).paint(deltaTime, g);
        }
        for (int i = 0; i < constan.c_arrBullet.size() - 1; i++) {
//            constan.c_arrBullet.get(i).m_fBGx = gameController.m_objPosX.m_fAcc;
//            constan.c_arrBullet.get(i).update(deltaTime);
            constan.c_arrBullet.get(i).paint(deltaTime, g);
//            if (constan.c_arrBullet.get(i).m_fLocateY < -10) {
//                constan.c_arrBullet.remove(i);
//            }
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
    public Region getBoundaryPath() {
//        Paint wallpaint = new Paint();

//        paint.setColor(Color.MAGENTA);
        Path wallpath = new Path();
        int a=0;
        wallpath.reset(); // only needed when reusing this path for a new build
        double cenX = (x4 + x3 + x2 + x1) / 4, cenY = (y4 + y3 + y2 + y1) / 4;
        double xp1 = (cenX) + (x1 - (cenX)) * Math.cos(Math.toRadians(a - 90)) - (y1 - (cenY)) * Math.sin(Math.toRadians(a - 90)), yp1 = (cenY) + (x1 - (cenX)) * Math.sin(Math.toRadians(a - 90)) + (y1 - (cenY)) * Math.cos(Math.toRadians(a - 90));
        double xp2 = (cenX) + (x2 - (cenX)) * Math.cos(Math.toRadians(a - 90)) - (y2 - (cenY)) * Math.sin(Math.toRadians(a - 90)), yp2 = (cenY) + (x2 - (cenX)) * Math.sin(Math.toRadians(a - 90)) + (y2 - (cenY)) * Math.cos(Math.toRadians(a - 90));
        double xp3 = (cenX) + (x3 - (cenX)) * Math.cos(Math.toRadians(a - 90)) - (y3 - (cenY)) * Math.sin(Math.toRadians(a - 90)), yp3 = (cenY) + (x3 - (cenX)) * Math.sin(Math.toRadians(a - 90)) + (y3 - (cenY)) * Math.cos(Math.toRadians(a - 90));
        double xp4 = (cenX) + (x4 - (cenX)) * Math.cos(Math.toRadians(a - 90)) - (y4 - (cenY)) * Math.sin(Math.toRadians(a - 90)), yp4 = (cenY) + (x4 - (cenX)) * Math.sin(Math.toRadians(a - 90)) + (y4 - (cenY)) * Math.cos(Math.toRadians(a - 90));
        wallpath.moveTo((float) (xp1), (float) (yp1)); // used for first point
        wallpath.lineTo((float) (xp2), (float) (yp2));
        wallpath.lineTo((float) (xp3), (float) (yp3));
        wallpath.lineTo((float) (xp4), (float) (yp4));
        wallpath.lineTo((float) (xp1), (float) (yp1)); // there is a setLastPoint action but i found it not to work as expected
//        canvas.drawPath(wallpath,wallpaint);
        Path path1 = new Path();
        Region region1 = new Region(0, 0, 1000, 1000);
        Region region2 = new Region(0, 0, 1000, 1000);
        canvas.drawPath(wallpath, paint);
//        canvas.drawPath(path1,wallpaint);
        region1.setPath(wallpath, region1);
//        region2.setPath(path1, region2);
        return region1;
    }
}
