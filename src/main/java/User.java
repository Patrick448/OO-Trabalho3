import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String userName;
    private List<Notebook> notebooks;
    private List<User> followers;
    private List<User> following;

    public User(String name, String userName) {
        this.name = name;
        this.userName = userName;
        this.notebooks = new ArrayList<Notebook>();
        this.followers = new ArrayList<User>();
        this.following = new ArrayList<User>();
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

    public void addFollower(User follower){
        this.followers.add(follower);
        follower.addToFollowing(this);
    }

    public void addToFollowing(User following){
        this.following.add(following);
    }

    public Notebook getNotebook(int id){
        return new Notebook();
    }

    public Notebook getNotebook(String name){
        return new Notebook();
    }

    public void createNotebook(String name){
        Notebook notebook = new Notebook(name);
        this.notebooks.add(notebook);
    }

}
