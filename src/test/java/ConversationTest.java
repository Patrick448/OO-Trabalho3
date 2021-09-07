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

   /* @Test
    void deveRetornarListaLetters1Elemento(){
        User owner = new User("José", "@zezinho");
        User correspondent = new User("Maria", "@maria");
        Conversation conversation = new Conversation(owner, correspondent);
        TextBody textBody = new TextBody("blá blá blá");

        Letter letter = conversation.createLetterOutgoing(textBody);

        List<Letter> letters = Arrays.asList(letter);

        assertEquals(letters, conversation.getLetters());
    }

    @Test
    void deveRetornarListaLetters2Elemento(){
        User owner = new User("José", "@zezinho");
        User correspondent = new User("Maria", "@maria");
        Conversation conversation = new Conversation(owner, correspondent);
        TextBody textBody = new TextBody("blá blá blá");

        Letter letter = conversation.createLetterOutgoing(textBody);
        Letter letter2 = conversation.createLetterOutgoing(textBody);

        List<Letter> letters = Arrays.asList(letter, letter2);

        assertEquals(letters, conversation.getLetters());
    }*/

}