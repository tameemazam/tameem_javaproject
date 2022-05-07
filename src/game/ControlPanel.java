package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ControlPanel {
    private JPanel mainPanel;
    private JButton resumeButton;
    private JButton saveButton;
    private JButton quitButton;
    private JButton instructionsButton;
    private JButton loadButton;
    private JButton restartButton;
    private final GameLevel currentLevel;
    private final Game game;

    public ControlPanel(GameLevel level, Game g){
        currentLevel = level;
        game = g;

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        resumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("resume button pressed");
                currentLevel.start();
                game.toggleMenu();
            }
        });
        instructionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.transitionToInstructions();
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("save button pressed");
                try {
                    GameSaverLoader.save("data/save.txt", game.currentLevel);
                }catch (IOException ee){
                    ee.printStackTrace();
                }
            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // GameLevel loadedLevel = GameSaverLoader.load("data/save.txt");
                //game.setLevel(loadedLevel);
            }
        });
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.restart();
                game.toggleMenu();
            }
        });
    }

    public JPanel getMainPanel(){
        return mainPanel;
    }
}
