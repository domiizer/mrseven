package com.example.asus.mrseven.dome.ui;

import com.example.asus.mrseven.dome.constan;
import com.example.asus.mrseven.framework.FMXGame;
import com.example.asus.mrseven.framework.FMXGraphics;
import com.example.asus.mrseven.framework.FMXImage;
import com.example.asus.mrseven.framework.FMXScreen;

public class loading_Rogue extends FMXScreen {
    FMXImage Loading_Logo,loading_frame;
    float count=0;
    public loading_Rogue(FMXGame game) {
        super(game);
        FMXGraphics g = game.getGraphics();
        Loading_Logo= g.newImage("Resource UI/02_Loading_Rogue/Loading_Logo_[690x194].png", FMXGraphics.ImageFormat.ARGB4444);
        loading_frame= g.newImage("Resource UI/02_Loading_Rogue/loading_frame.png", FMXGraphics.ImageFormat.ARGB4444);
    }

    @Override
    public void update(float deltaTime) {
        count+=deltaTime*0.01;
        if (count>=2){
            game.setScreen(new login(game));
        }
    }

    @Override
    public void paint(float deltaTime) {
        FMXGraphics g = game.getGraphics();
        g.drawImage(constan.BG_Space,0,0,constan.BG_Space.getWidth()/2-constan.SCREEN_WIDTH/2,constan.BG_Space.getHeight()-constan.SCREEN_HEIGHT,constan.SCREEN_WIDTH,constan.SCREEN_HEIGHT);
        g.drawImage(Loading_Logo,constan.SCREEN_WIDTH/2-Loading_Logo.getWidth()/2,constan.SCREEN_HEIGHT/2-Loading_Logo.getHeight()-loading_frame.getHeight());
        g.drawImage(loading_frame,constan.SCREEN_WIDTH/2-loading_frame.getWidth()/2,constan.SCREEN_HEIGHT/2-loading_frame.getHeight()+50);

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
