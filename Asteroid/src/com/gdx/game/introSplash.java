package com.gdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class introSplash implements Screen
{
        private SpriteBatch spriteBatch;
        private Texture splsh;
        private Game myGame;
        
        /**
         * Constructor for the splash screen
         * @param g Game which called this splash screen.
         */
        public introSplash(Game g)
        {
                myGame = g;
        }

        public void render(float delta)
        {
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                spriteBatch.begin();
                spriteBatch.draw(splsh, 0, 0);
                spriteBatch.end();
                
                if(Gdx.input.isKeyPressed(Keys.C))
                	 myGame.setScreen(new gameClass());
        }
        
        public void show()
        {
                spriteBatch = new SpriteBatch();
                splsh = new Texture(Gdx.files.internal("data/alienblaster.png"));
                if(Gdx.input.isKeyPressed(Keys.C))
                	 myGame.setScreen(new gameClass());
        }

		@Override
		public void resize(int width, int height) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void hide() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void pause() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void resume() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			
		}
}