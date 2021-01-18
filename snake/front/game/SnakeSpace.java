package front.game;

import logic.instance.Point;
import logic.instance.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class SnakeSpace {
    private JPanel panel1;
    private JFrame headFrame;
    private Label[][] arrayOfLabels;
    private int prizeX, prizeY;

    public SnakeSpace()  {
        headFrame = new JFrame("Snake ;)");
        arrayOfLabels = new Label[16][16];
    }

    public void buildFrame()
    {
        headFrame.setSize(1200, 1200);
        headFrame.setFocusable(true);
        headFrame.setLayout(new GridLayout(16, 16, 2 ,2 ));
        headFrame.setResizable(false);
        headFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        headFrame.setVisible(true);
        headFrame.setBackground(Color.BLUE);
        headFrame.setForeground(Color.BLUE);
        fillHeadFrame();
    }

    private void fillHeadFrame()  {
        for (int i = 0; i < arrayOfLabels.length; i++)
            for (int j = 0; j < arrayOfLabels[0].length; j++) {
                arrayOfLabels[i][j] = new Label();
                arrayOfLabels[i][j].setSize(10, 10);
                arrayOfLabels[i][j].setBackground(new Color(107, 106, 104));
                arrayOfLabels[i][j].setForeground(new Color(107, 106, 104));
            }

        for (int i = 0; i < arrayOfLabels.length; i++)
            for (int j = 0; j < arrayOfLabels[0].length; j++) {
                headFrame.getContentPane().add(arrayOfLabels[i][j]);
            }

    }

    public void addSnake(Snake snake)
    {
        Point point = new Point(snake.getHead().getX(), snake.getHead().getY());
        arrayOfLabels[point.getX()][point.getY()].setBackground(new Color(102, 0,0));
        arrayOfLabels[point.getX()][point.getY()].setForeground(new Color(102, 0,0));

        for(int i = 0 ; i < snake.getTail().length; i++) {
            arrayOfLabels[snake.getTail()[i].getX()][snake.getTail()[i].getY()].setBackground(new Color(0, 102, 51));
            arrayOfLabels[snake.getTail()[i].getX()][snake.getTail()[i].getY()].setForeground(new Color(0, 102, 51));
        }


    }
    public void prize(Point point)
    {
        arrayOfLabels[point.getX()][point.getY()].setBackground(Color.WHITE);
        arrayOfLabels[point.getX()][point.getY()].setForeground(Color.WHITE);
        prizeX = point.getX();
        prizeY = point.getY();

    }

    public void deleteSnake()
    {
        for (int i = 0; i < arrayOfLabels.length; i++)
            for (int j = 0; j < arrayOfLabels[0].length; j++) {
                    arrayOfLabels[i][j].setBackground(new Color(107, 106, 104));
                    arrayOfLabels[i][j].setForeground(new Color(107, 106, 104));

                    if(i == prizeX && j == prizeY)
                    {
                        arrayOfLabels[i][j].setBackground(Color.WHITE);
                        arrayOfLabels[i][j].setForeground(Color.WHITE);
                    }

            }
    }

    public void addKeyListener(KeyListener keyListener)
    {
        headFrame.addKeyListener(keyListener);
    }



}
