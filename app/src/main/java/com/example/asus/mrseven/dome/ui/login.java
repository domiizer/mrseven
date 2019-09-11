package com.example.asus.mrseven.dome.ui;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.Log;

import com.example.asus.mrseven.dome.constan;
import com.example.asus.mrseven.dome.stage011;
import com.example.asus.mrseven.framework.FMXButton;
import com.example.asus.mrseven.framework.FMXGame;
import com.example.asus.mrseven.framework.FMXGraphics;
import com.example.asus.mrseven.framework.FMXImage;
import com.example.asus.mrseven.framework.FMXInput;
import com.example.asus.mrseven.framework.FMXScreen;

import java.util.List;

public class login extends FMXScreen {
    FMXImage login_01,Loing_02,Loing_03,Loing_04;

    Rect b_start;
    public login(FMXGame game) {
        super(game);
        FMXGraphics g= game.getGraphics();
        login_01=g.newImage("Resource UI/03_Login/login_01_[494x80].png", FMXGraphics.ImageFormat.ARGB4444);    //ip box
        Loing_02=g.newImage("Resource UI/03_Login/Loing_02_[526x132].png", FMXGraphics.ImageFormat.ARGB4444);   //face goo
        Loing_03=g.newImage("Resource UI/03_Login/Loing_03_[193x84].png", FMXGraphics.ImageFormat.ARGB4444);    //start
        Loing_04=g.newImage("Resource UI/03_Login/Loing_04_[206x86].png", FMXGraphics.ImageFormat.ARGB4444);    //login

        FMXButton button =game.getButton();
        b_start=new Rect();
        b_start=button.drawBTRects(constan.SCREEN_WIDTH/2-Loing_03.getWidth()/2,constan.SCREEN_HEIGHT/2-login_01.getHeight()/2+130*2,Loing_03.getWidth(),Loing_03.getHeight());
    }

    @Override
    public void update(float deltaTime) {
        checkTouch();
    }

    @Override
    public void paint(float deltaTime) {
        FMXGraphics g = game.getGraphics();
        g.drawImage(constan.BG_Space,0,0,constan.BG_Space.getWidth()/2-constan.SCREEN_WIDTH/2,constan.BG_Space.getHeight()-constan.SCREEN_HEIGHT,constan.SCREEN_WIDTH,constan.SCREEN_HEIGHT);
        g.drawRect(b_start, Color.MAGENTA);
        g.drawImage(login_01,constan.SCREEN_WIDTH/2-login_01.getWidth()/2,constan.SCREEN_HEIGHT/2-login_01.getHeight()/2);
        g.drawImage(login_01,constan.SCREEN_WIDTH/2-login_01.getWidth()/2,constan.SCREEN_HEIGHT/2-login_01.getHeight()/2+130);
        g.drawImage(Loing_03,constan.SCREEN_WIDTH/2-Loing_03.getWidth()/2,constan.SCREEN_HEIGHT/2-login_01.getHeight()/2+130*2);
        g.drawImage(Loing_02,constan.SCREEN_WIDTH/2-login_01.getWidth()/4-Loing_02.getWidth()/4/2,constan.SCREEN_HEIGHT/2-login_01.getHeight()/2-Loing_02.getHeight()-50,0,0,Loing_02.getWidth()/4,Loing_02.getHeight());
        g.drawImage(Loing_02,constan.SCREEN_WIDTH/2+login_01.getWidth()/4-Loing_02.getWidth()/4/2,constan.SCREEN_HEIGHT/2-login_01.getHeight()/2-Loing_02.getHeight()-50,Loing_02.getWidth()/4*2,0,Loing_02.getWidth()/4,Loing_02.getHeight());
        g.drawImage(Loing_04,constan.SCREEN_WIDTH/2-Loing_04.getWidth()/2,constan.SCREEN_HEIGHT/2-login_01.getHeight()/2-Loing_02.getHeight()-50-Loing_04.getHeight()-50);
    }


    private void checkTouch() {
        List<FMXInput.TouchEvent> touchEvents = game.getInput().getTouchEvents();
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            FMXInput.TouchEvent event = touchEvents.get(i);

            if (event.type == FMXInput.TouchEvent.TOUCH_DOWN) {
                if (b_start.contains(event.x, event.y)) {
                    game.setScreen(new home(game));
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
