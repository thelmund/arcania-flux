/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goblinfire.arcaniaflux.actor;

import com.badlogic.gdx.physics.box2d.Body;

/**
 *
 * @author john
 */
public abstract class Actor {

    protected int worldX;
    protected int worldY;
    protected boolean isVisible;
    protected Body body;

    public Actor(int worldX, int worldY, boolean isVisible, Body body) {
        this.worldX = worldX;
        this.worldY = worldY;
        this.isVisible = isVisible;
        this.body = body;
    }
}
