package com.example.asus.mrseven.dome.ui;

import android.graphics.Color;
import android.graphics.Rect;

import com.example.asus.mrseven.dome.constan;
import com.example.asus.mrseven.framework.FMXButton;
import com.example.asus.mrseven.framework.FMXGame;
import com.example.asus.mrseven.framework.FMXGraphics;
import com.example.asus.mrseven.framework.FMXImage;
import com.example.asus.mrseven.framework.FMXInput;
import com.example.asus.mrseven.framework.FMXScreen;

import java.util.List;

public class home extends FMXScreen {
    FMXImage Home_01,Home_02,Home_04;
    Rect b_start;
    public home(FMXGame game) {
        super(game);
        FMXGraphics g = game.getGraphics();
        Home_01=g.newImage("Resource UI/04_Home/Home_01_[802x360].png", FMXGraphics.ImageFormat.ARGB4444);//start rank lo*2
        Home_02=g.newImage("Resource UI/04_Home/Home_02_.png", FMXGraphics.ImageFormat.ARGB4444);//logo
        Home_04=g.newImage("Resource UI/04_Home/Home_04_[398x360].png", FMXGraphics.ImageFormat.ARGB4444);//start rank credits
        FMXButton b = game.getButton();
        b_start = b.drawBTRects(constan.SCREEN_WIDTH/2-Home_01.getWidth()/2/2,constan.SCREEN_HEIGHT-Home_01.getHeight(),Home_01.getWidth()/2,Home_01.getHeight()/3);
    }

    @Override
    public void update(float deltaTime) {
        checkTouch();
    }

    @Override
    public void paint(float deltaTime) {
        FMXGraphics g = game.getGraphics();
        g.drawImage(constan.BG_Space,0,0,constan.BG_Space.getWidth()/2-constan.SCREEN_WIDTH/2,constan.BG_Space.getHeight()-constan.SCREEN_HEIGHT,constan.SCREEN_WIDTH,constan.SCREEN_HEIGHT);

        g.drawImage(Home_01,constan.SCREEN_WIDTH/2-Home_01.getWidth()/2/2,constan.SCREEN_HEIGHT-Home_01.getHeight(),0,0,Home_01.getWidth()/2,Home_01.getHeight());
        g.drawImage(Home_02,constan.SCREEN_WIDTH/2-Home_02.getWidth()/2,50);
        g.drawRect(b_start,Color.MAGENTA);
    }
    private void checkTouch() {
        List<FMXInput.TouchEvent> touchEvents = game.getInput().getTouchEvents();
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            FMXInput.TouchEvent event = touchEvents.get(i);

            if (event.type == FMXInput.TouchEvent.TOUCH_DOWN) {
                if (b_start.contains(event.x, event.y)) {
                    game.setScreen(new map(game));
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
