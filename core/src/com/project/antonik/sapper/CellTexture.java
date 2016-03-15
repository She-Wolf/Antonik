package com.project.antonik.sapper;


import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.project.antonik.TextureHelper;

public class CellTexture extends Actor {
	public int w;
	public int h;
	
    @Override
    public void draw(Batch batch, float parentAlpha) {
    	TextureHelper textures = TextureHelper.getInstance();
    	GameField field = GameField.getInstance();
    	batch.draw(textures.sapperTR[field.states[w][h]], getX(), getY(), getWidth(), getHeight());
    }
}
