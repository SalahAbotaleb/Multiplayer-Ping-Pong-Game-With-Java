import java.awt.*;
import java.util.*;
import javax.swing.*;
public class GameFrame extends JFrame {

    GamePanel panel;
    GameFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        panel=new GamePanel();
        this.add(panel);
        this.setResizable(false);
        this.setBackground(Color.BLACK); // color here or in gamePanel?
        this.setTitle("Pong Game by Salah");
        this.setVisible(true);
        this.pack();


    }

}
