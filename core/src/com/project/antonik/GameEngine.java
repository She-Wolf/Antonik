package com.project.antonik;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/** Тут будут все данные, подлежащие сохранению */
public class GameEngine {
	private static GameEngine gameEngine;
	
	public static void initInstance() { gameEngine = new GameEngine(); }
	public static GameEngine getInstance() { return gameEngine; }
	
	/**
	 * Загрузка данных
	 */
	public void load() {
		Preferences prefs = Gdx.app.getPreferences("prefs");
		//prefs.getInteger("ченить");
	};
	/**
	 * Сохранение данных
	 */
	public void save() {
		Preferences prefs = Gdx.app.getPreferences("prefs");
		//prefs.putInteger("ченить", ченить);
	}
}
