package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

/**class for the movements of enemyShips in all levels
 *
 */
public class EnemyShipMovement implements StepListener {
    private final EnemyShip enemyShip;
    private final Vec2 initialPosition;

    public EnemyShipMovement(EnemyShip enemyShip) {
        this.enemyShip = enemyShip;
        initialPosition = enemyShip.getPosition();
        enemyShip.getWorld().addStepListener(this);
    }
//conditions for the movements
    @Override
    public void preStep(StepEvent stepEvent) {
        if(enemyShip.getPosition().x>35){
            enemyShip.setPosition(new Vec2(-35,initialPosition.y));
        }
        enemyShip.setPosition(new Vec2(enemyShip.getPosition().x+0.15f, enemyShip.getPosition().y));
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
