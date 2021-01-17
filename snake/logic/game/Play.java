package logic.game;

import front.game.End;
import front.game.Reaction;
import front.game.SnakeSpace;
import logic.instance.Point;
import logic.instance.Snake;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Play {
    private SnakeSpace snakeSpace;
    private Snake snake;
    private Reaction listener;
    private Point actualPrize;
    private int score;
    private int difficultyLevel;
    long timeElapsed;

    public Play()
    {
        snakeSpace = new SnakeSpace();
        snake = new Snake();
        listener = new Reaction();
        score = 0;
        difficultyLevel = 200;
        timeElapsed = 0;

    }

    public void buildGame() throws InterruptedException {
        snakeSpace.buildFrame();
        snakeSpace.addKeyListener(listener);
        snakeSpace.addSnake(snake);
        drawActualPrize();


        move();
    }
    public void move() throws InterruptedException {

      Instant start = Instant.now();

        while(snake.checkLose()){
            setMoveOnSnake();
            snake.move();

            if(checkWin())
                reactOnWin();

            snakeSpace.addSnake(snake);
            Thread.sleep(difficultyLevel);
            snakeSpace.deleteSnake();
        }

        Instant finish = Instant.now();

        timeElapsed = Duration.between(start, finish).toMillis();

        End end = new End(getScore(), getTime());

    }

    private void setMoveOnSnake()
    {
        snake.setDirection(listener.getTurn());
        listener.setTurn();
    }

    private boolean checkWin()
    {
        if(snake.getHead().getX() == actualPrize.getX() && snake.getHead().getY() == actualPrize.getY())
           return true;
        return false;
    }

    private void reactOnWin()
    {
        snake.levelUp();
        changeDifficultLevel();
        drawActualPrize();
        score+=100;
    }

    private void changeDifficultLevel()
    {
        if(snake.getLevel() <= 2)
            difficultyLevel = 130;
        if(snake.getLevel() > 2 && snake.getLevel() <= 4)
            difficultyLevel = 110;
        if(snake.getLevel() == 5)
            difficultyLevel = 100;
        if(snake.getLevel() >= 6 && snake.getLevel() < 10)
            difficultyLevel = 80;
        if(snake.getLevel() >= 10 && snake.getLevel() <= 13)
            difficultyLevel = 60;
        if(snake.getLevel() > 13&& snake.getLevel() <= 18 )
            difficultyLevel = 50;
        if(snake.getLevel() > 18)
            difficultyLevel = 30;
    }

    public void drawActualPrize()
    {
        Random random = new Random();
        actualPrize = new Point(random.nextInt(16), random.nextInt(16));
        snakeSpace.prize(actualPrize);
    }

    public int getScore()
    {
        return score;
    }

    private String getTime()
    {
        int second = (int) timeElapsed/1000;
        return "" + (int) second/60 + ":" + (int) timeElapsed%60;
    }

}
