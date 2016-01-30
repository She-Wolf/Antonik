package com.project.antonik;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class GameScreen implements Screen {
	
    private SpriteBatch batch; 
    static CustomStage stage;  //сцена
    public static ScreenController sc;
    public TextureHelper textures;
    public AnimationHelper animations;
    private OrthographicCamera camera;
    public GameScreen(SpriteBatch batch, ScreenController sc) {
    	GameScreen.sc = sc;
    	this.batch = batch;
    }
   
    /**
     * Показать основной экран
     */
    @Override
	public void show() {
		textures = TextureHelper.getInstance();
		AnimationHelper.initInstance();
		animations = AnimationHelper.getInstance();
		animations.initAnimations();
   		float screenMnozh = ((float)Gdx.graphics.getWidth()/(float)Gdx.graphics.getHeight())/(16f/9f);
   		camera = new OrthographicCamera(1920*screenMnozh, 1080);
   		ExtendViewport viewp = new ExtendViewport(1920, 1080, camera);
   		stage = new CustomStage(viewp); 
   		Gdx.input.setInputProcessor(stage);
	}
    
    /**
     * Рендеринг сцены
     */
    @Override
    public void render(float delta) {
    	Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //Все действия с любыми актерами будут тут
        stage.act(Gdx.graphics.getDeltaTime());
    	stage.draw();
    }
    
    @Override
    public void dispose() {}
    
	@Override
	public void hide() {dispose();}

	@Override
	public void resize(int width, int height) {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}
}