import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Notebook {
    private String name;
    private List<Entry> entries;
    private boolean statusPublic;
    private User author;
    private int id;


    public Notebook(String name, User author) {

        if(author==null){
            throw new IllegalArgumentException("author argument must not be null.");
        }

        this.name = name;
        this.author = author;
        this.entries = new ArrayList<Entry>();
    }

    public Notebook(User author) {
        if(author==null){
            throw new IllegalArgumentException("author argument must not be null.");
        }
        this.author = author;
        this.entries = new ArrayList<Entry>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public Entry getEntry(int id){
        for(Entry entry: entries){
            if(id ==entry.getId()){
                return entry;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setStatusPublic(boolean statusPublic){
        this.statusPublic = statusPublic;
    }

    public boolean isPublic(){
        return this.statusPublic;
    }

    public List<Entry> searchEntry(String text){
        List<Entry> result = new ArrayList<Entry>();
        for(Entry entry: entries){
            String entryTitle = entry.getTitle().toLowerCase(Locale.ROOT);
            String searchString = text.toLowerCase(Locale.ROOT);
            if(entryTitle.contains(searchString)){
                result.add(entry);
            }
        }
        return result;
    }

    public void addEntry(Entry entry){
        if(entry==null){
            throw new IllegalArgumentException("Argument entry must not be null.");
        }
        this.entries.add(entry);
    }

    public Entry createEntry(String title){
        Entry entry = new Entry(title, this.author);
        entries.add(entry);

        return entry;
    }
}
