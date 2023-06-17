import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Score extends Rectangle {
    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    int player1Score;
    int player2Score;
    Score(int GAME_WIDTH,int GAME_HEIGHT) {
        this.GAME_WIDTH=GAME_WIDTH;
        this.GAME_HEIGHT=GAME_HEIGHT;
        player1Score=0;
        player2Score=0;
    }

    public void draw(Graphics g) {
        //responsible for drawing the score of the 2 players at the middle top of the screen and to be called by the draw function in the GamePanel

    }
}
