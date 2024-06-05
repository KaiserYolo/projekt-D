package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import static com.mygdx.game.Movement.*;


public class GameScreen extends ScreenAdapter {

    ShapeRenderer shapeRenderer;
    SpriteBatch batch;
    Movement movement;
    GameScreen gameScreen;

    public GameScreen(){
        gameScreen = new GameScreen();
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();
        //Movement.Movement(gameScreen);
        //this.movement = Movement.getMovement();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,1);
        movement.playerMovement(delta);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rect(movement.getPlayerPosition().x,movement.getPlayerPosition().y,100,100);
        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void hide() {
        super.hide();
    }


}
