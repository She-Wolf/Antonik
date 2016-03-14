package com.project.antonik;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class MenuScreen implements Screen {
	private SpriteBatch Sb;
	private Stage stage;
	private OrthographicCamera camera;
	ScreenController sc;
	TextureHelper textures;
	
	//На каждую кнопку - свой листенер
	class SingleGameListener extends ClickListener {
		@Override
	    public void clicked(InputEvent event, float x, float y) {
			sc.setScreen(sc.gameScreen);
	    }
	 }
	class MultiGameListener extends ClickListener {
		@Override
		public void clicked(InputEvent event, float x, float y) {
			
	    }
	}
	class ShopListener extends ClickListener {
		@Override
		public void clicked(InputEvent event, float x, float y) {
			
		}
	}
	class SettingsListener extends ClickListener {
		@Override
	    public void clicked(InputEvent event, float x, float y) {
			
	    }
	}
	class HelpListener extends ClickListener {
		@Override
	    public void clicked(InputEvent event, float x, float y) {
			
	    }
	}
	
    public MenuScreen(SpriteBatch batch, ScreenController sc) {
    	this.sc = sc;
    	textures = TextureHelper.getInstance();
    	camera = new OrthographicCamera();
    	camera.setToOrtho(false, 1080, 1920);
    	//Две магические строчки, для адекватного растягивания под любой экран, насколько это вообще возможно
    	float screenMnozh = ((float)Gdx.graphics.getWidth()/(float)Gdx.graphics.getHeight())/(16f/9f);
    	ExtendViewport viewp = new ExtendViewport(1080*screenMnozh, 1920, camera);
    	Sb = new SpriteBatch();
    	stage = new Stage(viewp, Sb);
    	BackgroundInit();
    	for(int i=0; i<5; i++) {
    		ButtonInit((int)(camera.viewportWidth/2-textures.BUTTON_WIDTH/2), 1550-250*i , textures.buttonsTR[i], i);
    	}
    }

    @Override
    public void dispose() {}

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}
    public void BackgroundInit() {
    	CustomActor mButton = new CustomActor(textures.menuBackgroundTexture);
    	mButton.setSize(camera.viewportWidth, camera.viewportHeight);
    	mButton.setPosition(0, 0);
        stage.addActor(mButton);	
    }
    /**
     * @param x координата x
     * @param y координата y
     * @param tr регион текстуры
     * @param number номер кнопки
     */
    public void ButtonInit(int x, int y, TextureRegion tr, int number) {
    	CustomActor mButton = new CustomActor(tr);
    	mButton.setSize((int)(textures.menuButtonsTexture.getWidth()), (int)(textures.menuButtonsTexture.getHeight()/4));
    	mButton.setPosition(x, y);
    	switch(number) {
    		case 0:mButton.addListener(new SingleGameListener());break;
    		case 1:mButton.addListener(new MultiGameListener());break;
    		case 2:mButton.addListener(new ShopListener());break;
    		case 3:mButton.addListener(new SettingsListener());break;
    		case 4:mButton.addListener(new HelpListener());break;
    	}
        stage.addActor(mButton);
    }

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	stage.draw();
    	stage.act(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void hide() {
		stage.dispose();
	}
}
