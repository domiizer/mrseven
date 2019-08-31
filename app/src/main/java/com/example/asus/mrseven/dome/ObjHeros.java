package com.example.asus.mrseven.dome;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;

import com.example.asus.mrseven.framework.FMXGraphics;

public class ObjHeros  {
    float m_fPosX;
    float m_fPosY;
    float m_fUpdateY;
    float m_fUpdateX;
    float m_fcountDelay;
    Paint paintex = new Paint();
    Paint paint;
    float a=0;
    Canvas canvas;
    int m_dRadius;
    float m_fDelay;
    int locateX,locateY;
    public int x1,y1,x2,y2,x3,y3,x4,y4;

    public ObjHeros(float x,float y,int radius) {
        super();
        canvas = new Canvas(constan.fram);
        m_fPosX=x;
        m_fPosY=y;
        m_dRadius=radius;
        m_fUpdateX=0;
        m_fUpdateY=0;
        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
    }

    public void update(float deltaTime) {
//        m_fUpdateY += deltaTime * 0.01 * 50;
        locateX=(int) (m_fPosX +  m_fUpdateX );
        locateY=(int) (m_fPosY + m_fUpdateY);

    }
    public void paint(float deltaTime, FMXGraphics g) {
//        g.drawRect(getBounds(),Color.LTGRAY);
//        x1= (int) (m_fPosX+m_fUpdateX);
//        y1= (int) (m_fPosY+m_fUpdateY);
//        x2= (int) (m_fPosX+m_fUpdateX)+m_dSizeY;
//        y2= (int) (m_fPosY+m_fUpdateY);
//        x3= (int) (m_fPosX+m_fUpdateX)+m_dSizeY;
//        y3= (int) (m_fPosY+m_fUpdateY)+m_dSizeX;
//        x4= (int) (m_fPosX+m_fUpdateX);
//        y4= (int) (m_fPosY+m_fUpdateY)+m_dSizeX;
        getBoundaryPath();

    }
    public Region getBoundaryPath() {
//        Paint wallpaint = new Paint();
//        wallpaint.setStyle(Paint.Style.FILL);
//        wallpaint.setColor(Color.MAGENTA);
        Path wallpath = new Path();
        wallpath.reset(); // only needed when reusing this path for a new build
//        double cenX=(x4+x3+x2+x1)/4,cenY=(y4+y3+y2+y1)/4;
//        double xp1=(cenX)+(x1-(cenX))*Math.cos(Math.toRadians(a - 90))-(y1-(cenY))*Math.sin(Math.toRadians(a - 90))
//                ,yp1=(cenY)+(x1-(cenX))*Math.sin(Math.toRadians(a - 90))+(y1-(cenY))*Math.cos(Math.toRadians(a - 90));
//        double xp2=(cenX)+(x2-(cenX))*Math.cos(Math.toRadians(a - 90))-(y2-(cenY))*Math.sin(Math.toRadians(a - 90))
//                ,yp2=(cenY)+(x2-(cenX))*Math.sin(Math.toRadians(a - 90))+(y2-(cenY))*Math.cos(Math.toRadians(a - 90));
//        double xp3=(cenX)+(x3-(cenX))*Math.cos(Math.toRadians(a - 90))-(y3-(cenY))*Math.sin(Math.toRadians(a - 90))
//                ,yp3=(cenY)+(x3-(cenX))*Math.sin(Math.toRadians(a - 90))+(y3-(cenY))*Math.cos(Math.toRadians(a - 90));
//        double xp4=(cenX)+(x4-(cenX))*Math.cos(Math.toRadians(a - 90))-(y4-(cenY))*Math.sin(Math.toRadians(a - 90))
//                ,yp4=(cenY)+(x4-(cenX))*Math.sin(Math.toRadians(a - 90))+(y4-(cenY))*Math.cos(Math.toRadians(a - 90));
//        wallpath.moveTo((float) (xp1), (float) (yp1)); // used for first point
//        wallpath.lineTo((float) (xp2), (float) (yp2));
//        wallpath.lineTo((float) (xp3), (float) (yp3));
//        wallpath.lineTo((float) (xp4), (float) (yp4));
//        wallpath.lineTo((float)(xp1), (float) (yp1)); // there is a setLastPoint action but i found it not to work as expected
        wallpath.addCircle(m_fPosX,m_fPosY,m_dRadius, Path.Direction.CCW);
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
