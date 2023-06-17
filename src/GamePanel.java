import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
public class GamePanel extends JPanel implements Runnable {

    GamePanel(){
        //here initial components are instantiated


    }
    public void newBall(){
        //whenever newBall is called a new ball will be created on the screen
    }
    public void newPaddels(){
        //whenever we want to reset the paddels or the game

    }
    public void paint(Graphics g)
    {
        //this is called when GamePanel is created or repaint is called when resizing the screen
        //must place here initial drawings

    }
    public void draw(Graphics g)
    {
        //an alternative for using repaint

    }
    public void move()
    {
        //to be called each iteration to move the Paddels and ball

    }

    @Override
    public void run() {
        //here the code that always runs is written + used to be able to multi-thread

    }
    //inner class acts as action listener for key pressed
    private class AL extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){

        }
        @Override
        public void keyReleased(KeyEvent e)
        {

        }

    }




}
