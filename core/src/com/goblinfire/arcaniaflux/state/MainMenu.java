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
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.goblinfire.arcaniaflux.ui.Button;
import com.goblinfire.arcaniaflux.ui.Widget;
import com.goblinfire.arcaniaflux.ui.WidgetAction;
import com.goblinfire.arcaniaflux.utility.Utility;
import java.util.ArrayList;

/**
 *
 * @author john
 */
public class MainMenu extends Gamestate {

    private final SpriteBatch batch;

    public MainMenu() {
        this.camera = new OrthographicCamera(Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight());
        this.batch = new SpriteBatch();
        this.widgets = new ArrayList<Widget>();
        this.widgets.add(new Button(0, 0, true,
                new Texture(Gdx.files.internal("badlogic.jpg")),
                new WidgetAction() {
            @Override
            public void onFocus() {
                System.out.println("Focused!");
            }

            @Override
            public void onUnfocus() {
                System.out.println("Unfocused!");
            }

            @Override
            public void onSelect() {
                System.out.println("Selected!");
            }

            @Override
            public void onUnselect() {
                System.out.println("Unselected!");
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
                        Vector3 mouse_coordinates = new Vector3(x, y, 0);
                        GamestateManager.getCurrentState().camera.unproject(mouse_coordinates);

                        int wx = widget.getX();
                        int wy = widget.getY();
                        int ww = widget.getTexture().getWidth();
                        int wh = widget.getTexture().getHeight();

                        if (Utility.isInRect(mouse_coordinates.x,
                                mouse_coordinates.y, wx, wy, wx + ww,
                                wy + wh)) {
                            widget.getAction().onSelect();
                            widget.setSelected(true);
                        }
                    }
                }

                return true;
            }

            @Override
            public boolean touchUp(int x, int y, int pointer, int button) {
                if (button == Input.Buttons.LEFT) {
                    for (Widget widget : GamestateManager.getCurrentState().getWidgets()) {
                        Vector3 mouse_coordinates = new Vector3(x, y, 0);
                        GamestateManager.getCurrentState().camera.unproject(mouse_coordinates);

                        int wx = widget.getX();
                        int wy = widget.getY();
                        int ww = widget.getTexture().getWidth();
                        int wh = widget.getTexture().getHeight();

                        if (Utility.isInRect(mouse_coordinates.x,
                                mouse_coordinates.y, wx, wy, wx + ww,
                                wy + wh)) {
                            widget.getAction().onUnselect();
                            widget.setSelected(false);
                        } else if (widget.isSelected()) {
                            widget.getAction().onUnfocus();
                            widget.setFocused(false);
                            widget.getAction().onUnselect();
                            widget.setSelected(false);
                        }
                    }
                }

                return true;
            }

            @Override
            public boolean mouseMoved(int x, int y) {
                for (Widget widget : GamestateManager.getCurrentState().getWidgets()) {
                    Vector3 mouse_coordinates = new Vector3(x, y, 0);
                    GamestateManager.getCurrentState().camera.unproject(mouse_coordinates);

                    int wx = widget.getX();
                    int wy = widget.getY();
                    int ww = widget.getTexture().getWidth();
                    int wh = widget.getTexture().getHeight();

                    if (!widget.isFocused() && Utility.isInRect(mouse_coordinates.x,
                            mouse_coordinates.y, wx, wy, wx + ww,
                            wy + wh)) {
                        widget.getAction().onFocus();
                        widget.setFocused(true);
                    } else if (widget.isFocused() && !Utility.isInRect(mouse_coordinates.x,
                            mouse_coordinates.y, wx, wy, wx + ww,
                            wy + wh)) {
                        /* Mouse isn't over widget but it is focused, so unfocus it. */
                        widget.getAction().onUnfocus();
                        widget.setFocused(false);
                    }
                }
                return true;
            }
        });
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.camera.update();
        this.batch.setProjectionMatrix(this.camera.combined);
        this.batch.begin();

        for (Widget widget : this.widgets) {
            widget.render(batch, Gdx.graphics.getDeltaTime());
        }

        this.batch.end();
    }
}
