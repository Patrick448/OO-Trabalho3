import java.util.ArrayList;
import java.util.List;

public class Conversation{
    private User owner;
    private User correspondent;
    private List<Letter> letters;

    public Conversation(User owner, User correspondent) {
        if(owner==null){
            throw new IllegalArgumentException("owner argument must not be null.");
        }
        if(correspondent==null){
            throw new IllegalArgumentException("correspondent argument must not be null.");
        }
        this.owner = owner;
        this.correspondent = correspondent;
        this.letters = new ArrayList<Letter>();
    }

    public List<Letter> getLetters() {
        return letters;
    }


    public void addLetter(Letter letter){
        if(letter==null){
            throw new IllegalArgumentException("letter argument must not be null.");
        }
        this.letters.add(letter);
    }

    public User getOwner() {
        return owner;
    }

    public User getCorrespondent() {
        return correspondent;
    }

    public String getCorrespondentUserName() {
        return correspondent.getUserName();
    }

}
