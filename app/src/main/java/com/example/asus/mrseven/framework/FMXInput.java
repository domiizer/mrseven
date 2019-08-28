/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.asus.mrseven.framework;

import java.util.List;

public interface FMXInput {
    
    public static class TouchEvent {
        public static final int TOUCH_DOWN = 0;
        public static final int TOUCH_UP = 1;
        public static final int TOUCH_DRAGGED = 2;
        public static final int TOUCH_HOLD = 3;

        public int type;
        public int x, y;
        public int pointer;


    }

    public boolean isTouchDown(int pointer);

    public int getTouchX(int pointer);

    public int getTouchY(int pointer);
    
    public float getAccelX();

    public float getAccelY();

    public float getAccelZ();

    public List<TouchEvent> getTouchEvents();
}