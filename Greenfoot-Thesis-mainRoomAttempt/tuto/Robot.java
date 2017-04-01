import greenfoot.*; 
import java.util.List; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * 
 * @author (Margaret) 
 * @version (a version number or a date)
 */
public class Robot{
    private Level_1 myworld;
    private boolean canMove = true, isMoving = false;
    boolean flagForImage = false, bothDirections = false;
    String getKeyBoth = "", getKey = "";
    int img_cell = 32;
    int img = 0;
    int delay = 0;
    GreenfootImage alex = new GreenfootImage("alex.png");
    final int IMG_WIDTH = alex.getWidth()/6;
    final int IMG_HEIGHT = alex.getHeight()/4;

    /**
     * Constructor
     */
    public Robot(){
       // setImage(getSprite(alex, img_cell*3,  img_cell*2, img_cell*4, img_cell*3, IMG_WIDTH, IMG_HEIGHT));
    }

    /**
     * Act - do whatever the Alex wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    // public void act() 
    // {
        // move(5);  
    // }

    // /**
     // * Setter method - sets the move state of Alex
     // */
    // public void setCanMove(boolean moveStatus){
        // canMove = moveStatus;
    // }

    // /**
     // * Move method - gives movement to Alex
     // */
    // public void move(int moveAmt){

        // // determine direction by keypress checking
        // if (!canMove){
            // return;
        // }

        // int dx = 0, dy = 0;
        // //checking which button(s) is/are pressed
        // if (Greenfoot.isKeyDown("down") && Greenfoot.isKeyDown("right")) {
            // getKeyBoth = "downRight";
            // animation();
        // }
        // if (Greenfoot.isKeyDown("down") && Greenfoot.isKeyDown("left")) {
            // getKeyBoth = "downLeft";
            // animation();
        // }
        // if (Greenfoot.isKeyDown("up") && Greenfoot.isKeyDown("right")) {
            // getKeyBoth = "upRight";
            // animation();
        // }
        // if (Greenfoot.isKeyDown("up") && Greenfoot.isKeyDown("left")) {
            // getKeyBoth = "upLeft";
            // animation();
        // }
        // if (Greenfoot.isKeyDown("right")) {
            // dx += 1;
            // getKey = "right";
            // animation();
        // }
        // if (Greenfoot.isKeyDown("left")) {
            // dx -= 1;
            // getKey = "left";
            // animation();
        // }
        // if (Greenfoot.isKeyDown("down")) {
            // dy += 1;
            // getKey = "down";
            // animation();
        // }
        // if (Greenfoot.isKeyDown("up")) {
            // dy -= 1;
            // getKey = "up";
            // animation();
        // }
        // //initializes the getKey variables
        // initGetKey();

        // //check for wall on each step of move in both vertical and horizontal directions
        // for (int i = 0; i < moveAmt; i++)
        // {
            // setLocation(getX() + dx, getY());
            // if ((getOneIntersectingObject(Wall.class) != null) || 
            // (getOneIntersectingObject(Grass.class) != null) || 
            // (getOneIntersectingObject(Elder.class) != null) || 
            // (getOneIntersectingObject(Door.class) != null) ||
            // (getOneIntersectingObject(Lumber.class) !=null) ||
            // (getOneIntersectingObject(Clay.class) !=null) ||
            // (getOneIntersectingObject(Straw.class) !=null)){ 
                // setLocation(getX() - dx, getY());
            // }
            // setLocation(getX(), getY() + dy);
            // if ((getOneIntersectingObject(Wall.class) != null)
            // || (getOneIntersectingObject(Grass.class) != null) 
            // || (getOneIntersectingObject(Elder.class) != null) 
            // || (getOneIntersectingObject(Door.class) != null)
            // || (getOneIntersectingObject(Lumber.class) !=null)
            // || (getOneIntersectingObject(Clay.class) !=null)
            // || (getOneIntersectingObject(Straw.class) !=null)){
                // setLocation(getX(), getY() - dy);
            // }
        // }
    // }

    // /**
     // * Gives animation to Alex - 8 different cases, 16 different images
     // */
    // public void animation(){
        // delay--;

