import greenfoot.*; 
import java.util.List; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Robot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Robot extends SpriteSheet{
    private Level_1 myworld;
    private boolean canMove = true, isMoving = false;
    String getKey = "";

    int img_cell = 32;
    int img = 0;
    GreenfootImage alex = new GreenfootImage("alex.png");
    final int IMG_WIDTH = alex.getWidth()/6;
    final int IMG_HEIGHT = alex.getHeight()/4;
    
    public Robot(){
        setImage(getSprite(alex, 0, 0, 32, 32, IMG_WIDTH, IMG_HEIGHT));
    }

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
            getKey = "right";
            animation();
            
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
    
    public void animation(){
        if (getKey == "right"){
            for (int i = 0; i < alex.getWidth())
            setImage(getSprite(alex, img,  img_cell*2, img_cell, img_cell*3, IMG_WIDTH, IMG_HEIGHT));
            setImage(getSprite(alex, img_cell,  img_cell*2, img_cell*2, img_cell*3, IMG_WIDTH, IMG_HEIGHT));
            //setImage(getSprite(alex, img_cell*2,  img_cell*2, img_cell, img_cell*3, IMG_WIDTH, IMG_HEIGHT));
        }
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
