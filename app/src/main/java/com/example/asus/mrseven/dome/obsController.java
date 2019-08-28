package com.example.asus.mrseven.dome;

import android.util.Log;

import com.example.asus.mrseven.framework.FMXGraphics;

import java.util.ArrayList;

public class obsController {

    ArrayList<obsSequence> m_arrObsSequence;
    obsSequence  m_objObsSequence;
    boolean m_bRun = false;
    int tick = 0, tester = -1;

    public obsController() {
        m_arrObsSequence = new ArrayList<>();
        m_objObsSequence=new obsSequence();
        m_objObsSequence.m_strObsType="SKY";
        m_objObsSequence.SampleSequence();
        m_arrObsSequence.add(m_objObsSequence);

    }


    public void update(float deltaTime, float CurrentSector) {
        for (int i = 0; i <= m_arrObsSequence.size() - 1; i++) {
            if (m_arrObsSequence.get(i).Waiting(CurrentSector)){
                m_arrObsSequence.get(i).TriggerCurrentSequence();
            }
            m_arrObsSequence.get(i).update(deltaTime);
        }
    }

    public void paint(float deltaTime, FMXGraphics g) {
        for (int i = 0; i <= m_arrObsSequence.size() - 1; i++) {
            m_arrObsSequence.get(i).paint(deltaTime,g);
        }
    }
    public void Collision(){

    }

//    public void update(float deltaTime) {
//
//    }
//
//    public void paint(float deltaTime, FMXGraphics g) {
//
//    }
}
