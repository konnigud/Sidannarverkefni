import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * Author: Óskar Ögri Birgisson
 * Date: 19.11.2012
 * Last Updated: 19.11.2012
 * Time: 14:02
 * Description:
 */
public class SquareTest {

    @Test
    public void testIsEmtpy() throws Exception {
        Square testSquare = new Square();

        assertTrue("Error! Should be empty!", testSquare.IsEmtpy());

        testSquare.setMark(Mark.O);
        assertFalse("Error! Should no be empty!", testSquare.IsEmtpy());

        testSquare.setMark(Mark.X);
        assertFalse("Error! Should no be empty!", testSquare.IsEmtpy());

    }
}
