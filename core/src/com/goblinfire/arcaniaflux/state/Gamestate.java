/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goblinfire.arcaniaflux.state;

import com.goblinfire.arcaniaflux.ui.Widget;
import java.util.ArrayList;

/**
 *
 * @author john
 */
public abstract class Gamestate {

    protected ArrayList<Widget> widgets;

    public abstract void render();

    public ArrayList<Widget> getWidgets() {
        return this.widgets;
    }
}
