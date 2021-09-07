import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Notebook {
    private String name;
    private List<Entry> entries;
    private boolean statusPublic;
    private User author;

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


    public Entry createEntry(String title){
        Entry entry = new Entry(title, this.author);
        entries.add(entry);

        return entry;
    }
}
