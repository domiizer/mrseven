/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.asus.mrseven.framework.implementation;

import com.example.asus.mrseven.framework.FMXGraphics;
import com.example.asus.mrseven.framework.FMXImage;

/**
 *
 * @author User
 */
public class FMXGResource extends FMXGObject{
    public FMXImage m_img;
    public String   m_strName;
    
    private int m_nSubX;
    private int m_nSubY;
    private int m_nSubWidth;
    private int m_nSubHeight;
    private int m_nCurrentFrame;
    
    public int m_nImageWidth;
    public int m_nImageHeight;
 //   private boolean m_bVisible;
    private boolean m_bAnimate;
    private boolean m_bAnimateLoop;
    private int m_nAnimateType;
    private int m_nAnimateDelay;
    private int m_nDelayCount;
    private int m_nMaxFrame;

    private double m_dAlpha;
    
    private boolean m_bManual;
    private int m_nManualFrameArr[];
    private int m_nManualFrameCount;
    private int m_nManualRunningFrame;

    /*  public enum AnimeType {
     FWD (0),
     BWD (1),
     PNP (2);
        
     }*/

    public FMXGResource() {
        super();
        setOffset(0, 0);
        setSubFrame(1, 1);
        setCurrentFrame(0);
      //  setVisible(true);
        setAlpha(1);
        setAnimation(false, -1, 0);
        setLoop(true);
        setManaul(false,null,0,0);
    }
    
    public void setManaul(boolean b,int arr[],int count,int delay){
        m_bManual = b;
        m_nManualFrameArr = arr;
        m_nManualFrameCount = count;
        m_nManualRunningFrame = 0;
        setAnimation(false, -1, delay);
    }
    
    public void setLoop(boolean b){
        m_bAnimateLoop = b;
    }
    public void setMaxFrame(int max) {
        m_nMaxFrame = max;
    }
    
    public int getMaxFrame(){
        return m_nMaxFrame;
    }

    public void setCurrentFrame(int frame) {
        m_nCurrentFrame = frame;
    }

    public int getCurrentFrame() {
        return m_nCurrentFrame;
    }

    public void setSubFrame(int subx, int suby) {
        m_nSubX = subx;
        m_nSubY = suby;

        
        m_nSubWidth = m_nImageWidth / m_nSubX;
        m_nSubHeight = m_nImageHeight / m_nSubY;
        
        setSize(m_nSubWidth, m_nSubHeight);
        setMaxFrame(m_nSubX * m_nSubY);
    }


    public void setAnimation(boolean b, int type, int delay) {
        m_bAnimate = b;
        m_nAnimateType = type;
        m_nAnimateDelay = delay;
        m_nDelayCount = 0;
    }
    
    public void setAlpha(double alpha){
        m_dAlpha = alpha;
    }


    public void update() {
        super.update();
        if(m_viewportMain!=null){
            setScale(m_viewportMain.m_dDepthOfFieldX, m_viewportMain.m_dDepthOfFieldY);
        }
        if (m_bAnimate) {
            if (m_nAnimateType == 0) {
                if (m_nDelayCount < m_nAnimateDelay) {
                    m_nDelayCount++;
                } else {
                    m_nDelayCount = 0;
                    int temp = getCurrentFrame();
                    temp = (temp + 1) % (m_nMaxFrame);
                    setCurrentFrame(temp);
                }
            } else if (m_nAnimateType == 1) {
                if (m_nDelayCount < m_nAnimateDelay) {
                    m_nDelayCount++;
                } else {
                    m_nDelayCount = 0;
                    int temp = getCurrentFrame();
                    temp = (temp + (m_nMaxFrame - 1)) % (m_nMaxFrame);
                    setCurrentFrame(temp);
                }
            } else if (m_nAnimateType == 2) {
            }
        }else{
            if(m_bManual){
                if (m_nDelayCount < m_nAnimateDelay) {
                    m_nDelayCount++;
                } else {
                    m_nDelayCount = 0;
                    setCurrentFrame(m_nManualFrameArr[m_nManualRunningFrame]);
                    m_nManualRunningFrame = (m_nManualRunningFrame+1)%m_nManualFrameCount;
                }
            }
        }
    }

    public void drawImage(FMXGraphics g) {
        
       drawImage(g,(int)m_dViewPosX,(int)m_dViewPosY);
    }

