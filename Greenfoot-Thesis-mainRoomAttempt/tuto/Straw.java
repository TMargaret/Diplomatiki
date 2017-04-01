import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Straw here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Straw extends Actor
{
    private HiddenSprite hs;
    /**
     * Act - do whatever the Straw wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
        protected void addHiddenSprite() {   
        hs = new HiddenSprite(this, getImage().getWidth() + getImage().getWidth()/2 , 40, 10, 5, true);  
        getWorld().addObject(hs, getX(), getY()); 
    }

    public void elderDialogue(){

        if( hs.getWorld() != null ) {   
            List<Actor> things = hs.getHitBoxIntersections();    
            if( things.size() > 1 ) {      
                int infront = 0;      
                for(int i=0; i < things.size(); i++ ) {       
                    Actor a = things.get(i);        
                    if(a instanceof HiddenSprite)        
                        continue;        
                    if( a instanceof Alex) {
                    }
                }
            }
        }
    }
}
