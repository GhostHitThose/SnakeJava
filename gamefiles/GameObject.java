package com.maxrenner.gamefiles;

import java.awt.*;

public abstract class GameObject {
    private int x, y, width, height;
    public abstract void draw(Graphics2D g);
    public void move(){}
    public void move(int headX, int headY){}

    public int getX(){return x;}
    public int getY(){return y;}
    public int getWidth(){return width;}
    public int getHeight(){return height;}

    public void setX(int x){this.x = x;}
    public void setY(int y){this.y = y;}
    public void setWidth(int width){this.width = width;}
    public void setHeight(int height){this.height = height;}

}