    public void drawImage(FMXGraphics g, int px, int py) {
        int w = (int) ((double) (m_nWidth) * m_dScaleX);
        int h = (int) ((double) (m_nHeight) * m_dScaleY);
        int x = px;
        int y = py;
        super.paintObjectBound(g);
        if (m_bVisible) {
            if(m_dAlpha==1)
                drawImage(g, (int) (x - (m_nOffsetX * m_dScaleX)), (int) (y - (m_nOffsetY * m_dScaleY)), (int) (m_nSubWidth * m_dScaleX), (int) (m_nSubHeight * m_dScaleY), m_nCurrentFrame);
            else
                drawImage(g, (int) (x - (m_nOffsetX * m_dScaleX)), (int) (y - (m_nOffsetY * m_dScaleY)), (int) (m_nSubWidth * m_dScaleX), (int) (m_nSubHeight * m_dScaleY), m_nCurrentFrame,m_dAlpha);
        }
    }
    public void drawImage(FMXGraphics g, int px, int py,int frame) {
        int w = (int) ((double) (m_nWidth) * m_dScaleX);
        int h = (int) ((double) (m_nHeight) * m_dScaleY);
        int x = px;
        int y = py;
        int f = frame;
        super.paintObjectBound(g);
        if (m_bVisible) {
            if(m_dAlpha==1)
                drawImage(g, (int) (x - (m_nOffsetX * m_dScaleX)), (int) (y - (m_nOffsetY * m_dScaleY)), (int) (m_nSubWidth * m_dScaleX), (int) (m_nSubHeight * m_dScaleY), f);
            else
                drawImage(g, (int) (x - (m_nOffsetX * m_dScaleX)), (int) (y - (m_nOffsetY * m_dScaleY)), (int) (m_nSubWidth * m_dScaleX), (int) (m_nSubHeight * m_dScaleY), f,m_dAlpha);
        }
    }

    public void drawImage(FMXGraphics g, int px, int py, int width, int height) {
        g.drawImage(m_img, px, py,0,0, width, height);
    }

    public void drawImage(FMXGraphics g, int px, int py, int width, int height, int frame) {
        if(!m_bVisible)
            return;
        int i = frame % m_nSubX;
        int j = frame / m_nSubX;
        /*Composite old_comp = g2d.getComposite();
        if(m_modeBlending!=BlendingMode.NORMAL)
            g2d.setComposite(BlendComposite.getInstance(m_modeBlending, 1.0f));*/
        g.drawImage(m_img, px, py,i * m_nSubWidth, j * m_nSubHeight, i * m_nSubWidth + m_nSubWidth, j * m_nSubHeight + m_nSubHeight);
        /*if(m_modeBlending!=BlendingMode.NORMAL)
            g2d.setComposite(old_comp);*/
           // g2d.setComposite(BlendComposite.getInstance(BlendingMode.NORMAL, 1.0f));
    }
    public void drawImage(FMXGraphics g, int px, int py, int width, int height, int frame,double alpha) {

    }
    
    public void drawImageFlipV(FMXGraphics g,int px,int py){
        drawImageFlipV(g,(int)(px-(m_nOffsetX*m_dScaleX)),(int)(py-(m_nOffsetY*m_dScaleY)),(int)(m_nSubWidth*m_dScaleX),(int)(m_nSubHeight*m_dScaleY),m_nCurrentFrame);

    }
    public void drawImageFlipH(FMXGraphics g,int px,int py){
        drawImageFlipH(g,(int)(px-(m_nOffsetX*m_dScaleX)),(int)(py-(m_nOffsetY*m_dScaleY)),(int)(m_nSubWidth*m_dScaleX),(int)(m_nSubHeight*m_dScaleY),m_nCurrentFrame);

    }
    public void drawImageFlipV(FMXGraphics g,int px,int py,int width,int height,int frame){
        if(!m_bVisible)
            return;

        int i = frame%m_nSubX;
        int j = frame/m_nSubX;
        /*if(m_modeBlending!=BlendingMode.NORMAL)
            g2d.setComposite(BlendComposite.getInstance(m_modeBlending, 1.0f));*/
        g.drawImage(m_img, px, py+height,
                i*m_nSubWidth,j*m_nSubHeight,i*m_nSubWidth+m_nSubWidth,j*m_nSubHeight+m_nSubHeight);
    }
    public void drawImageFlipH(FMXGraphics g,int px,int py,int width,int height,int frame){
        if(!m_bVisible)
            return;
        int i = frame%m_nSubX;
        int j = frame/m_nSubX;
       /* if(m_modeBlending!=BlendingMode.NORMAL)
            g2d.setComposite(BlendComposite.getInstance(m_modeBlending, 1.0f));*/
        g.drawImage(m_img, px+width, py,
                i*m_nSubWidth,j*m_nSubHeight,i*m_nSubWidth+m_nSubWidth,j*m_nSubHeight+m_nSubHeight);
    }
}
