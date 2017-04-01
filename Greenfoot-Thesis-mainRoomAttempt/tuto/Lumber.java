import greenfoot.*;
import java.util.List;   // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lumber here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lumber extends Actor
{
    private HiddenSprite hs;
    boolean isEDown = false, isActive = false, tryAgainOrLeave = false;
    boolean wrongCommand = false;
    TextField textField;
    int counter = 30;
    String my_text = "";
    TextPanel textPanel;
    /**
     * Act - do whatever the Lumber wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void Lumber() 
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 10, image.getHeight() - 10);
        setImage(image);
    }

    public void act() 
    {
        lumberCreation();
    } 

    protected void addedToWorld(World w)
    {
        addHiddenSprite();
    }

    protected void addHiddenSprite() {   
        hs = new HiddenSprite(this, getImage().getWidth() + getImage().getWidth()/2 , 40, 10, 5, true);  
        getWorld().addObject(hs, getX(), getY()); 
    }

    public void lumberCreation(){

        if( hs.getWorld() != null ) {   
            List<Actor> things = hs.getHitBoxIntersections();    
            if( things.size() > 1 ) {      
                int infront = 0;      
                for(int i=0; i < things.size(); i++ ) {       
                    Actor a = things.get(i);        
                    if(a instanceof HiddenSprite)        
                        continue;        
                    if( a instanceof Alex) {
                        counter--;
                        if (Greenfoot.isKeyDown("e") & !isEDown){
                            isEDown = true;
                        }
                        if (counter<0 && !isActive && isEDown){
                            isActive = true;
                            textField = new TextField(700, 45, "Δημιούργησε ένα αντικείμενο Wood και πάτα enter");
                            getWorld().addObject(textField, textField.getImage().getWidth()/2, getWorld().getHeight() - textField.getImage().getHeight()/2);
                        }
                        if (Greenfoot.mouseClicked(textField) || Greenfoot.isKeyDown("backspace")){
                            textField.setText("");
                        }
                        if (Greenfoot.isKeyDown("enter") && isEDown){
                            counter = 30;
                            my_text = textField.getText();

                            if (my_text.contains("new Wood();"))
                            {
                                getWorld().removeObject(textField);
                                getWorld().removeObject(this);
                                isActive = false;
                                break;
                            }
                            else {
                                checkHealthBar();
                                getWorld().removeObject(textField);
                                textPanel= new TextPanel("wrongKey");
                                getWorld().addObject(textPanel, getWorld().getWidth()/2, getWorld().getHeight()/2);
                                tryAgainOrLeave = true;
                                isEDown = false;
                            }
                        }
                        if (Greenfoot.isKeyDown("enter") && counter < 0 && tryAgainOrLeave){
                            counter = 40;
                            isEDown = false;
                            isActive = false;
                            tryAgainOrLeave = false;
                            getWorld().removeObject(textPanel);
                        }
                    }
                    wrongCommand = false;
                }
            }
        }
    }
    
    public void checkHealthBar(){
        mainHouseRoom mainHouseRoom = (mainHouseRoom)getWorld();
        HealthBar healthBar = mainHouseRoom.getHealthBar();
        getWorld().removeObject(textField);
        if (!wrongCommand){
            wrongCommand = true;
            healthBar.looseHealth();
        }
    }

    public boolean getActive(){
        return isActive;
    }
}
