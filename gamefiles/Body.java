package gamefiles;

import java.awt.*;

public class Body extends GameObject {

    @Override
    public void move(int nextX, int nextY) {
        setX(nextX);
        setY(nextY);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.green);
        g.fillRect(getX(),getY(), getWidth(),getHeight());
    }
}
