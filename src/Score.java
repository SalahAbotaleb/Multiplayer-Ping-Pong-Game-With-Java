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
        g.setColor(Color.white);
        g.drawLine(GAME_WIDTH/2,0,GAME_WIDTH/2,GAME_HEIGHT);
        g.setFont(new Font("Consolas",Font.PLAIN,60));
        g.drawString(String.valueOf(player2Score/10)+String.valueOf(player2Score%10),(GAME_WIDTH/2)-85,50);
        g.drawString(String.valueOf(player1Score/10)+String.valueOf(player1Score%10),(GAME_WIDTH/2)+20,50);
    }
}
