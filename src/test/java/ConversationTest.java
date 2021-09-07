import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConversationTest {

    @Test
    void deveRetornarListaLettersVazia(){

        User owner = new User("José", "@zezinho");
        User correspondent = new User("Maria", "@maria");
        Conversation conversation = new Conversation(owner, correspondent);

        assertEquals(new ArrayList<Letter>(), conversation.getLetters());
    }

    @Test
    void deveRetornarListaLetters1Elemento(){

        User owner = new User("José", "@zezinho");
        User correspondent = new User("Maria", "@maria");

        Letter letter = new Letter(owner, correspondent, new TextBody(), "01-01-2020");
        Conversation conversation = new Conversation(owner, correspondent);
        conversation.addLetter(letter);

        assertEquals(Arrays.asList(letter), conversation.getLetters());
    }

    @Test
    void deveRetornarListaLettersMultiplosElementos(){

        User owner = new User("José", "@zezinho");
        User correspondent = new User("Maria", "@maria");

        Letter letter = new Letter(owner, correspondent, new TextBody(), "01-01-2020");
        Letter letter2 = new Letter(owner, correspondent, new TextBody(), "01-01-2020");
        Conversation conversation = new Conversation(owner, correspondent);
        conversation.addLetter(letter);
        conversation.addLetter(letter2);

        assertEquals(Arrays.asList(letter, letter2), conversation.getLetters());
    }

    @Test
    void deveRetornarExcecaoOwnerNuloConstrutor() {
        try{
            User user = new User("José", "@zezinho");
            Conversation conversation = new Conversation(null, user);
            fail();
        }catch(IllegalArgumentException e){
            assertEquals("owner argument must not be null.", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoCorrespondentNuloConstrutor() {
        try{
            User user = new User("José", "@zezinho");
            Conversation conversation = new Conversation(user, null);
            fail();
        }catch(IllegalArgumentException e){
            assertEquals("correspondent argument must not be null.", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoAddLetterNulo() {
        try{
            User user = new User("José", "@zezinho");
            User user2 = new User("José", "@zezinho");

            Conversation conversation = new Conversation(user, user2);
            conversation.addLetter(null);
            fail();
        }catch(IllegalArgumentException e){
            assertEquals("letter argument must not be null.", e.getMessage());
        }
    }


}