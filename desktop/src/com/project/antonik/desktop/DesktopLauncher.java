package com.project.antonik.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.project.antonik.ScreenController;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Antonik";
	    config.width = 540;
	    config.height = 960;
	    config.fullscreen = false;
	    config.vSyncEnabled = true;
		new LwjglApplication(new ScreenController() , config);
	}
}
