package com.spaceshooter.view;

import java.awt.image.BufferedImage;

public class ImageHandler {
    private static BufferedImage enemySpaceshipImage;
    private static BufferedImage playerSpaceshipImage;
    private static BufferedImage playerLaserbeamImage;
    private static BufferedImage enemyLaserbeamImage;
    private static BufferedImage bossImage;
    private static BufferedImage[] smallExplosionAnimation;
    private static BufferedImage[] bigExplosionAnimation;
//    private static BufferedImage[] playerSpaceshipAnimation;
    private final static int smallExplosionFrames = 80;
    private final static int smallExplosionSpriteSheetColumns = 10;
    private final static int smallExplosionSubImageWidth = 100;
    private final static int smallExplosionSubImageHeight = 100;

    private final static int bigExplosionFrames = 64;
    private final static int bigExplosionSpriteSheetColumns = 8;
    private final static int bigExplosionSubImageWidth = 256;
    private final static int bigExplosionSubImageHeight = 256;

    static{
        BufferedImageLoader bufferedImageLoader = new BufferedImageLoader();

        playerSpaceshipImage = bufferedImageLoader.loadImage("/com/spaceshooter/view/images/playerSpaceship.png");
        enemySpaceshipImage = bufferedImageLoader.loadImage("/com/spaceshooter/view/images/ufodark.png");
        playerLaserbeamImage = bufferedImageLoader.loadImage("/com/spaceshooter/view/images/PlayerLaser.png");
        enemyLaserbeamImage = bufferedImageLoader.loadImage("/com/spaceshooter/view/images/enemyEnergyBall.png");
        bossImage = bufferedImageLoader.loadImage("/com/spaceshooter/view/images/boss.png");

        smallExplosionAnimation = new BufferedImage[smallExplosionFrames];
//        playerSpaceshipAnimation = new BufferedImage[11];

        BufferedImage explosionSpriteSheet = bufferedImageLoader.loadImage("/com/spaceshooter/view/images/verticalexplosion.png");
        smallExplosionAnimation = initializeExplosionAnimation(explosionSpriteSheet, smallExplosionSpriteSheetColumns, smallExplosionSubImageWidth, smallExplosionSubImageHeight, smallExplosionFrames);
        explosionSpriteSheet = bufferedImageLoader.loadImage("/com/spaceshooter/view/images/explosion256.png");
        bigExplosionAnimation = initializeExplosionAnimation(explosionSpriteSheet, bigExplosionSpriteSheetColumns, bigExplosionSubImageWidth, bigExplosionSubImageHeight, bigExplosionFrames);
//        loadPlayerSpaceshipAnimation();
    }

    private static BufferedImage[] initializeExplosionAnimation(BufferedImage explosionSpriteSheet, int explosionSpriteSheetColumns, int explosionSubImageWidth, int explosionSubImageHeight, int explosionFrames)
    {
        BufferedImage[] explosionAnimation = new BufferedImage[explosionFrames];
        for (int i = 0; i < explosionAnimation.length ; i++) {
            int row = i / explosionSpriteSheetColumns;
            int column = i % explosionSpriteSheetColumns;

            explosionAnimation[i] = explosionSpriteSheet.getSubimage((column * explosionSubImageWidth),
                    (row * explosionSubImageWidth), explosionSubImageWidth, explosionSubImageHeight);
        }

        return explosionAnimation;
    }

  /*  private static void loadPlayerSpaceshipAnimation(){
        BufferedImageLoader bufferedImageLoader = new BufferedImageLoader();

        for (int i = 0; i < 11; i++) {
            playerSpaceshipAnimation[i] = bufferedImageLoader.loadImage("/com/spaceshooter/view/images/playerspaceship/fighter/smallfighter" + (i+1) + ".png");
        }
    }*/

    public static BufferedImage getEnemySpaceshipImage(){
        return enemySpaceshipImage;
    }

    public static BufferedImage getPlayerSpaceshipImage(){
        return playerSpaceshipImage;
    }

    public static BufferedImage getEnemyLaserbeamImage(){
        return enemyLaserbeamImage;
    }

    public static BufferedImage[] getSmallExplosionAnimation() {
        return smallExplosionAnimation;
    }

    public static BufferedImage getPlayerLaserbeamImage() {
        return playerLaserbeamImage;
    }

    public static BufferedImage getBossSpaceshipImage() {
        return bossImage;
    }

    public static BufferedImage[] getBigExplosionAnimation() {
        return bigExplosionAnimation;
    }



    /*  public static BufferedImage[] getPlayerSpaceshipAnimation(){
        return playerSpaceshipAnimation;
    }*/
}
