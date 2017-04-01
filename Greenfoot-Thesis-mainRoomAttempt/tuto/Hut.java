import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Place here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hut extends Actor
{
    int counter = 10;
    boolean isActive = false, displayMessage = false;
    private TextPanel textPanel;

    /**
     * Act - do whatever the Place wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        canSeeAlex();
    } 

    public boolean getActive(){
        return displayMessage;
    }

    public void canSeeAlex(){
        if (isTouching(Alex.class))
        {
            counter--;
            if (counter<0 && !isActive){

                textPanel = new TextPanel("BrokenHutMessage");
                getWorld().addObject(textPanel, getWorld().getWidth()/2, getWorld().getHeight()/2);
                isActive = true;
                displayMessage = true;
            }
        }
        if (Greenfoot.isKeyDown("enter")){
            counter = 10;
            getWorld().removeObject(textPanel);
            displayMessage = false;

        }
        if (!isTouching(Alex.class))
        {
            isActive = false;

        }
    }
}
