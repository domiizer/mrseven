/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.asus.mrseven.framework.implementation;

import android.animation.ObjectAnimator;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaActionSound;
import android.util.Log;

//import com.example.asus.mrseven.dome.constan;
import com.example.asus.mrseven.dome.constan;
import com.example.asus.mrseven.framework.FMXGraphics;
import com.example.asus.mrseven.framework.FMXImage;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FMXAndroidGraphics implements FMXGraphics {
    AssetManager assets;
    Bitmap frameBuffer;
    Canvas canvas;
    Paint paint;
    Rect srcRect = new Rect();
    Rect dstRect = new Rect();
    static ObjectAnimator objectAnimator;
    boolean numbercheckBoom = true;

    int numberAl =0;

    public FMXAndroidGraphics(AssetManager assets, Bitmap frameBuffer) {
        this.assets = assets;
        this.frameBuffer = frameBuffer;
        this.canvas = new Canvas(frameBuffer);
        this.paint = new Paint();

        constan.fram= frameBuffer;
    }

    @Override
    public FMXImage newImage(String fileName, ImageFormat format , int type) {
        Config config = null;
        if (format == ImageFormat.RGB565)
            config = Config.RGB_565;
        else if (format == ImageFormat.ARGB4444)
            config = Config.ARGB_4444;
        else
            config = Config.ARGB_8888;

        Options options = new Options();
        options.inPreferredConfig = config;


        InputStream in = null;
        Bitmap bitmap = null;
        try {
            if(type==0)
                in = assets.open(fileName);
            else{
                String src = fileName;
                URL url = new URL(src);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                in = connection.getInputStream();
                Log.i("LNXConnectionManager", "FMXImage");
            }
            bitmap = BitmapFactory.decodeStream(in, null, options);
            if (bitmap == null)
                throw new RuntimeException("Couldn't load bitmap from asset '"
                        + fileName + "'");
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load bitmap from asset '"
                    + fileName + "'");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }

        if (bitmap.getConfig() == Config.RGB_565)
            format = ImageFormat.RGB565;
        else if (bitmap.getConfig() == Config.ARGB_4444)
            format = ImageFormat.ARGB4444;
        else
            format = ImageFormat.ARGB8888;

        return new FMXAndroidImage(bitmap, format);
    }

    @Override
    public FMXImage newImage(String fileName, ImageFormat format) {
        Config config = null;
        if (format == ImageFormat.RGB565)
            config = Config.RGB_565;
        else if (format == ImageFormat.ARGB4444)
            config = Config.ARGB_4444;
        else
            config = Config.ARGB_8888;

        Options options = new Options();
        options.inPreferredConfig = config;


        InputStream in = null;
        Bitmap bitmap = null;
        try {
            in = assets.open(fileName);
            bitmap = BitmapFactory.decodeStream(in, null, options);
            if (bitmap == null)
                throw new RuntimeException("Couldn't load bitmap from asset '"
                        + fileName + "'");
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load bitmap from asset '"
                    + fileName + "'");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }

        if (bitmap.getConfig() == Config.RGB_565)
            format = ImageFormat.RGB565;
        else if (bitmap.getConfig() == Config.ARGB_4444)
            format = ImageFormat.ARGB4444;
        else
            format = ImageFormat.ARGB8888;

        return new FMXAndroidImage(bitmap, format);
    }

    @Override
    public void clearScreen(int color) {
        canvas.drawRGB((color & 0xff0000) >> 16, (color & 0xff00) >> 8,
                (color & 0xff));
    }

    @Override
    public void drawLine(int x, int y, int x2, int y2, int color) {
        paint.setColor(color);
        canvas.drawLine(x, y, x2, y2, paint);
    }

    @Override
    public void drawRect(int x, int y, int width, int height, int color) {
        paint.setColor(color);
        paint.setStyle(Style.FILL);
        canvas.drawRect(x, y, x + width - 1, y + height - 1, paint);

    }
    public void drawRectF(RectF rectF, int color){
        paint.setColor(color);
        paint.setStyle(Style.FILL);
        canvas.drawRect(rectF,paint);
    }
    public void drawRectBG(int x, int y, int width, int height, int color,int alpha) {
        paint.setColor(color);
        paint.setStyle(Style.FILL);
        paint.setAlpha(alpha);
        canvas.drawRect(x, y, x + width , y + height, paint);

    }
    public void drawPath(Path path,Paint paint){
        canvas.drawPath(path,paint);
    }
    public void drawRoundRect(int x, int y, double width, int height, float fRx, float fRy, int color) {
        paint.setColor(color);
        paint.setStyle(Style.FILL);
        RectF r = new RectF(x, y, (float) (x+width), y+height);
        canvas.drawRoundRect(r, fRx, fRy, paint);

    }


    @Override
    public void drawARGB(int a, int r, int g, int b) {
        paint.setStyle(Style.FILL);
       canvas.drawARGB(a, r, g, b);

    }


    @Override
    public void drawString(String text, int x, int y, Paint paint){
        canvas.drawText(text, x, y, paint);

    }

    public void drawImage(FMXImage Image, int x, int y, int srcX, int srcY,
                          int srcWidth, int srcHeight) {
        srcRect.left = srcX;
        srcRect.top = srcY;
        srcRect.right = srcX + srcWidth;
        srcRect.bottom = srcY + srcHeight;


        dstRect.left = x;
        dstRect.top = y;
        dstRect.right = x + srcWidth;
        dstRect.bottom = y + srcHeight;

        canvas.drawBitmap(((FMXAndroidImage) Image).bitmap, srcRect, dstRect,
                null);
    }

    @Override
    public void drawImage(FMXImage Image, int x, int y) {
        canvas.drawBitmap(((FMXAndroidImage)Image).bitmap, x, y, null);
    }

    @Override
    public void drawRect(Rect rect, int color){
        paint.setColor(color);
        paint.setStyle(Style.FILL);
        canvas.drawRect(rect, paint);
    }
    @Override
    public void drawImageRotate(FMXImage Image, int x, int y, double degree ,double alPha) {
        paint.setAlpha((int)alPha);
        Matrix rotator = new Matrix();
        rotator.setRotate(
                (float) degree, // degrees
                Image.getWidth() /2, // px
                Image.getHeight()  // py
        );
        rotator.postTranslate(
                x,
                y
        );
        canvas.drawBitmap(((FMXAndroidImage)Image).bitmap,rotator, paint);
    }
