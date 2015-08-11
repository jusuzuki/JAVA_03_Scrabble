import org.junit.*;
import static org.junit.Assert.*;

public class ScrabbleTest {

    @Test
    public void scrabbleCount_forLetterA_1(){
        Scrabble app = new Scrabble();
        Integer score = 1;
        assertEquals(score, app.scoreCount("a"));
        }

    @Test
    public void scrabbleCount_forLetterWord_steal(){
        Scrabble app = new Scrabble();
        Integer score = 5;
        assertEquals(score, app.scoreCount("STEAL"));
        }


    @Test
    public void scrabbleCount_forLetterWord_queen(){
        Scrabble app = new Scrabble();
        Integer score = 14;
        assertEquals(score, app.scoreCount("QueeN"));
        }

}
