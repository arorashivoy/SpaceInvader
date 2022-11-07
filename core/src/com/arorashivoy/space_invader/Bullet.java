package com.arorashivoy.space_invader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.LinkedList;

public class Bullet {
	private final int x;
	private int y;
	private final Boolean direction;
	Texture whitePixel;
	private int frame = 0;
	public static LinkedList<Bullet> bullets = new LinkedList<>();

	/**
	 * Create a bullet which is fired
	 *
	 * @param x         x coordinate of the bullet
	 * @param y         y coordinate of the bullet
	 * @param direction true, if upwards else false
	 */
	public Bullet(int x, int y, Boolean direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;

		whitePixel = new Texture("whitePixel.png");
	}


	public void draw(SpriteBatch batch) {
		if (frame == CustomConstants.BULLET_SPEED) {
			y += direction ? 5 : -5;
			frame = 0;
		}
		batch.draw(whitePixel, x, y, CustomConstants.BULLET_WIDTH, CustomConstants.BULLET_HEIGHT);
		frame += 1;
	}

	public void dispose() {
		whitePixel.dispose();
	}

	////////////////////////////////////////////////////// Helper //////////////////////////////////////////////////////
	public Boolean outOfBounds() {
		return y > Gdx.graphics.getHeight() || y < 0;
	}
}
