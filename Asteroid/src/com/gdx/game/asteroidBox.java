package com.gdx.game;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
//import com.badlogic.gdxinvaders.simulation.Simulation;

/*package com.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class weaponClass extends AlphaShip 
{
	private float ycor = 0F;
	private float xcor = 0F;
	private float speedLazer = 0.10F;
	private float angle= 0F;
	private float xv=0F;
	private float yv=0F;
public weaponClass()
{
	spriteLazer[] = new Sprite[100];
}
public void fire()
{
   xcor=this.xpos;
   ycor=this.ypos;
   angle=this.rotation;
   yv += Math.sin(Math.toRadians(angle)) * speedLazer;
   xv += Math.cos(Math.toRadians(angle)) * speedLazer;
   xcor+=xcor+xv*2;
   ycor+=ycor+yv*2;  
}
}
*/

public class asteroidBox {
	private ArrayList<Rectangle> Rect;
	private ArrayList<Integer> Xpos;
	private ArrayList<Integer> Ypos;
	private ArrayList<Float> Vy;
	private ArrayList<Float> Vx;
	private ArrayList<Float> Rot;
	private ArrayList<Float> Rotv;
	private ArrayList<Float> Speed;
	private ArrayList<Integer> Width;
	private ArrayList<Integer> Heigth;
	private int numAsteroids =6;
	
	

	private int ASTEROIDMAXHEIGHT =100;
	private int ASTEROIDMINHEIGHT =20;
	private int ASTEROIDMINWIDTH =100;
	private int ASTEROIDMAXWIDTH =20;
	private int MAXHEIGHT =768;
	private int MAXWIDTH =1024;
	private float MAXROT =360f;
	private float MAXROTV =.10f;
	private float  MAXSPEED =2F;
	private boolean  Done =false;
	boolean ifshot = false;
	private int dyn = 0;
	
	public asteroidBox (int numAsteroids) //boolean isInvaderShot) 
	{	
		
		Random car =new Random();
		Rect = new ArrayList<Rectangle>();
		Heigth = new ArrayList<Integer>();
		Width = new ArrayList<Integer>();
		Xpos = new ArrayList<Integer>();
		Ypos = new ArrayList<Integer>();
		Rot = new ArrayList<Float>();
		Rotv = new ArrayList<Float>();
		Speed = new ArrayList<Float>();
		Vx = new ArrayList<Float>();
		Vy = new ArrayList<Float>();

		
		for (int i1 = 0; i1 <numAsteroids && Done==false ; i1++) 
		{

			
			int test = car.nextInt(ASTEROIDMAXHEIGHT)+20;
			int test1 = car.nextInt(ASTEROIDMAXWIDTH)+20;
			int test2 =car.nextInt(MAXHEIGHT);
			int test3 =car.nextInt(MAXWIDTH);
			Float test4 =car.nextFloat()*MAXROT;
			Float test5 =car.nextFloat()*MAXROTV;
			Float test6 =car.nextFloat()*MAXSPEED;
			Speed.add(test6);
			Rotv.add(test5);
			
			Float test7 =(float) (Math.cos(Math.toRadians(Rotv.get(i1)))* Speed.get(i1));
			Float test8 =(float) (Math.sin(Math.toRadians(Rotv.get(i1)))* Speed.get(i1));
			Width.add(test);
			Heigth.add(test1);
			Xpos.add(test2);
			Ypos.add(test3);
			Rot.add(test4);
			//Rotv.add(test5);
			
			
			Vx.add( test7);
			Vy.add( test8);
			
			Rect.add(new Rectangle(Xpos.get(i1), Ypos.get(i1), Width.get(i1), Heigth.get(i1))); 
			

			
		}
		
		
		Done= true;
	}
	
	

	public void update (float delta) 
	{
		for (int i = 0; i < Rect.size(); i++) 
		{
		Xpos.set(i, (int) (Xpos.get(i)+Vx.get(i)));
		Ypos.set(i, (int) (Ypos.get(i)+Vx.get(i)));
		 Rot.set(i,Rot.get(i)+Rotv.get(i));
		gameClass.asteroidBoxes.rect(Xpos.get(i), Ypos.get(i), Width.get(i), Heigth.get(i));// Color.GREEN, Color.GREEN,Color.GREEN,Color.GREEN);
		gameClass.asteroidBoxes.rotate(0, 0, 1 , Rot.get(i));

	
	if(Xpos.get(i)>=1024)
	{
		Xpos.set(i, 0);
	}
	else if(Xpos.get(i)<=0)
	{
		Xpos.set(i, 1024);
	}
	if(Ypos.get(i)>=768)
	{
		Ypos.set(i,0);
	}
	else if(Ypos.get(i)<=0)
	{
		Ypos.set(i,768);
	}
		}
	}
	

	
	
	public void split()
	{
		
		boolean breaks =true;
		for (int i = 0; i < Rect.size(); i++) 
		{		
			breaks=true;
			for (int b = 0; b < gameClass.laser.size() && breaks == true; b++)
			{
				if(Rect.get(i).overlaps(gameClass.laser.get(b).lazerArea))
				{/*
					Rect.add(new Rectangle(Xpos.get(i)+Width.get(i)/2, Ypos.get(i), Width.get(i)/2, Heigth.get(i)/2));
					Xpos.add(Xpos.get(i)+Width.get(i)/2 );
					Ypos.add(Ypos.get(i));
					Width.add(Width.get(i)/2);
					Heigth.add(Heigth.get(i)/2);
					Rot.add(Rot.get(i));
					Rotv.add(Rotv.get(i));
					Vx.add(Vx.get(i));
						Rect.add(new Rectangle(Xpos.get(i), Ypos.get(i), Width.get(i)/2, Heigth.get(i)/2));
					Xpos.add(Xpos.get(i));
					Ypos.add(Ypos.get(i));
					Width.add(Width.get(i)/2);
					Heigth.add(Heigth.get(i)/2);
					Rot.add(Rot.get(i));	
					Rotv.add(Rotv.get(i));
					Vx.add(Vx.get(i));	
					//	asteroidBoxes.rect(Xpos.get(i)+Width.get(i)/2, Ypos.get(i), Width.get(i)/2, Heigth.get(i)/2);
						
					//	asteroidBoxes.rect(Xpos.get(i) , Ypos.get(i), Width.get(i)/2,  Heigth.get(i)/2);
						dyn++;
						dyn++;
					
					
					*/
					
				Rect.remove(i);
				Vx.remove(i);
				Xpos.remove(i);
				Ypos.remove(i);
				Width.remove(i);
				Heigth.remove(i);
				Rot.remove(i);
				Rotv.remove(i);
				breaks =false;
				ifshot = true;
				dyn--;
				
				}
			}
	}
	}
}
	


