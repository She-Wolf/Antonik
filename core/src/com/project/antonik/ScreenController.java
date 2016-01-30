package com.project.antonik;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScreenController extends Game {
    private SpriteBatch batch; 
    // Экраны игры. Потом их будет больше
    public MenuScreen menuScreen; 
    public GameScreen gameScreen; 

    @Override
    public void create() {
    	TextureHelper.initInstance();
        GameEngine.initInstance();
        batch = new SpriteBatch();
        menuScreen = new MenuScreen(batch, this);
        gameScreen = new GameScreen(batch, this);
        setScreen(menuScreen);
    }  
}