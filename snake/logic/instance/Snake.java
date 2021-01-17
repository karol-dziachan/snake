package logic.instance;


public class Snake {
    private Point[] lastPosition;
    private int level;
    private final int maximumLengthSnake;
    private int direction;  //0 - right, 1 - down, 2 - left, 3 - up

    public Snake() {

        maximumLengthSnake = 30;
        lastPosition = new Point[maximumLengthSnake];
        direction = 0;
        level = 0;
        firstPosition();
    }

    public int calculateLength() {
        return level + 5;
    }

    private void firstPosition() {
        lastPosition[0] = new Point(0, 4);
        lastPosition[1] = new Point(0, 3);
        lastPosition[2] = new Point(0, 2);
        lastPosition[3] = new Point(0, 1);
        lastPosition[4] = new Point(0, 0);

        for(int i = 5; i < maximumLengthSnake; i++)
            lastPosition[i] = new Point(0, 0);
    }

    public Point getHead() {
        return lastPosition[0];
    }

    public Point[] getTail() {
        Point[] helperToTail = new Point[calculateLength() - 1];

        if (calculateLength() - 1 >= 0) System.arraycopy(lastPosition, 1, helperToTail, 0, calculateLength() - 1);

        return helperToTail;
    }

    public void addHead(Point point)
    {
        Point[] helperTail = new Point[maximumLengthSnake];
        if (helperTail.length - 1 >= 0) System.arraycopy(lastPosition, 0, helperTail, 1, helperTail.length - 1);

        helperTail[0] = point;

        lastPosition = helperTail;
    }

    public void setDirection(int turn) // 0 - turn left , 1 - turn right
    {                                   //0 - right, 1 - down, 2 - left, 3 - up

        if(direction == 0 && turn == 0)
           setDirectionInside(3);
        else if(direction == 0 && turn == 1)
            setDirectionInside(1);
        else if(direction == 1 && turn == 0)
            setDirectionInside(2);
        else if(direction == 1 && turn == 1)
            setDirectionInside(0);
        else if(direction == 2 && turn == 0)
            setDirectionInside(1);
        else if(direction == 2 && turn == 1)
            setDirectionInside(3);
        else if(direction == 3 && turn == 0)
            setDirectionInside(2);
        else if(direction == 3 && turn == 1)
            setDirectionInside(0);

    }

    private void setDirectionInside(int direction)
    {
        this.direction = direction;
    }

    public void levelUp()
    {
        level++;
    }


    public void move()
    {
        if(direction == 0) {
            if(getHead().getY() < 15)
                addHead(new Point(getHead().getX(), getHead().getY() + 1));
            else
                addHead(new Point(getHead().getX(), 0));
        }
        if(direction == 1)
            if(getHead().getX() < 15)
                addHead(new Point(getHead().getX()+1, getHead().getY()));
            else
                addHead(new Point(0, getHead().getY()));

        if(direction == 2)
            if(getHead().getY() > 0 )
                addHead(new Point(getHead().getX(), getHead().getY()-1));
            else
                addHead(new Point(getHead().getX(), 15));

        if(direction == 3)
            if(getHead().getX() > 0)
                addHead(new Point(getHead().getX()-1, getHead().getY()));
            else
                addHead(new Point(15, getHead().getY()));


    }

    public boolean checkLose()
    {
        for(int i = 1 ; i < calculateLength(); i++)
            if(getHead().getX() == lastPosition[i].getX() && getHead().getY() == lastPosition[i].getY())
                return false;

            return true;
    }

    public int getLevel()
    {
        return level;
    }

    @Override
    public String toString() {
        return "Actual position: ( " + getHead().getX() + " , " +getHead().getY() +" )";
    }
}
