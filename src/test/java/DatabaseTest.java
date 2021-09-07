import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    @Test
    void deveInicializarBanco() {
        Database.initializeDatabase();
        assertEquals(new ArrayList<User>(),Database.getUsers());
    }

    @Test
    void deveRetornarListaUsuariosVazia(){
        Database.initializeDatabase();
        assertEquals(new ArrayList<User>(), Database.getUsers());
    }

    @Test
    void deveRetornarLista1Usuario(){
        Database.initializeDatabase();
        User user = new User("José", "@zezinho");
        Database.addUser(user);
        assertEquals(Arrays.asList(user), Database.getUsers());
    }
    @Test
    void deveRetornarLista2Usuarios(){
        Database.initializeDatabase();
        User user1 = new User("José", "@zezinho");
        User user2 = new User("Maria", "@maria");
        Database.addUser(user1);
        Database.addUser(user2);
        assertEquals(Arrays.asList(user1, user2), Database.getUsers());
    }

    @Test
    void deveRetornarListaPublicEntriesVazia(){
        Database.initializeDatabase();
        assertEquals(new ArrayList<User>(),Database.getPublicEntries());
    }

    @Test
    void deveRetornarListaPublicEntries1Elemento(){
        Database.initializeDatabase();
        User user1 = new User("José", "@zezinho");
        User user2 = new User("Maria", "@maria");
        User user3 = new User("Maria123", "@maria123");

        Notebook notebook = user1.createNotebook("Caderno1");
        Entry entry1 = notebook.createEntry("Alguma coisa");
        Entry entry2 = notebook.createEntry("Alguma coisa");
        entry1.setStatusPublic(true);

        Database.addUser(user1);
        Database.addUser(user2);
        Database.addUser(user3);

        assertEquals(Arrays.asList(entry1),Database.getPublicEntries());
    }

    @Test
    void deveRetornarListaPublicEntriesMultiplosElementos(){
        Database.initializeDatabase();
        User user1 = new User("José", "@zezinho");
        User user2 = new User("Maria", "@maria");
        User user3 = new User("Maria123", "@maria123");

        Notebook notebook = user1.createNotebook("Caderno1");
        Entry entry1 = notebook.createEntry("Alguma coisa");
        Entry entry2 = notebook.createEntry("Alguma coisa");
        Entry entry3 = notebook.createEntry("Alguma coisa");
        entry1.setStatusPublic(true);

        Notebook notebook2 = user2.createNotebook("Caderno1");
        Entry entry4 = notebook2.createEntry("Alguma coisa");
        Entry entry5 = notebook2.createEntry("Alguma coisa");
        Entry entry6 = notebook2.createEntry("Alguma coisa");
        entry4.setStatusPublic(true);
        entry5.setStatusPublic(true);

        Database.addUser(user1);
        Database.addUser(user2);
        Database.addUser(user3);

        assertEquals(Arrays.asList(entry1, entry4, entry5),Database.getPublicEntries());
    }

    @Test
    void deveRetornarExcecaoAddUserNulo() {
        try{
           Database.addUser(null);
           fail();
        }catch(IllegalArgumentException e){
            assertEquals("user argument must not be null.", e.getMessage());
        }
    }

}