import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NotebookTest {

    @Test
    void deveRetornarExcecaoAuthorNuloConstrutor() {
        try{
            Notebook notebook = new Notebook(null);
            fail();
        }catch(IllegalArgumentException e){
            assertEquals("author argument must not be null.", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoAuthorNuloConstrutor2() {
        try{
            Notebook notebook = new Notebook("string", null);
            fail();
        }catch(IllegalArgumentException e){
            assertEquals("author argument must not be null.", e.getMessage());
        }
    }

    @Test
    void deveRetornarListaEntriesVazia(){
        User user = new User("Patrick", "@patrick");
        Notebook notebook = new Notebook(user);
        assertEquals(new ArrayList<Entry>(), notebook.getEntries());
    }

    @Test
    void deveRetornarListaEntries1Elemento(){
        User user = new User("Patrick", "@patrick");
        Notebook notebook = new Notebook(user);

        Entry entry = notebook.createEntry("abc");

        List<Entry> entries =Arrays.asList(entry);

        assertEquals(entries, notebook.getEntries());
    }

    @Test
    void deveRetornarListaEntries2Elementos(){
        User user = new User("Patrick", "@patrick");
        Notebook notebook = new Notebook(user);

        Entry entry = notebook.createEntry("abc");
        Entry entry2 = notebook.createEntry("abc");


        List<Entry> entries =Arrays.asList(entry, entry2);

        assertEquals(entries, notebook.getEntries());
    }


    @Test
    void deveRetornarListaEntries1ElementoUsandoCreateEntry(){
        User user = new User("Patrick", "@patrick");
        Notebook notebook = new Notebook(user);

        List<Entry> entries =Arrays.asList(notebook.createEntry("entry"));

        assertEquals(entries, notebook.getEntries());
    }

    @Test
    void deveRetornarListaEntries2ElementosUsandoCreateEntry(){
        User user = new User("Patrick", "@patrick");
        Notebook notebook = new Notebook(user);

        List<Entry> entries =Arrays.asList(
                notebook.createEntry("entry"),
                notebook.createEntry("entry2"));

        assertEquals(entries, notebook.getEntries());
    }

    @Test
    void deveRetornarListaEntry(){
        User user = new User("Patrick", "@patrick");
        Notebook notebook = new Notebook(user);

        Entry entry = notebook.createEntry("Entry1");
        Entry entry2 = notebook.createEntry("Poem2");
        Entry entry3 = notebook.createEntry("Just a regular entry");

        List<Entry> entries =Arrays.asList(entry, entry3);

        assertEquals(entries, notebook.searchEntry("entry"));
    }
}