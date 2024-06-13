package com.mygdx.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Vector2;

public class Slime {

    public TextureAtlas slimeA;
    public Sprite slimeSprite;
    public Animation<TextureRegion> walkAnimation;
    private float animationTime = 0.0f;
    final int upscaling = 6;
    int leben = 5, z= 100;
    boolean slimeAmLeben = true;
    AssetManager assetManager;

    public Slime() {
        assetManager = new AssetManager();
        assetManager.load("slime", TextureAtlas.class);
        slimeA = new TextureAtlas("slime.atlas");
        slimeSprite = new Sprite(slimeHitbox());
        walkAnimation = new Animation<>(0.1f,slimeA.findRegions("slime_run_anim"), Animation.PlayMode.LOOP);
    }

    public void render(float delta, SpriteBatch batch){
        if(slimeAmLeben) {
            animationTime += delta;
            TextureRegion currentFrame = walkAnimation.getKeyFrame(animationTime);
            batch.draw(currentFrame, 130, 130, currentFrame.getRegionWidth() * upscaling, currentFrame.getRegionHeight() * upscaling);
            slimeSprite.setPosition(130 + 10, 130 + 20);
            slimeSprite.draw(batch);
        }
    }

    public Texture slimeHitbox() {
        Pixmap pixmap = new Pixmap(80, 60, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.CLEAR);
        pixmap.fill();
        Texture texture = new Texture(pixmap); // must be manually disposed
        pixmap.dispose();

        return texture;
    }

    public void damage(){
        if (z > 4){
            leben--;
            System.out.println("hit");
            z = 0;
        }
        z++;
        if (leben == 0){
            slimeAmLeben = false;
            //slimeSprite = null;
            slimeSprite.getTexture().dispose();
        }
    }
}
