import java.util.ArrayList;
import java.util.List;

public class Notebook {
    private String name;
    private List<Entry> entries;

    public Notebook() {
        this.name = name;
        this.entries = new ArrayList<Entry>();
    }
    public Notebook(String name) {
        this.name = name;
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

    public void addEntry(Entry entry){
        this.entries.add(entry);
    }
}
