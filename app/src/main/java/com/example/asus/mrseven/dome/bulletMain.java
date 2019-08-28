package com.example.asus.mrseven.dome;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;

import com.example.asus.mrseven.framework.FMXGraphics;

public class bulletMain {
    float m_fSpeed=300;
    float m_fUpdateY;
    float m_fUpdateX;
    float m_fPosX;
    float m_fPosY;
    float m_fLocateX;
    float m_fLocateY;
    float a;
    boolean delete;
    Paint paint;
    float m_fSideX=0;
    float m_fSideY=0;
    float m_fBGx = 0;
    float m_fDamage;
    Canvas canvas;
    public int x1, y1, x2, y2, x3, y3, x4, y4;
//    float upper=0;
    public bulletMain(float x, float y) {
        this.m_fPosX = x;
        this.m_fPosY = y;
        this.m_fUpdateY =0;
        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        canvas=new Canvas(constan.fram);
        this.delete=false;
    }

    public void update(float deltaTime) {
//        m_fUpdateY -= deltaTime * 0.01 * 300;
//        a += deltaTime * 0.01 * 50;
        m_fLocateX = m_fPosX + m_fUpdateX;
        m_fLocateY = m_fPosY + m_fUpdateY;
    }

    public void paint(float deltaTime, FMXGraphics g) {
//        g.drawRect(getBounds(), Color.LTGRAY);

//        a+=deltaTime*0.01*50;
//        m_fPosX = ((int) ((delX - 2) + 81 * Math.sin(Math.toRadians(a - 90))));
//        m_fPosY = (int) ((delY) - 81 * Math.cos(Math.toRadians(a - 90)));
//        x1 = (int) (m_fPosX + m_fUpdateX);
//        y1 = (int) (m_fPosY + m_fUpdateY);
//        x2 = (int) (m_fPosX + m_fUpdateX) + 50;
//        y2 = (int) (m_fPosY + m_fUpdateY);
//        x3 = (int) (m_fPosX + m_fUpdateX) + 50;
//        y3 = (int) (m_fPosY + m_fUpdateY) + 50;
//        x4 = (int) (m_fPosX + m_fUpdateX);
//        y4 = (int) (m_fPosY + m_fUpdateY) + 50;
        getBoundaryPath();
    }
    public Rect getBounds(){
        return new Rect((int) ((m_fPosX) + m_fSideX),(int) (m_fPosY + m_fUpdateY),(int) ((m_fPosX) + m_fSideX +10),(int) (m_fPosY + m_fUpdateY +10));
    }

    public Region getBoundaryPath() {
//        Paint wallpaint = new Paint();

//        paint.setColor(Color.MAGENTA);
        Path wallpath = new Path();
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
