package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InstructionsPanel {
    private JPanel mainPanel;
    private JTextArea howToPlayWTextArea;
    private JButton backButton;
    private final Game game;

    public InstructionsPanel(Game g) {
        game= g;
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.transitionToMain();
            }
        });
    }
    public JPanel getMainPanel(){
        return mainPanel;
    }

}
