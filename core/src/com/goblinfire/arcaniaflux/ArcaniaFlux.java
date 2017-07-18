package com.goblinfire.arcaniaflux;

import com.badlogic.gdx.ApplicationAdapter;
import com.goblinfire.arcaniaflux.state.GamestateManager;
import com.goblinfire.arcaniaflux.state.SplashScreen;

public class ArcaniaFlux extends ApplicationAdapter {

    @Override
    public void create() {
        GamestateManager.switchState(new SplashScreen());
    }

    @Override
    public void render() {
        GamestateManager.getCurrentState().render();
    }

    @Override
    public void dispose() {
    }
}
