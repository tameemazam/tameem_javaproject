package game;

import city.cs.engine.*;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 * Your main game entry point
 */
public class Game {
    GameLevel currentLevel;
    private final GameView view;
    SpaceshipController controller;
    private final Spaceship spaceship;

    public boolean menuVisible;


    private final ControlPanel controlPanel;
    private final InstructionsPanel instructionsPanel;
    private final RestartButton restartButton;
    public JFrame frame;

    private boolean gameOver;

    private SoundClip gameMusic;

    /** Initialise a new Game. */
    public Game() {
        menuVisible = false;

        gameOver = false;

        //creating the first level
        currentLevel = new Level1(this);

        //background music
        try {
            gameMusic = new SoundClip("data/background.wav");
            gameMusic.loop();
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }

        spaceship = currentLevel.getSpaceship();

        //3. make a view to look into the game world
        view = new GameView(this,currentLevel,spaceship,1000,700);
        view.setZoom(15);

        currentLevel.setGravity(0);
        view.addMouseListener(new GiveFocus(view));

        controller = new SpaceshipController(this,currentLevel.getSpaceship());
        view.addKeyListener(controller);

        //optional: draw a 1-metre grid over the view
        // view.setGridResolution(1);


        //Java window (frame)
        frame = new JFrame("City Game");

        frame.add(view);

        controlPanel = new ControlPanel(currentLevel, this);
        instructionsPanel = new InstructionsPanel(this);
        restartButton = new RestartButton(this);
        //frame.add(controlPanel.getMainPanel(), BorderLayout.WEST);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        //optional: uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 500, 500);

        // start our game world simulation!
        currentLevel.start();
    }

    public void setLevel(GameLevel level){
        currentLevel.stop();
        currentLevel = level;
        view.setWorld(currentLevel);
        controller.updateSpaceship(currentLevel.getSpaceship());
        view.updateZoom();
        currentLevel.start();
    }

    //conditions for when to move to the next level
    public void goToNextLevel(){

        if(currentLevel instanceof Level1) {
            currentLevel.stop();
            currentLevel = new Level2(this);
            view.setWorld(currentLevel);
            controller.updateSpaceship(currentLevel.getSpaceship());
            view.updateZoom();
            currentLevel.start();
        }
        else if(currentLevel instanceof Level2) {
            setLevel(currentLevel = new Level3(this));
        }
        else if(currentLevel instanceof Level3){
            setLevel(currentLevel = new Level4(this));
        }
        else if(currentLevel instanceof Level4){
            System.out.println("Game Over!");
            System.exit(0);
        }

    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }

    //control panel toggling
    public void toggleMenu(){
        if(menuVisible){
            //hide menu
            frame.remove(controlPanel.getMainPanel());
            menuVisible = false;
            gameMusic.resume();
            currentLevel.start();
            frame.pack();
        }
        else{
            //show menu
            frame.add(controlPanel.getMainPanel(), BorderLayout.WEST);
            menuVisible = true;
            gameMusic.pause();
            currentLevel.stop();
            frame.pack();
        }
    }

    public void toggleRestart(){
        if(gameOver){
            frame.add(restartButton.mainPanel, BorderLayout.SOUTH);
            frame.pack();
        }
    }

    public void transitionToInstructions(){
        frame.remove(controlPanel.getMainPanel());
        frame.add(instructionsPanel.getMainPanel(), BorderLayout.WEST);
        frame.pack();
    }

    public void transitionToMain(){
        frame.remove(instructionsPanel.getMainPanel());
        frame.add(controlPanel.getMainPanel(), BorderLayout.WEST);
        frame.pack();
    }

    public boolean isGameOver(){
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
        currentLevel.stop();
        view.repaint();
    }

    public void restart(){
        currentLevel = new Level1(this);
        gameMusic.play();
        view.setWorld(currentLevel);
        controller.updateSpaceship(currentLevel.getSpaceship());
        view.updateZoom();
        this.setGameOver(false);
        frame.remove(restartButton.mainPanel);
        frame.pack();
        spaceship.setLives(3);
        spaceship.setCredits(0);
        currentLevel.start();

    }

}
