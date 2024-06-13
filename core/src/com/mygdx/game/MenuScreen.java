package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class MenuScreen extends ScreenAdapter {

    SpriteBatch batch;
    Stage stage;
    TextButton startGame;
    TextButton.TextButtonStyle startGameS;
    BitmapFont font;
    Table table;
    MenuScreen menuScreen;

    public MenuScreen() {
        menuScreen = this;
        batch = new SpriteBatch();
        table = new Table();
        table.setFillParent(true);
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        font = new BitmapFont();
        startGameS = new TextButton.TextButtonStyle();
        startGameS.font = font;
        startGame = new TextButton("Start", startGameS);
        table.add(startGame);
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
    }
}
