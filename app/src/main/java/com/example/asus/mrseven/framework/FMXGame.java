/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.asus.mrseven.framework;

/**
 *
 * @author User
 */
public interface FMXGame {
    public FMXAudio getAudio();

    public FMXInput getInput();

    public FMXFileIO getFileIO();

    public FMXButton getButton();

    public FMXGraphics getGraphics();

    public void setScreen(FMXScreen screen);

    public FMXScreen getCurrentScreen();

    public FMXScreen getInitScreen();
    
    public int[] getScreenSize();
}
