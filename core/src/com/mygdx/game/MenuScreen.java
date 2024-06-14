package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class MenuScreen extends ScreenAdapter {

    SpriteBatch batch;
    Stage stage;
    TextButton startGame, endGame;
    TextButton.TextButtonStyle startGameS;
    BitmapFont font;
    Table table;
    TextureAtlas menuA;
    TextureRegion menuR;
    MenuScreen menuScreen;

    public MenuScreen() {
        menuScreen = this;
        batch = new SpriteBatch();
        table = new Table();
        table.setFillParent(true);
        stage = new Stage();
        menuA = new TextureAtlas("menu.atlas");
        menuR = new TextureRegion();
        Gdx.input.setInputProcessor(stage);
        font = new BitmapFont();
        startGameS = new TextButton.TextButtonStyle();
        startGameS.font = font;
        startGame = new TextButton("Start", startGameS);
        endGame = new TextButton("Exit", startGameS);
        startGame.setSize(600,200);
        table.add(startGame).pad(10);
        table.row();
        table.add(endGame);//.setActorBounds(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight(),600,200);
        stage.addActor(table);
        startGameAction();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        batch.begin();
        batch.end();
        stage.draw();
    }

    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();
        font.dispose();
    }

    @Override
    public void hide() {
        this.dispose();
    }

    public void startGameAction() {
        startGame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Button pressed");
                Main.INSTANCE.setScreen(new GameScreen(menuScreen));
            }
        });

        endGame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Button pressed");
                Gdx.app.exit();
            }
        });
    }
}
