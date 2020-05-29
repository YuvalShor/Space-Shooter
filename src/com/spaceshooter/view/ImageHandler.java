package com.spaceshooter.view;

import java.awt.image.BufferedImage;

public class ImageHandler {
    private static BufferedImage starImage;
    private static BufferedImage enemySpaceshipImage;
    private static BufferedImage playerSpaceshipImage;
    private static BufferedImage laserbeamImage;
    private static BufferedImage[] explosionAnimation;
    private final static int explosionFrames = 74;
    private final static int explosionSpriteSheetColumns = 10;
    private final static int explosionSubImageWidth = 100;
    private final static int explosionSubImageHeight = 100;

    static{
        BufferedImageLoader bufferedImageLoader = new BufferedImageLoader();

        starImage = bufferedImageLoader.loadImage("/com/spaceshooter/view/images/star-16.png");
        playerSpaceshipImage = bufferedImageLoader.loadImage("/com/spaceshooter/view/images/playerSpaceship.png");
        enemySpaceshipImage = null;
        laserbeamImage = bufferedImageLoader.loadImage("/com/spaceshooter/view/images/PlayerLaser.png");

        explosionAnimation = new BufferedImage[explosionFrames];

        BufferedImage explosionSpriteSheet = bufferedImageLoader.loadImage("/com/spaceshooter/view/images/verticalexplosion.png");
        initializeExplosionAnimation(explosionSpriteSheet);
    }

    private static void initializeExplosionAnimation(BufferedImage explosionSpriteSheet) {
        for (int i = 0; i < explosionAnimation.length ; i++) {
            int row = i / explosionSpriteSheetColumns;
            int column = i % explosionSpriteSheetColumns;

            explosionAnimation[i] = explosionSpriteSheet.getSubimage((column * explosionSubImageWidth),
                    (row * explosionSubImageWidth), explosionSubImageWidth, explosionSubImageHeight);
        }
    }

    public static BufferedImage getStarImage(){
        return starImage;
    }

    public static BufferedImage getEnemySpaceshipImage(){
        return enemySpaceshipImage;
    }

    public static BufferedImage getPlayerSpaceshipImage(){
        return playerSpaceshipImage;
    }

    public static BufferedImage getLaserbeamImage(){
        return laserbeamImage;
    }

    public static BufferedImage[] getExplosionAnimation() {
        return explosionAnimation;
    }
}
