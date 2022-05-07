package game;

import city.cs.engine.*;

public class Asteroid extends DynamicBody{

    private static final Shape AsteroidShape = new CircleShape(1f);
    private static final BodyImage image = new BodyImage("data/asteroid1.png", 2.5f);

    public Asteroid(World world) {
        super(world, AsteroidShape);
        this.addImage(image);
        this.setGravityScale(0);
    }
}
