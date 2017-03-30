import greenfoot.*; 
import java.util.List; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Robot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Robot extends SmoothMover
{
    private Level_1 myworld;
    private boolean canMove = true, isMoving = false;

    /**
     * Act - do whatever the Robot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

        move(5);  

    } 

    public void setCanMove(boolean moveStatus){
        canMove = moveStatus;
    }

    public void move(int moveAmt){

        // determine direction by keypress checking
        if (!canMove){
            return;
        }

        int dx = 0, dy = 0;
        if (Greenfoot.getKey() == null){
            isMoving = false;
        }

        if (Greenfoot.isKeyDown("right")) {
            dx += 1;
            isMoving = true;
        }
        if (Greenfoot.isKeyDown("left")) {
            dx -= 1;
            isMoving = true;
        }
        if (Greenfoot.isKeyDown("down")) {
            dy += 1;
            isMoving = true;
        }
        if (Greenfoot.isKeyDown("up")) {
            dy -= 1;
            isMoving = true;
        }

        //check for wall on each step of move in both vertical and horizontal directions
        for (int i = 0; i < moveAmt; i++)
        {
            setLocation(getX() + dx, getY());
            if ((getOneIntersectingObject(Wall.class) != null) || 
            (getOneIntersectingObject(Grass.class) != null) || 
            (getOneIntersectingObject(Elder.class) != null) || 
            (getOneIntersectingObject(Door.class) != null) ||
            (getOneIntersectingObject(Lumber.class) !=null) ||
            (getOneIntersectingObject(Clay.class) !=null) ||
            (getOneIntersectingObject(Straw.class) !=null)){ 
                setLocation(getX() - dx, getY());
            }
            setLocation(getX(), getY() + dy);
            if ((getOneIntersectingObject(Wall.class) != null)
            || (getOneIntersectingObject(Grass.class) != null) 
            || (getOneIntersectingObject(Elder.class) != null) 
            || (getOneIntersectingObject(Door.class) != null)
            || (getOneIntersectingObject(Lumber.class) !=null)
            || (getOneIntersectingObject(Clay.class) !=null)
            || (getOneIntersectingObject(Straw.class) !=null)){
                setLocation(getX(), getY() - dy);
            }
        }
        //isMoving = false;
    }

    /**
     * Return true if we can see an object of class 'clss' right where we are. 
     * False if there is no such object here.
     */
    public boolean canSee(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
    }

    public boolean getIsMoving(){
        return isMoving;
    }

}
