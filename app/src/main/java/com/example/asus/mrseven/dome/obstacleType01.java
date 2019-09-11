package com.example.asus.mrseven.dome;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
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
    Canvas canvas;
    Paint paint;
    int m_dRadius;
    int Type;
    public obstacleType01(float x, float y,int Radius) {
        paintex.setColor(Color.YELLOW);
        paintex.setTextSize(50);
        this.m_fPosX = x;
        this.m_fPosY = y;
        this.m_dRadius=Radius;
        canvas = new Canvas(constan.fram);
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
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
        getBoundaryPath();
        g.drawString("T-01", (int) (m_fPosX + lr), (int) (m_fPosY + m_fUp), paintex);

    }

    public Rect getBounds() {
        return new Rect((int) (m_fPosX + lr), (int) (m_fPosY + m_fUp+200), (int) (m_fPosX +lr+ 200), (int) (m_fPosY +m_fUp));
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
