package com.spaceshooter.model;

import com.spaceshooter.controller.*;
import com.spaceshooter.view.LoginRegisterFrame;

import java.awt.*;

public class Game implements ObjectObserver{
    public final static int WIDTH = 1280;
    public final static int HEIGHT = 720;
    public final static SpaceObjectCreator creator = new SpaceObjectCreator();
    public static GameState gameState;
    private GameMenu gameMenu;
    private GameOver gameOver;
    private HUD hud;
    private Player player;
    private EnemySpaceshipManager enemySpaceshipManager;
    private StarManager starManager;
    private ExplosionManager explosionManager;
    private CollisionHandler collisionHandler;
    private int gameLevel;
    private final int MAX_LEVEL = 10;
    private boolean gameRunning;
    private long startTime;

    public static void main(String[] args) {
        Game game = new Game();
        LoginRegisterFrame loginRegisterFrame = new LoginRegisterFrame();
        Controller gameController = new Controller(loginRegisterFrame, game);
        loginRegisterFrame.setController(gameController);
    }

    public Game() {
        gameState = GameState.GameMenu;
        gameMenu = new GameMenu();
        gameOver = new GameOver();
        player = Player.createInstance();
        enemySpaceshipManager = new EnemySpaceshipManager();
        starManager = new StarManager();
        explosionManager = new ExplosionManager();
        hud = new HUD(player, this);
        gameLevel = 1;
        gameRunning = true;

        creator.setEnemyManager(this.enemySpaceshipManager);
        creator.setExplosionManager(this.explosionManager);
        creator.setPlayerLaserbeamManager(this.player.getLaserbeamManager());
        creator.setEnemyLaserbeamManager(this.enemySpaceshipManager.getEnemyLaserbeamManager());
        creator.setPlayer(this.player);

        starManager.createStars();
        enemySpaceshipManager.setObservableObject(this);
        enemySpaceshipManager.createEnemies(gameLevel);

        collisionHandler = new CollisionHandler(enemySpaceshipManager, player);
    }

    public boolean isGameRunning() {
        return gameRunning;
    }

    public void onTick(){
        player.onTick();
        enemySpaceshipManager.onTick();
        starManager.onTick();
        collisionHandler.onTick();
        explosionManager.onTick();
    }

    public void draw(Graphics graphics){
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, 1280, 720);
        starManager.draw(graphics);
        enemySpaceshipManager.draw(graphics);
        player.draw(graphics);
        explosionManager.draw(graphics);
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
        starManager.onTick();
        explosionManager.onTick();

        if(!explosionManager.hasExplosions()){
            enemySpaceshipManager.clear();
        }

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, 1280, 720);
        starManager.draw(graphics);
        enemySpaceshipManager.draw(graphics);
        explosionManager.draw(graphics);
        hud.draw(graphics);
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

    public void updatePlayerPosition(int playerX, int playerY) {
        player.updateSpaceshipPosition(playerX, playerY);
    }

    public void playerMouseClicked() {
        player.playerMouseClicked();
    }

    public int getLevel() {
        return this.gameLevel;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getStartTime() {
        return startTime;
    }

    @Override
    public void objectStateChanged(ObservableObject observable) {
        player.addScore(10);

        if(enemySpaceshipManager.isFleetAnnihilated()){
            float minutesTookToFinishRound = (System.currentTimeMillis() - startTime)/1000;
            int scoreToAdd = (int) ((1/minutesTookToFinishRound) * gameLevel * 100);

            player.addScore(scoreToAdd);

            startTime = System.currentTimeMillis();

            if(gameLevel == MAX_LEVEL){
                creator.createSpaceObject("boss", Game.WIDTH/2, Game.WIDTH/8);
                gameLevel++;
            }
            else{
                enemySpaceshipManager.createEnemies(++gameLevel);
            }
        }
        else{
            if (enemySpaceshipManager.getEnemySpaceships().get(0) instanceof BossSpaceship) {
                gameState = GameState.GameOver;
            }
        }
    }
}