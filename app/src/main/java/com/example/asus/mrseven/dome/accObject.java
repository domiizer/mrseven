package com.example.asus.mrseven.dome;

import java.util.ArrayList;

public class accObject {
    float m_fData = 0;
    float m_fAcc = 0;
    float m_fTarget = 0;
    float m_fGetSectorY = 0;
    int m_nTester = -1;
    int tick = 0;

    boolean m_bIsRun = false;
    ArrayList<Float> m_lfAcc = new ArrayList<Float>();
    ArrayList<Float> m_lfSwitchOn = new ArrayList<Float>();
    ArrayList<Float> m_lfTarget = new ArrayList<Float>();

    public accObject() {

    }

    public void setDatato(float target, float acc,float sector) {
        m_fTarget = target;
        m_lfSwitchOn.add(sector);
        m_nTester++;
        m_lfAcc.add(acc);
        m_lfTarget.add(m_fTarget);
    }
        public void setDatato(float target, float acc) {
        m_fTarget = target;
//        m_fAcc = acc;
            m_lfSwitchOn.add((float) 0);
        m_nTester++;
        m_lfAcc.add(acc);
        m_lfTarget.add(m_fTarget);
    }


    public  void nowIn(float getSectorY){
        m_fGetSectorY=getSectorY;
    }


    public void update(float deltaTime) {
if (m_lfSwitchOn.size()>0)
        if (m_fGetSectorY>=m_lfSwitchOn.get(tick)){
            m_bIsRun = true;
        }else {
            m_bIsRun = false;
        }
        if (m_bIsRun) {
            m_fAcc = m_lfAcc.get(tick);
            if (m_fAcc > 0) {
                if (m_fData < m_lfTarget.get(tick)) {
                    m_fData += deltaTime * 0.01 * m_fAcc;
                } else {
                    m_fData = m_lfTarget.get(tick);
                    m_fAcc = 0;
                    if (tick < m_nTester) {
                        tick++;
                    } else {
                        m_bIsRun = false;
                    }
                }
            } else if (m_fAcc < 0) {
                if (m_fData > m_lfTarget.get(tick)) {
                    m_fData += deltaTime * 0.01 * m_fAcc;
                } else {
                    m_fData = m_lfTarget.get(tick);
                    m_fAcc = 0;
                    if (tick < m_nTester) {
                        tick++;
                    } else {
                        m_bIsRun = false;
                    }
                }
            }

        }
    }

//    public void update(float deltaTime) {
//            if (m_bIsRun) {
//                if (m_fAcc > 0) {
//                    if (m_fData < m_fTarget)
//                        m_fData += deltaTime * 0.01 * m_fAcc;
//                    else {
//                        m_fData = m_fTarget;
//                        m_fAcc = 0;
//                    }
//                } else if (m_fAcc < 0) {
//                    if (m_fData > m_fTarget)
//                        m_fData += deltaTime * 0.01 * m_fAcc;
//                    else {
//                        m_fData = m_fTarget;
//                        m_fAcc = 0;
//                    }
//                } else {
//                    m_bIsRun = false;
//                }
//            }
//    }


}
