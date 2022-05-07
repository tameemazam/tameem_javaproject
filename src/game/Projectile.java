package game;

import city.cs.engine.*;

//class for the projectiles of the main spaceship
public class Projectile extends DynamicBody {
    public static final Shape projectile=new PolygonShape(-0.09f,1.27f,
            -0.35f,1.07f,
            -0.36f,-1.06f,
            -0.06f,-1.22f,
            0.23f,-1.06f,
            0.23f,1.11f);

    public static final BodyImage image= new BodyImage("data/bullet.png",3f);

    public Projectile(World world) {
        super(world,projectile);
        this.addImage(image);
    }
}
