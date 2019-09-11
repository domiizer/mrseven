package com.example.asus.mrseven.dome;

import android.graphics.Region;
import android.util.Log;

import com.example.asus.mrseven.framework.FMXGraphics;

import java.util.ArrayList;

public class obsSet {
    int nid;
    float m_fTriggerTL;
    ArrayList<obstacleType01> m_arrObsta;
    ArrayList<Monster> m_arrMonster;
    ArrayList<Item> m_arrItem;


    public obsSet() {
        m_arrObsta = new ArrayList<>();
        m_arrMonster = new ArrayList<>();
        m_arrItem = new ArrayList<>();


    }

    public void initSampleSet(int nID) {
        nid=nID;
        if (nID == 0) {
//            m_fTriggerTL=35;
//            m_arrMonster.add(new Type14(constan.SCREEN_WIDTH + 60, -30, 5));
//            m_arrMonster.add(new Type14(-60, -30, 0));
            m_arrMonster.add(new Type31prismStage(constan.SCREEN_WIDTH / 2 - 50, 400, 0));
        } else if (nID == 1) {
//            m_fTriggerTL=60;

            m_arrObsta.add(new Type28Yellow(constan.SCREEN_WIDTH / 2, 400, 30));
            m_arrObsta.add(new Type28Yellow(constan.SCREEN_WIDTH / 2 + 200, 400, 30));
            m_arrObsta.add(new Type28Yellow(constan.SCREEN_WIDTH / 2 + 200, 600, 30));
            m_arrObsta.add(new Type28Yellow(constan.SCREEN_WIDTH / 2 - 200, 600, 30));
//            m_arrObsta.add(new Type28Yellow(constan.SCREEN_WIDTH / 2 - 200, 600, 30));
            m_arrMonster.add(new mid1(50, 450, 5));
        } else if (nID == 2) {
//            m_fTriggerTL=200;
            m_arrItem.add(new Item(0, -200));
        }
    }