        // if (getKeyBoth == "downRight"){  
            // if (delay<0 && !flagForImage){
                // setImage(getSprite(alex, img_cell*3,  img_cell*2, img_cell*4, img_cell*3, IMG_WIDTH, IMG_HEIGHT));
                // delay = 20;
                // flagForImage = true;
            // }
            // if (delay < 0 && flagForImage){
                // setImage(getSprite(alex, img_cell*4,  img_cell*2, img_cell*5, img_cell*3, IMG_WIDTH, IMG_HEIGHT));
                // flagForImage = false;
                // delay = 20;
            // }
        // }
        // if (getKeyBoth == "downLeft"){  
            // if (delay<0 && !flagForImage){
                // setImage(getSprite(alex, img_cell*3,  img, img_cell*4, img_cell, IMG_WIDTH, IMG_HEIGHT));
                // delay = 20;
                // flagForImage = true;
            // }
            // if (delay < 0 && flagForImage){
                // setImage(getSprite(alex, img_cell*4,  img, img_cell*5, img_cell, IMG_WIDTH, IMG_HEIGHT));
                // flagForImage = false;
                // delay = 20;
            // }
        // }
        // if (getKeyBoth == "upRight"){  
            // if (delay<0 && !flagForImage){
                // setImage(getSprite(alex, img_cell*3,  img_cell*3, img_cell*4, img_cell*4, IMG_WIDTH, IMG_HEIGHT));
                // delay = 20;
                // flagForImage = true;
            // }
            // if (delay < 0 && flagForImage){
                // setImage(getSprite(alex, img_cell*4,  img_cell*3, img_cell*5, img_cell*4, IMG_WIDTH, IMG_HEIGHT));
                // flagForImage = false;
                // delay = 20;
            // }
        // }
        // if (getKeyBoth == "upLeft"){  
            // if (delay<0 && !flagForImage){
                // setImage(getSprite(alex, img_cell*3,  img_cell, img_cell*4, img_cell*2, IMG_WIDTH, IMG_HEIGHT));
                // delay = 20;
                // flagForImage = true;
            // }
            // if (delay < 0 && flagForImage){
                // setImage(getSprite(alex, img_cell*4,  img_cell, img_cell*5, img_cell*2, IMG_WIDTH, IMG_HEIGHT));
                // flagForImage = false;
                // delay = 20;
            // }
        // }
        // if (getKey == "right"){
            // if (delay<0 && !flagForImage){
                // setImage(getSprite(alex, img,  img_cell*2, img_cell, img_cell*3, IMG_WIDTH, IMG_HEIGHT));
                // delay = 10;
                // flagForImage = true;
            // }
            // if (delay < 0 && flagForImage){
                // setImage(getSprite(alex, img_cell,  img_cell*2, img_cell*2, img_cell*3, IMG_WIDTH, IMG_HEIGHT));
                // flagForImage = false;
                // delay = 10;
            // }
        // }
        // if (getKey == "left"){   
            // if (delay<0 && !flagForImage){
                // setImage(getSprite(alex, img,  img_cell, img_cell, img_cell*2, IMG_WIDTH, IMG_HEIGHT));
                // delay = 10;
                // flagForImage = true;
            // }
            // if (delay < 0 && flagForImage){
                // setImage(getSprite(alex, img_cell,  img_cell, img_cell*2, img_cell*2, IMG_WIDTH, IMG_HEIGHT));
                // flagForImage = false;
                // delay = 10;
            // }
        // }
        // if (getKey == "up"){   
            // if (delay<0 && !flagForImage){
                // setImage(getSprite(alex, img,  img_cell*3, img_cell, img_cell*4, IMG_WIDTH, IMG_HEIGHT));
                // delay = 10;
                // flagForImage = true;
            // }
            // if (delay < 0 && flagForImage){
                // setImage(getSprite(alex, img_cell,  img_cell*3, img_cell*2, img_cell*4, IMG_WIDTH, IMG_HEIGHT));
                // flagForImage = false;
                // delay = 10;
            // }
        // }
        // if (getKey == "down"){   
            // if (delay<0 && !flagForImage){
                // setImage(getSprite(alex, img,  img, img_cell, img_cell, IMG_WIDTH, IMG_HEIGHT));
                // delay = 10;
                // flagForImage = true;
            // }
            // if (delay < 0 && flagForImage){
                // setImage(getSprite(alex, img_cell,  img, img_cell*2, img_cell, IMG_WIDTH, IMG_HEIGHT));
                // flagForImage = false;
                // delay = 10;
            // }
        // }

    // }

    // /**
     // * Return true if we can see an object of class 'clss' right where we are. 
     // * False if there is no such object here.
     // */
    // public boolean canSee(Class clss)
    // {
        // Actor actor = getOneObjectAtOffset(0, 0, clss);
        // return actor != null;        
    // }

    // /**
     // * Initializes the getKey and getKeyBoth String variables
     // */
    // public void initGetKey(){
        // getKey = "";
        // getKeyBoth = "";
    // }
}
