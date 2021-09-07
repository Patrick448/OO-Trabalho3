import java.util.ArrayList;
import java.util.List;

public class Database {
    private static List<User> users;

    public static void initializeDatabase(){
        Database.users = new ArrayList<User>();
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void addUser(User user) {
        if(user==null){
            throw new IllegalArgumentException("user argument must not be null.");
        }
        Database.users.add(user);
    }

    public static List<Entry> getPublicEntries() {
        List<Entry> entries = new ArrayList<Entry>();
        for(User user: users){
            for(Notebook notebook: user.getNotebooks()){
                for(Entry entry: notebook.getEntries()){
                    if(entry.isPublic()){
                        entries.add(entry);
                    }
                }
            }
        }
        return entries;
    }

}
