package front.game;

import javax.swing.*;
import java.awt.*;

public class End {
    private JPanel panel1;
    private JTextArea endArea;
    private JFrame headFrame;
    private int score;
    private String time;

    public End(int score, String time)  {
        this.score = score;
        this.time = time;
        headFrame = new JFrame("Game Over");
        endArea.append("\nScore: " + score +"\nTime: " + time);
        headFrame.getContentPane().add(endArea);
        headFrame.setSize(400, 400);
        headFrame.setFocusable(true);
        headFrame.setResizable(false);
        headFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        headFrame.setVisible(true);
        headFrame.setBackground(Color.BLACK);
        headFrame.setForeground(Color.BLACK);
    }


}
