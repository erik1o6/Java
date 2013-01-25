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

public class thruster {
	public static float SHOT_VELOCITY = 10;
	//public final Vector3 position = new Vector3();
	public boolean isInvaderShot;
	public boolean hasLeftField = false;
	public ParticleEffect thrust;
	int emitterIndex;
	public Array<ParticleEmitter> laserPEmitters;
	int particleCount = 10;
	private float vx=0;
	private float vy=0;
	private float xpos=0;
	private float ypos=0;
	//private float  speed =4F;
	private float rot=0;
	private static int count=1;
	public int i =0;
/*public weaponClass()
{

}*/
	public thruster()
	{
		
		thrust = new ParticleEffect();
		thrust.load(Gdx.files.internal("data/thruster.p"), Gdx.files.internal("data"));
		laserPEmitters = new Array(thrust.getEmitters());
		
		thrust.start();
	 
	}
	public thruster (float xcor, float ycor)//, float rotation) //boolean isInvaderShot) 
	{	
		//thrust = new ParticleEffect();
		//thrust.load(Gdx.files.internal("data/thruster.p"), Gdx.files.internal("data"));
		//thrust.setPosition(xcor,ycor);
		
		//this.vy += Math.sin(Math.toRadians(rotation)) * speed;
		//this.vx += Math.cos(Math.toRadians(rotation)) * speed;
		this.xpos=xcor;
		this.ypos=ycor;

		//test = thrust.getEmitters();
		//thrust.start();
		//this.rot=rotation;
		//count++;
		
		//thrust.setPosition(xpos,ypos);
		//laserPEmitters = new Array<ParticleEmitter>(thrust.getEmitters());
	}

	public void update (float xcor, float ycor, float rotation) 
	{
		this.xpos=xcor;
		this.ypos=ycor;
		thrust.setPosition(xpos,ypos);
		laserPEmitters= thrust.getEmitters();
		laserPEmitters.get(i).getAngle().setLow(rotation - 4,rotation + 4);
		laserPEmitters.get(i).getAngle().setHigh(rotation - 4, rotation + 4);
				thrust.getEmitters().add(laserPEmitters.get(i)); laserPEmitters.get(i).start();
		//this.rot=rotation;
		//thrust.
		//laserPEmitters.get(count).getAngle().setLow(rot - 1,rot - 1);
		//laserPEmitters.get(count).getAngle().setHigh(rot - 1, rot - 1);
		//thrust.getEmitters().add(laserPEmitters.get(count)); laserPEmitters.get(count).start();
		//laserPEmitters.get(count).getAngle().setHigh(rot - 1, rot - 1);
		//thrust.getEmitters().add(laserPEmitters.get(count));
		//laserPEmitters.get(count).start();
		
		//laserPEmitters.get(count).setAligned(true);
		//laserPEmitters.get(count).setAdditive(false);
		//laserPEmitters.get(count).setContinuous(true);
		
		

	//	if (position.z > Simulation.PLAYFIELD_MAX_Z) hasLeftField = true;
	//	if (position.z < Simulation.PLAYFIELD_MIN_Z) hasLeftField = true;
	}
}
