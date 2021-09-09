package com.maxrenner.gamefiles;

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

    public int checkCollision(Apple apple, int windowW, int windowH){
        if(getX() == apple.getX() && getY() == apple.getY()){
            return 1;
        }
        if(getX() < 0 || getX() > windowW || getY() < 0 || getY() > windowH){
            return 2;
        }
        return 0;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.red);
        g.fillRect(getX(),getY(), getWidth(),getHeight());
    }
}
