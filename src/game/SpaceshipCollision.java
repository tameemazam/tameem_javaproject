package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

//class for collisions on the spaceship
public class SpaceshipCollision implements CollisionListener {
    GameLevel currentLevel;
    private final Spaceship spaceship;
    private final Game game;

    //sound effect for when a life is lost
    public static SoundClip LivesLost;
    static {
        try {
            LivesLost = new SoundClip("data/liveslost.wav");// Open an audio input stream
            System.out.println("sound plays");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public SpaceshipCollision(Game g, GameLevel level, Spaceship s){
        game = g;
        currentLevel = level;
        spaceship = s;
    }

    //conditions for collisions
    @Override
    public void collide(CollisionEvent c) {
        if(c.getOtherBody() instanceof Spaceship){
            spaceship.setLives(spaceship.getLives()-1);
            LivesLost.play();
            if(spaceship.getLives() == 0){
                game.setGameOver(true);
            }
            c.getReportingBody().destroy();
        }
        else if (c.getOtherBody() instanceof EnemyShip){
            c.getReportingBody().destroy();
        }
        else if (c.getOtherBody() instanceof Projectile){
            c.getOtherBody().destroy();
            c.getReportingBody().destroy();
        }

    }

}
