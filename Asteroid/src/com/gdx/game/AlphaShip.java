package com.gdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class AlphaShip
{
	public Sprite spriteShip;
	public Sprite[] spriteLazer;
	private float vx=0;
	private float vy=0;
	protected float rotation = 0;
	private float  speed =0.03F;
	private float friction=0.99F;
	private float rotv=0;
	protected float xpos=0;
	protected float ypos=0;
	
	
	public AlphaShip()
	{
		
	 spriteShip = new Sprite(new Texture(Gdx.files.internal("data/alienblaster.png")),128,128);
	 
	}
	public float getX()
	{
		return this.xpos;
	}
	public float getY()
	{
		return this.ypos;
	}
	public float getRotation()
	{
		return this.rotation;
	}
	public void shipMove()
	{
		
		// vx and vy are floats that store the acceleration to be added
		// - speed is a constant (i set to 0.03)
		vy += Math.sin(Math.toRadians(rotation)) * speed;
		vx += Math.cos(Math.toRadians(rotation)) * speed;
	}
	public void shipStop()
	{
		// if ship isn't being accelerated, slow it down by simulating 'drag'
		// in space/atmosphere. try friction = 0.95
		vy *=friction;
		vx *= friction;
	}
	public void shipLeft()
	{
		rotv += speed - 0.005;
	}
	public void shipRight()
	{
		rotv -= speed - 0.005;
		
	}
	public void shipSLR()//Ship not moving left or right
	{
		rotv *= friction;
	}
	public void shipUpdate()
	{
		// then add these deltas to the position vector of the player's ship and apply
		rotation += rotv;
		xpos += vx;
		ypos += vy;
		if(xpos>=1024)
		{
		xpos=0;
		}
		else if(xpos<=0)
		{
		xpos=1024;
		}
		if(ypos>=768)
		{
		ypos=0;
		}
		else if(ypos<=0)
		{
		ypos=768;
		}
		
		spriteShip.setRotation((float)rotation);
		spriteShip.setPosition((float)xpos+64, (float)ypos);
	}
}

