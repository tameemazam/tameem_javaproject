package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

//class for the final boss enemy in level 4
public class BossEnemyLevel4 extends Walker implements StepListener {

    private static SoundClip BossEncounter;
    static {
        try {
            BossEncounter = new SoundClip("data/boss.wav");// Open an audio input stream
            System.out.println("sound plays");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private static final Shape EnemyBoss = new PolygonShape(
            0.02f,3.84f,
            -3.67f,3.68f,
            -3.86f,1.54f,
            -0.1f,-3.58f,
            3.82f,1.62f,
            3.72f,3.66f
    );

    private static final BodyImage image = new BodyImage("data/es2.png",8);
    private final int SPEED = 12;
    private float left, right;

    public BossEnemyLevel4(World world) {
        super(world, EnemyBoss);
        this.addImage(image);
        getWorld().addStepListener(this);
        startWalking(SPEED);
        this.setGravityScale(0);
    }

    @Override
    public void setPosition(Vec2 position){
        super.setPosition(position);
        left = position.x-25;
        right = position.x+25;
    }

    //set movement of the Boss enemy
    @Override
    public void preStep(StepEvent stepEvent) {
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
