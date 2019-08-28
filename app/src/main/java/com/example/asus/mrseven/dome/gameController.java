package com.example.asus.mrseven.dome;

import android.graphics.Color;
import android.util.Log;

import com.example.asus.mrseven.framework.FMXGraphics;

import java.util.List;

public class gameController {
    public static accObject m_objPosX;
    public static accObject m_objPosY;

    private int m_nGridsize = 100;
    private int m_ncountLine = (constan.SCREEN_HEIGHT / m_nGridsize) + 2;
    private int m_ncountLineX = (constan.SCREEN_WIDTH / m_nGridsize) + 4;
    private float m_arrLineY[], m_arrLineX[];
    private float m_fCountDelayBU = 0, m_fCountDelaySW = 0, m_fCountDelaySP = 0;
    private int m_dGabBU = 0, m_dGabSW = 0, m_dGabSP = 0; // =m_fCountDelayBU-m_dGabBU
    private int m_dBulletSecBU = 20, m_dBulletSecSW = 5, m_dBulletSecSP = 5;
//    public static ArrayList<bulletSwing> m_arrSwingR;
//    public static ArrayList<bulletSwing> m_arrSwingL;
//    public static ArrayList<bulletSplash> m_arrSplash;
//    public static ArrayList<bulletBullet> m_arrBullet;
//    public static ArrayList<bulletMain> m_arrBullet;
    float m_fSwing = 3;
    boolean m_bLR = true;
    obsController m_objObsController;
    public gameController() {
        m_objPosX = new accObject();
        m_objPosY = new accObject();
//        m_arrSwingR = new ArrayList<>();
//        m_arrSwingL = new ArrayList<>();
//        m_arrSplash = new ArrayList<>();
        m_objObsController =new obsController();
        m_objPosY.setDatato(25, 5);
        m_objPosY.setDatato(50, 10);
        m_objPosY.setDatato(100, 5);
        m_objPosY.setDatato(200, 10);
        m_objPosY.setDatato(500, 12);

        m_arrLineY = new float[m_ncountLine];
        for (int i = 0; i < m_ncountLine; i++) {
            m_arrLineY[i] = m_nGridsize * (i - 2);
        }

        m_arrLineX = new float[m_ncountLineX];
        for (int i = 0; i < m_ncountLineX; i++) {
            m_arrLineX[i] = m_nGridsize * (i - 2);
        }
//        m_arrBullet.add(new bulletBullet(constan.SCREEN_WIDTH / 2 - (constan.shipsdf.getWidth() / 3 / 2) + constan.shipsdf.getWidth() / 3 / 2, constan.SCREEN_HEIGHT - constan.SCREEN_HEIGHT / 4 - constan.shipsdf.getHeight() / 2));
//        m_arrBullet.add(new bulletBullet(constan.SCREEN_WIDTH / 2 - (constan.shipsdf.getWidth() / 3 / 2) + constan.shipsdf.getWidth() / 3 / 2, constan.SCREEN_HEIGHT ));

    }

    public void update(float deltaTime) {
        m_objPosX.update(deltaTime);
        m_objPosY.update(deltaTime);
        m_objPosX.nowIn(m_objPosY.m_fData);
        m_objObsController.update(deltaTime,m_objPosY.m_fData);

        funGrid(deltaTime);
//        funSwing(deltaTime);
//        funSplash(deltaTime);
//        funCol(deltaTime);

    }

    private void funCol(float deltaTime) {

    }

    private void funGrid(float deltaTime) {
        //YYY
        for (int i = 0; i < m_ncountLine; i++) {
            m_arrLineY[i] += m_objPosY.m_fAcc*constan.gridSpeed;
            constan.gridY= m_objPosY.m_fAcc*constan.gridSpeed;
            float Max = m_nGridsize * (m_ncountLine - 2);
            float start = m_nGridsize * (-2);
            if (m_arrLineY[i] > Max) {
                float dif = m_arrLineY[i] - Max;
                m_arrLineY[i] = start + dif;
            }
        }

        //XXX
        for (int i = 0; i < m_ncountLineX; i++) {
            m_arrLineX[i] += m_objPosX.m_fAcc*constan.gridSpeed;
            constan.gridX=m_objPosX.m_fAcc*constan.gridSpeed;
            if (m_objPosX.m_fAcc > 0) {//+++
                float Max = m_nGridsize * (m_ncountLineX - 2);
                float start = m_nGridsize * (-2);
                if (m_arrLineX[i] > Max) {
                    float dif = m_arrLineX[i] - Max;
                    m_arrLineX[i] = start + dif;
                }
            } else if (m_objPosX.m_fAcc < 0) {//---
                float Max = m_nGridsize * (-2);
                float start = m_nGridsize * (-2) + (m_nGridsize * m_ncountLineX);
                if (m_arrLineX[i] < Max) {
                    float dif = m_arrLineX[i] - Max;
                    m_arrLineX[i] = start + dif;
                }
            }
        }
    }


    public void paint(float deltaTime, FMXGraphics g) {
//        m_objObsController.paint(deltaTime,g);
        g.clearScreen(Color.BLACK);
        for (int i = 0; i < m_ncountLine; i++) {
            g.drawLine(0, (int) (m_arrLineY[i]), constan.SCREEN_WIDTH, (int) (m_arrLineY[i]), Color.WHITE);
        }
        for (int i = 0; i < m_ncountLineX; i++) {
            g.drawLine((int) (m_arrLineX[i]), 0, (int) (m_arrLineX[i]), constan.SCREEN_HEIGHT, Color.WHITE);
        }
        m_objObsController.paint(deltaTime,g);

    }



}

