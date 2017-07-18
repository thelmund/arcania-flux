/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goblinfire.arcaniaflux.state;

/**
 *
 * @author john
 */
public class GamestateManager {

    private static Gamestate current_state;

    public static void switchState(Gamestate new_state) {
        GamestateManager.current_state = new_state;
    }

    public static Gamestate getCurrentState() {
        return GamestateManager.current_state;
    }
}
