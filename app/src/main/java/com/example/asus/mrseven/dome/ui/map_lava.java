package com.example.asus.mrseven.dome.ui;

import android.graphics.Rect;

import com.example.asus.mrseven.dome.constan;
import com.example.asus.mrseven.dome.settingItem;
import com.example.asus.mrseven.dome.stage011;
import com.example.asus.mrseven.framework.FMXButton;
import com.example.asus.mrseven.framework.FMXGame;
import com.example.asus.mrseven.framework.FMXGraphics;
import com.example.asus.mrseven.framework.FMXImage;
import com.example.asus.mrseven.framework.FMXInput;
import com.example.asus.mrseven.framework.FMXScreen;

import java.util.List;

public class map_lava extends FMXScreen {
    FMXImage play,FrameScore,Frame,Star,Button,Boss,LavaPlanet,Character,Back;
    Rect b1;
    public map_lava(FMXGame game) {
        super(game);
        FMXGraphics g = game.getGraphics();
        play=g.newImage("Resource UI/09_Map_LAVA/LAVA_MAP_01_PLAY_02[122x44].png", FMXGraphics.ImageFormat.ARGB4444);
        FrameScore=g.newImage("Resource UI/09_Map_LAVA/LAVA_MAP_02_Frame-Score_[388x168].png", FMXGraphics.ImageFormat.ARGB4444);
        Frame=g.newImage("Resource UI/09_Map_LAVA/LAVA_MAP_03_Frame_[694x190].png", FMXGraphics.ImageFormat.ARGB4444);
        Star=g.newImage("Resource UI/09_Map_LAVA/LAVA_MAP_04_Star_[48x24].png", FMXGraphics.ImageFormat.ARGB4444);//1*2
        Button=g.newImage("Resource UI/09_Map_LAVA/LAVA_MAP_05_Button_[76x38].png", FMXGraphics.ImageFormat.ARGB4444);//1*2
        Boss=g.newImage("Resource UI/09_Map_LAVA/LAVA_MAP_06_Boss_[134x204].png", FMXGraphics.ImageFormat.ARGB4444);
        LavaPlanet=g.newImage("Resource UI/09_Map_LAVA/LAVA_MAP_09_LavaPlanet_[380x380].png", FMXGraphics.ImageFormat.ARGB4444);
        Character=g.newImage("Resource UI/09_Map_LAVA/LAVA_MAP_10_Character_[258x108].png", FMXGraphics.ImageFormat.ARGB4444);//3*2
        Back=g.newImage("Resource UI/09_Map_LAVA/LAVA_MAP_11_Back_[98x54].png", FMXGraphics.ImageFormat.ARGB4444);
        FMXButton b = game.getButton();
        b1=new Rect(b.drawBTRects(constan.SCREEN_WIDTH-Boss.getWidth()-50-Button.getWidth()-20,constan.SCREEN_HEIGHT-Boss.getHeight()-50-Button.getHeight()-20,Button.getWidth()/2,Button.getHeight()));
    }

    @Override
    public void update(float deltaTime) {
        checkTouch();
    }

    @Override
    public void paint(float deltaTime) {
        FMXGraphics g = game.getGraphics();
        g.drawImage(constan.BG_Space, 0, 0, constan.BG_Space.getWidth() / 2 - constan.SCREEN_WIDTH / 2, constan.BG_Space.getHeight() - constan.SCREEN_HEIGHT, constan.SCREEN_WIDTH, constan.SCREEN_HEIGHT);
        g.drawImage(LavaPlanet,constan.SCREEN_WIDTH/2-LavaPlanet.getWidth()/2,50);
        g.drawImage(FrameScore,constan.SCREEN_WIDTH/2-FrameScore.getWidth()/2,50+LavaPlanet.getHeight()+20);
        g.drawImage(Button,constan.SCREEN_WIDTH-Boss.getWidth()-50-Button.getWidth()-20,constan.SCREEN_HEIGHT-Boss.getHeight()-50-Button.getHeight()-20,0,0,Button.getWidth()/2,Button.getHeight());
        g.drawImage(Boss,constan.SCREEN_WIDTH-Boss.getWidth()-50,constan.SCREEN_HEIGHT-Boss.getHeight()-50);
    }


    private void checkTouch() {
        List<FMXInput.TouchEvent> touchEvents = game.getInput().getTouchEvents();
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            FMXInput.TouchEvent event = touchEvents.get(i);

            if (event.type == FMXInput.TouchEvent.TOUCH_DOWN) {
                if (b1.contains(event.x, event.y)) {
                    game.setScreen(new settingItem(game));
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
