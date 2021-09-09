package frame;

import gamefiles.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrameBuilder extends JFrame implements FrameVariables {
    public void build(Game game){
        setTitle(TITLE);
        setPreferredSize(new Dimension(S_WIDTH, S_HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        add(game);
        addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                game.keyPressed(e);
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
