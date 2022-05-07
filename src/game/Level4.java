package game;

import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

//class for everything that needs to be in level4
public class Level4 extends GameLevel{
    Image background;
    public Level4(Game game) {
        super(game);

        //background image for this level
        background = new ImageIcon("data/bg5.jpg").getImage();

        //creating enemyShips
        EnemyShip enemyShip=new EnemyShip(game,this, false, false);
        enemyShip.setPosition(new Vec2(-7,12));
        EnemyShipMovement em1 = new EnemyShipMovement(enemyShip);

        EnemyShip enemyShip1=new EnemyShip(game,this, false, false);
        enemyShip1.setPosition(new Vec2(7,12));
        EnemyShipMovement em2 = new EnemyShipMovement(enemyShip1);

        EnemyShip enemyShip2=new EnemyShip(game,this, true, false);
        enemyShip2.setPosition(new Vec2(0,5));
        EnemyShipMovement em3 = new EnemyShipMovement(enemyShip2);

        EnemyShip enemyShip3=new EnemyShip(game,this, true, false);
        enemyShip3.setPosition(new Vec2(-15,5));
        EnemyShipMovement em4 = new EnemyShipMovement(enemyShip3);

        EnemyShip enemyShip4=new EnemyShip(game,this, true, false);
        enemyShip4.setPosition(new Vec2(15,5));
        EnemyShipMovement em5 = new EnemyShipMovement(enemyShip4);

        EnemyShip enemyShip5=new EnemyShip(game,this, false, false);
        enemyShip5.setPosition(new Vec2(22,12));
        EnemyShipMovement em6 = new EnemyShipMovement(enemyShip5);

        EnemyShip enemyShip6=new EnemyShip(game,this, false, false);
        enemyShip6.setPosition(new Vec2(-22,12));
        EnemyShipMovement em7 = new EnemyShipMovement(enemyShip6);

        EnemyShip enemyShip7=new EnemyShip(game,this, true, false);
        enemyShip7.setPosition(new Vec2(27,5));
        EnemyShipMovement em8 = new EnemyShipMovement(enemyShip7);

        EnemyShip enemyShip8=new EnemyShip(game,this, true, false);
        enemyShip8.setPosition(new Vec2(-27,5));
        EnemyShipMovement em9 = new EnemyShipMovement(enemyShip8);

        EnemyShip enemyShip9=new EnemyShip(game,this, false, false);
        enemyShip9.setPosition(new Vec2(-35,12));
        EnemyShipMovement em10 = new EnemyShipMovement(enemyShip9);

        //creating multiple platforms
        PlatformLevel4 platform = new PlatformLevel4(this);
        platform.setPosition(new Vec2(1,15));

        PlatformLevel4 platform1 = new PlatformLevel4(this);
        platform1.setPosition(new Vec2(-13,15));

        PlatformLevel4 platform2 = new PlatformLevel4(this);
        platform2.setPosition(new Vec2(15,15));

        //creating the boss enemy for this level
        BossEnemyLevel4 bossEnemyLevel4 = new BossEnemyLevel4(this);
        bossEnemyLevel4.setPosition(new Vec2(0,19));
    }

    @Override
    public boolean isComplete() {
        return getSpaceship().getCredits() >= 32;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Image getBackground() {
        return background;
    }
}
