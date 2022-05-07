package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.*;


public abstract class GameLevel extends World {

    private final Spaceship spaceship;
    private final Game game;



    public GameLevel(Game game){
        this.game = game;

        //creating main spaceship
        spaceship=new Spaceship(this, game);
        spaceship.setPosition(new Vec2(0,-20));

    }

    public Spaceship getSpaceship() {
        return spaceship;
    }

    public abstract boolean isComplete();

    public abstract String getName();

    public abstract Image getBackground();




}
