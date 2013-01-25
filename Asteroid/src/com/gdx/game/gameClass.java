package com.gdx.game;
//Coding By : Erik Arfvison
import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;

import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Shape.Type;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Array;
//import com.badlogic.gdxinvaders.simulation.Shot;

public class gameClass extends Game implements Screen {
	private SpriteBatch batch;
	public int count2=0;
	public boolean wasSpacePressed= false;
	public boolean wasShot= false;
	protected Texture shipImage;


	public int i=0;

	private Music backgroudMusic;
	private Sound laserSound;
	private AlphaShip ship2;
	private weaponClass laz; 


	private thruster jet; 
	public static ArrayList<weaponClass> laser;

	private ArrayList<Mesh> mesh;
	public asteroidBox Asteroids;
	public static ShapeRenderer asteroidBoxes;

	private int numAsteroids =6;

	@Override

	public void create() {		
        this.setScreen(new introSplash(this));

		ship2 = new AlphaShip();//Creates Ship
		jet = new thruster();// Creates thruster particle

		backgroudMusic = Gdx.audio.newMusic(Gdx.files.internal("data/8bit.mp3"));//Gets Music
		laserSound =  Gdx.audio.newSound(Gdx.files.internal("data/laser.wav"));// gets shoot sound
		backgroudMusic.setLooping(true);// loops music
		backgroudMusic.play();// plays the game music

		laser = new ArrayList<weaponClass>();



		batch = new SpriteBatch();// Batch that contains the Sprites

		asteroidBoxes = new ShapeRenderer();//Creates shaperender
		Asteroids = new asteroidBox(numAsteroids);// Creates AsteroidBoxes and set the numAsteroids

	}


	//EveryItem that is created must be disposed otherwise it takes up space in ram
	@Override
	public void dispose() {//Dispose of elements created on the game when game exits
		batch.dispose();
		shipImage.dispose();
		backgroudMusic.dispose();
		laserSound.dispose();
	}

	@Override
	public void render() {	


		Gdx.gl.glClearColor(0, 0, 0.2f, 1);//set blue tone background
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);// Clears the screen


		batch.begin();
		//
		//asteroidBoxes.draw(batch,1f);
		for (int i = 0; i < laser.size(); i++) {
			weaponClass shot = laser.get(i);

			//shot.update(delta);
			//ship.draw(shipImage, ship.x, ship.y);
			if(shot.laserPurple != null);
			shot.laserPurple.draw(batch, 1F);// Gdx.graphics.getDeltaTime());
			//if(jet.thrust != null);

		}
		jet.thrust.draw(batch, 1F);
		ship2.spriteShip.draw(batch);
		batch.end();

		//Keyboard Inputs Handles all the movement of the ship and also the shooting of the ship
		if (Gdx.input.isKeyPressed(Keys.W))	// Move ship whenever W is pressed
		{
			ship2.shipMove();
		}
		else// Stop ship whenever W is not pressed
		{
			ship2.shipStop();

		}

		if (Gdx.input.isKeyPressed(Keys.A))// move ship left whenever a is pressed A
			ship2.shipLeft();
		else if (Gdx.input.isKeyPressed(Keys.D))// move ship right whenever a is pressed D
			ship2.shipRight();
		else
		{
			ship2.shipSLR();//Stop rotational velocity whenever A or D is not pressed
		}
		if (Gdx.input.isKeyPressed(Keys.SPACE))	// Shoots whenever space is released
		{
			wasSpacePressed= true;
		}

		if(wasSpacePressed && wasShot==false)
		{
			laser.add(new weaponClass(ship2.getX()+127, ship2.getY()+64, ship2.getRotation()));//adds lazer to game
			laserSound.play();
			wasShot=true;
		}

		if(Gdx.input.isKeyPressed(Keys.SPACE)!=true && wasShot==true)
		{
			wasSpacePressed=false;
			wasShot=false;
		}


		for (int i = 0; i < laser.size(); i++) {// Updates laser loop 
			weaponClass shot = laser.get(i);

			shot.update(2f);//Updates the lazers
			if(shot.remove())
			{
				laser.remove(i);

			}

		}
		ship2.shipUpdate();// Updates Ship
		jet.update(ship2.getX()+127,ship2.getY()+64,ship2.rotation+180);// Updates Thruster





		asteroidBoxes.begin(ShapeType.Rectangle);// Initiates Shaperender that draws the rectangles on the screen
		asteroidBoxes.identity();
		asteroidBoxes.setColor(Color.RED);//Color of Asteroids

		Asteroids.update(2f);// Updates the Asteroids
		//Asteroids.split(); handles whenver there is a collision between the laser and asteroid. Its causing game to crash so i disabled this feature
		asteroidBoxes.end();




	}








	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}


	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}


}
