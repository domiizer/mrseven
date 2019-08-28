/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.asus.mrseven.framework;

/**
 *
 * @author User
 */
public abstract class FMXScreen {
    protected final FMXGame game;

    public FMXScreen(FMXGame game) {
        this.game = game;
    }

    public abstract void update(float deltaTime);

    public abstract void paint(float deltaTime);

    public abstract void pause();

    public abstract void resume();

    public abstract void dispose();
    
    public abstract void backButton();

    public abstract void onBackPressed();
}