import greenfoot.*; 
import java.util.List; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends Actor
{
    int counter = 5, firstMessageFlag = 0;
    boolean isActive = false, enableTextField = false, isEDown = false, tryAgainOrLeave = false;
    boolean wrongCommand = false;
    private TextPanel textPanel, textPanel2;
    private HiddenSprite hs;
    TextField textField;
    String my_text = "";
    Elder myElder;

    /**
     * Act - do whatever the Door wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        canSeeRobot();
    } 

    protected void addedToWorld(World w)
    {
        addHiddenSprite();
    }

    protected void addHiddenSprite() {   
        hs = new HiddenSprite(this, getImage().getWidth() + getImage().getWidth()/2 , 50, 0, 0, true);  
        getWorld().addObject(hs, getX(), getY()); 
    }

    public void canSeeRobot(){
        if( hs.getWorld() != null ) {   
            List<Actor> things = hs.getHitBoxIntersections();    
            if( things.size() > 1 ) {      
                int infront = 0;      
                for(int i=0; i < things.size(); i++ ) {       
                    Actor a = things.get(i);        
                    if(a instanceof HiddenSprite)        
                        continue;        
                    if( a instanceof Robot) {  
                        counter--;
                        if (Greenfoot.isKeyDown("e")){
                            isEDown = true;
                        }
                        if (counter<0 && !isActive && isEDown){
                            counter = 50;
                            textPanel = new TextPanel("lockedDoor");
                            getWorld().addObject(textPanel, getWorld().getWidth()/2, getWorld().getHeight()/2);
                            isActive = true;
                        }
                        if (Greenfoot.isKeyDown("enter") && isEDown && !enableTextField){
                            counter = 40;
                            getWorld().removeObject(textPanel);
                            setTextField(true);
                            textField = new TextField(700, 45, "Δημιούργησε ένα αντικείμενο Key και πάτα enter");
                            getWorld().addObject(textField, textField.getImage().getWidth()/2, getWorld().getHeight() - textField.getImage().getHeight()/2);
                        }
                        if (Greenfoot.mouseClicked(textField) || Greenfoot.isKeyDown("backspace")){
                            textField.setText("");
                        }
                        if (Greenfoot.isKeyDown("enter") && counter<0 && enableTextField && isEDown){
                            counter = 30;
                            my_text = textField.getText();

                            if (my_text.contains("new Key();"))
                            {
                                getWorld().removeObject(textField);
                                isActive = false;
                                getWorld().removeObject(this);                     
                                break;
                            }
                            else {
                                checkHealthBar();
                                textPanel2 = new TextPanel("wrongKey");
                                getWorld().addObject(textPanel2, getWorld().getWidth()/2, getWorld().getHeight()/2);
                                tryAgainOrLeave = true;
                                isEDown = false;                             
                           }
                        }
                        if (Greenfoot.isKeyDown("enter") && counter < 0 && tryAgainOrLeave){
                            counter = 40;
                            isEDown = false;
                            isActive = false;
                            setTextField(false);
                            tryAgainOrLeave = false;
                            getWorld().removeObject(textPanel2);

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

    public void setTextField(boolean activeTextField){
        enableTextField = activeTextField;
    }

    public boolean getTextField(){
        return enableTextField;
    }

    public boolean getActive(){
        return isActive;
    }

    public void setActive(boolean active){
        isActive = active;
        counter = 30;
    }

}