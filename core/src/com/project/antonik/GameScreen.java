package com.project.antonik;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.project.antonik.MenuScreen.SingleGameListener;
import com.project.antonik.sapper.CellTexture;
import com.project.antonik.sapper.GameField;

public class GameScreen implements Screen {
	
	class SapperListener extends ClickListener {
		@Override
	    public void clicked(InputEvent event, float x, float y) {
			  if (x<480&&y<320&&field.press==false){
				  int w=(int)(x/40);
					int h=(int)(y/40);
					if(field.mines == null) field.fillMines(w, h);
					int state=field.mines[w][h]+2;
					if (state == 2) {
						openCell(w,h);
					} else if (state == 11){
						for (int i=0; i < field.WIDTH; i++ ) {
							for (int j=0; j < field.HEIGHT; j++ ) {
								if (field.mines[i][j] == 9) field.states[i][j] = field.mines[i][j]+2;
							}
						}
						field.states[w][h] = 13;
						field.press=true;
					} else field.states[w][h] = state;
			  }
			
			}
	}
	
	class ButtonMGameListener extends ClickListener {
		@Override
	    public void clicked(InputEvent event, float x, float y) {
			if (field.press==true){
				fillField();
				field.mines=null;
				field.fillStates();
				field.press=false;
			}
			
	    }
	 }
	
    private SpriteBatch batch; 
    static Stage stage;  //сцена
    public static ScreenController sc;
    public TextureHelper textures;
    public AnimationHelper animations;
    private OrthographicCamera camera;
    GameField field;
    CustomActor items[];
    Sprite floor;
    
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
		field = GameField.getInstance();
		field.fillStates();
		AnimationHelper.initInstance();
		animations = AnimationHelper.getInstance();
		animations.initAnimations();
   		float screenMnozh = ((float)Gdx.graphics.getWidth()/(float)Gdx.graphics.getHeight())/(9f/16f);
   		camera = new OrthographicCamera(540, 960);
   		ExtendViewport viewp = new ExtendViewport(540, 960/screenMnozh, camera);
   		stage = new Stage(viewp); 
   		Gdx.input.setInputProcessor(stage);
   		buttonStartGame();
   		loadLevel();
   		stage.addListener(new SapperListener());
   		
	}
    
    public void buttonStartGame (){
    	CustomActor sButton = new CustomActor(textures.btStart);
    	sButton.setSize((int)(textures.btStart.getWidth()) , (int)(textures.btStart.getHeight()));
    	sButton.setPosition(480, 0);
    	sButton.addListener(new ButtonMGameListener());
    	stage.addActor(sButton);
    	
    }
    
    /** Загрузка уровня из json*/
    public void loadLevel() {
    	FileHandle handle = Gdx.files.internal("level/1.lvl");  //для теста 1 уровень                
    	Json json = new Json();
    	Level level = json.fromJson(Level.class, handle.readString());
    	textures.floor[level.back].setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
    	TextureRegion imgTextureRegion = new TextureRegion(textures.floor[level.back]);
    	imgTextureRegion.setRegion(0,0,textures.floor[level.back].getWidth()*12, textures.floor[level.back].getHeight()*20);
    	floor = new Sprite (imgTextureRegion);
    	floor.setSize(imgTextureRegion.getRegionWidth(), imgTextureRegion.getRegionHeight());
    	floor.setPosition(0, 0);
    	
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
    
    /** Отрисовать поле */
	public void fillField (){
		for (int i=0; i<field.WIDTH; i++){
			for (int j=0; j<field.HEIGHT; j++){
				createCell(textures.sapperTR[0],40*i, 40*j, i, j);
			}
		}
	}
	
	/** Открыть ячейку на игровом поле */
	public void openCell(int w, int h) {
		int state=field.mines[w][h]+2;
		int oldState = field.states[w][h];
		field.states[w][h] = state;
		if (state==2 && oldState==0) {
			if (w-1!=-1 && h-1!=-1) openCell(w-1,h-1);
			if (h-1!=-1) openCell(w,h-1);
			if (w+1!=field.WIDTH && h-1!=-1) openCell(w+1,h-1);
			if (w-1!=-1) openCell(w-1,h);
			if (w+1!=field.WIDTH) openCell(w+1,h);
			if (w-1!=-1 && h+1!=field.HEIGHT) openCell(w-1,h+1);
			if (h+1!=field.HEIGHT) openCell(w,h+1);
			if (w+1!=field.WIDTH && h+1!=field.HEIGHT) openCell(w+1,h+1);
		}
	}
	
	public void createCell(TextureRegion tr, int x, int y, int w, int h){
		CellTexture cell = new CellTexture();
		cell.setSize(40,40);
		cell.setPosition(x, y);
	    stage.addActor(cell);
	    cell.w = w;
	    cell.h = h;
    }
    
    /**
     * Рендеринг сцены
     */
    @Override
    public void render(float delta) {
    	Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        floor.draw(batch);
        batch.end();
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