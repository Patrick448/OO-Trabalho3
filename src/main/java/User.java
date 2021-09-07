import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String userName;
    private List<Notebook> notebooks;
    private List<User> followers;
    private List<User> following;
    private List<Conversation> conversations;

    public User(String name, String userName) {
        this.name = name;
        this.userName = userName;
        this.notebooks = new ArrayList<Notebook>();
        this.followers = new ArrayList<User>();
        this.following = new ArrayList<User>();
        this.conversations = new ArrayList<Conversation>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Notebook> getNotebooks() {
        return notebooks;
    }


    public List<User> getFollowers() {
        return followers;
    }

    public List<User> getFollowing() {
        return following;
    }


    private void addFollower(User follower){
        this.followers.add(follower);
    }

    public void follow(User user){
        this.following.add(user);
        user.addFollower(this);
    }

    public void unfollow(String userName){
        for(User user: following){
            if(user.userName.equals(userName)){
                user.removeFollower(this);
            }
        }
    }

    public void removeFollower(User user){
        this.followers.remove(user);
        user.following.remove(this);
    }

    public Notebook getNotebook(int id){
        for(Notebook notebook: notebooks){
            if(id ==notebook.getId()){
                return notebook;
            }
        }
        return null;
    }

    public Notebook getNotebook(String name){
        for(Notebook notebook: notebooks){
            if(name.equals(notebook.getName())){
                return notebook;
            }
        }
        return null;
    }

    public List<Conversation> getConversations() {
        return conversations;
    }


    public Notebook createNotebook(String name){
        Notebook notebook = new Notebook(name, this);
        this.notebooks.add(notebook);

        return notebook;
    }

    public void addLetter(Letter letter){
        if(letter==null){
            throw new IllegalArgumentException("letter argument must not be null.");
        }

        Conversation conversation;

        if(letter.getRecipient()==this){
            conversation=getConversationWith(letter.getAuthor());
            if(conversation==null){
                conversation = this.createConversation(letter.getAuthor());
            }
        }else{
            conversation=getConversationWith(letter.getRecipient());
            if(conversation==null){
                conversation = this.createConversation(letter.getRecipient());
            }
        }

        conversation.addLetter(letter);
    }

    public Conversation createConversation(User correspondent){

        Conversation conversation = new Conversation(this, correspondent);
        this.conversations.add(conversation);

        return conversation;
    }

    /*public void sendLetter(User correspondent, TextBody textBody){

        Conversation conversation = getConversationWith(correspondent);

        if(conversation==null){
            conversation = this.createConversation(correspondent);
        }
        //conversation.createLetterOutgoing(textBody);

        correspondent.receiveLetter(this, textBody);

    }

    public void receiveLetter(User sender, TextBody textBody){
        Conversation conversation = getConversationWith(sender);

        if(conversation==null){
            conversation = this.createConversation(sender);
        }
       // conversation.createLetterIncoming(textBody);
    }*/

    public Conversation getConversationWith(User user){
        for(Conversation conversation: conversations){
            if(conversation.getCorrespondentUserName().equals(user.getUserName())){
                return conversation;
            }
        }
        return null;
    }


}
