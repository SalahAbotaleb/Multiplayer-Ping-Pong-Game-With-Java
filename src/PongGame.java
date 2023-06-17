import java.awt.*;
import java.util.*;
import javax.swing.*;
public class PongGame {
    public static void main(String[] args)
    {
        /*PongGame instantiates GameFrame which contains only basic
        * configurations of the Frame while GameFrame instantiates GamePanel
        * which is responsible for the following:
        * 1. adding a new thread
        * 2. initialize the panel size
        * 3. have the run method that infinitely runs till the close of the app
        * 4. instantiate Paddle, Ball and Score objects
        * 5. call appropriate functions from Paddle, Ball and Score objects upon occurrence of specific events
        *  */
        GameFrame frame=new GameFrame();
    }

}
