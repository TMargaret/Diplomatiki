import greenfoot.*;
import java.util.ArrayList;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class mainHouseRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mainHouseRoom extends World
{
    Robot robot;
    Elder elder;
    Door door, door2;
    Lumber lumber, lumber2;
    Clay clay, clay2;
    int counter = 100, counter2 = 25, flag = 0;
    boolean isActive = false;
    private TextPanel textPanel, entranceText;
    private ArrayList <Door> doorList = new ArrayList<Door>();
    private ArrayList <Lumber> lumberList = new ArrayList<Lumber>();
    private ArrayList<Clay> clayList = new ArrayList<Clay>();
    HealthBar healthBar;
    HealthLogo healthLogo;

    /**
     * Constructor for objects of class mainHouseRoom.
     * 
     */
    public mainHouseRoom()
    {
        super(1000, 600, 1);
        prepare();

    }

    public void act(){
        gameOver();
        enterRoomText();
        exitRoom();
        boolean doNotMove = false;
        if (elder.getTalking() || (flag == 1) || (isActive)){
            doNotMove  = true;
        }
        for(Door door : doorList){
            if (door.getActive()){
                doNotMove  = true;
            }
        }
        for(Lumber lumber : lumberList){
            if (lumber.getActive()){
                doNotMove  = true;
            }
        }
        for(Clay clay : clayList){
            if (clay.getActive()){
                doNotMove  = true;
            }
        }
        robot.setCanMove(!doNotMove);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void prepare()
    {
        // put your code here
        GreenfootImage image = new GreenfootImage(getWidth(), getHeight());
        image.setColor(java.awt.Color.BLACK);
        image.fill();
        setBackground(image);

        door = new Door();
        addObject(door,713,225);

        door2 = new Door();
        addObject(door2,321,406);

        doorList.add(door);
        doorList.add(door2);

        addWall();

        robot = new Robot();
        addObject(robot,80, 90);

        elder = new Elder();
        addObject(elder,900,500);

        clay = new Clay();
        addObject(clay,910,85);
        clay2 = new Clay();
        addObject(clay2,910,230);

        clayList.add(clay);
        clayList.add(clay2);

        lumber = new Lumber();
        addObject(lumber,100,400);
        lumber2 = new Lumber();
        addObject(lumber2,100,528);  

        lumberList.add(lumber);
        lumberList.add(lumber2);

        healthBar = new HealthBar();
        addObject(healthBar, healthBar.getImage().getWidth(), healthBar.getImage().getHeight());

        healthLogo = new HealthLogo();
        addObject(healthLogo,20,20);
    }

    public void addWall(){
        Wall[] wall = new Wall[25];
        Wall[] wall2 = new Wall[25];

        //Room with Clay
        Wall wall79 = new Wall();
        addObject(wall79,712,81);
        wall79.setRotation(90);

        Wall wall80 = new Wall();
        addObject(wall80,958,294);

        Wall wall81 = new Wall();
        addObject(wall81,876,294);

        Wall wall82 = new Wall();
        addObject(wall82,795,294);

        Wall wall83 = new Wall();
        addObject(wall83,735,294);

        Wall wall84 = new Wall();
        addObject(wall84,712,137);
        wall84.setRotation(90);

        //Room with Wood
        Wall wall71 = new Wall();
        addObject(wall71,82,340);

        Wall wall72 = new Wall();
        addObject(wall72,164,340);

        Wall wall73 = new Wall();
        addObject(wall73,246,340);

        Wall wall74 = new Wall();
        addObject(wall74,301,340);

        Wall wall75 = new Wall();
        addObject(wall75,321,547);
        wall75.setRotation(90);

        Wall wall76 = new Wall();
        addObject(wall76,321,490);
        wall76.setRotation(90);

        //builds the right vertical paths
        for(int i=0; i<=getHeight(); i+= 80)
        {
            Wall wall_vert = new Wall();
            addObject(wall_vert, getWidth() - wall_vert.getImage().getWidth()/4,i);
            wall_vert.setRotation(90);
        }

        //builds the left vertical paths
        for(int i=150; i<=getHeight(); i+= 80)
        {
            Wall wall_vert2 = new Wall();
            addObject(wall_vert2, wall_vert2.getImage().getWidth()/4 ,i );
            wall_vert2.setRotation(90);
        }

        for(int j=0; j<wall.length; j++){
            wall[j]=new Wall();
            wall2[j] = new Wall();
            addObject(wall[j],j*wall[j].getImage().getWidth(), wall[j].getImage().getHeight()/2);
            addObject(wall2[j],j*wall2[j].getImage().getWidth(), getHeight() - wall[j].getImage().getHeight()/2);
        }

    }

    public void enterRoomText(){
        counter2--;
        if (counter2 < 0 && flag == 0){
            entranceText = new TextPanel("RoomEntranceText");
            addObject(entranceText, getWidth()/2, getHeight()/2);
            flag = 1;
        }
        if (Greenfoot.isKeyDown("enter")){
            counter2 = 50;
            removeObject(entranceText);
            flag = 2;
        }
    }

    public void exitRoom(){
        if (robot.isAtEdge()){
            counter--;
            if (!isActive){
                textPanel = new TextPanel("exitRoom");
                addObject(textPanel, getWidth()/2, getHeight()/2);
                isActive = true;
            }
        }
        if (counter < 0){
            removeObject(textPanel);
            Greenfoot.setWorld(new Level_1());
        }      
    }

    public HealthBar getHealthBar(){
        return healthBar;
    }

    public void gameOver(){
        if (healthBar.getHealth() <= 0)
            Greenfoot.stop();
    }

}
