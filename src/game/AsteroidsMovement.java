package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**class for the moving asteroids in level 1
 *
 */
public class AsteroidsMovement implements StepListener {
    private final Asteroid asteroid;
    private final Vec2 initialPosition;

    public AsteroidsMovement(Asteroid a){
        asteroid=a;
        initialPosition = a.getPosition();
        a.getWorld().addStepListener(this);

    }
    @Override
    public void preStep(StepEvent stepEvent) {
        //code for asteroid  movement
        if(asteroid.getPosition().x>35){
            asteroid.setPosition(new Vec2(-35,initialPosition.y));
        }
        asteroid.setPosition(new Vec2(asteroid.getPosition().x+0.25f, asteroid.getPosition().y));

    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
