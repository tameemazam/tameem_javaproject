package game;

import city.cs.engine.DynamicBody;
import org.jbox2d.common.Vec2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**class for saving and loading the game
 *
 */
public class GameSaverLoader {

    /**method for saving the game
     *
     * @param fileName
     * @param level
     * @throws IOException
     */
    public static void save(String fileName, GameLevel level)
            throws IOException {
        boolean append = false;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, append);


            writer.write(level.getName() + "\n");

            for (int i = 0; i < level.getDynamicBodies().size(); i++) {
                DynamicBody b = level.getDynamicBodies().get(i);

                if (b instanceof Spaceship) {
                    writer.write("Spaceship," + b.getPosition().x + "," + b.getPosition().y + ((Spaceship) b).getCredits() + "\n");
                } else if (b instanceof Asteroid) {
                    writer.write("Asteroids," + b.getPosition().x + "," + b.getPosition().y + "\n");
                }
                /*else if (b instanceof EnemyShip) {
                    writer.write("EnemyShip," + b.getPosition().x + "," + b.getPosition().y + "\n");
                }*/
            }
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

  /*  /**method for loading the game
     *
     * @param fileName
     * @param game
     * @return
     * @throws IOException
     */
    /*public static GameLevel load(String fileName, Game game) throws IOException {
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);

            String line = reader.readLine();
            GameLevel level = null;
            if (line.equals("Level1")) {
                level = new Level1(game);
            } else if (line.equals("Level2")) {
                level = new Level2(game);
            }

            line = reader.readLine();
            while (line != null) {
                // file is assumed to contain one name, score pair per line
                String[] tokens = line.split(",");

                if(tokens[0].equals("EnemyShip")){
                    EnemyShip enemyShip = new EnemyShip(level);
                    enemyShip.setPosition(new Vec2(Float.parseFloat(tokens[1]),Float.parseFloat(tokens[2])));
                }
                else if(tokens[0].equals("Spaceship")){
                    Spaceship spaceship = new Spaceship(level);
                    spaceship.setPosition(new Vec2(Float.parseFloat(tokens[1]),Float.parseFloat(tokens[2])));
                    spaceship.setCredits(Integer.parseInt(tokens[3]));
                }
                else if(tokens[0].equals("Asteroids")){
                    Asteroid asteroids = new Asteroid(level);
                    asteroids.setPosition(new Vec2(Float.parseFloat(tokens[1]),Float.parseFloat(tokens[2])));
                }
                line = reader.readLine();
            }
            return level;
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
    }*/
}

