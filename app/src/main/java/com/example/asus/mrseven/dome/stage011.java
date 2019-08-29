package com.example.asus.mrseven.dome;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import com.example.asus.mrseven.framework.FMXButton;
import com.example.asus.mrseven.framework.FMXGame;
import com.example.asus.mrseven.framework.FMXGraphics;
import com.example.asus.mrseven.framework.FMXImage;
import com.example.asus.mrseven.framework.FMXInput;
import com.example.asus.mrseven.framework.FMXScreen;

import java.util.ArrayList;
import java.util.List;

public class stage011 extends FMXScreen {
    gameController controller;


    //    bulletMain m_objMain;
    FMXImage ship_red;
    Paint sector = new Paint();
    float deeta;
    int sejf;
    Rect RazorSW;
    float red, green, blue;
    Paint paintSW;
    public stage011(FMXGame game) {
        super(game);
        FMXGraphics g = game.getGraphics();
        constan.shipsdf = g.newImage("ship_red.png", FMXGraphics.ImageFormat.ARGB4444);
        sector.setColor(Color.GREEN);
        sector.setTextSize(50);
        ship_red = g.newImage("ship_red.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.shipsizeW = ship_red.getWidth();
        constan.shipsizeH = ship_red.getHeight();
        controller = new gameController();
        FMXButton b = game.getButton();
        RazorSW = b.drawBTRects(constan.SCREEN_WIDTH - 120, constan.SCREEN_HEIGHT - 120, 100, 100);

    }

    @Override
    public void update(float deltaTime) {
        controller.update(deltaTime);

        checkTouch();
    }

    @Override
    public void paint(float deltaTime) {
        FMXGraphics g = game.getGraphics();
        g.clearScreen(Color.BLACK);
        controller.paint(deltaTime, g);
        g.drawImage(ship_red, constan.SCREEN_WIDTH / 2 - ship_red.getWidth() / 3 / 2, constan.SCREEN_HEIGHT - ship_red.getHeight(), 0, 0, ship_red.getWidth() / 3, ship_red.getHeight());
        g.drawString("Y:" + controller.m_objPosY.m_fData, 50, 50, sector);
        g.drawString("X:" + controller.m_objPosX.m_fData, constan.SCREEN_WIDTH / 2, 50, sector);

        PBullet(deltaTime, g);

    }

    private void PBullet(float deltaTime, FMXGraphics g) {
        if (constan.changeColor) {
            g.drawRect(RazorSW,Color.rgb(255, 255, 0));
        }else {
            g.drawRect(RazorSW,Color.rgb(102, 204, 255));
        }
    }

    private void checkTouch() {
        List<FMXInput.TouchEvent> touchEvents = game.getInput().getTouchEvents();
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            FMXInput.TouchEvent event = touchEvents.get(i);

            if (event.type == FMXInput.TouchEvent.TOUCH_DOWN) {
                if (RazorSW.contains(event.x, event.y)) {
                    if (!constan.changeColor){
                        constan.changeColor=true;
                    }
                    else{
                        constan.changeColor=false;
                    }
                    Log.i("asdfsdfffa", "checkTouch: "+constan.changeColor);
                }
            }
        }
    }


    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void backButton() {

    }

    @Override
    public void onBackPressed() {

    }
}
