package com.excerloops.interfaces;


import java.awt.*;

/**
 * Created by Gunther Knutson on 11/22/2016.
 */

public interface ExcerloopsInterface {
    //Roles
    String USER = "user";
    String ADMIN =  "admin";

    //Colors
    int MAGENTA = Color.magenta.getRGB();
    int BLUE = Color.blue.getRGB();
    int CYAN = Color.cyan.getRGB();
    int GREEN = Color.green.getRGB();
    int YELLOW = Color.yellow.getRGB();
    int RED = Color.red.getRGB();
    int BLACK = Color.black.getRGB();
    int WHITE = Color.white.getRGB();

    //int MAGENTA = -65281;
    //int BLUE = -16776961;
    //int CYAN = -16711681;
    //int GREEN = -16711936;
    //int YELLOW = -256;
    //int RED = -65536;
    //int BLACK = -16777216;
    //int WHITE = -1;

    //Units
    public final String MI =  "MI";
    public final String KM = "KM";

    //Transit Modes
    String RUN = "RUN";
    String BIKE = "BIKE";
    String DRIVE = "DRIVE";
}