//    public void drawRectRotate(int x, int y, int width, int height, int color,int degree){
//        paint.setColor(color);
//        paint.setStyle(Style.FILL);
//        RectF r1 = new RectF(x,y,width,height);
//        Matrix mat = new Matrix();
//        mat.setRotate(degree,  constan.SCREEN_HEIGHT/2, constan.SCREEN_WIDTH/2);
//        mat.mapRect(r1);
//        canvas.drawRect(r1,paint);
//    }
    public void drawPoly(int x1, int y1, int x2, int y2, int x3, int y3,int x4,int y4,double degree){
        Paint wallpaint = new Paint();
        wallpaint.setStyle(Style.STROKE);
        Path wallpath = new Path();
        wallpath.reset(); // only needed when reusing this path for a new build
        double cenX=(x4+x3+x2+x1)/4,cenY=(y4+y3+y2+y1)/4;
        double xp1=(cenX)+(x1-(cenX))*Math.cos(Math.toRadians(degree))-(y1-(cenY))*Math.sin(Math.toRadians(degree))
                ,yp1=(cenY)+(x1-(cenX))*Math.sin(Math.toRadians(degree))+(y1-(cenY))*Math.cos(Math.toRadians(degree));
        double xp2=(cenX)+(x2-(cenX))*Math.cos(Math.toRadians(degree))-(y2-(cenY))*Math.sin(Math.toRadians(degree))
                ,yp2=(cenY)+(x2-(cenX))*Math.sin(Math.toRadians(degree))+(y2-(cenY))*Math.cos(Math.toRadians(degree));
        double xp3=(cenX)+(x3-(cenX))*Math.cos(Math.toRadians(degree))-(y3-(cenY))*Math.sin(Math.toRadians(degree))
                ,yp3=(cenY)+(x3-(cenX))*Math.sin(Math.toRadians(degree))+(y3-(cenY))*Math.cos(Math.toRadians(degree));
        double xp4=(cenX)+(x4-(cenX))*Math.cos(Math.toRadians(degree))-(y4-(cenY))*Math.sin(Math.toRadians(degree))
                ,yp4=(cenY)+(x4-(cenX))*Math.sin(Math.toRadians(degree))+(y4-(cenY))*Math.cos(Math.toRadians(degree));
        wallpath.moveTo((float) (xp1), (float) (yp1)); // used for first point
        wallpath.lineTo((float) (xp2), (float) (yp2));
        wallpath.lineTo((float) (xp3), (float) (yp3));
        wallpath.lineTo((float) (xp4), (float) (yp4));
        wallpath.lineTo((float)(xp1), (float) (yp1)); // there is a setLastPoint action but i found it not to work as expected
        canvas.drawPath(wallpath,wallpaint);
    }

    @Override
    public void drawImageRotate1(FMXImage Image, int x, int y, double degree,double alPha) {
        paint.setAlpha((int)alPha);
        Matrix rotator = new Matrix();
        rotator.setRotate(
                (float) degree, // degrees
                Image.getWidth() /2, // px
                Image.getHeight()/2  // py
        );
        rotator.postTranslate(
                x,
                y
        );

        canvas.drawBitmap(((FMXAndroidImage)Image).bitmap,rotator, paint);
    }

    @Override
    public void drawImageAlpha(FMXImage Image, float x, float y){
        paint.setAlpha(100);

        canvas.drawBitmap(((FMXAndroidImage)Image).bitmap,x,y, paint);


    }

    @Override
    public void drawAnimationAlpha(FMXImage Image, int number, float x, float y){
        paint.setAlpha(number);

        canvas.drawBitmap(((FMXAndroidImage)Image).bitmap,x,y, paint);


    }

    @Override
    public  void drawAnimationBoom(FMXImage Image, int number, int x, int y){
        paint.setAlpha(number);
        canvas.drawBitmap(((FMXAndroidImage)Image).bitmap,x,y, paint);

    }



    public void drawScaledImage(FMXImage Image, int x, int y, int width, int height, int srcX, int srcY, int srcWidth, int srcHeight){

        srcRect.left = srcX;
        srcRect.top = srcY;
        srcRect.right = srcX + srcWidth;
        srcRect.bottom = srcY + srcHeight;

        dstRect.left = x;
        dstRect.top = y;
        dstRect.right = x + width;
        dstRect.bottom = y + height;

        canvas.drawBitmap(((FMXAndroidImage) Image).bitmap, srcRect, dstRect, null);

    }

    @Override
    public int getWidth() {
        return frameBuffer.getWidth();
    }

    @Override
    public int getHeight() {
        return frameBuffer.getHeight();
    }

}
