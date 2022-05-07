package game;

import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

//class for everything that needs to be in level1
public class Level1 extends GameLevel{

    Image background;

    public Level1(Game game){

        super(game);

        //background image for this level
        background = new ImageIcon("data/space.jpg").getImage();

        //creating asteroids
        Asteroid asteroid=new Asteroid(this);
        asteroid.setPosition(new Vec2(-21,8));
        AsteroidsMovement am1 = new AsteroidsMovement(asteroid);

        Asteroid asteroid1=new Asteroid(this);
        asteroid1.setPosition(new Vec2(-10,-5));
        AsteroidsMovement am2 = new AsteroidsMovement(asteroid1);

        Asteroid asteroid2=new Asteroid(this);
        asteroid2.setPosition(new Vec2(24,16));
        AsteroidsMovement am3 = new AsteroidsMovement(asteroid2);

        Asteroid asteroid3=new Asteroid(this);
        asteroid3.setPosition(new Vec2(-1,21));
        AsteroidsMovement am4 = new AsteroidsMovement(asteroid3);

        Asteroid asteroid4=new Asteroid(this);
        asteroid4.setPosition(new Vec2(22,4));
        AsteroidsMovement am6 = new AsteroidsMovement(asteroid4);

        Asteroid asteroid5=new Asteroid(this);
        asteroid5.setPosition(new Vec2(10,-8));
        AsteroidsMovement am5 = new AsteroidsMovement(asteroid5);

        //creating enemy ships
        EnemyShip enemyShip=new EnemyShip(game,this, false, false);
        enemyShip.setPosition(new Vec2(-15,12));
        EnemyShip enemyShip1=new EnemyShip(game,this, false, false);
        enemyShip1.setPosition(new Vec2(15,12));
        EnemyShip enemyShip2=new EnemyShip(game,this, false, false);
        enemyShip2.setPosition(new Vec2(0,0));

    }

   /* @Override
    public void populate(){
        super.populate();
    }*/

    @Override
    public boolean isComplete() {
        return getSpaceship().getCredits() >= 3;
    }

    @Override
    public String getName() {
        return "Level1";
    }

    @Override
    public Image getBackground() {
        return background;
    }
}
