package com.goblinfire.arcaniaflux.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.goblinfire.arcaniaflux.ArcaniaFlux;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Arcania Flux";
        config.width = 800;
        config.height = 600;
        new LwjglApplication(new ArcaniaFlux(), config);
    }
}
