import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
public class GamePanel extends JPanel implements Runnable {

    static final int PANEL_WIDTH=1000;
    static final int PANEL_HEIGHT=(int)(PANEL_WIDTH*0.556);
    static final Dimension SCREEN_SIZE= new Dimension(PANEL_WIDTH,PANEL_HEIGHT);
    static final int BALL_DIAMETER=20; //those numebers are in pixels
    static final int PADDLE_WIDTH =25;
    static final int PADDLE_HEIGHT =100;
    //uninitialized references going to initialize in the constructor
    Thread gameRunningThread; //to be able to run the game in a different thread
    Graphics graphics; //to be able to instantiate and pass to drawing functions
    Image image; //it is used to be able to instantiate graphics
    Random random; //to pass it to ball class to randomly generate starting location
                   //may be removed
    Paddle player1;
    Paddle player2;
    Ball ball;
    Score score;
    state p1,p2; //enum to store the state of keyboard
    GamePanel(){
        //here initial components are instantiated
        this.setPreferredSize(SCREEN_SIZE);
        newPaddels();
        newBall();
        score=new Score(PANEL_WIDTH,PANEL_HEIGHT);
        this.setFocusable(true); //to be able to be sensitive for keystrokes
        this.addKeyListener(new AL());
        gameRunningThread = new Thread(this); //multithreading
        System.out.println(Thread.activeCount());
        gameRunningThread.start();
        System.out.println(Thread.activeCount());

    }
    public void newBall(){
        //whenever newBall is called a new ball will be created on the screen
        ball=new Ball(BALL_DIAMETER);
    }
    public void newPaddels(){
        //whenever we want to reset the paddels or the game
        player1=new Paddle(0,PANEL_HEIGHT/2-PADDLE_HEIGHT/2,1,PADDLE_WIDTH, PADDLE_HEIGHT);
        player2=new Paddle(PANEL_WIDTH- PADDLE_WIDTH,PANEL_HEIGHT/2-PADDLE_HEIGHT/2,2,PADDLE_WIDTH, PADDLE_HEIGHT);
    }
    public void paint(Graphics g)
    {
        //this is called when GamePanel is created or repaint is called when resizing the screen
        //must place here initial drawings
        image=createImage(getWidth(),getHeight());
        graphics=image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
        /**
         * what happens is the following:
         * 1. Draw the components paddle, ball and score on an image(or graphics element of the image)
         * 2. Use the generated image to draw it using the Graphics g
         */

    }
    public void draw(Graphics g)
    {
        //to be used for paint and repaint

        player1.draw(g);
        player2.draw(g);
        score.draw(g);
        ball.draw(g);



    }
    public void move()
    {
        //to be called each iteration to move the ball
        ball.move();
    }
    public void checkCollisions(){
        //checks if a collision happen between ball and a wall or paddle
        if(ball.intersects(player1)) {ball.setXDirection(1);}
        if(ball.intersects(player2)) {ball.setXDirection(-1);}
        if(ball.x<0) {
            score.player1Score+=1;
            newBall();
            newPaddels();
        }
        if(ball.x>PANEL_WIDTH) {
            score.player2Score+=1;
            newBall();
            newPaddels();
        }


    }

    @Override
    public void run() {
        //here the code that always runs is written + used to be able to multi-thread
        //game loop
        //60 frames per second
        /*
        * Those are the steps for a basic game loop
        * 1. Seek how many frames per second
        * 2. calculations are done in nanosecond
        * 3. get current time in nanosecond
        * 4. calculate the amount of nanoseconds in the preferred frame rate
        * 5. goal is to check the elapsed time whether it passed the amount of nanoseconds of preferred frame rate
        * 6. after checking if it passed perform the required action
        * 7. accumulate the differences in a variable for next comparison
        * 8. after each true resulted comparison the accumulator should be reduced by one unit
        * 9. the condition to be true is to pass a one unit (maybe time or a scaled unit)
        * */
        long lastTime=System.nanoTime();
        double amountofTicks=60;
        double ns=1000000000/amountofTicks;
        double delta=0;
        while(true)
        {
            long currTime=System.nanoTime();
            delta+=(currTime-lastTime)/ns;
            if(delta>=1)
            {

                checkCollisions();
                move();
                repaint();
                delta--;

            }
            lastTime=currTime;
        }
    }
    //inner class acts as action listener for key pressed
    private class AL extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){
            if(e.getKeyCode()==KeyEvent.VK_W)
                p1=state.UP;
            if(e.getKeyCode()==KeyEvent.VK_S)
                p1=state.DOWN;
            if(e.getKeyCode()==KeyEvent.VK_UP)
                p2=state.UP;
            if(e.getKeyCode()==KeyEvent.VK_DOWN)
                p2=state.DOWN;
            player1.keyPressed(p1);
            player2.keyPressed(p2);
        }
        @Override
        public void keyReleased(KeyEvent e){
            if(e.getKeyCode()==KeyEvent.VK_W || e.getKeyCode()==KeyEvent.VK_S)
                p1=state.NONE;
            if(e.getKeyCode()==KeyEvent.VK_UP || e.getKeyCode()==KeyEvent.VK_DOWN)
                p2=state.NONE;

        }


    }
    enum state{
        UP,
        DOWN,
        NONE;

    }




}
