/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.asus.mrseven.framework;


/**
 *
 * @author User
 */
public interface FMXAudio {
    public FMXMusic createMusic(String file);

    public FMXSound createSound(String file);
}