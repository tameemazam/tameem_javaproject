package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

//class for the enemy ships in every level
public class EnemyShip extends StaticBody{

    private Timer t;
    private final Game game;

    private static SoundClip EnemyEncounter;
    static {
        try {
            EnemyEncounter = new SoundClip("data/explode.wav");// Open an audio input stream
            System.out.println("enemy encounter sound plays");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }


    public static final Shape EnemyShip = new PolygonShape(
            -2.05f,1.54f,
            -1.49f,-0.31f,
            -0.03f,-1.75f,
            1.49f,-0.14f,
            2.0f,1.5f
    );

    private static final BodyImage image = new BodyImage("data/enemy1.png", 8);

    public EnemyShip(Game g,World world, boolean withShooting, boolean withShootingDelay) {
        super(world, EnemyShip);
        this.game = g;
        this.addImage(image);

        //conditions for if the enemyShip shoots or not
        if (withShooting) {
            EnemyShooting actionListener = new EnemyShooting(game,(GameLevel) this.getWorld(), this);
            t = new Timer(3000, actionListener);
            t.setInitialDelay(1000);
            t.start();
        }

        if (withShootingDelay) {
            EnemyShooting actionListener = new EnemyShooting(game,(GameLevel) this.getWorld(), this);
            t = new Timer(6000, actionListener);
            //t.setInitialDelay(3000);
            t.start();
        }


    }

    //sound effect after destroying an enemyShip
    @Override
    public void destroy() {
        super.destroy();

        EnemyEncounter.play();

        if (t != null)
            t.stop();
    }

}
