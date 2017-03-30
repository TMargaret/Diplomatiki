import greenfoot.*; 
import java.awt.Color; 
import java.util.*;

public class HiddenSprite extends Actor {  
    GreenfootImage body;  
    int offsetX;  
    int offsetY;  
    Actor host;    
    
    public HiddenSprite(Actor a, int w, int h, int dx, int dy, boolean visible) {    
        host = a;   
        offsetX = dx;    
        offsetY = dy;    
        body = new GreenfootImage(w, h);    
        if( visible ) {      
            // Transparency values range from 0 (invisible) to 255 (opaque) 
            body.setColor(Color.RED);
            body.fill();
            body.setTransparency(0);          
        }    
        setImage(body);  
    }    
    
    public void act() {    
        if( host.getWorld() != null ) {      
            setLocation(host.getX()+offsetX, host.getY()+offsetY);    
        } else {      
            getWorld().removeObject(this);    
        }  
    }    
    
    public List getHitBoxIntersections() {    
        return getIntersectingObjects(Actor.class);  
    } 
}
