/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.asus.mrseven.framework.implementation;

import android.graphics.Color;
import com.example.asus.mrseven.framework.FMXGraphics;

/**
 *
 * @author User
 */
public class FMXGObject {
    
    protected double m_dPosX;
    protected double m_dPosY;
    protected double m_dPosZ;
    protected double m_dViewPosX;
    protected double m_dViewPosY;
    protected double m_dViewPosZ;
    protected double m_dRPosX;
    protected double m_dRPosY;
    protected double m_dRPosZ;
    protected int m_nWidth;
    protected int m_nHeight;
    protected double m_dScaleX;
    protected double m_dScaleY;
    protected int m_nOffsetX;
    protected int m_nOffsetY;
    protected int m_nDirX;
    protected int m_nDirY;
    protected int m_nDirZ;
    protected double m_dSpeedX;
    protected double m_dSpeedY;
    protected double m_dSpeedZ;
    protected boolean m_bShowBoundingBox;
    protected FMXGViewport m_viewportMain;
    protected FMXGObject m_objRelative = null;
    protected boolean m_bVisible;

    public FMXGObject() {
        setPosition(0, 0, 0);
        setScale(1, 1);
        setSize(120, 120);
        setDirection(0, 0, 0);
        setSpeed(0, 0, 0);
        setShowBoundingBox(false);
        setVisible(true);
    }

    public void update() {
        if(m_objRelative!=null){
            double pos[] = m_objRelative.getPosition();
            setPosition(pos[0]+m_dRPosX,pos[1]+m_dRPosY,pos[2]+m_dRPosZ);
            
            m_dRPosX += m_nDirX * m_dSpeedX;
            m_dRPosY += m_nDirY * m_dSpeedY;
            m_dRPosZ += m_nDirZ * m_dSpeedZ;
            
            setScale(m_objRelative.getScale()[0], m_objRelative.getScale()[1]);
        }else{
            m_dPosX += m_nDirX * m_dSpeedX;
            m_dPosY += m_nDirY * m_dSpeedY;
            m_dPosZ += m_nDirZ * m_dSpeedZ;
        }

        setViewPositionByViewport(m_viewportMain);
    }
    
    public void setVisible(boolean b){
        m_bVisible = b;
    }
    public boolean getVisible(){
       return m_bVisible;
    }

    public void setViewport(FMXGViewport vp) {
        m_viewportMain = vp;
    }
    public void setRelative2Object(FMXGObject obj){
        m_objRelative = obj;
    }

    public void setViewPositionByViewport(FMXGViewport vp) {
        if (vp != null) {
            m_dViewPosX = (vp.m_dDestWidth / 2) + (m_dPosX - vp.m_dViewX) * (vp.m_dDepthOfFieldX);
            m_dViewPosY = (vp.m_dDestHeight / 2) + (vp.m_dViewY - m_dPosY) * (vp.m_dDepthOfFieldY);
            m_dViewPosZ = m_dPosZ;
        } else {
            m_dViewPosX = m_dPosX;
            m_dViewPosY = m_dPosY;
            m_dViewPosZ = m_dPosZ;
        }
    }

    public void setSpeed(double spX, double spY, double spZ) {
        m_dSpeedX = spX;
        m_dSpeedY = spY;
        m_dSpeedZ = spZ;
    }

    public void setDirection(int dX, int dY, int dZ) {
        if (dX != 99) {
            m_nDirX = dX;
        }
        if (dY != 99) {
            m_nDirY = dY;
        }
        if (dZ != 99) {
            m_nDirZ = dZ;
        }
    }
    public int[] getDirection(){
        int dir[] = {m_nDirX,m_nDirY,m_nDirZ};
        return dir;
    }

    public void setSize(int width, int height) {
        m_nWidth = width;
        m_nHeight = height;
    }

    public int[] getSize() {
        int arr[] = {m_nWidth, m_nHeight};
        return arr;
    }

    public void setOffset(int ox, int oy) {
        m_nOffsetX = ox;
        m_nOffsetY = oy;
    }

    public void setOffsetHCenter() {
        m_nOffsetX = m_nWidth / 2;
    }

    public void setOffsetVCenter() {
        m_nOffsetY = m_nHeight / 2;
    }

    public void setOffsetCenter() {
        setOffsetHCenter();
        setOffsetVCenter();
    }

    public void setScale(double sx, double sy) {
        m_dScaleX = sx;
        m_dScaleY = sy;
    }

    public double[] getScale() {
        double scale[] = {m_dScaleX, m_dScaleY};
        return scale;
    }

    public void setPosition(double px, double py, double pz) {
        m_dPosX = px;
        m_dPosY = py;
        m_dPosZ = pz;
    }
    public void setRelativePosition(double px, double py, double pz) {
        m_dRPosX = px;
        m_dRPosY = py;
        m_dRPosZ = pz;
    }
     public double[] getRelativePosition() {
        double pos[] = {m_dRPosX, m_dRPosY, m_dRPosZ};
        return pos;
    }

    public double[] getPosition() {
        double pos[] = {m_dPosX, m_dPosY, m_dPosZ};
        return pos;
    }
    public double[] getViewPosition() {
        double pos[] = {m_dViewPosX, m_dViewPosY, m_dViewPosZ};
        return pos;
    }
    public double[] getSpeed() {
        double sp[] = {m_dSpeedX, m_dSpeedY, m_dSpeedZ};
        return sp;
    }

    public void setShowBoundingBox(boolean b) {
        m_bShowBoundingBox = b;
    }

    public void paintObjectBound(FMXGraphics g) {
        if(m_bShowBoundingBox && m_bVisible)
            g.drawRect((int) (m_dViewPosX - (m_nOffsetX * m_dScaleX)), (int) (m_dViewPosY - (m_nOffsetY * m_dScaleY)), (int) (m_nWidth * m_dScaleX), (int) (m_nHeight * m_dScaleY),Color.YELLOW);
    }

    public boolean isInObject(int px, int py, int inBoundX, int inBoundY) {
        int x1 = (int) (m_dPosX - (m_nOffsetX * m_dScaleX));
        int y1 = (int) (m_dPosY - (m_nOffsetY * m_dScaleY));
        int x2 = x1 + (int) (m_nWidth * m_dScaleX);
        int y2 = y1 + (int) (m_nHeight * m_dScaleY);
        if (px >= x1 + inBoundX && px <= x2 - inBoundX && py >= y1 + inBoundY && py <= y2 - inBoundY) {
            return true;
        }
        return false;
    }

    public boolean isCollision(FMXGObject obj, int inBoundX, int inBoundY) {
        int x1 = (int) (m_dPosX - (m_nOffsetX * m_dScaleX));
        int y1 = (int) (m_dPosY - (m_nOffsetY * m_dScaleY));
        int x2 = x1 + (int) (m_nWidth * m_dScaleX);
        int y2 = y1 + (int) (m_nHeight * m_dScaleY);
        if (obj.isInObject(x1, y1, inBoundX, inBoundY) || obj.isInObject(x1, y2, inBoundX, inBoundY)
                || obj.isInObject(x2, y1, inBoundX, inBoundY) || obj.isInObject(x2, y2, inBoundX, inBoundY)) {
            return true;
        }
        return false;
    }
}
