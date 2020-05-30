package com.spaceshooter.view;

import java.awt.image.BufferedImage;

public class ImageHandler {
    private static BufferedImage starImage;
    private static BufferedImage enemySpaceshipImage;
    private static BufferedImage playerSpaceshipImage;
    private static BufferedImage playerLaserbeamImage;
    private static BufferedImage enemyLaserbeamImage;
    private static BufferedImage[] explosionAnimation;
//    private static BufferedImage[] playerSpaceshipAnimation;
    private final static int explosionFrames = 74;
    private final static int explosionSpriteSheetColumns = 10;
    private final static int explosionSubImageWidth = 100;
    private final static int explosionSubImageHeight = 100;

    static{
        BufferedImageLoader bufferedImageLoader = new BufferedImageLoader();

        starImage = bufferedImageLoader.loadImage("/com/spaceshooter/view/images/star-16.png");
        playerSpaceshipImage = bufferedImageLoader.loadImage("/com/spaceshooter/view/images/playerSpaceship.png");
        enemySpaceshipImage = bufferedImageLoader.loadImage("/com/spaceshooter/view/images/ufodark.png");
        playerLaserbeamImage = bufferedImageLoader.loadImage("/com/spaceshooter/view/images/PlayerLaser.png");
        enemyLaserbeamImage = bufferedImageLoader.loadImage("/com/spaceshooter/view/images/enemyEnergyBall.png");

        explosionAnimation = new BufferedImage[explosionFrames];
//        playerSpaceshipAnimation = new BufferedImage[11];

        BufferedImage explosionSpriteSheet = bufferedImageLoader.loadImage("/com/spaceshooter/view/images/verticalexplosion.png");
        initializeExplosionAnimation(explosionSpriteSheet);
//        loadPlayerSpaceshipAnimation();
    }

    private static void initializeExplosionAnimation(BufferedImage explosionSpriteSheet) {
        for (int i = 0; i < explosionAnimation.length ; i++) {
            int row = i / explosionSpriteSheetColumns;
            int column = i % explosionSpriteSheetColumns;

            explosionAnimation[i] = explosionSpriteSheet.getSubimage((column * explosionSubImageWidth),
                    (row * explosionSubImageWidth), explosionSubImageWidth, explosionSubImageHeight);
        }
    }

  /*  private static void loadPlayerSpaceshipAnimation(){
        BufferedImageLoader bufferedImageLoader = new BufferedImageLoader();

        for (int i = 0; i < 11; i++) {
            playerSpaceshipAnimation[i] = bufferedImageLoader.loadImage("/com/spaceshooter/view/images/playerspaceship/fighter/smallfighter" + (i+1) + ".png");
        }
    }*/

    public static BufferedImage getStarImage(){
        return starImage;
    }

    public static BufferedImage getEnemySpaceshipImage(){
        return enemySpaceshipImage;
    }

    public static BufferedImage getPlayerSpaceshipImage(){
        return playerSpaceshipImage;
    }

    public static BufferedImage getEnemyLaserbeamImage(){
        return enemyLaserbeamImage;
    }

    public static BufferedImage[] getExplosionAnimation() {
        return explosionAnimation;
    }

    public static BufferedImage getPlayerLaserbeamImage() {
        return playerLaserbeamImage;
    }

  /*  public static BufferedImage[] getPlayerSpaceshipAnimation(){
        return playerSpaceshipAnimation;
    }*/
}
