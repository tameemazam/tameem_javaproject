package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**class for the main spaceship
 *
 */
public class Spaceship extends Walker {
    private Projectile projectile;
    Game game;
    GameLevel level;

    //shooting sound effect when the spaceship shoots
    private static SoundClip shootingSound;
    static {
        try {
            shootingSound = new SoundClip("data/shoot.wav");// Open an audio input stream
            System.out.println("sound plays");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private static final Shape spaceshipShape = new PolygonShape(
            -0.15f,2.99f,
            -2.99f,-1.52f,
            -3.01f,-2.19f,
            -0.44f,-2.97f,
            0.41f,-2.96f,
            3.01f,-2.14f,
            2.99f,-1.54f,
            0.25f,3.0f);
    private static final BodyImage image = new BodyImage("data/spaceship.png", 6);

    private static int credits = 0;
    private static int lives = 3;

    public Spaceship(GameLevel world, Game game){
        super(world,spaceshipShape);
        this.addImage(image);
        this.setGravityScale(0);
        level = world;
        this.game = game;
    }


    public void setCredits(int credits){
        Spaceship.credits = credits;
    }
    public int getCredits(){
        return credits;
    }

    public int getLives() {
        return lives;
    }
    public void setLives(int lives) {
        Spaceship.lives = lives;
    }

    //method for shooting
    public void shoot(){
        projectile = new Projectile(getWorld());
        shootingSound.play();
        ShootEnemy listener = new ShootEnemy(this, level, game);
        projectile.addCollisionListener(listener);
        projectile.setPosition(new Vec2(this.getPosition().x, this.getPosition().y + 3.7f));
        projectile.setLinearVelocity(new Vec2(0, 50));
        projectile.setGravityScale(0);
    }
}
