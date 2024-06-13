package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player {

    private Texture player;
    public TextureAtlas playerA;
    private TextureRegion playerR;

    public Player() {
        player = new Texture("Soldier/Soldier.png");
        playerA = new TextureAtlas("Soldier.atlas");
        playerR = playerA.findRegion("Soldier-Idle");
    }
}
