/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goblinfire.arcaniaflux.ui;

/**
 *
 * @author john
 */
public abstract class Widget {

    protected int x;
    protected int y;
    protected boolean is_visible;

    public Widget(int x, int y, boolean is_visible) {
        this.x = x;
        this.y = y;
        this.is_visible = is_visible;
    }
}
