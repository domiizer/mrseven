package com.example.asus.mrseven.dome;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.util.Log;

import com.example.asus.mrseven.framework.FMXGraphics;

public class Monster {
    float m_fPosX;
    float m_fPosY;
    float m_fUpdateY;
    float m_fUpdateX;
    float m_fUpdatexSpeed;
    float m_fHP;
    float lr = 0;
    int m_dSizeX,m_dSizeY;
    float m_fDelay;
    int locateX,locateY;
    float m_fcountDelay;
    Paint paintex = new Paint();
    Paint paint;
    float a=0;
    Canvas canvas;
    public int x1,y1,x2,y2,x3,y3,x4,y4;
    public Monster(float x, float y,float delay) {
        paintex.setColor(Color.YELLOW);
        paintex.setTextSize(50);
        this.m_fDelay=delay;
        this.m_dSizeX=100;
        this.m_dSizeY=50;
        this.m_fPosX = x;
        this.m_fPosY = y;
        this.m_fcountDelay=0;
        this.m_fHP=100;
        canvas = new Canvas(constan.fram);
        locateX=(int) (m_fPosX + lr+ m_fUpdateX);
        locateY=(int) (m_fPosY + m_fUpdateY +m_dSizeY);
        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
    }
    public void update(float deltaTime) {
//        m_fUpdateY += deltaTime * 0.01 * 50;
        lr += gameController.m_objPosX.m_fAcc;
        locateX=(int) (m_fPosX + lr+ m_fUpdateX +m_dSizeX/2);
        locateY=(int) (m_fPosY + m_fUpdateY +m_dSizeY);



    }
    public void paint(float deltaTime, FMXGraphics g) {
//        g.drawRect(getBounds(),Color.LTGRAY);
        x1= (int) (m_fPosX+m_fUpdateX);
        y1= (int) (m_fPosY+m_fUpdateY);
        x2= (int) (m_fPosX+m_fUpdateX)+100;
        y2= (int) (m_fPosY+m_fUpdateY);
        x3= (int) (m_fPosX+m_fUpdateX)+100;
        y3= (int) (m_fPosY+m_fUpdateY)+100;
        x4= (int) (m_fPosX+m_fUpdateX);
        y4= (int) (m_fPosY+m_fUpdateY)+100;
        getBoundaryPath();

    }
    public Rect getBounds() {
        return new Rect((int) (m_fPosX + lr+ m_fUpdateX), (int) (m_fPosY + m_fUpdateY +m_dSizeY), (int) (m_fPosX +lr+ m_dSizeX+ m_fUpdateX), (int) (m_fPosY + m_fUpdateY));
    }
    public Region getBoundaryPath() {
//        Paint wallpaint = new Paint();
//        wallpaint.setStyle(Paint.Style.FILL);
//        wallpaint.setColor(Color.MAGENTA);
        Path wallpath = new Path();
        wallpath.reset(); // only needed when reusing this path for a new build
        double cenX=(x4+x3+x2+x1)/4,cenY=(y4+y3+y2+y1)/4;
        double xp1=(cenX)+(x1-(cenX))*Math.cos(Math.toRadians(a - 90))-(y1-(cenY))*Math.sin(Math.toRadians(a - 90))
                ,yp1=(cenY)+(x1-(cenX))*Math.sin(Math.toRadians(a - 90))+(y1-(cenY))*Math.cos(Math.toRadians(a - 90));
        double xp2=(cenX)+(x2-(cenX))*Math.cos(Math.toRadians(a - 90))-(y2-(cenY))*Math.sin(Math.toRadians(a - 90))
                ,yp2=(cenY)+(x2-(cenX))*Math.sin(Math.toRadians(a - 90))+(y2-(cenY))*Math.cos(Math.toRadians(a - 90));
        double xp3=(cenX)+(x3-(cenX))*Math.cos(Math.toRadians(a - 90))-(y3-(cenY))*Math.sin(Math.toRadians(a - 90))
                ,yp3=(cenY)+(x3-(cenX))*Math.sin(Math.toRadians(a - 90))+(y3-(cenY))*Math.cos(Math.toRadians(a - 90));
        double xp4=(cenX)+(x4-(cenX))*Math.cos(Math.toRadians(a - 90))-(y4-(cenY))*Math.sin(Math.toRadians(a - 90))
                ,yp4=(cenY)+(x4-(cenX))*Math.sin(Math.toRadians(a - 90))+(y4-(cenY))*Math.cos(Math.toRadians(a - 90));
        wallpath.moveTo((float) (xp1), (float) (yp1)); // used for first point
        wallpath.lineTo((float) (xp2), (float) (yp2));
        wallpath.lineTo((float) (xp3), (float) (yp3));
        wallpath.lineTo((float) (xp4), (float) (yp4));
        wallpath.lineTo((float)(xp1), (float) (yp1)); // there is a setLastPoint action but i found it not to work as expected
        canvas.drawPath(wallpath,paint);
        Path path1 = new Path();
        Region region1 = new Region(0, 0, 1000, 1000);
        Region region2 = new Region(0, 0, 1000, 1000);
//        canvas.drawPath(path1,wallpaint);
        region1.setPath(wallpath, region1);
//        region2.setPath(path1, region2);
        return region1;
    }

}
