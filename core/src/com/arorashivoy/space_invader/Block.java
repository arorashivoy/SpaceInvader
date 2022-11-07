package com.arorashivoy.space_invader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Block {
	private final int x;
	private final int y;
	Texture img;

	public Block(int x, int y) {
		this.x = x;
		this.y = y;

		Pixmap Original = new Pixmap(Gdx.files.internal("Block.png"));
		Pixmap resized = new Pixmap(CustomConstants.BLOCK_SIZE, CustomConstants.BLOCK_SIZE, Original.getFormat());
		resized.drawPixmap(Original, 0, 0, Original.getWidth(), Original.getHeight(), 0, 0, resized.getWidth(), resized.getHeight());
		img = new Texture(resized);

		// disposing the Pixmap
		Original.dispose();
		resized.dispose();

	}

	public void draw(SpriteBatch batch) {
		batch.draw(img, x, y);
	}

	public void dispose() {
		img.dispose();
	}

	////////////////////////////////////////////////////// Helper //////////////////////////////////////////////////////
	public void gotHit() {

	}
}
