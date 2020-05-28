package com.spaceshooter.model;

import com.spaceshooter.controller.CollisionHandler;
import com.spaceshooter.controller.Controller;
import com.spaceshooter.controller.EnemySpaceshipManager;
import com.spaceshooter.controller.StarManager;
import com.spaceshooter.view.GameWindow;

import java.awt.*;

public class Game  {
    public final static int WIDTH = 1280;
    public final static int HEIGHT = 720;
    public GameState gameState;
    private GameMenu gameMenu;
    private GameOver gameOver;
    private HUD hud;
    private Player player;
    private EnemySpaceshipManager enemySpaceshipManager;
    private StarManager starManager;
    private CollisionHandler collisionHandler;
    private int gameLevel;
    private boolean gameRunning;

    public static void main(String[] args) {
        Game game = new Game();
        GameWindow gameWindow = new GameWindow(Game.WIDTH, Game.HEIGHT);
        Controller gameController = new Controller(gameWindow, game);
        gameWindow.setController(gameController);

        gameController.start();
    }

    public Game() {
        gameState = GameState.GameMenu;
        gameMenu = new GameMenu();
        gameOver = new GameOver();
        player = Player.createInstance();
        enemySpaceshipManager = new EnemySpaceshipManager();
        starManager = new StarManager();
        collisionHandler = new CollisionHandler(enemySpaceshipManager, player);
        hud = new HUD(player);
        gameLevel = 1;
        gameRunning = true;

        createStars();
    }

    public boolean isGameRunning() {
        return gameRunning;
    }

    public void onTick(){
        player.onTick();
        enemySpaceshipManager.onTick();
        starManager.onTick();
        collisionHandler.onTick();
    }

    public void draw(Graphics graphics){
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, 1280, 720);
        starManager.draw(graphics);
        enemySpaceshipManager.draw(graphics);
        player.draw(graphics);
        hud.draw(graphics);
    }

    // main menu
    public void runMenu(Graphics graphics) {
        gameMenu.onTick();
        gameMenu.draw(graphics);
    }


    public void runGame(Graphics graphics) {
        onTick();
        draw(graphics);
    }

    public void runGameOver(Graphics graphics) {
        gameOver.onTick();
        gameOver.draw(graphics);
    }

    public void update(Graphics graphics) {

        switch(gameState) {
            case GameMenu:
                runMenu(graphics);
                break;
            case GameRunning:
                runGame(graphics);
                break;
            case GameOver:
                runGameOver(graphics);
                break;
            default:
                break;
        }
    }

    public void pauseGame(){

    }

    public void nextLevel(){
        gameLevel++;
    }

    public void addPlayerLaserbeam(){

    }

    public void updateLeaderboard(){

    }

    private void createStars(){

    }

    private void createEnemySpaceships(){

    }

    public void updatePlayerPosition(int playerX, int playerY) {
        player.updateSpaceshipPosition(playerX, playerY);
    }
}