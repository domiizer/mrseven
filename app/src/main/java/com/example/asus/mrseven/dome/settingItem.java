package com.example.asus.mrseven.dome;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.Log;

import com.example.asus.mrseven.framework.FMXButton;
import com.example.asus.mrseven.framework.FMXGame;
import com.example.asus.mrseven.framework.FMXGraphics;
import com.example.asus.mrseven.framework.FMXInput;
import com.example.asus.mrseven.framework.FMXScreen;

import java.util.List;

public class settingItem extends FMXScreen {
    Rect NextScreen;
    Rect[ ] itemSlot=new Rect[6];
    Rect[] item=new Rect[10];
    public settingItem(FMXGame game) {
        super(game);
        FMXGraphics g = game.getGraphics();
        FMXButton b = game.getButton();
        constan.shipsdf = g.newImage("ship_red.png", FMXGraphics.ImageFormat.ARGB4444);
        NextScreen = b.drawBTRects(constan.SCREEN_WIDTH - 250, constan.SCREEN_HEIGHT - 150, 200, 100);
        for (int i = 0; i <itemSlot.length ; i+=2) {
            itemSlot[i] = b.drawBTRects(constan.SCREEN_WIDTH/2 - 250, 200+80*i, 100, 100);
        }
        for (int i = 1; i <itemSlot.length ; i+=2) {
            itemSlot[i] = b.drawBTRects(constan.SCREEN_WIDTH/2 + 150, 200+80*(i-1), 100, 100);
        }
        for (int i = 0,x=0,m=0; i < item.length; i++) {
            if (i %4==0&&i!=0){
                x++;
                m+=4;
            }
            item[i]=b.drawBTRects(constan.SCREEN_WIDTH/2 -250+150*(i-m), constan.SCREEN_HEIGHT/2+constan.SCREEN_HEIGHT/8+150*x, 100, 100);
        }

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void paint(float deltaTime) {
        FMXGraphics g = game.getGraphics();

        g.drawRect(NextScreen, Color.GREEN);
        for (int i = 0; i < itemSlot.length; i++) {
            g.drawRect(itemSlot[i], Color.RED);
        }
        for (int i = 0; i < item.length; i++) {
            g.drawRect(item[i],Color.GRAY);
        }
        g.drawImage(constan.shipsdf,constan.SCREEN_WIDTH/2 - constan.shipsdf.getWidth()/3/2,400,0, 0, constan.shipsdf.getWidth() / 3, constan.shipsdf.getHeight());
        checkTouch();
    }

    private void checkTouch() {
        List<FMXInput.TouchEvent> touchEvents = game.getInput().getTouchEvents();
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            FMXInput.TouchEvent event = touchEvents.get(i);

            if (event.type == FMXInput.TouchEvent.TOUCH_DOWN) {
                if (NextScreen.contains(event.x, event.y)) {
                    game.setScreen(new stage011(game));
                }
                for (int j = 0; j < itemSlot.length; j++) {
                    if (itemSlot[j].contains(event.x, event.y)) {
                        constan.setfillter=true;
                        Log.i("Whare am I ", "itemSlot: "+j);
                    }
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
