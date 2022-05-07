package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

//class for the final boss enemy in level 3
public class BossEnemyLevel3 extends Walker implements StepListener {

    private static SoundClip BossEncounter;
    static {
        try {
            BossEncounter = new SoundClip("data/boss.wav");// Open an audio input stream
            System.out.println("sound plays");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public static final Shape EnemyBoss = new BoxShape(3,3);

    private static final BodyImage image = new BodyImage("data/es1.png",8);

    private final int SPEED = 10;
    private float left, right;

    public BossEnemyLevel3(World world) {
        super(world, EnemyBoss);
        this.addImage(image);
        getWorld().addStepListener(this);
        startWalking(SPEED);
        this.setGravityScale(0);
    }

    @Override
    public void setPosition(Vec2 position){
        super.setPosition(position);
        left = position.x-24;
        right = position.x+24;
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

    //sound effect after destroying the boss enemy
    @Override
    public void destroy() {
        super.destroy();
        BossEncounter.play();
    }
}
