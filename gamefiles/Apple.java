package com.maxrenner.gamefiles;

import java.awt.*;

public class Apple extends GameObject {
    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.red);
        g.fillRect(getX(),getY(),getWidth(),getHeight());
    }
}
