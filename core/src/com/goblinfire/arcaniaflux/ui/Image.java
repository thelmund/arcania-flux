/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goblinfire.arcaniaflux.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author John
 */
public class Image extends Widget {

    public Image(int x, int y, boolean isVisible, Texture texture,
            WidgetAction action) {
        super(x, y, isVisible, texture, action);
    }

    @Override
    public void render(SpriteBatch batch, float dt) {
        batch.draw(this.texture, this.x, this.y);
    }
}
