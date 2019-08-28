/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.asus.mrseven.framework.implementation;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.Window;
import android.view.WindowManager;

import com.example.asus.mrseven.framework.FMXAudio;
import com.example.asus.mrseven.framework.FMXButton;
import com.example.asus.mrseven.framework.FMXFileIO;
import com.example.asus.mrseven.framework.FMXGame;
import com.example.asus.mrseven.framework.FMXGraphics;
import com.example.asus.mrseven.framework.FMXInput;
import com.example.asus.mrseven.framework.FMXScreen;


public abstract class FMXAndroidGame extends Activity implements FMXGame {
    FMXAndroidFastRenderView renderView;
    FMXGraphics graphics;
    FMXButton button;
    FMXAudio audio;
    FMXInput input;
    FMXFileIO fileIO;
    FMXScreen screen;
    WakeLock wakeLock;
    
    protected int m_nScreenWidth  = 720;//480;
    protected int m_nScreenHeight = 1280;//784;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        boolean isPortrait = getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
        int frameBufferWidth = isPortrait ? m_nScreenWidth: m_nScreenHeight;
        int frameBufferHeight = isPortrait ? m_nScreenHeight: m_nScreenWidth;
        Bitmap frameBuffer = Bitmap.createBitmap(frameBufferWidth,
                frameBufferHeight, Config.RGB_565);
        
        float scaleX = (float) frameBufferWidth
                / getWindowManager().getDefaultDisplay().getWidth();
        float scaleY = (float) frameBufferHeight
                / getWindowManager().getDefaultDisplay().getHeight();

        renderView = new FMXAndroidFastRenderView(this, frameBuffer);
        graphics = new FMXAndroidGraphics(getAssets(), frameBuffer);
        button = new FMXAndroidButton();
        fileIO = new FMXAndroidFileIO(this);
        audio = new FMXAndroidAudio(this);
        input = new FMXAndroidInput(this, renderView, scaleX, scaleY);
        screen = getInitScreen();
        setContentView(renderView);
        
        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "MyGame");
    }
    
    public int[] getScreenSize(){
        boolean isPortrait = getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
        int frameBufferWidth = isPortrait ? m_nScreenWidth: m_nScreenHeight;
        int frameBufferHeight = isPortrait ? m_nScreenHeight: m_nScreenWidth;
        int size[] = {frameBufferWidth,frameBufferHeight} ;
        return size;
    
    }
    
    @Override
    public void onResume() {
        super.onResume();
        wakeLock.acquire();
        screen.resume();
        renderView.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        wakeLock.release();
        renderView.pause();
        screen.pause();

        if (isFinishing())
            screen.dispose();
    }
    @Override
    public void onBackPressed() {
        // your code.
        screen.onBackPressed();

    }
    @Override
    public FMXInput getInput() {
        return input;
    }

    @Override
    public FMXFileIO getFileIO() {
        return fileIO;
    }

    @Override
    public FMXGraphics getGraphics() {
        return graphics;
    }
    @Override
    public FMXButton getButton() {
        return button;
    }
    @Override
    public FMXAudio getAudio() {
        return audio;
    }

    @Override
    public void setScreen(FMXScreen screen) {
        if (screen == null)
            throw new IllegalArgumentException("Screen must not be null");

        this.screen.pause();
        this.screen.dispose();
        screen.resume();
        screen.update(0);
        this.screen = screen;
    }
    
    public FMXScreen getCurrentScreen() {

        return screen;
    }
}
