package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.*;

public class Level {
    public TextureAtlas levelAtlasFloor, levelAtlasWall;
    private TextureRegion levelR;
    public Animation<TextureRegion> spikeAnimation;
    private float animationTime = 0.0f;
    final int upscaling = 6;
    private final int[][] levelLayout = {
            {1, 1, 2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 1, 1, 2, 2},
            {1, 3, 3, 3, 1, 3, 3, 3, 1, 3, 3, 3, 1, 3, 3, 3, 1, 3, 3, 3},
            {2, 3, 4, 3, 2, 3, 4, 3, 2, 3, 4, 3, 2, 3, 4, 3, 2, 3, 4, 3},
            {1, 3, 3, 3, 1, 3, 3, 3, 1, 3, 3, 3, 1, 3, 3, 3, 1, 3, 3, 3},
            {1, 1, 2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 1, 1, 2, 2},
            {1, 3, 3, 3, 1, 3, 3, 3, 1, 3, 3, 3, 1, 3, 3, 3, 1, 3, 3, 3},
            {2, 3, 4, 3, 2, 3, 4, 3, 2, 3, 4, 3, 2, 3, 4, 3, 2, 3, 4, 3},
            {1, 3, 3, 3, 1, 3, 3, 3, 1, 3, 3, 3, 1, 3, 3, 3, 1, 3, 3, 3},
            {1, 1, 2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 1, 1, 2, 2},
            {1, 3, 3, 3, 1, 3, 3, 3, 1, 3, 3, 3, 1, 3, 3, 3, 1, 3, 3, 3},
            {2, 3, 4, 3, 2, 3, 4, 3, 2, 3, 4, 3, 2, 3, 4, 3, 2, 3, 4, 3},
            {1, 3, 3, 3, 1, 3, 3, 3, 1, 3, 3, 3, 1, 3, 3, 3, 1, 3, 3, 3},
    };

    public Level() {
        levelAtlasFloor = new TextureAtlas("floor.atlas");
        levelAtlasWall = new TextureAtlas("wall.atlas");
    }


    public void renderLevel(SpriteBatch batch) {
        int tileSize = 16;

        for (int row = 0; row < levelLayout.length; row++) {
            for (int col = 0; col < levelLayout[row].length; col++) {
                int tileType = levelLayout[row][col];
                TextureRegion tile = getTileRegion(tileType);
                if (tile != null) {
                    batch.draw(tile, col * tileSize * upscaling, row * tileSize * upscaling, tileSize * upscaling, tileSize * upscaling);
                }
            }
        }
    }

    private TextureRegion getTileRegion(int tileType) {
        // Return the appropriate tile region based on the tile type
        switch (tileType) {
            case 1:
                return levelAtlasFloor.findRegion("floor",1);
            case 2:
                return levelAtlasFloor.findRegion("floor",2);
            case 3:
                return levelAtlasFloor.findRegion("floor",3);
            case 4:
                return levelAtlasFloor.findRegion("floor",4);
            case 5:
                return levelAtlasFloor.findRegion("floor",5);
            case 6:
                return levelAtlasFloor.findRegion("floor",6);
            case 7:
                return levelAtlasFloor.findRegion("floor",7);
            case 8:
                return levelAtlasFloor.findRegion("floor",8);
            case 9:
                return levelAtlasFloor.findRegion("floor",9);
            case 10:
                return levelAtlasFloor.findRegion("floor",10);
            case 11:
                return levelAtlasFloor.findRegion("floor_side");
            case 12:
                return levelAtlasFloor.findRegion("floor_side2");
            case 13:
                return levelAtlasFloor.findRegion("floor_side3");
            case 14:
                return levelAtlasFloor.findRegion("floor_side4");
            case 15:
                return levelAtlasFloor.findRegion("floor_side5");
            case 16:
                return levelAtlasFloor.findRegion("floor_side_left");
            case 17:
                return levelAtlasFloor.findRegion("floor_side_right");
            case 18:
                return levelAtlasFloor.findRegion("floor_stair");
            case 19:
                return levelAtlasFloor.findRegion("stair_nextlevel");
            case 20:
                //SpikeAnimation maybe
            default:
                // more, I need more, for walls
                return null;
        }
    }
}
