package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class Controls {
    private Vector2 playerPosition;
    float velocity = 100.0f;
    public GameScreen gameScreen;


    public Controls(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        playerPosition = new Vector2(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/10);
    }


    public Vector2 getPlayerPosition() {
        return playerPosition;
    }

    public void playerMovement(float delta){
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            if(playerPosition.x > 0){
                playerPosition.x -= velocity * delta;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            if(playerPosition.x <= (Gdx.graphics.getWidth())-100 ){
                playerPosition.x += velocity * delta;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            if(playerPosition.y < (Gdx.graphics.getHeight()) -100){
                playerPosition.y += velocity * delta;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            if(playerPosition.y > 0){
                playerPosition.y -= velocity * delta;
            }
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            Main.INSTANCE.setScreen(new MenuScreen());
        }
        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
            gameScreen.collisionSword();
        }


    }

}

