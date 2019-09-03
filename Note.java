/**
 * Note.java
 * This class represents a piece of paper that has a clue.
 * @author Deniz Sert, Nic Campanile
 * @version March 3, 2018
 */
public class Note extends Item{
    String clue;
    Place location;
    
    
    public Note(){
       
    }
    
    public Note(String s){
        this.clue=s;
    }
    
    /**
     * Constructs a Note object with a message and a location
     * @param _clue the message
     * @param _location where the note was found
     */
    public Note(String _clue, Place _location){
        location = _location;
        clue = _clue;
    }
    
    public String getClue(){
        return clue;
    }
    
    public Place getLocation() {
        return location;
    }
    
    public String toString(){
     return "Note with a clue regarding: " + clue;        
    }
    
    
}