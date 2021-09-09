package gamefiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Game extends JPanel implements Runnable {

    private final Head head = new Head();
    private ArrayList<Body> body = new ArrayList<Body>();
    private int bLength = 5;

    @Override
    public void paintComponent(Graphics graphics){
        Graphics2D g = (Graphics2D) graphics;
        super.paintComponent(g);

        drawBackground(g);

        head.draw(g);
        for(Body body : body){
            body.draw(g);
        }
    }

    public void drawBackground(Graphics2D g){
        g.setColor(Color.black);
        g.fillRect(0,0,getWidth(),getHeight());
    }

    @Override
    public void run() {
        head.setWidth(10);
        head.setHeight(10);
        head.setX(getWidth()/2- head.getWidth());
        head.setY(getHeight()/2- head.getHeight());
        head.setSpeed(head.getWidth());

        for(int i = 0; i < bLength; i++){
            Body body = new Body();
            body.setWidth(head.getWidth());
            body.setHeight(head.getHeight());
            body.setX(head.getX()-i*head.getWidth());
            body.setY(head.getY());
            this.body.add(body);
        }

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
        for(int i = bLength; i > 1; i--){
            if(i == 2){
                body.get(i-1).move(body.get(0).getX(), body.get(0).getY());
                body.get(0).move(head.getX(), head.getY());
            } else {
                body.get(i-1).move(body.get(i-2).getX(), body.get(i-2).getY());
            }
        }

        head.move();
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
