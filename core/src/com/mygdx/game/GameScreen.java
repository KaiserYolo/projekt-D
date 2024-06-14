package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;


public class GameScreen extends ScreenAdapter {

    public ShapeRenderer shapeRenderer;
    public SpriteBatch batch;
    public Controls controls;
    public MenuScreen menuScreen;
    public Player player;
    public Level level;
    public OrthographicCamera camera;
    public Slime slime;

    public GameScreen(MenuScreen menuScreen){
        this.menuScreen = menuScreen;
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.translate(Gdx.graphics.getWidth() / 2,Gdx.graphics.getHeight() / 2);
        camera.update();
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();
        controls = new Controls(this);
        player = new Player();
        slime = new Slime(this);
        level = new Level();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        ScreenUtils.clear(0,0,0,1);
        camera.update();
        controls.playerMovement(delta);
        Vector2 playerPosition = controls.getPlayerPosition();
        float degree = (float)Math.atan2((Gdx.graphics.getHeight() - Gdx.input.getY()) - (playerPosition.y+20), Gdx.input.getX() - (playerPosition.x +120))* MathUtils.radiansToDegrees;
        /*
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rect(playerPosition.x,playerPosition.y,100,100);
        shapeRenderer.rect( playerPosition.x+120,playerPosition.y+20,
                            0,0,
                            20,150,
                            1.0f,1.0f,
                            degree- 90);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.end();
        */
        batch.begin();
        level.renderLevel(batch);
        player.render(delta, batch, playerPosition, degree);
        slime.render(delta, batch, playerPosition);
        batch.end();
        collision();
        System.out.print(Gdx.graphics.getWidth());
        System.out.println(Gdx.graphics.getHeight());
    }

    public void collision(){
        boolean collisionPlayerSlime = player.playerSprite.getBoundingRectangle().overlaps(slime.slimeSprite.getBoundingRectangle());
        if (collisionPlayerSlime){
            player.damage();
        }

    }
    public void collisionSword(){
        boolean collisionSwordSlime = player.swordSprite.getBoundingRectangle().overlaps(slime.slimeSprite.getBoundingRectangle());
        System.out.println(collisionSwordSlime);
        if(collisionSwordSlime){
            slime.damage();
        }
    }

    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = width;
        camera.viewportHeight = height;
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
