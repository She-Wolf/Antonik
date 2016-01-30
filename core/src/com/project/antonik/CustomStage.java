package com.project.antonik;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class CustomStage extends Stage {
	public boolean wIsDown, aIsDown, sIsDown, dIsDown;
    public CustomStage(ExtendViewport screenViewport) {
        super(screenViewport);
    }

    @Override
    public boolean keyDown(int keyCode) {
    	if(Gdx.app.getType() == ApplicationType.Desktop) {
    		if(keyCode == Keys.W) wIsDown = true;
    		if(keyCode == Keys.S) sIsDown = true;
    		if(keyCode == Keys.A) aIsDown = true;
    		if(keyCode == Keys.D) dIsDown = true;
    	}
    	return super.keyDown(keyCode);
    }
    @Override
    public boolean keyUp(int keyCode) {
    	if(Gdx.app.getType() == ApplicationType.Desktop) {
    		if(keyCode == Keys.W) wIsDown = false;
    		if(keyCode == Keys.S) sIsDown = false;
    		if(keyCode == Keys.A) aIsDown = false;
    		if(keyCode == Keys.D) dIsDown = false;
    	}
    	return super.keyUp(keyCode);
    }
}  