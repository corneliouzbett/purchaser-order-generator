package com.bettkipchumba.java;

import com.bettkipchumba.java.core.Launcher;
import javax.swing.SwingUtilities;

/**
 *
 * @author Corneliouz Bett
 */
public class IntializingLauncher {

    @SuppressWarnings("Convert2Lambda")
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Launcher launcher = new Launcher();
            }
        });
    }

}
