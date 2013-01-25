package com.gdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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

public class weaponClass {
	public static float SHOT_VELOCITY = 10;
	//public final Vector3 position = new Vector3();
	public boolean isInvaderShot;
	public boolean hasLeftField = false;
	public ParticleEffect laserPurple;
	int emitterIndex;
	public Array<ParticleEmitter> laserPEmitters;
	int particleCount = 10;
	private float vx=0;
	public Rectangle lazerArea;
	private float vy=0;
	private float xpos=0;
	private float totaldistancex=0;
	private float totaldistancey=0;
	private float ypos=0;
	private float  speed =4F;
	private boolean  destroy =false;
	private float rot=0;
	private static int count=0;
/*public weaponClass()
{

}*/
	public weaponClass (float xcor, float ycor, float rotation) //boolean isInvaderShot) 
	{	
		laserPurple = new ParticleEffect();
		laserPurple.load(Gdx.files.internal("data/lazer2.p"), Gdx.files.internal("data"));
		laserPurple.setPosition(xcor,ycor);
		laserPurple.start();
		this.vy += Math.sin(Math.toRadians(rotation)) * speed;
		this.vx += Math.cos(Math.toRadians(rotation)) * speed;
		this.xpos=xcor+this.vx;
		this.ypos=ycor+this.vy;
		lazerArea = new Rectangle(this.xpos,this.ypos, 32, 32);
		this.rot=rotation;
		//count++;
		
		laserPurple.setPosition(this.xpos,this.ypos);
		//laserPEmitters = new Array<ParticleEmitter>(laserPurple.getEmitters());
	}

	public void update (float delta) 
	{
		this.xpos+=this.vx;
		this.ypos+=this.vy;
		lazerArea.set(this.xpos, this.ypos, 32, 32);
		this.totaldistancex+=Math.abs(this.vx);
		this.totaldistancey+=Math.abs(this.vy);
		
		if(this.xpos>=1024)
		{
			this.xpos=0;
		}
		else if(this.xpos<=0)
		{
			this.xpos=1024;
		}
		if(this.ypos>=768)
		{
			this.ypos=0;
		}
		else if(this.ypos<=0)
		{
			this.ypos=768;
		}
		//laserPEmitters.get(count).getAngle().setLow(rot - 1,rot - 1);
		//laserPEmitters.get(count).getAngle().setHigh(rot - 1, rot - 1);
		//laserPurple.getEmitters().add(laserPEmitters.get(count)); laserPEmitters.get(count).start();
		
		
		if(totaldistancex<1500 && totaldistancey<1500)
		{
		laserPurple.setPosition(this.xpos,this.ypos);
		
		}
		else //if(totaldistancex>200 || totaldistancey>200)
		{
			laserPurple.dispose();
			this.destroy=true;
		}
		//laserPEmitters.get(count).setAligned(true);
		//laserPEmitters.get(count).setAdditive(false);
		//laserPEmitters.get(count).setContinuous(true);
		
		

	//	if (position.z > Simulation.PLAYFIELD_MAX_Z) hasLeftField = true;
	//	if (position.z < Simulation.PLAYFIELD_MIN_Z) hasLeftField = true;
	}
	public boolean remove()
	{
		
		return destroy;
	}
	
}

