package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.mygdx.game.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		/*
		TexturePacker.Settings settings = new TexturePacker.Settings();
		settings.maxHeight = 4096;
		settings.maxWidth = 4096;
		settings.edgePadding = true;
		settings.filterMin = Texture.TextureFilter.Linear;
		TexturePacker.process(settings, "knight",".","knight");
		TexturePacker.process(settings, "enemies/slime",".","slime");
		TexturePacker.process(settings, "tiles/floor",".","floor");
		TexturePacker.process(settings,"tiles/wall",".","wall");
		TexturePacker.process(settings,"menu",".","menu.atlas");

		Tools are off in the gradle.build
		*/
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.useVsync(true);
		config.setTitle("projekt-D");
		config.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode());
		config.setWindowIcon("knight/knight_idle_anim_0.png");
		config.setResizable(true);
		//config.setWindowSizeLimits(800,600,800,600);
		new Lwjgl3Application(new Main(), config);
	}
}
