package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {

    public TextureAtlas playerA;
    public TextureRegion playerR, sword;
    public Animation<TextureRegion> walkAnimation;
    private float animationTime = 0.0f;
    final int upscaling = 6;
    int leben = 3, z = 200;
    public Sprite playerSprite, swordSprite;

    public Player() {
        playerA = new TextureAtlas("knight.atlas");
        playerR = playerA.findRegion("knight_idle_anim");
        playerSprite = new Sprite(playerHitbox());
        swordSprite = new Sprite(swordHitbox());
        sword = playerA.findRegion("weapon_sword");
        walkAnimation = new Animation<>(0.1f,playerA.findRegions("knight_run_anim"), Animation.PlayMode.LOOP);
    }
    public void render(float delta, SpriteBatch batch, Vector2 playerPos, float degree){
        animationTime += delta;
        TextureRegion currentFrame = walkAnimation.getKeyFrame(animationTime);
        batch.draw(currentFrame, playerPos.x, playerPos.y, currentFrame.getRegionWidth()*upscaling, currentFrame.getRegionHeight()*upscaling);
        batch.draw(sword,playerPos.x+120, playerPos.y+20,0,0,sword.getRegionWidth(),sword.getRegionHeight(),upscaling,upscaling,degree-45);
        playerSprite.setPosition(playerPos.x,playerPos.y);
        playerSprite.draw(batch);
        swordSprite.setPosition(playerPos.x+110,playerPos.y+20);
        swordSprite.setRotation(degree -90);
        swordSprite.setOrigin(10, 0);
        swordSprite.draw(batch);

    }


    public Texture playerHitbox() {
        Pixmap pixmap = new Pixmap(80, 80, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.CLEAR);
        pixmap.fill();
        Texture texture = new Texture(pixmap); // must be manually disposed
        pixmap.dispose();

        return texture;
    }
    public Texture swordHitbox() {
        Pixmap pixmap = new Pixmap(30, 120, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.CLEAR);
        pixmap.fill();
        Texture texture = new Texture(pixmap); // must be manually disposed
        pixmap.dispose();

        return texture;
    }
    public void damage(){
        if (z > 120){
            leben--;
            System.out.println("hit");
            z = 0;
        }
        z++;
        if (leben == 0){
            //Gdx.app.exit();
        }
    }
}
