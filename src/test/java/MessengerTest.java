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
}