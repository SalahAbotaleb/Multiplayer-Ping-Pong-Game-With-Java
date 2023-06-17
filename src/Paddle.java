import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle extends Rectangle{

    int playerNum;
    int yVelocity=20; //speed of how fast you are moving up and down
    Paddle(int xLocation,int yLocation,int playerNum,int PADDLE_WIDTH,int PADDLE_HEIGHT){
        super(xLocation,yLocation,PADDLE_WIDTH,PADDLE_HEIGHT);
        this.playerNum=playerNum;
    }
    public void keyPressed(GamePanel.state state){
        //this function is called by the GamePanel from Action Listener when a key is pressed
        if(state==GamePanel.state.UP && y>=0)
            y-=yVelocity;

        if(state==GamePanel.state.DOWN && y+getHeight()<=GamePanel.PANEL_HEIGHT)
            y+=yVelocity;

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
