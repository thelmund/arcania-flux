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
 * @author john
 */
public abstract class Widget {

    protected int x;
    protected int y;
    protected boolean isVisible;
    protected Texture texture;
    protected WidgetAction action;
    protected boolean isFocused;
    protected boolean isSelected;

    public Widget(int x, int y, boolean isVisible, Texture texture,
            WidgetAction action) {
        this.x = x;
        this.y = y;
        this.isVisible = isVisible;
        this.texture = texture;
        this.action = action;
    }

    public abstract void render(SpriteBatch batch, float dt);

    public void onFocus() {
        this.action.onFocus();
    }

    public void onUnfocus() {
        this.action.onUnfocus();
    }

    public void onSelect() {
        this.action.onSelect();
    }

    public void onUnselect() {
        this.action.onUnselect();
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public Texture getTexture() {
        return this.texture;
    }

    public WidgetAction getAction() {
        return this.action;
    }

    public boolean isFocused() {
        return this.isFocused;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setFocused(boolean isFocused) {
        this.isFocused = isFocused;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}
