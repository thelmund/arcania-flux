/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goblinfire.arcaniaflux.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.goblinfire.arcaniaflux.ui.Image;
import com.goblinfire.arcaniaflux.ui.WidgetAction;

/**
 *
 * @author john
 */
public class SplashScreen extends Gamestate {

    private final Image logo;
    private final SpriteBatch spriteBatch;
    private float timer;
    private final float timer_end;

    public SplashScreen() {
        this.camera = new OrthographicCamera(Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight());
        this.logo = new Image(0, 0, true,
                new Texture(Gdx.files.internal("badlogic.jpg")),
                new WidgetAction());
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
            this.spriteBatch.dispose();
            GamestateManager.switchState(new MainMenu());
        }

        this.camera.update();
        this.spriteBatch.setProjectionMatrix(this.camera.combined);
        this.spriteBatch.begin();
        this.logo.render(spriteBatch, Gdx.graphics.getDeltaTime());
        this.spriteBatch.end();
    }
}
