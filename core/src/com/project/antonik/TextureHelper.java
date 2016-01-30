package com.project.antonik;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
/** Все текстуры и их текстурРегионы находятся тут */
public class TextureHelper {
	//Текстуры
	private static TextureHelper textureHelper;
	public Texture menuButtonsTexture; //Кнопки меню
	public Texture menuBackgroundTexture; //Бэкгрануд меню
	//Регионы
	public TextureRegion[] buttonsTR; //Кнопки меню
	BitmapFont font;
	//Блок констант
	final int BUTTON_WIDTH = 600;
	final int BUTTON_HEIGHT = 150;
	final int BUTTONS_NUMBER = 5;
	private static final String FONT_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.:;,{}\"´`'<>";
	
	public static void initInstance() { textureHelper = new TextureHelper(); textureHelper.initTextures(); }
	public static TextureHelper getInstance() { return textureHelper;}
	
	/**
	 * Загрузка текстур 
	 */
	public void initTextures() {
		loadFont();
		loadTextures();
		loadTextureRegions();
	}
	/**
	 * Выгрузка текстур
	 */
	public void disposeAll() {
		menuButtonsTexture.dispose();
		menuBackgroundTexture.dispose();
	}
	 
	/**
	 * Загрузка шрифта
	 */
	private void loadFont() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Stencil Normal.ttf"));
        FreeTypeFontParameter param = new FreeTypeFontParameter();
        param.size = 110; 
        param.characters = FONT_CHARACTERS; 
        font = generator.generateFont(param); 
        font.setColor(Color.CYAN); 
        generator.dispose();
	}
	
	/**
	 * Загрузка текстур
	 */
	private void loadTextures() {	
		menuButtonsTexture = loadTexture("images/buttons.png");
    	menuBackgroundTexture = new Texture("images/background.jpg");
	}
	/**
	 * Разбиение текстур на регионы
	 */
	private void loadTextureRegions() {
		buttonsTR = new TextureRegion[BUTTONS_NUMBER];
		for (int i = 0; i < BUTTONS_NUMBER; i++) {
			buttonsTR[i] = new TextureRegion(menuButtonsTexture, 0, BUTTON_HEIGHT*i, BUTTON_WIDTH, BUTTON_HEIGHT);
		}
	}
	/** Загрузка и фильтрация текстуры */
	private Texture loadTexture(String path) {
		Texture texture = new Texture(Gdx.files.internal(path), true);
		texture.setFilter(Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.Nearest);
		return texture;
	}
}
