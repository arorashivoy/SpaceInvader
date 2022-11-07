package com.arorashivoy.space_invader;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Iterator;

public class SpaceInvader extends ApplicationAdapter {

	SpriteBatch batch;
	private Shooter shooter;
	ArrayList<Block> blocks;

	@Override
	public void create() {
		batch = new SpriteBatch();

		shooter = new Shooter((Gdx.graphics.getWidth() / 2) - 50, 10);
		blocks = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
//			blocks.add(new Block((int) (i * CustomConstants.BLOCK_SIZE * 1.5) + 50, 100));
			blocks.add(new Block(i * Gdx.graphics.getWidth() / 4 + 30, 100));
		}
	}

	@Override
	public void render() {
		// Clearing the screen
		ScreenUtils.clear(0, 0, 0, 1);

		batch.begin();

		// Drawing the shooter
		shooter.draw(batch);

		// Drawing the bullets
		Iterator<Bullet> bulletIterator = Bullet.bullets.iterator();
		while (bulletIterator.hasNext()) {
			Bullet bullet = bulletIterator.next();
			if (bullet.outOfBounds()) {
				bullet.dispose();
				bulletIterator.remove();
			} else {
				bullet.draw(batch);
			}
		}

		// Drawing the blocks
		for (Block block : blocks) {
			block.draw(batch);
		}

		batch.end();
	}


	@Override
	public void dispose() {
		batch.dispose();
		shooter.dispose();
	}

	////////////////////////////////////////////////////// Helper //////////////////////////////////////////////////////

}
