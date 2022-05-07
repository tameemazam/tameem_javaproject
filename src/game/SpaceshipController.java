package game;

import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//class for controlling the main spaceship
public class SpaceshipController implements KeyListener {
    private static final float FLYING_SPEED = 15;
    private Spaceship spaceship;
    private final Game game;

    public SpaceshipController (Game game,Spaceship spaceship){this.spaceship=spaceship;
    this.game=game;}

    //conditions for all the controls
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_A){
            spaceship.setLinearVelocity(new Vec2(-FLYING_SPEED,0));
            //spaceship.startWalking(-FLYING_SPEED);
        }
        else if(code == KeyEvent.VK_D ){
            spaceship.setLinearVelocity(new Vec2(FLYING_SPEED,0));
            //spaceship.startWalking(FLYING_SPEED);
        }
        else if(code == KeyEvent.VK_W){
            spaceship.setLinearVelocity(new Vec2(0,FLYING_SPEED));
            //spaceship.jump(FLYING_SPEED);
        }
        else if(code == KeyEvent.VK_S) {
            spaceship.setLinearVelocity(new Vec2(0,-FLYING_SPEED));
            //spaceship.jump(-FLYING_SPEED);
        }
        else if(e.getKeyCode() == KeyEvent.VK_ENTER){
            spaceship.shoot();
        }
        else if(code == KeyEvent.VK_ESCAPE){
            game.toggleMenu();
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_A && spaceship.getLinearVelocity().x < 0){
            //spaceship.stopWalking();
            spaceship.setLinearVelocity(new Vec2(0, 0));
        }
        else if(code == KeyEvent.VK_D && spaceship.getLinearVelocity().x > 0){
            //spaceship.stopWalking();
            spaceship.setLinearVelocity(new Vec2(0, 0));

        }
        else if(code == KeyEvent.VK_W && spaceship.getLinearVelocity().y > 0){
            spaceship.setLinearVelocity(new Vec2(0,0));
        }
        else if(code == KeyEvent.VK_S && spaceship.getLinearVelocity().y < 0) {
            spaceship.setLinearVelocity(new Vec2(0,0));
        }


    }

    public void updateSpaceship(Spaceship newSpaceship){
        spaceship = newSpaceship;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
