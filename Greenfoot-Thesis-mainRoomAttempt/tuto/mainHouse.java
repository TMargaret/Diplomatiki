import greenfoot.*; 
import java.util.List; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Place2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mainHouse extends Actor
{
    int counter = 100;
    boolean isActive = false, displayMessage = false;
    private TextPanel textPanel;
    /**
     * Act - do whatever the Place2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        enterInRoom();
    } 

    public boolean getActive(){
        return displayMessage;
    }

    /**
     * shows a message before entering the house
     */
    public void enterInRoom(){
        if (getOneIntersectingObject(Robot.class) != null){
            counter--;
            if (!isActive){
                textPanel = new TextPanel("enteringRoom");
                getWorld().addObject(textPanel, getWorld().getWidth()/2, getWorld().getHeight()/2);
                isActive = true;
                displayMessage = true;
            }
        }
        if (counter < 0){
            getWorld().removeObject(textPanel);
            displayMessage = false;
            isActive = false;
            Greenfoot.setWorld(new mainHouseRoom());
        }      
    }  
}
