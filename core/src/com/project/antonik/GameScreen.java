package com.project.antonik;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class GameScreen implements Screen {
	
    private SpriteBatch batch; 
    static Stage stage;  //сцена
    public static ScreenController sc;
    public TextureHelper textures;
    public AnimationHelper animations;
    private OrthographicCamera camera;
    CustomActor items[];
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
   		camera = new OrthographicCamera(540*screenMnozh, 960);
   		ExtendViewport viewp = new ExtendViewport(540, 960, camera);
   		stage = new Stage(viewp); 
   		Gdx.input.setInputProcessor(stage);
   		loadLevel();
	}
    
    /** Загрузка уровня из json*/
    public void loadLevel() {
    	FileHandle handle = Gdx.files.internal("level/1.lvl");  //для теста 1 уровень                
    	Json json = new Json();
    	Level level = json.fromJson(Level.class, handle.readString());
    	textures.floor[level.back].setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
    	TextureRegion imgTextureRegion = new TextureRegion(textures.floor[level.back]);
    	imgTextureRegion.setRegion(0,0,textures.floor[level.back].getWidth()*12, textures.floor[level.back].getHeight()*20);
    	CustomActor floor = new CustomActor (imgTextureRegion);
    	floor.setSize(floor.tr.getRegionWidth(), floor.tr.getRegionHeight());
    	floor.setPosition(0, 0);
    	stage.addActor(floor);
    	for (int i=0; i < level.items.size(); i++) {
    		initItem(level.items.get(i));	
    	}
    }
    
    public void initItem(Item item){
    	CustomActor actor = null;
    	if (item.type.equals("table")) actor = new CustomActor(textures.table);
    	if (item.type.equals("student")) actor = new Student(textures.student);
    	actor.setSize(actor.texture.getWidth(), actor.texture.getHeight());
    	actor.setPosition(item.x, item.y);
    	stage.addActor(actor);	
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