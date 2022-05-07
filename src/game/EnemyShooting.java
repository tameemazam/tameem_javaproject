package game;

import city.cs.engine.BoxShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EnemyShooting implements ActionListener {

    GameLevel world;

    private final EnemyShip enemyShip;
    private final Game game;


    public EnemyShooting(Game g,GameLevel w, EnemyShip enemyShip){
        game = g;
        world = w;
        this.enemyShip = enemyShip;

    }

    //creating bullets for the enemyShips
    @Override
    public void actionPerformed(ActionEvent e) {
        SpaceshipCollision listener1 = new SpaceshipCollision(game,world,world.getSpaceship());
        DynamicBody spawn = new DynamicBody(world, new BoxShape(0.1f, 0.8f));
        spawn.setPosition(new Vec2(enemyShip.getPosition().x, enemyShip.getPosition().y-3.2f));
        spawn.setFillColor(Color.RED);
        spawn.addCollisionListener(listener1);
    }


}
