package gamefiles;

import java.awt.*;

public class Head extends GameObject {

    private int speed;
    private char direction = 'w';

    @Override
    public void move() {
        if(direction == 'w'){
            setY(getY()-speed);
        }
        if(direction == 'a'){
            setX(getX()-speed);
        }
        if(direction == 'd'){
            setX(getX()+speed);
        }
        if(direction == 's'){
            setY(getY()+speed);
        }
    }

    public void changeDirection(char direction){this.direction = direction;}
    public char getDirection(){return direction;}
    public void setSpeed(int speed){this.speed = speed;}

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.red);
        g.fillRect(getX(),getY(), getWidth(),getHeight());
    }
}
