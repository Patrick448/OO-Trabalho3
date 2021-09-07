import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntryTest {

    @Test
    void deveRetornarExcecaoAuthorNuloConstrutor() {
        try{
            Entry entry = new Entry("title", null);
            fail();
        }catch(IllegalArgumentException e){
            assertEquals("author argument must not be null.", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoAuthorNuloConstrutor2() {
        try{
            Entry entry = new Entry(null);
            fail();
        }catch(IllegalArgumentException e){
            assertEquals("author argument must not be null.", e.getMessage());
        }
    }

    @Test
    void deveRetornarPreVizualizacao() {
        User user = new User("Patrick", "@patrick");

        Entry entry = new Entry(user);
        TextBody textBody = new TextBody("Abcd efgh ijklmno pq rst uvw x y z");
        entry.setTextBody(textBody);

        assertEquals("Abcd efgh ijklmno pq rst uvw x", entry.createTextPreview());
    }
}