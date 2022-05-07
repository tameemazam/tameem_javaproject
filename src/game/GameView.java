package game;

import city.cs.engine.UserView;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

/**class for viewing the game
 *
 */
public class GameView extends UserView {

    private final Game game;
    private final Spaceship spaceship;
    GameLevel currentLevel;

    public GameView(Game g,GameLevel w, Spaceship spaceship, int width, int height) {
        super(w, width, height);
        game= g;
        currentLevel = w;
        this.spaceship=spaceship;
    }

    public void updateZoom(){
        this.setZoom(15);
    }

    //background image
    @Override
    protected void paintBackground(Graphics2D g){
        g.drawImage(currentLevel.getBackground(),-200,-50,this);
    }

    @Override
    public void setWorld(World w){
        super.setWorld(w);
        currentLevel = (GameLevel)w;
    }


    //texts to show game or player stats
    @Override
    protected void paintForeground(Graphics2D g){
        g.setColor(Color.white);
        Font font1 = new Font("Arial", Font.BOLD,16);
        g.setFont(font1);
        //g.drawString("Shoot enemy ships for plus points and avoid the Asteroids",20,20);
        g.drawString("Points: " + spaceship.getCredits(),20,20);
        g.drawString("Lives : " +spaceship.getLives(),20,35 );
        if(game.isGameOver()){
            Font font = new Font("Arial",Font.BOLD,30);
            g.setFont(font);
            g.drawString("GAME OVER!", (this.getWidth()/2)-80, this.getHeight()/2);
            game.toggleRestart();
        }
    }
}
