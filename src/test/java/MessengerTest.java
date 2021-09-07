import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MessengerTest {

    @Test
    void deveEnviarMensagem() {
        User user1 = new User("José", "@zezinho");
        User user2 = new User("Maria", "@maria");

        TextBody textBody = new TextBody("abcde");
        Letter letter = Messenger.sendLetter(user1, user2, textBody, "21-01-2021");

        assertEquals( Arrays.asList(letter), user1.getConversationWith(user2).getLetters());
        assertEquals( Arrays.asList(letter), user2.getConversationWith(user1).getLetters());

    }

    @Test
    void deveRetornarExcecaoRecipientNuloConstrutor() {
        try{
            User user1 = new User("a", "b");
            TextBody textBody = new TextBody("abcde");
            Messenger.sendLetter(user1, null, textBody, "21-09-2021");
            fail();
        }catch(IllegalArgumentException e){
            assertEquals("recipient argument must not be null.", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoSenderNuloConstrutor() {
        try{
            User user1 = new User("a", "b");
            TextBody textBody = new TextBody("abcde");
            Messenger.sendLetter(null, user1, textBody, "21-09-2021");
            fail();
        }catch(IllegalArgumentException e){
            assertEquals("sender argument must not be null.", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoTextBodyNuloConstrutor() {
        try{
            User user1 = new User("a", "b");
            User user2 = new User("a", "b");
            Messenger.sendLetter(user2, user1, null, "21-09-2021");
            fail();
        }catch(IllegalArgumentException e){
            assertEquals("textBody argument must not be null.", e.getMessage());
        }
    }
}