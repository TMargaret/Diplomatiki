import greenfoot.*;
import java.awt.Color;
import java.awt.Font;

//κλάση του τελικού πίνακα ScoreBoard ο οποίος χρησιμοποιείται είτε σε περίπτωση νίκης, είτε ήττας
//author M Kölling
//modifications Trifou Margaret
//BrokenHutMessage, RoomEntranceText, welcomeMsg, taskText1-6,lockedDoor, warningForDoor

public class TextPanel extends Actor
{
    public static final float FONT_SIZE = 24.0f;
    public static final int WIDTH = 540;
    public static final int HEIGHT = 330;
   // public static final int TOTAL_ANSWERS = 6;
    private String status = null;
    private WrittenText text;
    private int counter = 1;
    //private int iScore, lives, wrong_answers = 0;

    private GreenfootImage image;

    public TextPanel(String status)
    {
        this.status = status;
        text = new WrittenText();
        //this.iScore = iScore;
       //wrong_answers = TOTAL_ANSWERS - iScore;
        
    }
    
    public void act()
    {
    }
    
    protected void addedToWorld(World w){
        makeText();
}
    
    private void makeText(){
        if (status == "BrokenHutMessage") {
            String mytext = text.brokenHut();
            makeImage(mytext);
        }
        if (status == "enteringRoom") {
            String mytext = text.enteringRoom();
            makeImage(mytext);
        }
        if (status == "exitRoom") {
            String mytext = text.exitRoom();
            makeImage(mytext);
        }
        if (status == "RoomEntranceText") {
            String mytext = text.roomEntranceText();
            makeImage(mytext);
        }
        if (status == "welcomeMsg") {
            String mytext = text.welcomeMsg();
            makeImage(mytext, "elder");
        }
        if (status == "taskText1") {
            String mytext = text.taskText1();
            makeImage(mytext, "elder");
        }
        if (status == "taskText2") {
            String mytext = text.taskText2();
            makeImage(mytext, "elder");
        }
        if (status == "taskText3") {
            String mytext = text.taskText3();
            makeImage(mytext, "elder");
        }
        if (status == "taskText4") {
            String mytext = text.taskText4();
            makeImage(mytext, "elder");
        }
        if (status == "taskText5") {
            String mytext = text.taskText5();
            makeImage(mytext, "elder");
        }
        if (status == "taskText6") {
            String mytext = text.taskText6();
            makeImage(mytext, "elder");
        }
        if (status == "lockedDoor") {
            String mytext = text.lockedDoor();
            makeImage(mytext);
        }
        if (status == "wrongKey"){
            String mytext = text.warningDoor();
            makeImage(mytext, "elder");
        }
    }
    
    private void makeImage(String title)
    //δημιουργείται η εικόνα του ScoreBoard
    {
        image = new GreenfootImage(WIDTH, HEIGHT);
        image.setColor(new Color(0,255,200, 128));
        image.fillRect(0, 0, image.getWidth(),image.getHeight());
        image.setColor(new Color(200, 130, 120, 128));
        image.fillRect(5, 5, image.getWidth()- 10, image.getHeight()-10);
        Font font = image.getFont();
        font = font.deriveFont(22.0f);
        image.setFont(font);
        image.setColor(Color.YELLOW);
        image.drawString(title, 5, 30);
        //image.drawString(prefix, 60, 150);
        //ανάλογα με την περίπτωση εμφανίζεται το κατάλληλο μήνυμα
        if ((status == "BrokenHutMessage") || (status == "RoomEntranceText")
        || (status == "welcomeMsg")) image.drawString("Πάτα ENTER", 30, 290);
        if (status == "lockedDoor") image.drawString("Πάτα ENTER", 30, 290);
        // if (status == "start1_1" | status == "start2_1") image.drawString("Πάτα το ΚΑΤΩ ΒΕΛΟΣ", 60, 300);
        // if (status == "start1_2") image.drawString("Πάτα SPACE για να ξεκινήσεις", 60, 300);
        // if (status == "start2") image.drawString("Πάτα ENTER", 200, 280);
        // if (status == "start_quiz") image.drawString("Πάτα ENTER", 200, 280);
        // if (status == "start_quiz2") image.drawString("Πάτα ENTER για να ξεκινήσεις", 60, 280);
        setImage(image);
 
    }
    
        private void makeImage(String title, String icon)
    //δημιουργείται η εικόνα του ScoreBoard
    {
        image = new GreenfootImage(WIDTH, HEIGHT);
        image.setColor(new Color(130,24,24, 255));
        image.fillRect(0, 0, image.getWidth(),image.getHeight());
        image.setColor(new Color(200, 163, 92, 100));
        image.fillRect(5, 5, image.getWidth()- 10, image.getHeight()-10);
        image.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        image.setColor(Color.WHITE);
        image.drawString(title, 30, 50);
        //ανάλογα με την περίπτωση εμφανίζεται το κατάλληλο μήνυμα
       if (status == "welcomeMsg" || status == "taskText1" || status == "taskText2") image.drawString("Πάτα ENTER", 30, 290);
       if (status == "taskText3" || status == "taskText4" || status == "taskText5") image.drawString("Πάτα ENTER", 30, 290);
       if (status == "taskText6" || status == "wrongKey") image.drawString("Πάτα ENTER", 30, 290);
        setImage(image);
    }
  
}