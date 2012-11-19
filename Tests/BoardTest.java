import org.junit.Test;
import static org.junit.Assert.*;

/**
* Created with IntelliJ IDEA.
* Author: Óskar Ögri Birgisson
* Date: 19.11.2012
* Last Updated: 19.11.2012
* Time: 15:01
* Description:
*/
public class BoardTest {

    private void fillBoardWithMark (Board board, Mark mark)
    {
        for (Square s : board.getSquares())
        {
            s.setMark(mark);
        }
    }

    @Test
    public void testGetValidMoves() throws Exception {
        Board testBoard = new Board();
        testBoard.getSquares()[1].setMark(Mark.O);
        testBoard.getSquares()[1].setIndex(1);

        //Checking a board with 1 move on it:
        int[] expected = new int[]{0,2,3,4,5,6,7,8};
        assertArrayEquals("Error! The Valid moves are not the same!",testBoard.GetValidMoves(), expected );

        //Checking a board with no moves on it:
        fillBoardWithMark(testBoard, Mark.Open);
        expected = new int[]{0,1,2,3,4,5,6,7,8};
        assertArrayEquals("Error! The Valid moves are not the same!",testBoard.GetValidMoves(), expected );

        //Checking a filled board...
        fillBoardWithMark(testBoard,Mark.O);
        expected = new int[0];
        assertArrayEquals("Error! The Valid moves are not the same!",testBoard.GetValidMoves(), expected );
    }

    @Test
    public void testEvaluate() throws Exception {
        Board testBoard = new Board();
        fillBoardWithMark(testBoard, Mark.Open);

        // Guaranteed evalutation should be a no-win, no games played:
        assertFalse("Error! The board is all open, should have no wins!", testBoard.Evaluate(Mark.O));
        assertFalse("Error! The board is all open, should have no wins!",testBoard.Evaluate(Mark.X));

        testBoard.getSquares()[0].setMark(Mark.O);
        testBoard.getSquares()[1].setMark(Mark.O);
        testBoard.getSquares()[2].setMark(Mark.O);

        assertTrue("Error! O marks horizontal should have been found!", testBoard.Evaluate(Mark.O));

        testBoard.getSquares()[3].setMark(Mark.O);
        testBoard.getSquares()[6].setMark(Mark.O);

        assertTrue("Error! O marks vertical should have been found!", testBoard.Evaluate(Mark.O));

        fillBoardWithMark(testBoard, Mark.Open);

        testBoard.getSquares()[0].setMark(Mark.X);
        testBoard.getSquares()[1].setMark(Mark.X);
        testBoard.getSquares()[2].setMark(Mark.X);

        assertTrue("Error! O marks horizontal should have been found!", testBoard.Evaluate(Mark.X));

        testBoard.getSquares()[3].setMark(Mark.X);
        testBoard.getSquares()[6].setMark(Mark.X);

        assertTrue("Error! O marks vertical should have been found!", testBoard.Evaluate(Mark.X));

        fillBoardWithMark(testBoard, Mark.Open);

        testBoard.getSquares()[0].setMark(Mark.O);
        testBoard.getSquares()[4].setMark(Mark.O);
        testBoard.getSquares()[8].setMark(Mark.O);

        assertTrue("Error! O marks first diagonal should have been found!", testBoard.Evaluate(Mark.O));

        testBoard.getSquares()[2].setMark(Mark.O);
        testBoard.getSquares()[6].setMark(Mark.O);

        assertTrue("Error! O marks second diagonal should have been found!", testBoard.Evaluate(Mark.O));

    }

    @Test
    public void testIsFull() throws Exception {
        Board testBoard = new Board();

        fillBoardWithMark(testBoard, Mark.Open);
        assertFalse("Error! The board should not be full!", testBoard.IsFull());

        fillBoardWithMark(testBoard, Mark.O);
        assertTrue("Error! The board should be full!", testBoard.IsFull());

    }

}
