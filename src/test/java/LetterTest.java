import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LetterTest {

    @Test
    void deveRetornarExcecaoRecipientNuloConstrutor() {
        try{
            User user1 = new User("a", "b");

            Letter letter = new Letter(user1, null, new TextBody(), "21-01-2021");
            fail();
        }catch(IllegalArgumentException e){
            assertEquals("recipient argument must not be null.", e.getMessage());
        }
    }
}