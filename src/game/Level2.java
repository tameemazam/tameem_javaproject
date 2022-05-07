package game;

import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

//class for everything that needs to be in level2
public class Level2 extends GameLevel{

    Image background;

    public Level2(Game game){
        super(game);

        //background image for this level
        background = new ImageIcon("data/bg2.jpg").getImage();

        //creating enemyShips
        EnemyShip enemyShip=new EnemyShip(game,this, true, false);
        enemyShip.setPosition(new Vec2(-8,12));

        EnemyShip enemyShip1=new EnemyShip(game,this, true, false);
        enemyShip1.setPosition(new Vec2(8,12));

        EnemyShip enemyShip2=new EnemyShip(game,this, false, false);
        enemyShip2.setPosition(new Vec2(0,0));

        EnemyShip enemyShip3=new EnemyShip(game,this, false, false);
        enemyShip3.setPosition(new Vec2(-17,0));

        EnemyShip enemyShip4=new EnemyShip(game,this, false, false);
        enemyShip4.setPosition(new Vec2(17,0));

        EnemyShip enemyShip5=new EnemyShip(game,this, true, false);
        enemyShip5.setPosition(new Vec2(24,12));

        EnemyShip enemyShip6=new EnemyShip(game,this, true, false);
        enemyShip6.setPosition(new Vec2(-24,12));

        //creating the boss enemy
        BossEnemyLevel2 bossEnemy = new BossEnemyLevel2(this);
        bossEnemy.setPosition(new Vec2(0,19));
    }

   /* @Override
    public void populate() {
        super.populate();
    }*/


    @Override
    public boolean isComplete() {
        return getSpaceship().getCredits() >= 11;

    }

    @Override
    public String getName() {
        return "Level2";
    }

    @Override
    public Image getBackground() {
        return background;
    }
}
