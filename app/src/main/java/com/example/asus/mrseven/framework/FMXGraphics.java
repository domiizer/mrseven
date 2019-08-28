/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.asus.mrseven.framework;


import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;

public interface FMXGraphics {
    
    public static enum ImageFormat {
        ARGB8888, ARGB4444, RGB565
    }

    public FMXImage newImage(String fileName, ImageFormat format);
    public FMXImage newImage(String fileName, ImageFormat format, int type);
    public void clearScreen(int color);
    public void drawLine(int x, int y, int x2, int y2, int color);

    public void drawRect(int x, int y, int width, int height, int color);
    public void drawRectF(RectF rectF, int color);
    public void drawRectBG(int x, int y, int width, int height, int color,int alpha);
    public void drawPath(Path path, Paint paint);
//    public void drawRoundRect(int x, int y, int width, int height,float fRx,float fRy, int color);

    public void drawImage(FMXImage image, int x, int y, int srcX, int srcY,
            int srcWidth, int srcHeight);
    public void drawRect(Rect rect, int color);
    public void drawImage(FMXImage Image, int x, int y);

    void drawString(String text, int x, int y, Paint paint);
    public void drawImageAlpha(FMXImage Image, float x, float y);

    public void drawAnimationAlpha(FMXImage Image, int number, float x, float y);

    public void drawAnimationBoom(FMXImage Image, int number, int x, int y);
    public int getWidth();

    public int getHeight();

    public void drawARGB(int i, int j, int k, int l);
    public void drawImageRotate(FMXImage Image, int x, int y, double degree,double alPha);
    public void drawImageRotate1(FMXImage Image, int x, int y, double degree,double alPha);
    public void drawScaledImage(FMXImage Image, int x, int y, int width, int height, int srcX, int srcY, int srcWidth, int srcHeight);
//    public void drawOval(int x,int y,int width,int height,int color);

}