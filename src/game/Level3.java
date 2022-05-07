package game;

import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

//class for everything that needs to be in level3
public class Level3 extends GameLevel{
    Image background;
    public Level3(Game game) {
        super(game);

        //background image for this level
        background = new ImageIcon("data/bg3.jpg").getImage();

        //creating the boss enemy for this level
        BossEnemyLevel3 enemyBoss = new BossEnemyLevel3(this);
        enemyBoss.setPosition(new Vec2(0,19));

        EnemyShip enemyShip=new EnemyShip(game,this, false, true);
        enemyShip.setPosition(new Vec2(-7,12));

        EnemyShip enemyShip1=new EnemyShip(game,this, false, true);
        enemyShip1.setPosition(new Vec2(7,12));

        EnemyShip enemyShip2=new EnemyShip(game,this, true, false);
        enemyShip2.setPosition(new Vec2(0,5));

        EnemyShip enemyShip3=new EnemyShip(game,this, true, false);
        enemyShip3.setPosition(new Vec2(-15,5));

        EnemyShip enemyShip4=new EnemyShip(game,this, true, false);
        enemyShip4.setPosition(new Vec2(15,5));

        EnemyShip enemyShip5=new EnemyShip(game,this, false, true);
        enemyShip5.setPosition(new Vec2(22,12));

        EnemyShip enemyShip6=new EnemyShip(game,this, false, true);
        enemyShip6.setPosition(new Vec2(-22,12));

        EnemyShip enemyShip7=new EnemyShip(game,this, true, false);
        enemyShip7.setPosition(new Vec2(27,5));

        EnemyShip enemyShip8=new EnemyShip(game,this, true, false);
        enemyShip8.setPosition(new Vec2(-27,5));

        //creating a platform
        PlatformLevel3 platform = new PlatformLevel3(this);
        platform. setPosition(new Vec2(1,15));
    }

    @Override
    public boolean isComplete() {
        return getSpaceship().getCredits() >= 21;
    }

    @Override
    public String getName() {
        return "Level3";
    }

    @Override
    public Image getBackground() {
        return background;
    }
}
