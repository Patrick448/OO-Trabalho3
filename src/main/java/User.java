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

    public List<User> getFollowing() {
        return following;
    }

    //todo: considerar o caso em que o usuário quer remover o seguidor

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
                following.remove(user);
                user.removeFollower(this);
            }
        }
    }

    private void removeFollower(User user){
        this.following.remove(user);
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


    public Notebook createNotebook(String name){
        Notebook notebook = new Notebook(name, this);
        this.notebooks.add(notebook);

        return notebook;
    }



}
