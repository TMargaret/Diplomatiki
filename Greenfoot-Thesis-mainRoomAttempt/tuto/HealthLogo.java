import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthLogo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthLogo extends Actor
{
    
    public HealthLogo(){
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 30, image.getHeight() - 30);
        setImage(image);
    }
    /**
     * Act - do whatever the HealthLogo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
}
