/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goblinfire.arcaniaflux.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.goblinfire.arcaniaflux.ui.Button;
import com.goblinfire.arcaniaflux.ui.Widget;
import com.goblinfire.arcaniaflux.ui.WidgetAction;
import java.util.ArrayList;

/**
 *
 * @author john
 */
public class MainMenu extends Gamestate {

    private final SpriteBatch batch;

    public MainMenu() {
        this.batch = new SpriteBatch();
        this.widgets = new ArrayList<Widget>();
        this.widgets.add(new Button(50, 50, true,
                new Texture(Gdx.files.internal("badlogic.jpg")),
                new WidgetAction() {
            @Override
            public void onFocus() {
                System.out.println("Focused!");
            }

            @Override
            public void onSelect() {
                System.out.println("Selected!");
            }
        }));

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                return true;
            }

            @Override
            public boolean keyUp(int keycode) {
                return true;
            }

            @Override
            public boolean touchDown(int x, int y, int pointer, int button) {
                if (button == Input.Buttons.LEFT) {

                    for (Widget widget : GamestateManager.getCurrentState().getWidgets()) {
                        int wx = widget.getX();
                        int wy = widget.getY();
                        int ww = widget.getTexture().getWidth();
                        int wh = widget.getTexture().getHeight();
                        
                        System.out.format("X, Y: (%d, %d)\nwX, wY: (%d, %d)\nwW, wH: %d, %d\n", x, y, wx, wy, ww, wh);

                        if (x >= wx && x <= wx + ww && y >= wy && y <= wy + wh) {
                            System.out.println("Widget clicked");
                            widget.getAction().onSelect();
                            widget.setSelected(true);
                        }
                    }
                }
                return true;
            }
        });
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.batch.begin();

        for (Widget widget : this.widgets) {
            widget.render(batch, Gdx.graphics.getDeltaTime());
        }

        this.batch.end();
    }
}
