/**
 * Created with IntelliJ IDEA.
 * Author: Óskar Ögri Birgisson
 * Date: 14.11.2012
 * Last Updated: 14.11.2012
 * Time: 23:00
 * Description:
 */
public class AI implements ComputerAI {
    @Override
    public int solve(Board board) {
        int Omove = -1;
        int v = -2;
        int alpha = -2;
        int beta = 2;

        for (int i : board.GetValidMoves())
        {
            Board successor = (Board)board.clone();
            successor.getSquares()[i].setMark(Mark.O);
            int vTemp = Min_Value(successor, alpha, beta);
            // take max of min values
            if (vTemp > v)
            {
                Omove = i;
                v = vTemp;
            }
            if (v >= beta)
                break;
            alpha = Max(alpha, v);
        }

        return Omove;

    }

    private int Max_Value(Board b, int alpha, int beta)
    {
        if (b.Evaluate(Mark.X))
            return -1; // minimize
        if (b.Evaluate(Mark.O))
            return 1;  // maximize
        if (b.IsFull())
            return 0;

        int v = -2;
        for (int i : b.GetValidMoves())
        {
            Board s = (Board)b.clone(); // successor
            s.getSquares()[i].setMark(Mark.O);
            v = Max(v, Min_Value(s, alpha, beta));
            if (v >= beta)
                return v;
            alpha = Max(alpha, v);
        }
        return v;
    }

    private int Min_Value(Board b, int alpha, int beta)
    {
        if (b.Evaluate(Mark.X))
            return -1;  // minimize
        if (b.Evaluate(Mark.O))
            return 1;   // maximize
        if (b.IsFull())
            return 0;

        int v = 2;
        for (int i : b.GetValidMoves())
        {
            Board s = (Board)b.clone(); //successor
            s.getSquares()[i].setMark(Mark.X);
            v = Min(v, Max_Value(s, alpha, beta));
            if (v <= alpha)
                return v;
            beta = Min(beta, v);
        }
        return v;
    }

    private int Max(int a, int b)
    {
        return (a > b ? a : b);
    }

    private int Min(int a, int b)
    {
        return (a < b ? a : b);
    }
}
