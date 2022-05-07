package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


//class for whatever collides with the projectile form the main spaceship
public class ShootEnemy implements CollisionListener {
    private final Spaceship spaceship;
    GameLevel currentLevel;
    Game game;

    //sound effect for when you lose a life
    public static SoundClip LivesLost;
    static {
        try {
            LivesLost = new SoundClip("data/liveslost.wav");// Open an audio input stream
            System.out.println("sound plays");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }


    public ShootEnemy(Spaceship s, GameLevel level, Game game){
        spaceship=s;
        currentLevel=level;
        this.game=game;
    }


    //conditions for collisions
    @Override
    public void collide(CollisionEvent c) {
        if(c.getOtherBody() instanceof EnemyShip){
            spaceship.setCredits(spaceship.getCredits()+1);
            System.out.println("Enemy ships destroyed : " + spaceship.getCredits());
            if(currentLevel.isComplete())
                game.goToNextLevel();
            c.getReportingBody().destroy();
            c.getOtherBody().destroy();

        }
        else if(c.getOtherBody() instanceof Asteroid){
            spaceship.setLives(spaceship.getLives()-1);
            LivesLost.play();
            if(spaceship.getLives() == 0){
                game.setGameOver(true);
            }
            c.getReportingBody().destroy();
            c.getOtherBody().destroy();
        }
        else if(c.getOtherBody() instanceof BossEnemyLevel2){
            spaceship.setCredits(spaceship.getCredits()+1);
            c.getReportingBody().destroy();
            c.getOtherBody().destroy();
            game.goToNextLevel();
        }
        else if(c.getOtherBody() instanceof BossEnemyLevel3){
            spaceship.setCredits(spaceship.getCredits()+1);
            c.getReportingBody().destroy();
            c.getOtherBody().destroy();
            game.goToNextLevel();
        }
        else if(c.getOtherBody() instanceof BossEnemyLevel4){
            spaceship.setCredits(spaceship.getCredits()+1);
            c.getReportingBody().destroy();
            c.getOtherBody().destroy();
            game.setGameOver(true);
        }
        else if(c.getOtherBody() instanceof PlatformLevel3){
            c.getReportingBody().destroy();
        }
        else if(c.getOtherBody() instanceof PlatformLevel4){
            c.getReportingBody().destroy();
        }
    }
}
