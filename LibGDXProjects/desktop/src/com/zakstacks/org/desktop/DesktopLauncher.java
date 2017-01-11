package com.zakstacks.org.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.zakstacks.org.MyGdxGame;
import com.zakstacks.org.Words;

import java.io.IOException;

public class DesktopLauncher {
	public static void main (String[] arg) throws IOException{
		//LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//new LwjglApplication(new MyGdxGame(), config);
		String args[] = new String[2];
		Words.main(args);
	}
}
