package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

public class Movement {
    private final Vector2 playerPosition;
    float velocity = 100.0f;
    public static Movement movement;


    public Movement() {
        movement = this;
        playerPosition = new Vector2(100.0f, 100.0f);
    }

    public Vector2 getPlayerPosition() {
        return playerPosition;
    }

    public static Movement getMovement() {
        return movement;
    }

    public void playerMovement(float delta){
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            playerPosition.x -= velocity * delta;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            playerPosition.x += velocity * delta;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            playerPosition.y -= velocity * delta;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            playerPosition.y += velocity * delta;
        }

    }

}

