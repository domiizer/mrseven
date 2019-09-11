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

public class map extends FMXScreen {
    FMXImage Planet, lock;
    Rect home, lava, ice;

    public map(FMXGame game) {
        super(game);
        FMXGraphics g = game.getGraphics();
        Planet = g.newImage("Resource UI/08_Map/Map_01_Planet[768x540].png", FMXGraphics.ImageFormat.ARGB4444);//4*3
        lock = g.newImage("Resource UI/08_Map/Map_02_lock[42x54].png", FMXGraphics.ImageFormat.ARGB4444);

        FMXButton b = game.getButton();
        home = new Rect(b.drawBTRects(constan.SCREEN_WIDTH / 2 - Planet.getWidth() / 4 / 2, 30,Planet.getWidth() / 4, Planet.getHeight() / 3));
        lava = new Rect(b.drawBTRects(constan.SCREEN_WIDTH / 4 - Planet.getWidth() / 4 / 2, 30 + (Planet.getHeight() / 3) * 2,Planet.getWidth() / 4, Planet.getHeight() / 3));
        ice = new Rect();
    }

    @Override
    public void update(float deltaTime) {
        checkTouch();
    }

    @Override
    public void paint(float deltaTime) {
        FMXGraphics g = game.getGraphics();
        g.drawImage(constan.BG_Space, 0, 0, constan.BG_Space.getWidth() / 2 - constan.SCREEN_WIDTH / 2, constan.BG_Space.getHeight() - constan.SCREEN_HEIGHT, constan.SCREEN_WIDTH, constan.SCREEN_HEIGHT);
        /*home*/
        g.drawRect(home, Color.MAGENTA);
        g.drawImage(Planet, constan.SCREEN_WIDTH / 2 - Planet.getWidth() / 4 / 2, 30, 0, 0, Planet.getWidth() / 4, Planet.getHeight() / 3);
        /*lava*/
        g.drawRect(lava,Color.MAGENTA);
        g.drawImage(Planet, constan.SCREEN_WIDTH / 4 - Planet.getWidth() / 4 / 2, 30 + (Planet.getHeight() / 3) * 2, Planet.getWidth() / 4, 0, Planet.getWidth() / 4, Planet.getHeight() / 3);


        g.drawImage(lock, constan.SCREEN_WIDTH / 4 - lock.getWidth() / 2, 30 + (Planet.getHeight() / 3) * 2 + lock.getHeight());
    }

    private void checkTouch() {
        List<FMXInput.TouchEvent> touchEvents = game.getInput().getTouchEvents();
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            FMXInput.TouchEvent event = touchEvents.get(i);

            if (event.type == FMXInput.TouchEvent.TOUCH_DOWN) {
                if (lava.contains(event.x, event.y)) {
                    game.setScreen(new map_lava(game));
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
