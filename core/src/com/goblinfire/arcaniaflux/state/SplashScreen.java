/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goblinfire.arcaniaflux.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author john
 */
public class SplashScreen extends Gamestate {
    
    private final Texture logo;
    private final SpriteBatch spriteBatch;
    private float timer;
    private final float timer_end;
    
    public SplashScreen() {
        this.logo = new Texture(Gdx.files.internal("badlogic.jpg"));
        this.spriteBatch = new SpriteBatch();
        this.timer = 0;
        this.timer_end = 3;
    }
    
    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        this.timer += Gdx.graphics.getDeltaTime();
        if (this.timer >= this.timer_end) {
            this.logo.dispose();
            this.spriteBatch.dispose();
            GamestateManager.switchState(new MainMenu());
        }
        
        this.spriteBatch.begin();
        this.spriteBatch.draw(logo, 150, 50);
        this.spriteBatch.end();
    }
}
