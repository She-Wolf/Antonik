package com.project.antonik;

import com.badlogic.gdx.graphics.g2d.Animation;

/** Хэлпер для работы с анимацией */
public class AnimationHelper {
	private static AnimationHelper animHelper;
	private static TextureHelper textures;
	public static void initInstance() { 
		animHelper = new AnimationHelper();
		textures = TextureHelper.getInstance();
	}
	public static AnimationHelper getInstance() { return animHelper;}
	
	public void initAnimations() {
		
	};
}
