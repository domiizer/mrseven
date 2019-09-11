package com.example.asus.mrseven.dome.ui;

import com.example.asus.mrseven.dome.constan;
import com.example.asus.mrseven.framework.FMXGame;
import com.example.asus.mrseven.framework.FMXGraphics;
import com.example.asus.mrseven.framework.FMXImage;
import com.example.asus.mrseven.framework.FMXScreen;

public class loading_LTR extends FMXScreen {
    FMXImage Loading_Logo_LTR;
    float count=0;
    public loading_LTR(FMXGame game) {
        super(game);
        FMXGraphics g = game.getGraphics();
        constan.BG_Space =g.newImage("Resource UI/00_Sharing/BG_Space_[1440x2560].png", FMXGraphics.ImageFormat.ARGB4444);
        Loading_Logo_LTR =g.newImage("Resource UI/01_Loading_LTR/Loading_Logo_LTR[552x176].png", FMXGraphics.ImageFormat.ARGB4444);

    }

    @Override
    public void update(float deltaTime) {
        count+=deltaTime*0.01;
        if (count>=2){
            game.setScreen(new loading_Rogue(game));
        }
    }

    @Override
    public void paint(float deltaTime) {
        FMXGraphics g = game.getGraphics();
        g.drawImage(constan.BG_Space,0,0,constan.BG_Space.getWidth()/2-constan.SCREEN_WIDTH/2,constan.BG_Space.getHeight()-constan.SCREEN_HEIGHT,constan.SCREEN_WIDTH,constan.SCREEN_HEIGHT);
        g.drawImage(Loading_Logo_LTR,constan.SCREEN_WIDTH/2-Loading_Logo_LTR.getWidth()/2,constan.SCREEN_HEIGHT/2-Loading_Logo_LTR.getHeight());
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
