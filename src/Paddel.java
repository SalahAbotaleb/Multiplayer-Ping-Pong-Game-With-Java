import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.*;
public class Paddel extends Rectangle{
    Paddel(){

    }
    public void keyPressed(KeyEvent e){
        //this function is called by the GamePanel from Action Listener when a key is pressed
    }
    public void keyReleased(KeyEvent e)
    {
        //this function is called by the GamePanel from Action Listener when a key is released

    }
    public void setYDirection(int y)
    {

    }
    public void move()
    {
        //responsible for moving the paddel to the new y location
    }
    public void draw(Graphics g)
    {
        //responsible for drawing the Paddel and to be called by the draw function in the GamePanel

    }

}
