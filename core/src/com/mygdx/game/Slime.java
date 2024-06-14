package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Slime {

    public TextureAtlas slimeA;
    public Sprite slimeSprite;
    public Animation<TextureRegion> walkAnimation;
    private float animationTime = 0.0f;
    final int upscaling = 6;
    private final float velocity = 30.0f;
    private int leben = 5, z= 100;
    private boolean slimeAmLeben = true;
    AssetManager assetManager;
    private Vector2 slimePosition;
    GameScreen gameScreen;

    public Slime(GameScreen gameScreen) {
        assetManager = new AssetManager();
        slimePosition = new Vector2(spawnLocation());
        assetManager.load("slime", TextureAtlas.class);
        slimeA = new TextureAtlas("slime.atlas");
        slimeSprite = new Sprite(slimeHitbox());
        walkAnimation = new Animation<>(0.1f,slimeA.findRegions("slime_run_anim"), Animation.PlayMode.LOOP);
        this.gameScreen = gameScreen;
    }

    public void render(float delta, SpriteBatch batch, Vector2 playerPos){
        if(slimeAmLeben) {
            animationTime += delta;
            TextureRegion currentFrame = walkAnimation.getKeyFrame(animationTime);
            movement(playerPos ,delta);
            batch.draw(currentFrame, slimePosition.x, slimePosition.y, currentFrame.getRegionWidth() * upscaling, currentFrame.getRegionHeight() * upscaling);
            slimeSprite.setPosition(slimePosition.x + 10, slimePosition.y + 20);
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

    public Vector2 spawnLocation(){
        float x = MathUtils.random(100, Gdx.graphics.getWidth()-100);
        float y = MathUtils.random((Gdx.graphics.getHeight()/2)+100, Gdx.graphics.getHeight()-100);
        return new Vector2(x, y);
    }

    public void movement(Vector2 playerPos, float delta){
        if (playerPos.x > slimePosition.x){
            slimePosition.x += delta*velocity;
        } else if (playerPos.x < slimePosition.x) {
            slimePosition.x -= delta*velocity;
        }

        if (playerPos.y > slimePosition.y){
            slimePosition.y += delta*velocity;
        } else if (playerPos.y < slimePosition.y) {
            slimePosition.y -= delta*velocity;
        }

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
            gameScreen.slime = new Slime(gameScreen);
        }
    }
}
