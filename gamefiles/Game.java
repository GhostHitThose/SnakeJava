package com.maxrenner.gamefiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Game extends JPanel implements Runnable {

    private final Head head = new Head();
    private final Apple apple = new Apple();
    private final ArrayList<GameObject> body = new ArrayList<GameObject>();
    private int bLength = 5;

    @Override
    public void paintComponent(Graphics graphics){
        Graphics2D g = (Graphics2D) graphics;
        super.paintComponent(g);

        drawBackground(g);

        for(GameObject snake : body){
            snake.draw(g);
        }

        apple.draw(g);
    }

    public void drawBackground(Graphics2D g){
        g.setColor(Color.black);
        g.fillRect(0,0,getWidth(),getHeight());
    }

    @Override
    public void run() {
        System.out.println(getWidth() + " " + getHeight());

        head.setWidth(10);
        head.setHeight(10);
        head.setX(290);
        head.setY(290);
        head.setSpeed(head.getWidth());
        this.body.add(head);

        for(int i = 0; i < bLength; i++){
            Body body = new Body();
            body.setWidth(head.getWidth());
            body.setHeight(head.getHeight());
            body.setX(head.getX()-i*head.getWidth());
            body.setY(head.getY());
            this.body.add(body);
        }
        apple.setWidth(head.getWidth());
        apple.setHeight(head.getHeight());
        apple.setX(((int)((Math.random() * getWidth())/apple.getWidth()))*apple.getWidth());
        apple.setY(((int)((Math.random() * getHeight())/apple.getHeight()))*apple.getHeight());

        long last = System.nanoTime();
        double delta = 0, ns = 1000000000/10.0;

        while(true){
            long current = System.nanoTime();
            delta += (current-last)/ns;
            last = current;

            while(delta >= 1){
                update();
                delta--;
            }

            render();
        }
    }

    public void render(){
        repaint();
    }

    public void update(){
        if(head.checkCollision(apple, getWidth(), getHeight()) == 1){
            int amount = 5;
            bLength += amount;
            for(int i = bLength- amount; i < bLength; i++){
                Body body = new Body();
                body.setHeight(this.body.get(0).getHeight());
                body.setWidth(this.body.get(0).getWidth());
                this.body.add(body);
            }
            apple.move();
        } else if(head.checkCollision(apple, getWidth(), getHeight()) == 2){
            System.exit(0);
        }

        for(int i = bLength+1; i > 1; i--){
            if(i == 2){
                body.get(i-1).move(body.get(0).getX(), body.get(0).getY());
            } else {
                body.get(i-1).move(body.get(i-2).getX(), body.get(i-2).getY());
            }
        }

        body.get(0).move();
    }

    public void keyPressed(KeyEvent e){
        char direction = e.getKeyChar();
        if(!(head.getDirection() == 's') && direction == 'w'){
            head.changeDirection(direction);
        }
        if(!(head.getDirection() == 'w') && direction == 's'){
            head.changeDirection(direction);
        }
        if(!(head.getDirection() == 'a') && direction == 'd'){
            head.changeDirection(direction);
        }
        if(!(head.getDirection() == 'd') && direction == 'a'){
            head.changeDirection(direction);
        }
    }
}
