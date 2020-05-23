package com.spaceshooter.model;

import com.spaceshooter.controller.CollisionHandler;
import com.spaceshooter.controller.Controller;
import com.spaceshooter.controller.EnemySpaceshipManager;
import com.spaceshooter.controller.StarManager;
import com.spaceshooter.view.GameWindow;

import java.awt.*;

public class Game  {
    public final int WIDTH = 1280;
    public final int HEIGHT = 720;
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
        GameWindow gameWindow = new GameWindow(game.WIDTH, game.HEIGHT);
        Controller gameController = new Controller(gameWindow, game);

        gameController.start();
    }

    public Game() {
        gameState = GameState.GameMenu;
        gameMenu = new GameMenu();
        gameOver = new GameOver();
        hud = new HUD();
        player = Player.CreateInstance();
        enemySpaceshipManager = new EnemySpaceshipManager();
        starManager = new StarManager();
        collisionHandler = new CollisionHandler();
        gameLevel = 1;
        gameRunning = true;

        createStars();
    }

    public boolean isGameRunning() {
        return gameRunning;
    }

    public void onTick(){
        hud.onTick();
        player.onTick();
        enemySpaceshipManager.onTick();
        starManager.onTick();
        collisionHandler.onTick();
    }

    public void draw(Graphics graphics){
        hud.draw(graphics);
        player.draw(graphics);
        enemySpaceshipManager.draw(graphics);
        starManager.draw(graphics);
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
        player.addLaserbeam();
    }

    public void updateLeaderboard(){

    }

    private void createStars(){

    }

    private void createEnemySpaceships(){

    }
}