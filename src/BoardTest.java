/**
 * Created with IntelliJ IDEA.
 * User: Guðný
 * Date: 11/14/12
 * Time: 10:28 PM
 *
 * @author Guðný Björk Gunnarsdóttir
 */

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

public class BoardTest extends TestCase {
    public void testGetValidMoves(){
        Board board = new Board();
        int[] test = {1,2,3};
        assertEquals("Valid moves should be 1,2 and 3", test, board.GetValidMoves());
    }

}
