import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextBodyTest {

    @Test
    void deveRetornarCaracteres() {
        TextBody textBody = new TextBody("Abcd efgh ijklmno pq rst uvw x y z");

        assertEquals("Abcd ef", textBody.getCharacters(7));
    }

    @Test
    void deveRetornarVazioComTextNuloTrue(){
        TextBody textBody = new TextBody();
        assertEquals(true, textBody.isEmpty());
    }

    @Test
    void deveRetornarVazioComTextVazioTrue(){
        TextBody textBody = new TextBody("");
        assertEquals(true, textBody.isEmpty());
    }

    @Test
    void deveRetornarVazioFalse(){
        TextBody textBody = new TextBody("a");
        assertEquals(false, textBody.isEmpty());
    }
}