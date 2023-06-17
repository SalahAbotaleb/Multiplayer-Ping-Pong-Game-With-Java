import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle extends Rectangle{

    int playerNum;
    int yVelocity; //speed of how fast you are moving up and down

    Paddle(int xLocation,int yLocation,int playerNum,int PADDLE_WIDTH,int PADDLE_HEIGHT){
        super(xLocation,yLocation,PADDLE_WIDTH,PADDLE_HEIGHT);
        this.playerNum=playerNum;
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
        //responsible for moving the paddle to the new y location
    }
    public void draw(Graphics g)
    {
        //responsible for drawing the Paddle and to be called by the draw function in the GamePanel
        if(playerNum==1)
            g.setColor(Color.BLUE);
        else
            g.setColor(Color.RED);
        g.fillRect(x,y,width,height);
    }

}
