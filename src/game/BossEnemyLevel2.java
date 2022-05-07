package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

//class for the final boss enemy in level 2
public class BossEnemyLevel2 extends Walker implements StepListener {

    private static SoundClip BossEncounter;
    static {
        try {
            BossEncounter = new SoundClip("data/boss.wav");// Open an audio input stream
            System.out.println("sound plays");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public static final Shape BossEnemy = new PolygonShape(
            -0.03f,3.5f,
            -2.38f,3.31f,
            -3.24f,1.58f,
            0.0f,-3.65f,
            3.28f,1.86f,
            1.91f,3.55f
    );

    private static final BodyImage image = new BodyImage("data/es3.png",8);
    private final int SPEED = 8;
    private float left, right;

    public BossEnemyLevel2(World w) {
        super(w, BossEnemy);
        this.addImage(image);
        getWorld().addStepListener(this);
        startWalking(SPEED);
        this.setGravityScale(0);
    }

    @Override
    public void setPosition(Vec2 position){
        super.setPosition(position);
        left = position.x-20;
        right = position.x+20;
    }
    @Override
    public void preStep(StepEvent stepEvent) {
        //set movement of the Boss enemy
        if(getPosition().x > right){
            startWalking(-SPEED);
        }
        if(getPosition().x < left){
            startWalking(SPEED);
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }

    //sound effect after colliding with the boss enemy
    @Override
    public void destroy() {
        super.destroy();
        BossEncounter.play();
    }

}
