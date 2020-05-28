package com.spaceshooter.view;

import java.awt.image.BufferedImage;

public class ImageHandler {
    private static BufferedImage starImage;
    private static BufferedImage enemySpaceshipImage;
    private static BufferedImage playerSpaceshipImage;
    private static BufferedImage laserbeamImage;

    static{
        BufferedImageLoader bufferedImageLoader = new BufferedImageLoader();

        starImage = bufferedImageLoader.loadImage("/com/spaceshooter/view/images/star-24.png");
        playerSpaceshipImage = bufferedImageLoader.loadImage("/com/spaceshooter/view/images/playerSpaceship.png");
        enemySpaceshipImage = null;
        laserbeamImage = null;
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
}
