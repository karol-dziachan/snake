package front.game;

import logic.instance.Point;
import logic.instance.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeSpace {
    private JPanel panel1;
    private JFrame headFrame;
    private Button[][] arrayOfButtons;
    private int prizeX, prizeY;

    public SnakeSpace()  {
        headFrame = new JFrame("Snake ;)");
        arrayOfButtons = new Button[16][16];
    }

    public void buildFrame()
    {
        headFrame.setSize(1200, 1200);
        headFrame.setFocusable(true);
        headFrame.setLayout(new GridLayout(16, 16, 0 ,0 ));
        headFrame.setResizable(false);
        headFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        headFrame.setVisible(true);
        headFrame.setBackground(Color.BLACK);
        headFrame.setForeground(Color.BLACK);
        fillHeadFrame();
    }

    private void fillHeadFrame()  {
        for (int i = 0; i < arrayOfButtons.length; i++)
            for (int j = 0; j < arrayOfButtons[0].length; j++) {
                arrayOfButtons[i][j] = new Button();
                arrayOfButtons[i][j].setSize(10, 10);
                arrayOfButtons[i][j].setBackground(Color.BLACK);
                arrayOfButtons[i][j].setForeground(Color.BLACK);
            }

        for (int i = 0; i < arrayOfButtons.length; i++)
            for (int j = 0; j < arrayOfButtons[0].length; j++) {
                headFrame.getContentPane().add(arrayOfButtons[i][j]);
            }

    }

    public void addSnake(Snake snake)
    {
        Point point = new Point(snake.getHead().getX(), snake.getHead().getY());
        arrayOfButtons[point.getX()][point.getY()].setBackground(Color.RED);
        arrayOfButtons[point.getX()][point.getY()].setForeground(Color.RED);

        for(int i = 0 ; i < snake.getTail().length; i++) {
            arrayOfButtons[snake.getTail()[i].getX()][snake.getTail()[i].getY()].setBackground(Color.GREEN);
            arrayOfButtons[snake.getTail()[i].getX()][snake.getTail()[i].getY()].setForeground(Color.GREEN);
        }


    }
    public void prize(Point point)
    {
        arrayOfButtons[point.getX()][point.getY()].setBackground(Color.WHITE);
        arrayOfButtons[point.getX()][point.getY()].setForeground(Color.WHITE);
        prizeX = point.getX();
        prizeY = point.getY();

    }

    public void deleteSnake()
    {
        for (int i = 0; i < arrayOfButtons.length; i++)
            for (int j = 0; j < arrayOfButtons[0].length; j++) {
                    arrayOfButtons[i][j].setBackground(Color.BLACK);
                    arrayOfButtons[i][j].setForeground(Color.BLACK);

                    if(i == prizeX && j == prizeY)
                    {
                        arrayOfButtons[i][j].setBackground(Color.WHITE);
                        arrayOfButtons[i][j].setForeground(Color.WHITE);
                    }

            }
    }

    public void addKeyListener(KeyListener keyListener)
    {
        headFrame.addKeyListener(keyListener);
    }



}
