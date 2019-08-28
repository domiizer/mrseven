/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.asus.mrseven.framework.implementation;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import com.example.asus.mrseven.framework.FMXGame;
import com.example.asus.mrseven.framework.FMXGraphics;
import com.example.asus.mrseven.framework.FMXGraphics.ImageFormat;
import com.example.asus.mrseven.framework.FMXImage;

/**
 *
 * @author User
 */
public class FMXGResourceControl {
    public static final int RESOURCE_IMAGE  = 0;
    
    public static final int IMAGE_JPG       = 0;
    public static final int IMAGE_PNG       = 1;
    
    
    protected int m_nNumGResourceLoaded = 0;
    protected int m_nNumGResourceRequested = 0;
    protected FMXGResource m_Res[];
    protected FMXGResourceRequestData m_Req[];
    
    protected FMXGame m_game;

    protected Paint m_paintText;
    public FMXGResourceControl(FMXGame game){
        m_nNumGResourceLoaded       = 0;
        m_nNumGResourceRequested    = 0;
        
        m_game = game;
        
        m_paintText = new Paint();
        m_paintText.setTextAlign(Paint.Align.CENTER);
        m_paintText.setAntiAlias(true);
        m_paintText.setColor(Color.WHITE);
        m_paintText.setFakeBoldText(true);
        m_paintText.setTextSize(26);
    }

    public void update(){
        if(m_nNumGResourceLoaded<m_nNumGResourceRequested){
            m_Res[m_nNumGResourceLoaded] = new FMXGResource();
            
            ImageFormat fmt[] = {ImageFormat.RGB565,ImageFormat.ARGB4444};
            
            FMXGraphics g = m_game.getGraphics();
            m_Res[m_nNumGResourceLoaded].m_img = g.newImage(m_Req[m_nNumGResourceLoaded].m_strFileName,fmt[m_Req[m_nNumGResourceLoaded].m_nSubType]);
            m_Res[m_nNumGResourceLoaded].m_strName = m_Req[m_nNumGResourceLoaded].m_strName;
            m_Res[m_nNumGResourceLoaded].m_nImageWidth = m_Res[m_nNumGResourceLoaded].m_img.getWidth();
            m_Res[m_nNumGResourceLoaded].m_nImageHeight = m_Res[m_nNumGResourceLoaded].m_img.getHeight();
            m_nNumGResourceLoaded++;
        }
    }
    
    public void paint(float deltaTime,FMXGraphics g){
       // if(m_nNumGResourceLoaded<m_nNumGResourceRequested){
            int scr_size[] = m_game.getScreenSize();
            g.drawRect(scr_size[0]/2-100, scr_size[1]/2, 200, 20, Color.GRAY);
            g.drawRect(scr_size[0]/2-100, scr_size[1]/2, (int)(200*(double)(m_nNumGResourceLoaded)/(double)(m_nNumGResourceRequested)), 20, Color.GREEN);
            g.drawString("..LOADING..", scr_size[0]/2, scr_size[1]/2-30, m_paintText);
       // }
    }
    
    public void requestLoadResource(String strFileName,String strName,int nType,int nSubType){
        int current = m_nNumGResourceRequested++;
        
        FMXGResourceRequestData data = new FMXGResourceRequestData(strFileName, strName, nType, nSubType);
        FMXGResourceRequestData temp_req[] = new FMXGResourceRequestData[m_nNumGResourceRequested];
        for(int i=0;i<m_nNumGResourceRequested-1;i++){
            temp_req[i] = m_Req[i];
        }
        temp_req[current] = data;
        
        m_Req = temp_req;
    }
    
    public void setResReadyToLoad(){
        m_Res = new FMXGResource[m_nNumGResourceRequested];
        m_nNumGResourceLoaded = 0;
    }
    
    public class FMXGResourceRequestData{
        public String m_strFileName;
        public String m_strName;
        public int m_nType;
        public int m_nSubType;
        
        public FMXGResourceRequestData(String strFileName,String strName,int nType,int nSubType){
            m_strFileName   = strFileName;
            m_strName       = strName;
            m_nType         = nType;
            m_nSubType      = nSubType;
        }
    }
    
    public FMXGResource getResourceByName(String strName){
        for(int i=0;i<m_nNumGResourceRequested;i++){
            if(m_Res[i].m_strName == strName){
                return m_Res[i];
            }
        }
        return null;
    }

 
}
