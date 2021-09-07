import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    @Test
    void deveInicializarBanco() {
        Database.initializeDatabase();
        assertNotNull(Database.getUsers());
        assertNotNull(Database.getLatestPublicEntries());
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

}