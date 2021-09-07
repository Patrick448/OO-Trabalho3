import java.util.ArrayList;
import java.util.List;

public class Conversation{
    private User owner;
    private User correspondent;
    private List<Letter> letters;

    public Conversation(User owner, User correspondent) {
        this.owner = owner;
        this.correspondent = correspondent;
        this.letters = new ArrayList<Letter>();
    }

    public List<Letter> getLetters() {
        return letters;
    }

    /*public Letter createLetterOutgoing(TextBody textBody){
        Letter letter = new Letter(owner, correspondent, textBody);
        this.letters.add(letter);
        return letter;
    }*/

    public void addLetter(Letter letter){
        this.letters.add(letter);
    }

    /*public Letter createLetterIncoming(TextBody textBody){
        Letter letter = new Letter(correspondent, owner, textBody);
        this.letters.add(letter);
        return letter;
    }*/


    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getCorrespondent() {
        return correspondent;
    }

    public String getCorrespondentUserName() {
        return correspondent.getUserName();
    }

    public void setCorrespondent(User correspondent) {
        this.correspondent = correspondent;
    }
}
