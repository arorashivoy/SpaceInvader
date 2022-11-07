package com.arorashivoy.space_invader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Shooter {
	private int x;
	private final int y;
	Texture img;
	private int frame = 0;

	/**
	 * Create a shooter
	 *
	 * @param x x coordinate of the shooter
	 * @param y y coordinate of the shooter
	 */
	public Shooter(int x, int y) {
		this.x = x;
		this.y = y;

		Pixmap Original = new Pixmap(Gdx.files.internal("Shooter.png"));
		Pixmap resized = new Pixmap(CustomConstants.SHOOTER_SIZE, CustomConstants.SHOOTER_SIZE, Original.getFormat());
		resized.drawPixmap(Original, 0, 0, Original.getWidth(), Original.getHeight(), 0, 0, resized.getWidth(), resized.getHeight());
		img = new Texture(resized);

		// disposing the Pixmap
		Original.dispose();
		resized.dispose();
	}

	public void draw(SpriteBatch batch) {
		handleInput();
		shoot();

		batch.draw(img, x, y);
	}

	public void dispose() {
		img.dispose();
	}

	////////////////////////////////////////////////////// Helper //////////////////////////////////////////////////////
	private void shoot() {
		if (frame == CustomConstants.BULLET_FREQ) {
			frame = 0;
			Bullet.bullets.add(new Bullet(x + (CustomConstants.SHOOTER_SIZE / 2), (int) (y + 4 + (CustomConstants.SHOOTER_SIZE / 1024f) * 322), true));
		}
		frame += 1;
	}

	private void handleInput() {
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			if (x > 0) {
				x -= 5;
			}
		} else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			if (x < Gdx.graphics.getWidth() - img.getWidth()) {
				x += 5;
			}
		}
	}
}