    public void update(float deltaTime) {
        Log.i("deltatimeaax", "paint:os "+deltaTime+"nID"+nid);
        for (int i = 0; i <= m_arrObsta.size() - 1; i++) {
            m_arrObsta.get(i).update(deltaTime);
        }
        for (int i = 0; i <= m_arrMonster.size() - 1; i++) {
            m_arrMonster.get(i).update(deltaTime);
        }

        for (int j = 0; j <= constan.c_arrBullet.size() - 1; j++) {
            for (int i = 0; i <= m_arrMonster.size() - 1; i++) {
                if (m_arrMonster.get(i).getBoundaryPath().op(constan.c_arrBullet.get(j).getBoundaryPath(), Region.Op.INTERSECT)) {
                    Log.i("asdfasdfasdf", "update: ");
                    if (m_arrMonster.get(i).Type == 31) {
                        if (m_arrMonster.get(i).m_fHP - constan.c_arrBullet.get(j).m_fDamage <= 0 && constan.setfillter && constan.c_arrBullet.get(j).Yellow) {
                            constan.c_arrBullet.remove(j);
                            m_arrMonster.add(new Type32(m_arrMonster.get(i).locateX - 150, m_arrMonster.get(i).locateY, 0));
                            m_arrMonster.add(new Type32(m_arrMonster.get(i).locateX + 50, m_arrMonster.get(i).locateY, 0));
                            m_arrMonster.remove(i);
                            break;
                        } else if (constan.c_arrBullet.get(j).Yellow) {
                            m_arrMonster.get(i).m_fHP -= constan.c_arrBullet.get(j).m_fDamage;
                            constan.c_arrBullet.remove(j);
                        } else {
//                            m_arrMonster.get(i).m_fHP -= constan.c_arrBullet.get(j).m_fDamage;
                            constan.c_arrBullet.remove(j);
                        }
                    } else {
                        if (m_arrMonster.get(i).m_fHP - constan.c_arrBullet.get(j).m_fDamage <= 0) {
                            m_arrMonster.remove(i);
                            constan.c_arrBullet.remove(j);
                            break;
                        } else {
                            m_arrMonster.get(i).m_fHP -= constan.c_arrBullet.get(j).m_fDamage;
                            constan.c_arrBullet.remove(j);
                        }

                    }
                }
            }


            for (int i = 0; i <= m_arrObsta.size() - 1; i++) {
                if (m_arrObsta.get(i).getBoundaryPath().op(constan.c_arrBullet.get(j).getBoundaryPath(), Region.Op.INTERSECT)) {
                    if (m_arrObsta.get(i).Type == 28 && constan.c_arrBullet.get(j).Yellow) {
                        Log.i("Yellowwww", "update: ");
                        Log.i("sssdkfj", "update: " + constan.c_arrBullet.get(j).m_SGoSide);
                            switch (constan.c_arrBullet.get(j).m_SGoSide) {
                                case "U":
                                    constan.c_arrBullet.add(new bulletHeros(m_arrObsta.get(i).m_fPosX, m_arrObsta.get(i).m_fPosY, "R","yellow"));
                                    constan.c_arrBullet.add(new bulletHeros(m_arrObsta.get(i).m_fPosX - 50, m_arrObsta.get(i).m_fPosY, "L","yellow"));
                                    constan.c_arrBullet.add(new bulletHeros(m_arrObsta.get(i).m_fPosX, m_arrObsta.get(i).m_fPosY-10, "U","yellow"));
                                    constan.c_arrBullet.remove(j);
                                    Log.i("GoSideCU", "update: "+constan.c_arrBullet.get(j).m_SGoSide);
                                    break;

                                case "D":
                                    constan.c_arrBullet.add(new bulletHeros(m_arrObsta.get(i).m_fPosX + 50, m_arrObsta.get(i).m_fPosY, "R","yellow"));
                                    constan.c_arrBullet.add(new bulletHeros(m_arrObsta.get(i).m_fPosX - 50, m_arrObsta.get(i).m_fPosY, "L","yellow"));
                                    constan.c_arrBullet.add(new bulletHeros(m_arrObsta.get(i).m_fPosX, m_arrObsta.get(i).m_fPosY + 20, "D","yellow"));
                                    constan.c_arrBullet.remove(j);
                                    Log.i("ggdsadf", "update: " + m_arrObsta.get(i).m_fPosY);
                                    break;

                                case "L":
                                    constan.c_arrBullet.add(new bulletHeros(m_arrObsta.get(i).m_fPosX, m_arrObsta.get(i).m_fPosY + 20, "D","yellow"));
                                    constan.c_arrBullet.add(new bulletHeros(m_arrObsta.get(i).m_fPosX, m_arrObsta.get(i).m_fPosY-20, "U","yellow"));
                                    constan.c_arrBullet.add(new bulletHeros(m_arrObsta.get(i).m_fPosX - 50, m_arrObsta.get(i).m_fPosY, "L","yellow"));
                                    constan.c_arrBullet.remove(j);
                                    Log.i("ggdsadf", "update: " + m_arrObsta.get(i).m_fPosY);
                                    break;

                                case "R":
                                    constan.c_arrBullet.add(new bulletHeros(m_arrObsta.get(i).m_fPosX, m_arrObsta.get(i).m_fPosY, "R","yellow"));
                                    constan.c_arrBullet.add(new bulletHeros(m_arrObsta.get(i).m_fPosX, m_arrObsta.get(i).m_fPosY + 20, "D","yellow"));
                                    constan.c_arrBullet.add(new bulletHeros(m_arrObsta.get(i).m_fPosX, m_arrObsta.get(i).m_fPosY, "U","yellow"));
                                    Log.i("GoSideCR", "update: "+constan.c_arrBullet.get(j).m_SGoSide);
                                    constan.c_arrBullet.remove(j);
                                    break;
//                                default:
//                                    constan.c_arrBullet.remove(j);
//                                    Log.i("default", "update: ");
//                                    break;
                            }

                    }
                }
            }
            if (constan.c_arrBullet.get(j).delete) {
                constan.c_arrBullet.remove(j);
            }
        }
        for (int i = 0; i <= m_arrItem.size() - 1; i++) {
            m_arrItem.get(i).update(deltaTime);
        }

    }

    public void paint(float deltaTime, FMXGraphics g) {


        for (int i = 0; i <= m_arrObsta.size() - 1; i++) {
            m_arrObsta.get(i).paint(deltaTime, g);
        }
        for (int i = 0; i <= m_arrMonster.size() - 1; i++) {
            m_arrMonster.get(i).paint(deltaTime, g);

        }
        for (int i = 0; i <= m_arrItem.size() - 1; i++) {
            m_arrItem.get(i).paint(deltaTime, g);
        }
        constan.ObjHeros.update(deltaTime);
        constan.ObjHeros.paint(deltaTime, g);
    }


}
