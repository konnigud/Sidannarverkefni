import org.junit.Test;
import static org.junit.Assert.*;

/**
* Created with IntelliJ IDEA.
* Author: Óskar Ögri Birgisson
* Date: 19.11.2012
* Last Updated: 19.11.2012
* Time: 17:06
* Description:
*/
public class AITest {

    @Test
    public void testSolve() throws Exception {

        ComputerAI testAI = new AI();
        Board testBoard = new Board();
        testBoard.getSquares()[4].setMark(Mark.X);

        assertEquals("Error 1! AI move not what it's supposed to be!", 0, testAI.solve(testBoard));

    }
}
