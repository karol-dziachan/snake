package front.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Reaction  implements KeyListener {

    private int actualTurn;

    public Reaction()
    {
        actualTurn = 3;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 0 - turn left , 1 - turn right
    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            actualTurn = 1;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            actualTurn = 0;
        }
    }

    public int getTurn()
    {
        return actualTurn;
    }

    public void setTurn()
    {
        actualTurn = -1;
    }
}
