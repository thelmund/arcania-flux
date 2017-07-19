/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goblinfire.arcaniaflux.state;

import java.util.Stack;

/**
 *
 * @author john
 */
public class GamestateManager {

    private static final Stack<Gamestate> STATE_STACK = new Stack<Gamestate>();

    public static void pushState(Gamestate new_state) {
        GamestateManager.STATE_STACK.push(new_state);
    }

    public static Gamestate popState() {
        return GamestateManager.STATE_STACK.pop();
    }

    public static void switchState(Gamestate new_state) {
        GamestateManager.STATE_STACK.clear();
        GamestateManager.STATE_STACK.push(new_state);
    }

    public static Gamestate getCurrentState() {
        return GamestateManager.STATE_STACK.peek();
    }
}
