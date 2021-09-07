import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentTest {

    @Test
    void deveRetornarPreVizualizacao() {
        TextBody textBody = new TextBody("Abcd efgh ijklmno pq rst uvw x y z");
        User user = new User("Patrick", "@patrick");
        Comment comment = new Comment(textBody, "05-09-2021", user);

        assertEquals("Abcd efgh ijklm", comment.createTextPreview());
    }

    @Test
    void deveRetornarExcecaoTextBodyNuloConstrutor() {
        try{
            Comment comment = new Comment(null, "05-09-2021", new User("a", "@a"));
            fail();
        }catch(IllegalArgumentException e){
            assertEquals("textBody argument must not be empty or null.", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoTextBodyVazioConstrutor() {
        try{
            Comment comment = new Comment(new TextBody(), "05-09-2021", new User("a", "@a"));
            fail();
        }catch(IllegalArgumentException e){
            assertEquals("textBody argument must not be empty or null.", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoAuthorNuloConstrutor() {
        try{
            Comment comment = new Comment(new TextBody("abc"), "05-09-2021",null);
            fail();
        }catch(IllegalArgumentException e){
            assertEquals("author argument must not be null.", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoDateVazioConstrutor() {
        try{
            User user = new User("Patrick", "@patrick");
            Comment comment = new Comment(new TextBody("abc"), "" ,user);
            fail();
        }catch(IllegalArgumentException e){
            assertEquals("date argument must not be empty or null.", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoSetTextBodyNulo() {
        try{
            TextBody textBody = new TextBody("Abcd efgh ijklmno pq rst uvw x y z");
            User user = new User("Patrick", "@patrick");
            Comment comment = new Comment(textBody, "05-09-2021", user);
            comment.setTextBody(null);
            fail();
        }catch(IllegalArgumentException e){
            assertEquals("textBody argument must not be null.", e.getMessage());
        }
    }

}