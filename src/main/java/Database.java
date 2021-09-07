import java.util.ArrayList;
import java.util.List;

public class Database {
    private static List<User> users;
    private static List<Entry> latestPublicEntries;

    public static void initializeDatabase(){
        Database.users = new ArrayList<User>();
        Database.latestPublicEntries = new ArrayList<Entry>();
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void addUser(User user) {
        Database.users.add(user);
    }

    public static List<Entry> getLatestPublicEntries() {
        return latestPublicEntries;
    }

}
