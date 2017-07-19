/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goblinfire.arcaniaflux.utility;

/**
 *
 * @author John
 */
public class Utility {

    public static boolean isInRect(float px, float py, float x1, float y1,
            float x2, float y2) {
        return px >= x1 && px <= x2 && py >= y1 && py <= y2;
    }
}
