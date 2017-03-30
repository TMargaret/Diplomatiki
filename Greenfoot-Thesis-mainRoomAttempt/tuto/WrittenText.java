import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WrittenText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WrittenText
{
    /**
     * Act - do whatever the WrittenText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public WrittenText(){
    }   
    
    public String brokenHut(){
        
        return "Η καλύβα αυτή φαίνεται ετοιμόρροπη.\nΚαλύτερα να τη φτιάξω πριν μπω.";
    }
    
    public String enteringRoom(){
        return "Είσοδος στο σπίτι...";
    }
    
    public String exitRoom(){
        return "Έξοδος...";
    }
    
    public String roomEntranceText(){
        return "Τι περίεργο σπίτι! \nΑ να κι ένα πλάσμα!\nΑς του μιλήσω, μπορεί να με βοηθήσει.";
    }
    
    public String welcomeMsg(){
        return "Καλώς ήρθες στον πλανήτη μου Objectus!\n\nΕίμαι ο πλανητάρχης Objectis και μπορώ \nνα σε "+
        "βοηθήσω να φύγεις αρκεί να κάνεις \nκάτι για μένα.";
    }
    
    public String taskText1(){
        return "Υπάρχουν δύο καλύβες έξω, οι οποίες \nχρειάζονται ανακατασκευή.\n\n"+
        "Για να τις φτιάξεις θα χρειαστείς τις\nεξής πρώτες ύλες:\nΞύλο, Πηλό και Άχυρο.";
    }
    public String taskText2(){
        return "Προκειμένου να λάβεις αυτές τις πρώτες\nύλες, θα πρέπει να τις δημιουργήσεις."
        +"\n\nΗ δημιουργία πρώτων υλών, μοιάζει πολύ\nμε τη δημιουργία αντικειμένων (objects)\nστον"
        +" κόσμο των προγραμματιστών.";
    }
    
    public String taskText3(){
        return "Αρχικά, ας ονομάσουμε τις πρώτες ύλες,\n\"κλάσεις\"."
        +"\n\nΓια παράδειγμα:\nη κλάση Ξύλο,\nη κλάση Πηλός,\nη κλάση Άχυρο.";
    }
    
    public String taskText4(){
        return "Στη συνέχεια, για να δημιουργήσεις\nκάποια πρώτη ύλη, αρκεί να \"καλέσεις\""
        +"\nτην αντίστοιχη κλάση ως εξής:\n\n π.χ\n new Wood();\n new Clay();";
    }
    
    public String taskText5(){
        return "new όνομα_κλάσης();\n\n-Το \"new\" υποδηλώνει τη δημιουργία του\nνέου αντικειμένου, οποιασδήποτε κλάσης."
        +"\n-Οι παρενθέσεις συνοδεύουν πάντα το\nόνομα της κλάσης.\n-Το ερωτηματικό μπαίνει απαραίτητα στο\nτέλος κάθε γραμμής κώδικα!";
    }
    
    public String taskText6(){
        return "Είσαι έτοιμος για την αποστολή σου.\n\nΘυμήσου!\nnew όνομα_κλάσης();\n\nΗ δημιουργία αντικειμένων θα σου\nανοίξει πολλές πόρτες... ";
    }
    
    public String lockedDoor(){
        return "Είναι κλειδωμένη...\n\nΆραγε μπορώ να την ανοίξω...;";
    }
    
    public String warningDoor(){
        return "Έκανες λάθος! Έχασες ενέργεια!\n\nΠροσπάθησε ξανά ή μίλα πάλι μαζί μου\nγια βοήθεια.";
    }
    
    
    
}
