/**
 * Created with IntelliJ IDEA.
 * Author: Óskar Ögri Birgisson
 * Date: 15.11.2012
 * Last Updated: 15.11.2012
 * Time: 14:05
 * Description:
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Board implements Cloneable {

    private Square[] squares;
    private Mark mark;

    public Board() {
        this.squares = new Square[9];

        for (int i = 0; i < squares.length; i++) {
            squares[i] = new Square();
            squares[i].setIndex(i);
        }
    }

    public int[] GetValidMoves() {
        List<Integer> moves = new ArrayList<Integer>();

        for (Square s : squares) {
            if (s.IsEmtpy())
                moves.add(s.getIndex());
        }

        int[] returner = new int[moves.size()];

        for (int i = 0; i < returner.length;i++)
            returner[i] = moves.get(i);

       return returner;
    }

    // Evaluates if the board has been won by the player with oPolo as a mark...
    public boolean Evaluate(Mark oPolo) {
        //Checking horizontal
        for (int i = 0; i < 7;i +=3)
        {
            if (squares[i].getMark() == squares[i+1].getMark() && squares[i].getMark() == squares [i+2].getMark() && squares[i].getMark() == oPolo)
                return true;
        }
        //Checking vertical
        for (int i = 0; i < 3; i++)
        {
            if (squares[i].getMark() == squares[i+3].getMark() && squares[i].getMark() == squares [i+6].getMark() && squares[i].getMark() == oPolo)
                return true;
        }
        //Checking both diagonals
        if (squares[0].getMark() == squares[4].getMark() && squares[4].getMark() == squares [8].getMark() && squares[0].getMark() == oPolo)
            return true;
        if (squares[2].getMark() == squares[4].getMark() && squares[4].getMark() == squares [6].getMark() && squares[2].getMark() == oPolo)
            return true;

        return false;
     }

    public boolean IsFull() {

        for (Square s : squares)
        {
            if (s.getMark() == Mark.Open)
                return false;
        }
        return true;
    }

    @Override
    protected Object clone() {
       Board newBoard = new Board();

        for (int i = 0; i < 9; i++)
        {
            newBoard.squares[i].setMark(this.squares[i].getMark());
            newBoard.squares[i].setIndex(this.squares[i].getIndex());
        }
        newBoard.setMark(this.getMark());

        return newBoard;
    }

    public Square[] getSquares() {
        return squares;
    }

    public void setSquares(Square[] squares) {
        this.squares = squares;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }
}
