import java.awt.*;
import java.util.*;
import javax.swing.*;
public class Ball extends Rectangle{
    Random random;
    int xVelocity=10; //how fast on x-axis
    int yVelocity=10; //how fast on y-axis
    final int BALL_DIAMETER;
    Ball(int BALL_DIAMETER){
        this.width=BALL_DIAMETER;
        this.height=BALL_DIAMETER;
        random=new Random();
        x=GamePanel.PANEL_WIDTH/2-BALL_DIAMETER/2;

        if(random.nextInt()%2==0) setXDirection(-1);
        else setXDirection(1);
        if(random.nextInt()%2==0) setYDirection(-1);
        else setYDirection(1);
        y=random.nextInt(0,GamePanel.PANEL_HEIGHT);
        this.BALL_DIAMETER=BALL_DIAMETER;
    }
    public void setXDirection(int x)
    {
        xVelocity=x;
    }
    public void setYDirection(int y)
    {
        yVelocity=y;
    }
    public void move()
    {
        //responsible for moving the ball to the new x,y location
        x+=xVelocity;

        y+=yVelocity;
        if(y<=0 || y+BALL_DIAMETER>=GamePanel.PANEL_HEIGHT)
        {
            y-=yVelocity;
            yVelocity*=-1;
            if(yVelocity>0) yVelocity=Math.min(yVelocity+1,20);
            else yVelocity=Math.max(yVelocity-1,-20);
            if(xVelocity>0) xVelocity=Math.min(xVelocity+1,20);
            else xVelocity=Math.max(xVelocity-1,-20);
        }
    }
    public void draw(Graphics g)
    {
        //responsible for drawing the ball and to be called by the draw function in the GamePanel
        g.setColor(Color.green);
        g.fillOval(x,y,BALL_DIAMETER,BALL_DIAMETER);
    }
}
