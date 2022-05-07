package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestartButton {
    public JPanel mainPanel;
    private JButton restartButton;
    private JButton quitButton;
    //private GameLevel currentLevel;
    private final Game game;

    public RestartButton(Game g) {
        this.game = g;
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.restart();
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
