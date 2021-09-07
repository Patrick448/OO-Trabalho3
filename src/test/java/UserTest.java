import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void deveRetornarFollowersVazio() {
        User user = new User("José", "@zezinho");
        assertEquals(new ArrayList<User>(), user.getFollowers());

    }

    @Test
    void deveRetornarFollowers1() {
        User user1 = new User("José", "@zezinho");
        User user2 = new User("Maria", "@maria");

        user2.follow(user1);

        assertEquals(Arrays.asList(user2), user1.getFollowers());
    }

    @Test
    void deveRetornarFollowing1() {
        User user1 = new User("José", "@zezinho");
        User user2 = new User("Maria", "@maria");

        user2.follow(user1);

        assertEquals(Arrays.asList(user1), user2.getFollowing());

    }

    @Test
    void deveRetornarFollowers2() {
        User user1 = new User("José", "@zezinho");
        User user2 = new User("Maria", "@maria");
        User user3 = new User("Pedro", "@pedro");

        user2.follow(user1);
        user3.follow(user1);

        assertEquals(Arrays.asList(user2, user3), user1.getFollowers());

    }

    @Test
    void deveRetornarFollowing2() {
        User user1 = new User("José", "@zezinho");
        User user2 = new User("Maria", "@maria");
        User user3 = new User("Pedro", "@pedro");

        user3.follow(user1);
        user3.follow(user2);


        assertEquals(Arrays.asList(user1, user2), user3.getFollowing());

    }

    @Test
    void deveRemoverSeguidor() {
        User user1 = new User("José", "@zezinho");
        User user2 = new User("Maria", "@maria");
        User user3 = new User("Pedro", "@pedro");

        user3.follow(user1);
        user3.follow(user2);
        user3.unfollow("@zezinho");

        assertEquals(Arrays.asList(user2), user3.getFollowing());
    }

    @Test
    void deveRemoverSeguidor2() {
        User user1 = new User("José", "@zezinho");
        User user2 = new User("Maria", "@maria");
        User user3 = new User("Pedro", "@pedro");

        user2.follow(user1);
        user3.follow(user1);

        user1.removeFollower(user2);
        assertEquals(Arrays.asList(user3), user1.getFollowers());
    }

    @Test
    void deveRetornar1NotebookCriado(){
        User user1 = new User("José", "@zezinho");
        Notebook notebook=user1.createNotebook("Caderno1");

        assertEquals(Arrays.asList(notebook), user1.getNotebooks());
    }

    @Test
    void deveRetornar2NotebooksCriados(){
        User user1 = new User("José", "@zezinho");

        List<Notebook> notebookList = Arrays.asList(
                user1.createNotebook("Caderno1"),
                user1.createNotebook("Caderno2"));


        assertEquals(notebookList, user1.getNotebooks());
    }

    @Test
    void deveRetornarCorrespondenteConversaCriadaViaCreateConversation(){
        User user1 = new User("José", "@zezinho");
        User user2 = new User("Maria", "@maria");
        Conversation conversation = user1.createConversation(user2);

        assertEquals(conversation.getCorrespondent(), user2);
    }

    @Test
    void deveRetornarProprietarioConversaCriadaViaCreateConversation(){
        User user1 = new User("José", "@zezinho");
        User user2 = new User("Maria", "@maria");
        Conversation conversation = user1.createConversation(user2);

        assertEquals(conversation.getOwner(), user1);
    }

    @Test
    void deveRetornar1ConversaCriada(){
        User user1 = new User("José", "@zezinho");
        User user2 = new User("Maria", "@maria");
        Conversation conversation = user1.createConversation(user2);

        assertEquals(Arrays.asList(conversation), user1.getConversations());
    }

    @Test
    void deveRetornar2ConversasCriadas(){
        User user1 = new User("José", "@zezinho");
        User user2 = new User("Maria", "@maria");
        User user3 = new User("Maria123", "@maria123");

        List<Conversation> conversations = Arrays.asList(
                user1.createConversation(user2),
                user1.createConversation(user3));

        assertEquals(conversations, user1.getConversations());
    }

    @Test
    void deveRetornarConversaCom(){
        User user1 = new User("José", "@zezinho");
        User user2 = new User("Maria", "@maria");
        User user3 = new User("Maria123", "@maria123");


        Conversation conversation1 = user1.createConversation(user2);
        user1.createConversation(user3);

        assertEquals(conversation1, user1.getConversationWith(user2));
    }

    @Test
    void deveRetornarListaLettersVazia(){
        User user1 = new User("José", "@zezinho");

        assertEquals( new ArrayList<Conversation>(), user1.getConversations());
    }

    @Test
    void deveRetornarListaLetters1Elemento(){
        User user1 = new User("José", "@zezinho");
        User user2 = new User("Maria", "@maria");
        TextBody textBody = new TextBody("abcde");
        Letter letter = new Letter(user1, user2, textBody, "21-09-2020");
        user1.addLetter(letter);

        assertEquals( Arrays.asList(letter), user1.getConversationWith(user2).getLetters());
    }

    @Test
    void deveRetornarListaLetters2Elementos(){
        User user1 = new User("José", "@zezinho");
        User user2 = new User("Maria", "@maria");

        TextBody textBody = new TextBody("abcde");
        Letter letter = new Letter(user1, user2, textBody, "21-09-2020");
        Letter letter2 = new Letter(user1, user2, textBody, "21-09-2020");
        user1.addLetter(letter);
        user1.addLetter(letter2);

        assertEquals( Arrays.asList(letter, letter2), user1.getConversationWith(user2).getLetters());
    }

    @Test
    void deveRetornarExcecaoLetterNuloAddLetter() {
        try{
            User user1 = new User("José", "@zezinho");
            user1.addLetter(null);
            fail();
        }catch(IllegalArgumentException e){
            assertEquals("letter argument must not be null.", e.getMessage());
        }
    }


}