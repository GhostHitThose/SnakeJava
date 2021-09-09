package com.maxrenner.frame;

import com.maxrenner.gamefiles.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrameBuilder extends JFrame implements FrameVariables {
    public void build(Game game){
        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
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

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(S_WIDTH, S_HEIGHT);
    }
}
