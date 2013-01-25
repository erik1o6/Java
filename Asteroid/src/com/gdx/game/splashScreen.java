package com.gdx.game;
//Coding By : Michael Mikulski
import java.awt.BorderLayout;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gdx.game.spriteTween;

public class splashScreen implements Screen 
{
	private Texture splashTexture;					//Splash screen image
	private Sprite	splashSprite;					//Image manipulation
	private SpriteBatch batch;						//Container to bundle Sprites to speed up performance
	private gameClass game;							//gameClass object
	private TweenManager manager;					//Updates all tweens at once
	private TweenCallback callBack;		
	
	//SplashScreen constructor
	public splashScreen(gameClass game)
	{
		this.game = game;
	}
	
	@Override
	public void render(float delta) 
	{
		Gdx.gl.glClearColor(0,0,0,1);					//Set color to black
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);		//Clear the color
		manager.update(delta);
		//Begin drawing
		batch.begin();
		
		splashSprite.draw(batch);
		
		//End drawing
		batch.end();
	}

	@Override
	public void show() 
	{	
		//initialize variables
		manager = new TweenManager();
        callBack = new TweenCallback() 
        {                        
            @Override
            public void onEvent(int type, BaseTween<?> source) 
            {
                    tweenCompleted();
            }
        };
        
		batch = new SpriteBatch();
		splashTexture = new Texture("data/SplashScreen.png");						//Declare the variable to the image file
		splashTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);		//Takes care of how the image will be resized
		
		//Center the splash screen 
		splashSprite = new Sprite(splashTexture);
		splashSprite.setColor(1,1,1,0);
		splashSprite.setX(Gdx.graphics.getWidth() /2 - (splashSprite.getHeight()/2));
		splashSprite.setY(Gdx.graphics.getHeight() /2- (splashSprite.getWidth() /2));
		
		
		
		//Register the Tween
		Tween.registerAccessor(Sprite.class, new spriteTween());

		//interpolates from the current values to the targets
		Tween.to(splashSprite, spriteTween.ALPHA, 2f).target(1)
				.ease(TweenEquations.easeInQuad).repeatYoyo(1, 2.9f).setCallback(callBack)
				.setCallbackTriggers(TweenCallback.COMPLETE).start(manager);
	}
	
    private void tweenCompleted()
    {	
    }
	@Override
	public void dispose() 
	{
		
	}

	@Override
	public void hide() 
	{
	
		
	}

	@Override
	public void pause() 
	{

		
	}
	@Override
	public void resize(int width, int height) 
	{
		
	}

	@Override
	public void resume() 
	{

		
	}
}
