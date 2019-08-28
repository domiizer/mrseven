/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.asus.mrseven.framework.implementation;

import java.util.List;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;

import com.example.asus.mrseven.framework.implementation.FMXAccelerometerHandler;
import com.example.asus.mrseven.framework.FMXInput;

public class FMXAndroidInput implements FMXInput {    
    FMXTouchHandler touchHandler;
    FMXAccelerometerHandler accelHandler;

    public FMXAndroidInput(Context context, View view, float scaleX, float scaleY) {
        accelHandler = new FMXAccelerometerHandler(context);
        if(Integer.parseInt(VERSION.SDK) < 5) 
            touchHandler = new FMXSingleTouchHandler(view, scaleX, scaleY);
        else
            touchHandler = new FMXMultiTouchHandler(view, scaleX, scaleY);        
    }


    @Override
    public boolean isTouchDown(int pointer) {
        return touchHandler.isTouchDown(pointer);
    }

    @Override
    public int getTouchX(int pointer) {
        return touchHandler.getTouchX(pointer);
    }

    @Override
    public int getTouchY(int pointer) {
        return touchHandler.getTouchY(pointer);
    }



    @Override
    public List<TouchEvent> getTouchEvents() {
        return touchHandler.getTouchEvents();
    }
    
    @Override
    public float getAccelX() {
        return accelHandler.getAccelX();
    }

    @Override
    public float getAccelY() {
        return accelHandler.getAccelY();
    }

    @Override
    public float getAccelZ() {
        return accelHandler.getAccelZ();
    }
}