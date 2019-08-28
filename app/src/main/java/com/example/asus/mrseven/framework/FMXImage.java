/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.asus.mrseven.framework;

import com.example.asus.mrseven.framework.FMXGraphics.ImageFormat;

public interface FMXImage {
    public int getWidth();
    public int getHeight();
    public ImageFormat getFormat();
    public void dispose();
}